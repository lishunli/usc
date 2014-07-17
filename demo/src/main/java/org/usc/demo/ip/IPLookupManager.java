package org.usc.demo.ip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

@Service("ipLooker")
public class IPLookupManager
{
    DataSource dataSource;

    private static int IP_LOCATION_CAPACITY = 347570;
    private List<IPRecord> ipRecords;
    private Map<Long, IPInfo> ipInfoCache;
    protected static Logger logger = LoggerFactory.getLogger(IPLookupManager.class);

    @Autowired
    private IPLookupManager(DataSource dataSource)
    {
        ipRecords = new ArrayList<IPRecord>(IP_LOCATION_CAPACITY);
        ipInfoCache = new HashMap<Long, IPInfo>();
        loadInfoFromDB(DataSourceUtils.getConnection(dataSource));
        logger.info("ip infomation loaded! ipinfo count:" + ipRecords.size());
    }

    private void loadInfoFromDB(Connection conn)
    {
        logger.debug("loading ip infomation!");
        try
        {
            logger.info("start load ipinfo!");
            loadIpInfoFromDB(conn);
            logger.info("load ipinfo succ!");
        } catch (Exception e)
        {
            logger.error("jdbc load failed! maybe cannot found jdbc driver class!");
            logger.error(e.getMessage(), e);
        } finally
        {
            DataSourceUtils.releaseConnection(conn, dataSource);
        }
    }

    private void loadIpInfoFromDB(final Connection conn) throws SQLException
    {
        PreparedStatement pstmt = conn.prepareStatement("select start_ip,end_ip,province, areaid from ip_city_cn order by start_ip asc");
        ResultSet rs = null;
        rs = pstmt.executeQuery();
        while (rs.next())
        {
            ipRecords.add(new IPRecord(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4)));
        }
        rs.close();
        pstmt.close();
    }

    public IPInfo lookup(final String ip)
    {
        return lookup(IPUtil.convertIP(ip));
    }

    public IPInfo lookup(final long ip)
    {
        if (ipInfoCache.containsKey(ip))
        {
            return ipInfoCache.get(ip);
        }
        else
        {
            IPRecord ipRecord = findLocation(ip);
            if (ipRecord == null)
                return IPInfo.EMPTY;
            IPInfo ipInfo = new IPInfoX(ipRecord.region);
            ipInfoCache.put(ip, ipInfo);
            return ipInfo;
        }
    }

    private IPRecord findLocation(long ip)
    {
        int mid = 0;
        int min = 0;
        int max = ipRecords.size() - 1;
        int eval = compareIp(ip, ipRecords.get(0).range.startip);
        if (eval == 0)
            return ipRecords.get(0);
        if (eval < 0)
            return null;

        while (min < max)
        {
            mid = getMid(min, max);
            eval = compareIp(ip, ipRecords.get(mid).range.startip);
            if (eval > 0)
                min = mid;
            else if (eval < 0)
            {
                if (mid == max)
                {
                    max--;
                    mid = max;
                }
                else
                    max = mid;
            }
            else
                return ipRecords.get(mid);
        }
        eval = compareIp(ip, ipRecords.get(mid).range.endip);
        if (eval <= 0)
            return ipRecords.get(mid);
        return null;
    }

    private int getMid(int begin, int end)
    {
        int records = (end - begin);
        records >>= 1;
        if (records == 0L)
            records = 1;
        return begin + records;
    }

    private int compareIp(long ip1, long ip2)
    {
        if (ip1 > ip2)
            return 1;
        else if (ip1 < ip2)
            return -1;
        else
            return 0;
    }

    @SuppressWarnings("resource")
    public static HashSet<String> getIpList(String fileName)
    {
        File readFile = new File(fileName);
        BufferedReader bufferedReader = null;
        InputStreamReader fileReader = null;
        HashSet<String> ipList = new HashSet<String>();
        try
        {
            System.out.println(new Date() + " start hander " + readFile.getName());
            fileReader = new InputStreamReader(new FileInputStream(readFile), "UTF-8");
            bufferedReader = new BufferedReader(fileReader);
            while (true)
            {
                try
                {
                    String aLine = bufferedReader.readLine();
                    if (aLine == null || aLine.length() == 0)
                        break;
                    if (!aLine.contains("Ip:"))
                        continue;
                    if (!aLine.trim().equals(""))
                    {
                        String[] spilts = aLine.split("[\t]");
                        String ip = spilts[5].split(":")[1];
                        ipList.add(ip.trim());
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return ipList;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
        // Class.forName("com.mysql.jdbc.Driver").newInstance();
        // Connection conn = DriverManager.getConnection(
        // "jdbc:mysql://10.11.9.15:3306/ips?useUnicode=true&characterEncoding=utf8",
        // "root",
        // "sd-9898w");
        // IPLookupManager iplm = IPLookupManager.getInstance(conn);
        // iplm.loadInfoFromDB(conn);
        // IPInfo ipInfo = iplm.lookup("58.17.138.19");
        // System.out.println(ipInfo.getProvince() + " ");
        // ipInfo = iplm.lookup("119.145.40.161");
        // System.out.println(ipInfo.getProvince() + " ");
    }
}
