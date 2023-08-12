package com.qb.question_bank_restapi.database;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String RESOURCE_NAME="jdbc/qb_database";
    private static final DataSource dataSource;

    static {

        try{

            PoolProperties poolProperties = new PoolProperties();
            DatabaseInfo info = new DatabaseInfo();

            poolProperties.setUrl(info.getDatabaseUrl());
            poolProperties.setUsername(info.getUserName());
            poolProperties.setPassword(info.getPassword());
            poolProperties.setDriverClassName(info.getDriverClassName());
            poolProperties.setMaxActive(1500);
            poolProperties.setInitialSize(10);
            poolProperties.setMaxWait(30000);
            poolProperties.setMinEvictableIdleTimeMillis(1800000);
            poolProperties.setTestOnBorrow(true);
            poolProperties.setValidationQuery("SELECT 1");
            poolProperties.setValidationQueryTimeout(30000);

            dataSource = new DataSource();
            dataSource.setPoolProperties(poolProperties);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static Connection getConnection()throws SQLException{
        return dataSource.getConnection();
    }

    public  static void close(Connection connection) throws SQLException {
        connection.close();
    }
}
