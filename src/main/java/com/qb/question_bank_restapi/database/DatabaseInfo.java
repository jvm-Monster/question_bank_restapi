package com.qb.question_bank_restapi.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DatabaseInfo {



    public  static String jdbcDriverType = "com.mysql.cj.jdbc.Driver";
    public  String driverClassName = "com.mysql.cj.jdbc.Driver";

    public  String userName;
    public  String password;
    public  String dataBaseUrl;

    public DatabaseInfo() throws FileNotFoundException {
        Properties qbdb = new Properties();
        try(FileInputStream filePropertiesToRead = new FileInputStream("/home/jvm-monster/Documents/qbdb.properties");
        ){
            qbdb.load(filePropertiesToRead);// to load all properties file into java properties object
            dataBaseUrl = qbdb.getProperty("url");
            userName = qbdb.getProperty("user");
            password = qbdb.getProperty("pwd");
        }catch (FileNotFoundException f){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getDatabaseUrl(){
        return dataBaseUrl;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }

    public String getDriverClassName(){
        return driverClassName;
    }

}
