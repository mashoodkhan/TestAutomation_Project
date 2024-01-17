package com.hrsoft.db;

import static com.hrsoft.reports.ExtentLogger.*;
import static org.testng.Assert.assertFalse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.postgresql.util.PGobject;



public class HrSoftDb {
    
    protected Connection connection = null;

//    public HrSoftDb (String hostName, String databaseName, String userName, String password) {
//        String connStr = "jdbc:sqlserver://" + hostName + ":1433;databaseName=" + databaseName + ";" + "user=" + userName + ";password=" + password + ";encrypt=true;trustServerCertificate=true;loginTimeout=30;";
//        try {
//            connection = DriverManager.getConnection (connStr);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
    public HrSoftDb ()  {
        String   connectionUrl =  "jdbc:sqlserver://tdb13.ec2.us-east-2.prd.tch:1433;" 
                   + "databaseName=TCC2200QUEIP01;"  //uat env
                   + "user=automation_app;"   //generic user and password
                   + "password=Sh92hkjs8kfm;"  
                   + "encrypt=true;"
                   + "trustServerCertificate=true;"
                   + "loginTimeout=30;";
        try {
           connection = DriverManager.getConnection (connectionUrl);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       }

    
    public List <Map <String, Object>> executeSelect (String query) {
        info ("query is: " + query);
        try (Statement statement = connection.createStatement ();
                ResultSet resultSet = statement.executeQuery (query)) {
            List <Map <String, Object>> tableData = new LinkedList <> ();
            if (resultSet != null) {
                ResultSetMetaData metaData = resultSet.getMetaData ();
                int columns = metaData.getColumnCount ();

                while (resultSet.next ()) {
                    Map <String, Object> row = new HashMap <String, Object> (columns);
                    for (int i = 1; i <= columns; ++i) {
                        row.put (metaData.getColumnName (i), resultSet.getObject (i));
                    }
                    tableData.add (row);
                }
            }
            return tableData;
        } catch (Exception e) {
            info ( e.toString ());
            throw new RuntimeException (e);
        }
    }
    
    public int executeUpdate (String query) {
        info ("query is: " + query);

        try (Statement statement = connection.createStatement ()) {
            assertFalse (statement.execute (query)); // returns false on update
            return statement.getUpdateCount ();
        } catch (Exception e) {
            info ( e.toString ());

            throw new RuntimeException (e);
        }
    }
    public void closeConnection () {
        try {
            connection.close ();
            connection = null;
            info ("DB connection closed");
        } catch (Exception e) {
            info ( e.toString ());

            throw new RuntimeException (e);
        }
    }

    public String jsonToString (Object data) {
        try {
            return new JSONObject ( ((PGobject) data).getValue ()).toString ();
        } catch (Exception e) {
            info ( e.toString ());

            throw new RuntimeException (e);
        }
    }

}
