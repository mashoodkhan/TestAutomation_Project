package com.hrsoft.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hera.aijaz
 */
public class UMEIDbHelper extends HrSoftDb{
    public List<String> getProductListByCustGuid (String CUST_GUID) throws SQLException {

        String query = "SELECT TOP 100000 \n" +
                "t0.[CUST_GUID] AS [cust_guid], t0.[APP_ID] AS [app_id], \n" +
                "t1.[APP_NAME] AS [app_name], t1.[APP_DESC] AS [app_desc], \n" +
                "(select top 1 trax.relationship_id from tcc_group_relationship_app_xref trax \n" +
                "   inner join tcc_group_relationship_cfg trc on trax.relationship_id = trc.relationship_id and \n" +
                "   trc.relationship_type = 'HIERARCHICAL' and relationship_scope = 'CLIENT' \n" +
                "   where trax.app_id = t0.app_id  and trax.cust_guid = t0.cust_guid) as [mapped_client_hierarchy], \n" +
                "   t0.[APP_DISPLAY_ORDER] AS [app_display_order_af18e525],t0.[cust_guid] AS [_pk$t0$cust_guid], \n" +
                "   t0.[app_id] AS [_pk$t0$app_id] FROM TCC_CUST_APP_CFG t0 LEFT OUTER JOIN TCC_APP_CFG as t1 ON (t0.[app_id] = t1.[app_id]) \n" +
                "WHERE t0.[cust_guid] = ? \n" +
                "ORDER BY \n"+
                "t1.[APP_NAME] ASC";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, CUST_GUID);

        List<String> productList = new ArrayList<>();

        ResultSet resultSet = stmt.executeQuery();

        while (true) {
            if(resultSet.next()) {
                String product = resultSet.getString("app_name").toUpperCase();
                productList.add(product);
            }
            else break;
        }

        resultSet.close();
        stmt.close();
        return productList;
    }

    public List<String> getDataFileByCustGuidAndAppId (String CUST_GUID, String APP_ID) throws SQLException {
        String query = "SELECT \n" +
                "TOP 100000 t0.[CUST_GUID] AS [cust_guid], \n" +
                "t0.[APP_ID] AS [app_id], \n" +
                "t0.[FILE_NAME] AS [file_name], \n" +
                "t0.[FILE_DESCRIPTION] AS [file_description], \n" +
                "t0.[FILE_EXTENSION] AS [file_extension], \n" +
                "t0.[FEED_ID] AS [feed_id], \n" +
                "t0.[TARGET_TYPE] AS [pi - target_type - ncaguuii] \n" +
                "FROM \n" +
                "TCC_DATA_FEED_CFG t0 \n" +
                "WHERE \n" +
                "(\n" +
                "(\n" +
                "t0.[cust_guid] = ? \n" +
                ") \n" +
                "AND (t0.[app_id] = ?)\n" +
                ") \n" +
                "ORDER BY \n" +
                "t0.[FILE_NAME] ASC";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, CUST_GUID);
        stmt.setString(2, APP_ID);

        List<String> dataFileList = new ArrayList<>();

        ResultSet resultSet = stmt.executeQuery();

        while (true) {
            if (resultSet.next()) {
                String dataFile = resultSet.getString("FILE_NAME").toUpperCase();
                dataFileList.add(dataFile);
            }
            else break;
        }
        resultSet.close();
        stmt.close();
        return dataFileList;
    }
}



