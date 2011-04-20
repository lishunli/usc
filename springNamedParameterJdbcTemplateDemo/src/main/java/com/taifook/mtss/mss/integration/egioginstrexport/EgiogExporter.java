package com.taifook.mtss.mss.integration.egioginstrexport;

/*
 * Created on 2010-10-18
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
//package com.taifook.pointsystem.point.util;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class EgiogExporter {
    //private static final String MSS_ERROR_LOGGER = "MSS_ERROR_LOGGER";
    private Logger logger = LoggerFactory.getLogger(EgiogExporter.class);
    //private Logger emailLogger = LoggerFactory.getLogger(MSS_ERROR_LOGGER);
    public static final String SERVER_NAME = "serverName";
    public static final String CONTEXT_PATH = "contextPath";
    public static final String CN_COUNTRY_CODE = "86";
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
    public static boolean errorFlag = false;
    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_NOW);
    public static int recordCount = 0;
    //public static String errorMsg = "";


    private static final String DEFAULT_EXPORT_EGIOG_DATE_SQL =
        "Select "+
            "DE.EGI_OG_ID, DE.OG_PROFILE_ID, DE.AMS_LOGICAL_DAY_NUM, DE.HOUSEKEEPING_FLAG, DE.LAST_HOUSEKEEP_DATE, " +
            "DECODE( DECODE(NVL(IC.INCOMPLETE_COUNT,0), 0, DECODE(GREATEST(NVL(CC.COMPLETE_COUNT,0), 0), 0, 'N', 'Y') , 'N' ), 'N', 'N', DECODE((SELECT COUNT(*) FROM EGI_OG_DATA_UPLOAD_STATUS WHERE SUB_SYSTEM_ID = 'ADMINCON'), 0, 'Y', DECODE(DE.AMS_LOGICAL_DAY_NUM, (SELECT LAST_AMS_LOGICAL_DAY_NUM FROM EGI_OG_DATA_UPLOAD_STATUS WHERE SUB_SYSTEM_ID = 'ADMINCON'), 'N', 'Y') ) ) AS READY_FOR_DOWNLOAD, " +
            "NVL((SELECT LAST_AMS_LOGICAL_DAY_NUM FROM EGI_OG_DATA_UPLOAD_STATUS WHERE SUB_SYSTEM_ID = 'ADMINCON'),-1) AS LAST_UPLOAD_LOGICAL_DAY_NUM " +
        "From " +
            "EGI_OG_DAY_END_STATUS DE, "+
            "EGI_OG_PRIMARY_ACTOR PA, "+
            "EGI_OG_HOST_AVAILABILITY HA, " +
            "(" +
                "select OG_DEVICE_ID, COUNT(*) COMPLETE_COUNT "+
                "from EGI_OG_DATA_DOWNLOAD_STATUS "+
                "where STATUS = 'C' "+
                "group by OG_DEVICE_ID "+
            ") CC, " +
            "(" +
                "select OG_DEVICE_ID, COUNT(*) INCOMPLETE_COUNT "+
                "from EGI_OG_DATA_DOWNLOAD_STATUS "+
                "where STATUS <> 'C' "+
                "group by OG_DEVICE_ID "+
            ") IC "+
        "where "+
        "DE.OG_PROFILE_ID = PA.LOAD_DB_DATA " +
        "AND HA.OG_PROFILE_ID = PA.LOAD_DB_DATA " +
        "AND HA.OG_DEVICE_ID = CC.OG_DEVICE_ID (+) " +
        "AND HA.OG_DEVICE_ID = IC.OG_DEVICE_ID (+) ";

    private static final String EGIOG_INSERT_SQL=
        "Insert into MC_TMP_OG_INSTR "+
            "(INSTR_CDE ,ISIN_CDE,LOT_SIZ,CCY_CDE,IS_SUSPD,IS_CCASS_SETL,HAS_STAMP,LST_DATE,DELIST_DATE,LST_STAT,PREV_CLOS_PRICE , "+
            "ENGLISH_INSTR_NAM ,BIG5_CHI_INSTR_NAM,GB_CHI_INSTR_NAM ,CALL_PUT_STAT ,STRK_PRICE,IS_CBBC,IS_WARRANT,CALL_PRICE,EXPR_DATE,WARRANT_UPPER_LVL_INSTR_CDE)"+
        " VALUES " +
            "(:INSTR_CDE ,:ISIN_CDE,:LOT_SIZ,:CCY_CDE,:IS_SUSPD,:IS_CCASS_SETL ,:HAS_STAMP,:LST_DATE,:DELIST_DATE,:LST_STAT,:PREV_CLOS_PRICE , "+
            ":ENGLISH_INSTR_NAM ,:BIG5_CHI_INSTR_NAM,:GB_CHI_INSTR_NAM  ,:CALL_PUT_STAT ,:STRK_PRICE,:IS_CBBC,:IS_WARRANT,:CALL_PRICE,:EXPR_DATE,:WARRANT_UPPER_LVL_INSTR_CDE)";

    private static final String EGIOG_DELETE_SQL=
        "Delete "+
            "FROM MC_TMP_OG_INSTR ";

    private static final String EGIOG_EXPORT_SQL =
            "SELECT  " +
                   "SUBSTR('0000' || h.scty_code,   LENGTH('0000' || h.scty_code) -4,   5) instr_code, " +
                "CASE WHEN isin_code = 'NA' THEN  '' ELSE  isin_code END isin_code, " +
                "lot_size, " +
                "cucy_code, " +
                "susp_flag, " +
                "CCASS_FLAG, " +
                "stamp_duty_flag, " +
                "CASE WHEN listing_date <> '00000000' THEN   to_date(listing_date,   'YYYY-MM-DD') ELSE  NULL END list_date, " +
                "CASE WHEN delisting_date <> '00000000' THEN   to_date(delisting_date,   'YYYY-MM-DD') ELSE  NULL END delisting_date, " +
                "listing_status , " +
                "prev_closing_price, " +
                "REPLACE(SCTY_NAME ,''',''''') scty_name, " +
                "scty_chinese_name_big5, " +
                "scty_chinese_name_gb, " +
                "WNT_CALL_PUT_OPTION, " +
                "WNT_STRIKE_PRICE, " +
                "case when substr(D.FREE_TEXT, 1,2) = 'CP' then 'Y' else 'N' end is_cbbc, " +
                "case when INSTRUMENT_TYPE ='BWRT' then 'Y' when INSTRUMENT_TYPE ='WRNT' then 'Y' else 'N' end is_warrant, " +
                "case when substr(D.FREE_TEXT, 1,2) = 'CP' then  SUBSTR(D.FREE_TEXT, 4, LENGTH(D.FREE_TEXT)-4) else '' end call_price, " +
                "CASE WHEN WNT_MATURITY_DATE <> '00000000' THEN   to_date(WNT_MATURITY_DATE,   'YYYY-MM-DD') ELSE  NULL END expr_date," +
                "WNT_UNDERLYING_SCTY_CODE " +
            "FROM egi_og_bcs_hdr h " +
            "INNER JOIN egi_og_bcs_dtl1 d ON h.scty_code = d.scty_code " +
            "WHERE d.sequence_num = 1";

    private String egiDbUrl;
    private String egiDbUser;
    private String egiDbPassword;
    private String msseDbUrl;
    private String msseDbUser;
    private String msseDbPassword;

    public EgiogExporter() {
    }


    public void setEgiDbUrl(String egiDbUrl) {
        this.egiDbUrl = egiDbUrl;
    }


    public void setEgiDbUser(String egiDbUser) {
        this.egiDbUser = egiDbUser;
    }


    public void setEgiDbPassword(String egiDbPassword) {
        this.egiDbPassword = egiDbPassword;
    }

    public void setMsseDbUrl(String msseDbUrl) {
        this.msseDbUrl = msseDbUrl;
    }


    public void setMsseDbUser(String msseDbUser) {
        this.msseDbUser = msseDbUser;
    }


    public void setMsseDbPassword(String msseDbPassword) {
        this.msseDbPassword = msseDbPassword;
    }

    public void exportToMsseDB(File file) {

    }

    public void exportToMsseDB(String expTime){
        try{
            DriverManagerDataSource dataSourceFrom = new DriverManagerDataSource();
            dataSourceFrom.setUrl(egiDbUrl);
            dataSourceFrom.setUsername(egiDbUser);
            dataSourceFrom.setPassword(egiDbPassword);
            dataSourceFrom.setDriverClassName("oracle.jdbc.driver.OracleDriver");


            DriverManagerDataSource dataSourceTo = new DriverManagerDataSource();
            dataSourceTo.setUrl(msseDbUrl);
            dataSourceTo.setUsername(msseDbUser);
            dataSourceTo.setPassword(msseDbPassword);
            dataSourceTo.setDriverClassName("oracle.jdbc.driver.OracleDriver");


            NamedParameterJdbcTemplate jdbcTemplateFrom = new NamedParameterJdbcTemplate(dataSourceFrom);
            final NamedParameterJdbcTemplate jdbcTemplateTo = new NamedParameterJdbcTemplate(dataSourceTo);


            //Date lastOGUpdateDate = new Date();\
            SqlRowSet srs = jdbcTemplateFrom.queryForRowSet(DEFAULT_EXPORT_EGIOG_DATE_SQL, new HashMap<String,Object>());
            //logger.debug("Load Last Status.");
            if (srs.next()){
                //Main.emailLogger.error("test email");
                //logger.debug("Ready for Download:"+srs.getString("READY_FOR_DOWNLOAD"));
                if(srs.getString("READY_FOR_DOWNLOAD").equals("Y")) {
                    logger.info("EGIOG Export Ready");
                    HashMap<String, Object> paramMap = new HashMap<String, Object>();
                    try {
                        logger.info("Clear MSSE Temp DB");
                        jdbcTemplateTo.update(EGIOG_DELETE_SQL, paramMap);
                        logger.info("MSSE Temp DB Cleared");
                        logger.info("EGIOG Export started");
                        jdbcTemplateFrom.query(EGIOG_EXPORT_SQL , paramMap,
                                new RowCallbackHandler() {
                                    public void processRow(ResultSet rs){
                                        try{
                                            recordCount++;
                                            HashMap<String, Object> paramMapTo = new HashMap<String, Object>();
                                            paramMapTo.put("INSTR_CDE", rs.getString("INSTR_CODE"));
                                            paramMapTo.put("ISIN_CDE", rs.getString("ISIN_CODE"));
                                            paramMapTo.put("LOT_SIZ", rs.getString("LOT_SIZE"));
                                            paramMapTo.put("CCY_CDE", rs.getString("CUCY_CODE"));
                                            paramMapTo.put("IS_SUSPD", rs.getString("SUSP_FLAG"));
                                            paramMapTo.put("IS_CCASS_SETL", rs.getString("CCASS_FLAG"));
                                            paramMapTo.put("HAS_STAMP", rs.getString("STAMP_DUTY_FLAG"));
                                            paramMapTo.put("LST_DATE", rs.getDate("LIST_DATE"));
                                            paramMapTo.put("DELIST_DATE", rs.getDate("DELISTING_DATE"));
                                            paramMapTo.put("LST_STAT", rs.getString("LISTING_STATUS"));
                                            paramMapTo.put("PREV_CLOS_PRICE", rs.getString("PREV_CLOSING_PRICE"));
                                            paramMapTo.put("ENGLISH_INSTR_NAM", rs.getString("SCTY_NAME"));
                                            paramMapTo.put("BIG5_CHI_INSTR_NAM", rs.getString("SCTY_CHINESE_NAME_BIG5"));
                                            paramMapTo.put("GB_CHI_INSTR_NAM", rs.getString("SCTY_CHINESE_NAME_GB"));
                                            paramMapTo.put("CALL_PUT_STAT", rs.getString("WNT_CALL_PUT_OPTION"));
                                            paramMapTo.put("STRK_PRICE", rs.getString("WNT_STRIKE_PRICE"));
                                            paramMapTo.put("EXPR_DATE", rs.getDate("EXPR_DATE"));
                                            paramMapTo.put("IS_CBBC", rs.getString("IS_CBBC"));
                                            paramMapTo.put("IS_WARRANT", rs.getString("IS_WARRANT"));
                                            paramMapTo.put("CALL_PRICE", rs.getString("CALL_PRICE"));
                                            paramMapTo.put("WARRANT_UPPER_LVL_INSTR_CDE", rs.getString("WNT_UNDERLYING_SCTY_CODE"));
                                            jdbcTemplateTo.update(EGIOG_INSERT_SQL, paramMapTo);
                                        }
                                        catch(NullPointerException ne){
                                            String errorMsg = "NullPointerException:"+ne.toString()+"\n";
                                            logger.error(errorMsg,ne);
                                            errorFlag = true;
                                        }
                                        catch(SQLException se){
                                            String errorMsg = "SQLException:"+se.toString()+"\n";
                                            logger.error(errorMsg,se);
                                            errorFlag = true;
                                        }
                                        catch(Exception ex){
                                            String errorMsg = "Exception:"+ex.toString()+"\n";
                                            logger.error(errorMsg,ex);
                                            errorFlag = true;
                                        }
                                    }
                                });
                    } finally {
                        if(errorFlag){
                            Main.emailLogger.error(Main.emailMessage);
                        }
                        else{
                            logger.info("Total Records Exported:"+recordCount);
                            logger.info("EGIOG Export Ended");
                        }
                    }
                }
                else{
                    //check the time
                    Calendar cal = Calendar.getInstance();
                    Date currentDate = cal.getTime();
                    SimpleDateFormat simpleDateformat=new SimpleDateFormat("yyyy-MM-dd");
                    String dateStr = simpleDateformat.format(currentDate)+" "+expTime;
                    Date comDate = dateFormat.parse(dateStr);
                    if(comDate.before(currentDate)){
                        Main.emailLogger.error("EGI-OG Source DB is not ready after the expiry time, please check the log for details");
                    }
                    logger.info("EGIOG Export Ended");
                }
            }
        }
        catch(Exception ex){
            logger.error(ex.toString());
            Main.emailLogger.error(Main.emailMessage);
        }
    }
}
