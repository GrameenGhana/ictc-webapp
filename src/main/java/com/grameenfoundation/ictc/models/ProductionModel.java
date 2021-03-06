/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.ProductionNew;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Sep 29, 2015 11:32:33 AM
 * description:
 */
public class ProductionModel {
    
    
     public boolean ProductionToUpdate(ProductionNew p, Node update) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

         

            System.out.println("biodata :" + p.getUnderlyingNode().getId());
            if (null != p) {
                System.out.println("in production update");
                p.setUpdate(update);
                created = true;
                trx.success();
                return created;
            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

     
        public ProductionNew getProduction(String field, String value) {
//        String q = "Start root=node(0) "
//                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->f-[:"+ICTCRelationshipTypes.HAS_PRODUCTION+
//                "]->p"
//                + " where f." + field + "='" + value + "'"
//                + " return p";
        
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
         String q = "match (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_PRODUCTION+"]->p"+ 
                " where f." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new ProductionNew(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find Product");
        }
         trx.success();
        }
        return null;
    }
        
        
   public Long getMOFAFMPProductionCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype=~'MOFA' WITH n match (f:FARMER)-[:HAS_PRODUCTION]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }

    public Long getACDIVOCAFMPProductionCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype=~'ACDIVOCA' WITH n match (f:FARMER)-[:HAS_PRODUCTION]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }

   
   

}
