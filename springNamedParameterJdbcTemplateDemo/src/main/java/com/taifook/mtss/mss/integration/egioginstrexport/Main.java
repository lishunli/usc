package com.taifook.mtss.mss.integration.egioginstrexport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final String CONF_FILE_NAME = "src\\main\\extconf\\config.properties";
    private static final String CONF_KEY_EGIOG_DB_URL = "egiDbUrl";
    private static final String CONF_KEY_EGIOG_DB_USER = "egiDbUser";
    private static final String CONF_KEY_EGIOG_DB_PASSWORD = "egiDbPassword";
    private static final String CONF_KEY_MSSE_DB_URL = "msseDbUrl";
    private static final String CONF_KEY_MSSE_DB_USER = "msseDbUser";
    private static final String CONF_KEY_MSSE_DB_PASSWORD = "msseDbPassword";
    private static final String CONF_KEY_EXP_TIME = "expiryTime";

    private static final String MSS_ERROR_LOGGER = "MSS_ERROR_LOGGER";
    private static boolean errorFlag = false;
    static Logger logger = LoggerFactory.getLogger(Main.class);
    static Logger emailLogger = LoggerFactory.getLogger(MSS_ERROR_LOGGER);
    public static final String emailMessage = "EGI-OG Export is failed, please check the error log for detail.";

    @SuppressWarnings("unused")
    public static void main(String[] args)  {
        logger.info("EGIOG Instrument Export Started");

        String egiDbUrl = null;
        String egiDbUser = null;
        String egiDbPassword = null;
        String msseDbUrl = null;
        String msseDbUser = null;
        String msseDbPassword = null;

        String configFileName = CONF_FILE_NAME;
        String fileName = null;
        String expiryTime = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        // process command line
        Options options = new Options();

        options.addOption("filename", true, "The prefix of output file. Default is 'dat/commission_', If the prefix is 'mss_', then the output file name will be 'mss_YYYYMMDD.dat' (YYYYMMDD is system date)");
        options.addOption("config", true, "Config file name");
        options.addOption(CONF_KEY_EGIOG_DB_URL, true, "Database URL, e.g. jdbc:oracle:thin:@HOST:PORT:SID");
        options.addOption(CONF_KEY_EGIOG_DB_USER, true, "Database User");
        options.addOption(CONF_KEY_EGIOG_DB_PASSWORD, true, "Database Password");
        options.addOption(CONF_KEY_MSSE_DB_URL, true, "Destination Database URL, e.g. jdbc:oracle:thin:@HOST:PORT:SID");
        options.addOption(CONF_KEY_MSSE_DB_USER, true, "Destination Database User");
        options.addOption(CONF_KEY_MSSE_DB_PASSWORD, true, "Destination Database Password");
        options.addOption(CONF_KEY_EXP_TIME, false, "Expiry Time for the program");
        options.addOption("help", false, "Print this help message");


        CommandLineParser parser = new GnuParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            errorFlag = true;
            System.err.println("Failed to parse argument: "+ e.getMessage());
            logger.error("Failed to parse argument: "+ e.getMessage());
            printUsage(options);
            System.exit(1);
        }

        if (cmd.hasOption("help")) {
            printUsage(options);
            System.exit(2);
        }

        if (cmd.hasOption("config")) {
            configFileName = cmd.getOptionValue("config", CONF_FILE_NAME);
        }
        if (cmd.hasOption(CONF_KEY_EGIOG_DB_URL)) {
            egiDbUrl = cmd.getOptionValue(CONF_KEY_EGIOG_DB_URL);
        }
        if (cmd.hasOption(CONF_KEY_EGIOG_DB_USER)) {
            egiDbUser = cmd.getOptionValue(CONF_KEY_EGIOG_DB_USER);
        }
        if (cmd.hasOption(CONF_KEY_EGIOG_DB_PASSWORD)) {
            egiDbPassword = cmd.getOptionValue(CONF_KEY_EGIOG_DB_PASSWORD);
        }
        if (cmd.hasOption(CONF_KEY_MSSE_DB_URL)) {
            msseDbUrl = cmd.getOptionValue(CONF_KEY_MSSE_DB_URL);
        }
        if (cmd.hasOption(CONF_KEY_MSSE_DB_USER)) {
            msseDbUser = cmd.getOptionValue(CONF_KEY_MSSE_DB_USER);
        }
        if (cmd.hasOption(CONF_KEY_MSSE_DB_PASSWORD)) {
            msseDbPassword = cmd.getOptionValue(CONF_KEY_MSSE_DB_PASSWORD);
        }
        if (cmd.hasOption(CONF_KEY_EXP_TIME)) {
            expiryTime = cmd.getOptionValue(CONF_KEY_EXP_TIME);
        }
        if (cmd.hasOption("filename")) {
            fileName = cmd.getOptionValue("filename");
        }

        // read config
        try {
            Properties config = new Properties();

            config.load(new FileInputStream(new File(configFileName)));

            if (egiDbUrl == null) {
                egiDbUrl = config.getProperty(CONF_KEY_EGIOG_DB_URL);
            }
            if (egiDbUser == null) {
                egiDbUser = config.getProperty(CONF_KEY_EGIOG_DB_USER);
            }
            if (egiDbPassword == null) {
                egiDbPassword = config.getProperty(CONF_KEY_EGIOG_DB_PASSWORD);
            }
            if (msseDbUrl == null) {
                msseDbUrl = config.getProperty(CONF_KEY_MSSE_DB_URL);
            }
            if (msseDbUser == null) {
                msseDbUser = config.getProperty(CONF_KEY_MSSE_DB_USER);
            }
            if (msseDbPassword == null) {
                msseDbPassword = config.getProperty(CONF_KEY_MSSE_DB_PASSWORD);
            }
            if (expiryTime == null) {
                expiryTime = config.getProperty(CONF_KEY_EXP_TIME);
            }

        } catch (IOException e) {
            errorFlag = true;
            logger.error("Failed to open config file " + configFileName + ", ignore");
            System.err.println("Failed to open config file " + configFileName + ", ignore");
        }

        if (egiDbUrl == null) {
            System.err.println("Source DB URL not provided, please define in command line argument or config file");
            errorFlag = true;
            logger.error("Source DB URL not provided, please define in command line argument or config file");
            System.exit(1);
        }
        if (egiDbUser == null) {
            errorFlag = true;
            System.err.println("Source DB User not provided, please define in command line argument or config file");
            logger.error("Source DB User not provided, please define in command line argument or config file");
            System.exit(1);
        }
        if (egiDbPassword == null) {
            errorFlag = true;
            System.err.println("Source DB Password not provided, please define in command line argument or config file");
            logger.error("Source DB Password not provided, please define in command line argument or config file");
            System.exit(1);
        }

        if (msseDbUrl == null) {
            errorFlag = true;
            System.err.println("Destination DB URL not provided, please define in command line argument or config file");
            logger.error("Destination DB URL not provided, please define in command line argument or config file");
            System.exit(1);
        }
        if (msseDbUser == null) {
            errorFlag = true;
            System.err.println("Destination DB User not provided, please define in command line argument or config file");
            logger.error("Destination DB User not provided, please define in command line argument or config file");
            System.exit(1);
        }
        if (msseDbPassword == null) {
            errorFlag = true;
            System.err.println("Destination DB Password not provided, please define in command line argument or config file");
            logger.error("Destination DB Password not provided, please define in command line argument or config file");
            System.exit(1);
        }
        if (expiryTime == null) {
            expiryTime = "09:30:00";
        }

        //logger.debug("errorFlag:"+errorFlag);
        //logger.debug(expiryTime);
        if(errorFlag){
            emailLogger.error(Main.emailMessage);
        }
        else{
            EgiogExporter egiogExporter  = new EgiogExporter();
            egiogExporter.setEgiDbUrl(egiDbUrl);
            egiogExporter.setEgiDbUser(egiDbUser);
            egiogExporter.setEgiDbPassword(egiDbPassword);
            egiogExporter.setMsseDbUrl(msseDbUrl);
            egiogExporter.setMsseDbUser(msseDbUser);
            egiogExporter.setMsseDbPassword(msseDbPassword);
            egiogExporter.exportToMsseDB(expiryTime);
        }

       /*
        try {
            if (fileName == null) {
                fileName = "dat/commission_";
            }

            egiogExporter.exportToMsseDB(fileName + dateFormat.format(new Date()) + ".dat");

        } catch (FileNotFoundException e) {
            System.err.println("Failed to export to " + fileName);
            e.printStackTrace();
        }
        */
    }

    private static void printUsage(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -jar egiogExporter.jar", options);
    }

}
