package com.myMoneyBuddy.Utils;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myMoneyBuddy.DAOClasses.Trading;
import com.smattme.MysqlExportService;
//import com.sun.java.util.jar.pack.Package.File;

/**
 * Dumper between databases.
 * 
 * @author ndeverge
 */
public final class DatabaseBackup {

    /**
     * Le logger.
     */
    private static final Log LOGGER = LogFactory.getLog(DatabaseBackup.class);




    public static void main(final String[] args) {
        try {
        	//required properties for exporting of db
        	Properties properties = new Properties();
        	properties.setProperty(MysqlExportService.DB_NAME, "jdbc:mysql://aa1l15v7ieqso0t.cxwkao9xfcpo.ap-south-1.rds.amazonaws.com:3306/ebdb");
        	properties.setProperty(MysqlExportService.DB_USERNAME, "moneybuddydb");
        	properties.setProperty(MysqlExportService.DB_PASSWORD, "moneybuddyproddb");
        	properties.setProperty(MysqlExportService.PRESERVE_GENERATED_ZIP, "true");
        	//properties relating to email config
/*        	properties.setProperty(MysqlExportService.EMAIL_HOST, "smtp.mailtrap.io");
        	properties.setProperty(MysqlExportService.EMAIL_PORT, "25");
        	properties.setProperty(MysqlExportService.EMAIL_USERNAME, "mailtrap-username");
        	properties.setProperty(MysqlExportService.EMAIL_PASSWORD, "mailtrap-password");
        	properties.setProperty(MysqlExportService.EMAIL_FROM, "test@smattme.com");
        	properties.setProperty(MysqlExportService.EMAIL_TO, "backup@smattme.com");*/

        	//set the outputs temp dir
        	Properties configProperties = new Properties();
			String propFilePath = "../../../config/config.properties";

			configProperties.load(Trading.class.getResourceAsStream(propFilePath));
        	System.out.println("extenal file path : "+ new java.io.File(configProperties.getProperty("DB_SRC_DIR_NAME")+"external").getPath());
        	properties.setProperty(MysqlExportService.TEMP_DIR, new java.io.File(configProperties.getProperty("DB_SRC_DIR_NAME")+"external").getPath());

        	MysqlExportService mysqlExportService = new MysqlExportService(properties);
        	
        	mysqlExportService.clearTempFiles(false);
        	mysqlExportService.export();
        	
        	String generatedSql = mysqlExportService.getGeneratedSql();
        } catch (Exception e) {
            LOGGER.error("", e);
        }
    }

}
