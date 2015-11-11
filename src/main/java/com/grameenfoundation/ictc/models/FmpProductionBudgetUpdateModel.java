/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.FmpProductionBudgetUpdate;
import com.grameenfoundation.ictc.domains.ProductionUpdate;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Nov 3, 2015 1:18:25 PM
 * description:
 */
public class FmpProductionBudgetUpdateModel {
    
    
    
     public  FmpProductionBudgetUpdate getFmpProductionBudgetUpdate(String field, String value) {
        String q = "match (n:PARENT)-[:FARMER]->(f)-[:"+ICTCRelationshipTypes.FMP_PRODUCTION_BUDGET+"]->(p)-[:"+ICTCRelationshipTypes.UPDATE+"]->m "
                + " where p." + field + "='" + value + "'"
                + " return m";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q,"m");
            if (null != node) {
                return new  FmpProductionBudgetUpdate(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find Production Update");
        }

        return null;
    }

}