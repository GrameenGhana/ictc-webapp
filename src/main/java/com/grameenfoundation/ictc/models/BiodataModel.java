/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.utils.CRUDServices;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import static com.grameenfoundation.ictc.utils.Neo4jServices.getIterativeNode;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.AgentWrapper;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.CommunityCounterWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.IteratorUtil;
//import org.neo4j.kernel.impl.util.StringLogger;
import scala.collection.Iterator;
import scala.sys.process.processInternal;

/**
 *
 * @author Joseph George Davis
 * @date Jul 16, 2015 1:49:34 PM description:
 */
public class BiodataModel {

    Logger log = Logger.getLogger(BiodataModel.class.getName());
    Node FarmerParent;

    public boolean createBiodata(BiodataWrapper biodataWrapper) {
        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Node farmerNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARMER);

            Biodata biodata = new Biodata(farmerNode);

            if (null == biodataWrapper) {
                log.info("Biodata is invalid");
                created = false;
            } else {
              //  FarmerParent = ParentNode.FarmerParentNode();

                biodata.setFirstname(biodataWrapper.getFirstName());
                biodata.setLastname(biodataWrapper.getLastName());
                biodata.setAge(biodataWrapper.getAge());
                biodata.setVillage(biodataWrapper.getVillage());
                biodata.setDistrict(biodataWrapper.getDistrict());
                biodata.setCommunity(biodataWrapper.getCommunity());
                biodata.setGender(biodataWrapper.getGender());
                biodata.setMaritalstatus(biodataWrapper.getMaritalStatus());
                biodata.setNickname(biodataWrapper.getNickname());
                biodata.setNumberofchildren(biodataWrapper.getNumberOfChildren());
                biodata.setNumberofdependants(biodataWrapper.getNumberOfDependants());
                biodata.setEducation(biodataWrapper.getEducation());
                biodata.setACDIVOCAFARMERID(biodataWrapper.getACDIVOCAFARMERID());
               
                biodata.setDataCollcetedBy(biodataWrapper.getDataCollcetedBy());
                biodata.setDataReviewedBy(biodataWrapper.getDataReviewedBy());
                biodata.setDateCollected(biodataWrapper.getDateCollected());
                biodata.setDateReviewed(biodataWrapper.getDateReviewed());
                biodata.setDateofbirth(biodataWrapper.getDateofbirth());
                biodata.setDistrict("");
               
                biodata.setFBOPosition(biodataWrapper.getFBOPosition());
                biodata.setFamer_type(biodataWrapper.getFamer_type());
                biodata.setFkAggregatorProfile(biodataWrapper.getFkAggregatorProfile());
                biodata.setFkFBOProfile(biodataWrapper.getFkFBOProfile());
                biodata.setFkFYName(biodataWrapper.getFkFYName());
                biodata.setFkFarmerHHProfile(biodataWrapper.getFkFarmerHHProfile());
                biodata.setFkNucleusFarmerProfile(biodataWrapper.getFkNucleusFarmerProfile());
                
                biodata.setImage_url(biodataWrapper.getImage_url());
                biodata.setIsOutGrower(biodataWrapper.getIsOutGrower());
                biodata.setIsWithFBO(biodataWrapper.getIsWithFBO());
                biodata.setIsWithPA(biodataWrapper.getIsWithPA());
                biodata.setTelephonenumber(biodataWrapper.getTelephonenumber());
                biodata.setNoMaleEmployees(biodataWrapper.getNoMaleEmployees());
                biodata.setNoFemaleEmployees(biodataWrapper.getNoFemaleEmployees());
                biodata.setLastModifiedDate(new Date());

              //  FarmerParent.createRelationshipTo(farmerNode, ICTCRelationshipTypes.FARMER);

                log.log(Level.INFO, "new node created {0}", biodata.getUnderlyingNode().getId());
                trx.success();

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }

        return created;
    }

    public boolean createBiodata(Node node) {
        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            if (null == node) {
                log.info("Biodata is invalid");
                created = false;
            } else {
                FarmerParent = ParentNode.FarmerParentNode();
                FarmerParent.createRelationshipTo(node, ICTCRelationshipTypes.FARMER);

                log.log(Level.INFO, "new node created {0}", node.getId());
                trx.success();

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }

        return created;
    }
    
    
     public List<Biodata> findAllFarmersByActivity(Enum relationship) {
        List<Biodata> aglist = new ArrayList<>();

        String q = " match (f:FARMER)-[:"+relationship+"]->p return  DISTINCT f"; 

        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Result result = Neo4jServices.executeCypherQuery(q);

            ResourceIterator<Node> n_column = result.columnAs("f");
            while (n_column.hasNext()) {
                // aglist.add(new Agent(n_column.next()));
                Biodata b = new Biodata(n_column.next());

                aglist.add(b);

            }
            tx.success();
        }
        
        
        return aglist;
     }
    
     public List<Biodata> findAllACDIVOCAFarmers() {
        List<Biodata> aglist = new ArrayList<>();

        String q = "match (n:AGENT) where n.agenttype='ACDIVOCA' WITH n match (l:FARMER) where l.CreatedById=n.Id return l";

        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Result result = Neo4jServices.executeCypherQuery(q);

            ResourceIterator<Node> n_column = result.columnAs("l");
            while (n_column.hasNext()) {
                // aglist.add(new Agent(n_column.next()));
                Biodata b = new Biodata(n_column.next());

                aglist.add(b);

            }
            tx.success();
        }
        
        
        return aglist;
     }
     
      public List<Biodata> findAllACDIVOCA() {
        List<Biodata> aglist = new ArrayList<>();

        String q = "MATCH (l:FARMER) WHERE EXISTS(l.ACDIVOCAFARMERID)  return l";

        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Result result = Neo4jServices.executeCypherQuery(q);

            ResourceIterator<Node> n_column = result.columnAs("l");
            while (n_column.hasNext()) {
                // aglist.add(new Agent(n_column.next()));
                Biodata b = new Biodata(n_column.next());

                aglist.add(b);

            }
            tx.success();
        }
        
        
        return aglist;
     }
     
     
     public List<Biodata> findAllMOFAFarmers() {
        List<Biodata> aglist = new ArrayList<>();

        String q = "match (n:AGENT) where n.agenttype='MOFA' WITH n match (l:FARMER) where l.CreatedById=n.Id return l";

        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Result result = Neo4jServices.executeCypherQuery(q);

            ResourceIterator<Node> n_column = result.columnAs("l");
            while (n_column.hasNext()) {
                // aglist.add(new Agent(n_column.next()));
                Biodata b = new Biodata(n_column.next());

                aglist.add(b);

            }
            tx.success();
        }
        
        
        return aglist;
     }
     
     
       public List<Biodata> findFarmerByAgentType(String agent) {
        List<Biodata> aglist = new ArrayList<>();

        String q = "match (n:AGENT) where n.agenttype='"+agent+"' WITH n match (l:FARMER) where l.CreatedById=n.Id return l";

        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Result result = Neo4jServices.executeCypherQuery(q);

            ResourceIterator<Node> n_column = result.columnAs("l");
            while (n_column.hasNext()) {
                // aglist.add(new Agent(n_column.next()));
                Biodata b = new Biodata(n_column.next());

                aglist.add(b);

            }
            tx.success();
        }
        
        
        return aglist;
     }

    public Biodata getBiodata(String field, String value) {
        
        
//        String q = "Start root=node(0) "
//                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->p"
//                + " where p." + field + "='" + value + "'"
//                + " return p";
//        
        String q = "match (l:FARMER) WHERE l." + field + "='" + value + "' return  l ";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "l");
            if (null != node) {
                return new Biodata(node);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to Find Biodata");
        }
       

        return null;
    }
    
    
    

    public List<BiodataWrapper> getBioData(String field, String value) {
        List<Biodata> bioData = new ArrayList<>();
        try {

            return Neo4jServices.findByLabel(ICTCRelationshipTypes.FARMER, "", "");
//            Iterator<Node> n_column = Neo4jServices.findAllByPrimaryRelation(ICTCRelationshipTypes.FARMER, null);
//            while (n_column.hasNext()) {
//                Node node = n_column.next();
//                try {
//                    System.out.println("Node I : "+node.getId());
//                    System.out.println("Node I I: "+(String)node.getProperty(Biodata.FIRST_NAME));
//                } catch (Exception e) {
//                    System.out.println("Exception e : "+e.getLocalizedMessage());
//                }
//                Biodata bd = new Biodata(node);
//                try {
//                    System.out.println("NDII : "+bd.getFirstname());
//                } catch (Exception e) {
//                }
//                bioData.add(bd);
//            }

        } catch (Exception e) {
            System.out.println("Unable to Find Bio Data List  : " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return null;
    }

    
    public List<BiodataWrapper>  getBioDataSearch( String value, long lastModified){
        
        //String q=" match(l:FARMER) WHERE l."+Biodata.CREATED_BY+" ='"+value+"' and l."+Biodata.LAST_MODIFIED+" >= "+lastModified+" return  l";
         //String q=" match(l:FARMER) WHERE l."+Biodata.CREATED_BY+" ='"+value+"' and l."+Biodata.LAST_MODIFIED+" <= "+lastModified+" return  l";
         String q=" match(l:FARMER) WHERE l."+Biodata.CREATED_BY+" ='"+value+"' return  l";
        System.out.println(q);
        return Neo4jServices.getIterativeNode(q);
    
  //  getIterativeNode
    }
    public List<BiodataWrapper> getBioDataSearch(String field, String value) {
        List<Biodata> bioData = new ArrayList<>();
        try {

            return Neo4jServices.findByLabel(ICTCRelationshipTypes.FARMER, field, value);
//            Iterator<Node> n_column = Neo4jServices.findAllByPrimaryRelation(ICTCRelationshipTypes.FARMER, null);
//            while (n_column.hasNext()) {
//                Node node = n_column.next();
//                try {
//                    System.out.println("Node I : "+node.getId());
//                    System.out.println("Node I I: "+(String)node.getProperty(Biodata.FIRST_NAME));
//                } catch (Exception e) {
//                    System.out.println("Exception e : "+e.getLocalizedMessage());
//                }
//                Biodata bd = new Biodata(node);
//                try {
//                    System.out.println("NDII : "+bd.getFirstname());
//                } catch (Exception e) {
//                }
//                bioData.add(bd);
//            }

        } catch (Exception e) {
            System.out.println("Unable to Find Bio Data List  : " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return null;
    }

    public boolean BiodataToFarmManagement(String biodata, Node farmManagement) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFarmManagement(farmManagement);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToHarvest(String biodata, Node harvest) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setHarvest(harvest);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToPostHarvest(String biodata, Node postHarvest) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setPostHarvest(postHarvest);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToStorage(String biodata, Node storage) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setStorage(storage);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToMarketing(String biodata, Node marketing) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setMarketing(marketing);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToTechNeeds(String biodata, Node techNeeds) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setTechNeeds(techNeeds);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }
    
      public boolean BiodataToFarmCreditPlan(Biodata b, Node FCP) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

           // Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != b) {

                b.setFarmCreditPlan(FCP);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }
  public boolean BiodataToFarmCreditPrevious(Biodata b, Node FCP) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

           // Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != b) {

                b.setFarmCreditPlan(FCP);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }
  
   public boolean BiodataToFarmCreditUpdate(Biodata b, Node FCP) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

           // Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != b) {

                b.setFarmCreditUpdate(FCP);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToOperations(String biodata, Node operations) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFarmOperation(operations);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToFMP(String biodata, Node fmp) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFMP(fmp);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToMeeting(String biodata, Node meeting) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFarmerMeeting(meeting);
                created = true;
                

            }
            trx.success();
        } catch (Exception e) {
            System.out.println("error");
            //created = false;
            e.printStackTrace();

        }

        return created;
    }

    public boolean BiodataToProduction(String biodata, Node production) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setProduction(production);
                created = true;
               

            }
            
             trx.success();
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToProfiling(String biodata, Node profile) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setProfiling(profile);
                created = true;
               

            }
            
             trx.success();
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public BiodataWrapper getBiodataByFieldValue(String field, String value) {
//        String q = "Start root=node(0) "
//                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->p"
//                + " where p." + field + "='" + value + "'"
//                + " return p";
        String q = "match (l:FARMER) WHERE l." + field + "='" + value + "' return  l ";
        System.out.println("Query " + q);
        try {
            List<BiodataWrapper> wrappers = Neo4jServices.getIterativeNode(q);
            System.out.println("Received : wrapp " + wrappers.size());
            if (wrappers.isEmpty()) {
                return null;
            } else {
                System.out.println("Returned 111");
                return wrappers.get(0);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find geofence");
        }

        return null;
    }

    public List<String> getCommunitiesList() {

        try {
            return Neo4jServices.getIterativeString("match (n:FARMER) RETURN DISTINCT n.community as l");
        } catch (Exception e) {
            System.out.println("Unable to Find Bio Data List  : " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return null;
    }

    public List<String> getVillageList() {

        try {
            return Neo4jServices.getIterativeString("match (n:FARMER) RETURN DISTINCT n.village as l");
        } catch (Exception e) {
            System.out.println("Unable to Find Bio Data List  : " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return null;
    }

    public Long getFarmerCount() {

        return Neo4jServices.getAggregatedValue(" match (n:FARMER) RETURN count(DISTINCT n.Id) as l");
    }
    
     public Long getMOFAAgentCount() {

        return Neo4jServices.getAggregatedValue(" match (n:AGENT) where n.agenttype='MOFA' return count(n.Id) as l");
    }

    public Long getACDIVOCAAgentCount() {

        return Neo4jServices.getAggregatedValue(" match (n:AGENT) where n.agenttype='ACDIVOCA' return count(DISTINCT n.Id) as l");
    }
    
    public Long getACDIVOCAFarmerCount() {

        return Neo4jServices.getAggregatedValue(" match (n:AGENT) where n.agenttype='ACDIVOCA' WITH n match (f:FARMER) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
    
    public Long getMOFAFarmerCount() {

        return Neo4jServices.getAggregatedValue(" match (n:AGENT) where n.agenttype='MOFA' WITH n match (f:FARMER) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
     public Long getFarmerCountByAgentType(String agent) {

        return Neo4jServices.getAggregatedValue(" match (n:AGENT) where n.agenttype='"+agent+"' WITH n match (f:FARMER) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
    
    public Long getCommunityCount() {

        return Neo4jServices.getAggregatedValue(" match (n:FARMER) RETURN count(DISTINCT n.village) as l");
    }

    public Long getAgentCount() {

        return Neo4jServices.getAggregatedValue(" match (n:AGENT) RETURN count(n) as l");
    }
    
    
     public Long getProfileCount() {

        //return Neo4jServices.getAggregatedValue(" match (n:PROFILE) RETURN count(n) as l");
       
               
        return Neo4jServices.getAggregatedValue("match (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_PROFILING+"]->p RETURN count(DISTINCT f.Id) as l");
    }
     
     public Long getBaselineProductionCount() {

        return Neo4jServices.getAggregatedValue(" match (n:BASELINE_PRODUCTION) RETURN count(n) as l");
    }
     
    public Long getBaselineProductionBudgetCount() {

        return Neo4jServices.getAggregatedValue(" match (n:BASELINE_PRODUCTION_BUDGET) RETURN count(n) as l");
    }
    
     public Long getFMPProductionCount() {

        return Neo4jServices.getAggregatedValue(" match (n:PRODUCTION) RETURN count(n) as l");
    }
    
      public Long getFMPProductionBudgetCount() {

        return Neo4jServices.getAggregatedValue(" match (n:FMP_PRODUCTION_BUDGET) RETURN count(n) as l");
    }
     
    public Long getFMPProductionBudgetUpdateCount() {

        return Neo4jServices.getAggregatedValue(" match (n:FMP_PRODUCTION_BUDGET_UPDATE) RETURN count(n) as l");
    }
      
    public Long getFMPPostHarvestCount() {

        return Neo4jServices.getAggregatedValue(" match (n:POSTHARVEST) RETURN count(n) as l");
    }
    
    
     public Long getBaselinePostHarvestCount() {

        return Neo4jServices.getAggregatedValue(" match (n:BASELINE_POST_HARVEST) RETURN count(n) as l");
    }
     
     public Long getBaselinePostHarvestBudgetCount() {

        return Neo4jServices.getAggregatedValue(" match (n:BASELINE_POST_HARVEST_BUDGET) RETURN count(n) as l");
    }
    
      public Long getFMPPostHarvestBudgetCount() {

        return Neo4jServices.getAggregatedValue(" match (n:FMP_POSTHARVEST_BUDGET) RETURN count(n) as l");
    }
      
    
     public Long getUpdateCount() {

        return Neo4jServices.getAggregatedValue(" match (n:UPDATE) RETURN count(n) as l");
    }
      
      public Long getCropAssessmentCount() {

        return Neo4jServices.getAggregatedValue(" match (n: FIELD_CROP_ASSESSMENT) RETURN count(n) as l");
    }
      
   public Long getFarmerActivityMonitoring(String partner,Enum relationship)
   {
     return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype='"+partner+"' WITH n match (f:FARMER)-[:"+relationship+"]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");  
   }
      
    public Long getACDIVOCAUpdateCount()
    {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype='ACDIVOCA' WITH n match (f:FARMER)-[]->(p)-[:UPDATE]->(u) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
     public Long getACDIVOCABaselineProductionCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype='ACDIVOCA' WITH n match (f:FARMER)-[:HAS_BASELINE_PRODUCTION]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
     
     public Long getACDIVOCABaselinePostHarvestCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype='ACDIVOCA' WITH n match (f:FARMER)-[:HAS_FARMCREDIT_PREVIOUS]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }

     public Long getACDIVOCAFarmCreditPreviousCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype='ACDIVOCA' WITH n match (f:FARMER)-[:HAS_BASELINE_POSTHARVEST]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
     
    public Long getACDIVOCAFMPProductionCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype=~'ACDIVOCA' WITH n match (f:FARMER)-[:HAS_PRODUCTION]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
      
     public Long getACDIVOCAFMPPostHarvestCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype=~'ACDIVOCA' WITH n match (f:FARMER)-[:HAS_POSTHARVEST]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
     public Long getACDIVOCAFFarmCreditPlanCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype=~'ACDIVOCA' WITH n match (f:FARMER)-[:HAS_FARMCREDIT_PLAN]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
     
   public Long getACDIVOCAFFMPProductionUpdateCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype=~'ACDIVOCA' WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
    public Long getMOFAUpdateCount()
    {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype=~'MOFA' WITH n match (f:FARMER)-[]->(p)-[:UPDATE]->(u) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    } 
    
      public Long getACDIVOCAFCPCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype=~'ACDIVOCA' WITH n match (f:FARMER)-[:HAS_FIELD_CROP_ASSESSMENT]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
   
    public Long getACDIVOCAPostHarvestUpdateCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype=~'ACDIVOCA' WITH n match (f:FARMER)-[:HAS_POSTHARVEST_UPDATE]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
    
    public Long getACDIVOCAFarmCreditUpdateCount() {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype=~'ACDIVOCA' WITH n match (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
    
    public Long getParameterCountByAgentType(ICTCRelationshipTypes relationship,String partner) {
        return Neo4jServices.getAggregatedValue("match (n:AGENT) where n.agenttype=~'"+partner+"' WITH n match (f:FARMER)-[:"+relationship+"]->(p) where f.CreatedById=n.Id return count(DISTINCT f.Id) as l");
    }
    

    public List<CommunityCounterWrapper> getCommunityWrapper() {
       List<CommunityCounterWrapper>  ccw= new ArrayList<>();
        String q = "match (n:FARMER) RETURN n.community as c, count(n.community) as s order by n.community";

        Iterator<Long> n_column = null;
        org.neo4j.cypher.javacompat.ExecutionResult result = null;
        // let's execute a query now
//        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
//            org.neo4j.cypher.javacompat.ExecutionEngine engine = new org.neo4j.cypher.javacompat.ExecutionEngine(
//                    ICTCDBUtil.getInstance().getGraphDB(), StringLogger.SYSTEM);
//            result = engine.execute(q);
//
//        ResourceIterator<Object> communities = result.columnAs("c");
//	ResourceIterator<Object> sumations = result.columnAs("s");
//         String com =""; long l =0;
//        while(communities.hasNext())
//        {
//            try {
//                
//            
//            try {
//                  com = (String)communities.next();
//            } catch (Exception e) {
//                 System.out.println("Error comm: "+e.getLocalizedMessage());
//                com="Null";
//            }
//           
//            try {
//                Object sums = sumations.next();
//                System.out.println("Sum: "+sums.toString());
//                l = (Long)sumations.next();
//            } catch (Exception e) {
//                 System.out.println("Error l: "+e.getLocalizedMessage());
//                l=0;
//            }
//            
//            ccw.add(new CommunityCounterWrapper(com, l));} catch (Exception e) {
//                System.out.println("Error: "+e.getLocalizedMessage());
//            }
//        }
//        
////            while (result.hasNext()) {
////                CommunityCounterWrapper  communityWrapper = new CommunityCounterWrapper();
////                
////                Map<String, Object> row = (Map<String, Object>) result.next();
////                for (Entry<String, Object> column : row.entrySet()) {
////                    if(column.getKey().equalsIgnoreCase("c"))
////                        communityWrapper.setCommunity((String)column.getValue());
////                    else
////                        communityWrapper.setNoOfFarmers((Long)column.getValue());
////                        
////                    
////                }
////                ccw.add(communityWrapper);
////            }
//
//        }

        return ccw;
    }
    
    
    public boolean lastmodifiedUpdate(String id,long lastmodified)
    {
         boolean updated = false;
         try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
         Biodata bio = getBiodata(Biodata.ID, id);
         
             if (null != bio) {

                 bio.setLastModifiedDate(lastmodified);
                
                 updated = true;
                 log.log(Level.INFO, "Bio Data Successfully Updated with lastmodified date {0}", updated);
                 
             } else {
                  log.log(Level.INFO, "Farmer not available");
                   trx.success();
             }
             
           trx.success();
        }
         
         return updated;
    }

      public boolean BiodataUpdate(String id, Map<String, String> data) {

        Biodata bio = getBiodata(Biodata.ID, id);
        boolean updated = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            //If the setting is not null
            if (null != bio) {

                for (Map.Entry<String, String> dataEntry : data.entrySet()) {

                    // get the field name
                    String fieldName = dataEntry.getKey();
                    // get the field value
                    String fieldValue = dataEntry.getValue();
                    System.out.println("Updating : " + fieldName + " <> " + fieldValue);
                    // Assigning the alias
                    if (fieldName.equalsIgnoreCase(Biodata.CLUSTER)) {
                        if (null != fieldValue) {
                            bio.setCluster(fieldValue);
                        }
                    }
                    if (fieldName.equalsIgnoreCase(Biodata.FARM_AREA)) {
                        if (null != fieldValue) {
                            bio.setFarmarea(fieldValue);
                        }
                    }
                    if (fieldName.equalsIgnoreCase(Biodata.FARM_PERIMETER)) {
                        if (null != fieldValue) {
                            bio.setFarmperimeter(fieldValue);
                        }
                    }

                    if (fieldName.equalsIgnoreCase(Biodata.IMAGE_URL)) {
                        if (null != fieldValue) {
                            bio.setImage_Url(fieldValue);
                        }
                    }

                    if (fieldName.equalsIgnoreCase(Biodata.CREATED_BY)) {

                        if (null != fieldValue) {

                            bio.setCreatedById(fieldValue);
                        }
                    }
                   

                }
                updated = true;
                log.log(Level.INFO, "Bio Data Successfully Updated {0}", updated);
                trx.success();

                

            } else {

                log.info("Unable to update Bio Data");
            }
        }
        return updated;
    }

    public boolean BiodataToBP(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setBP(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToBPB(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setBPB(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToBPHB(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setBPHB(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToBPH(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setBPH(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToFMPPB(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFMPPB(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToFMPPHB(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFMPPHB(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToFCA(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFCA(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }
    
    public Object getFarmerCountByAgent(String AgentId)
    {
        String q = " match (f:FARMER) where f.CreatedById='"+AgentId+"'"+
                " return count(DISTINCT f.Id)";
        
        return Neo4jServices.getAggregateItem(q);
    }
    
    
    public Object getFarmerBaselinProductionCountByAgent(String AgentId)
    {
       
        String q = " match (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION+"]->p where f.CreatedById='"+AgentId+"'"+
                " return   count(DISTINCT f)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }

    
    public Object getFarmerProfileCountByAgent(String AgentId)
    {
       
        String q = " match (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_PROFILING+"]->p where f.CreatedById='"+AgentId+"'"+
                " return  count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
    
    public Object getFarmerBaselineProductionBudgetCountByAgent(String AgentId)
    {
       
        String q = " match  (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION_BUDGET+"]->p where f.CreatedById='"+AgentId+"'"+
                " return count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
    
    public Object getFarmerBaselinePostHarvestCountByAgent(String AgentId)
    {
       
        String q = " match  (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST+"]->p where f.CreatedById='"+AgentId+"'"+
                " return  count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
    
    
     public Object getFarmerBaselinePostHarvestBudgetCountByAgent(String AgentId)
    {
       
        String q = " match  (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST_BUDGET+"]->p where f.CreatedById='"+AgentId+"'"+
                "  return count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
     
     public Object getFarmerCreditPreviousCountByAgent(String AgentId)
    {
       
        String q = " match  (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_FARMCREDIT_PREVIOUS+"]->p where f.CreatedById='"+AgentId+"'"+
                "  return count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
    
     
     public Object getFarmerFMPProductionCountByAgent(String AgentId)
    {
       
        String q = " match (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_PRODUCTION+"]->p where f.CreatedById='"+AgentId+"'"+
                " return count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
    
     
      public Object getFarmerFMPPostHarvestCountByAgent(String AgentId)
    {
       
        String q = " match  (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_POSTHARVEST+"]->p where f.CreatedById='"+AgentId+"'"+
                "  return count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
      
      
      public Object getFarmerCropAssessment(String AgentId)
    {
       
        String q = " match  (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_FIELD_CROP_ASSESSMENT+"]->p where f.CreatedById='"+AgentId+"'"+
                "  return count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
    
    public Object getFarmerCreditByAgent(String AgentId)
    {
       
        String q = " match  (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_FARMCREDIT_PLAN+"]->p where f.CreatedById='"+AgentId+"'"+
                "  return count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
     public Object getFarmerProductionUpdateByAgent(String AgentId)
    {
       
        String q = " match  (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_PRODUCTION_UPDATE+"]->p where f.CreatedById='"+AgentId+"'"+
                "  return count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
    
    public Object getFarmerPostHarvestUpdateByAgent(String AgentId)
    {
       
        String q = " match  (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_POSTHARVEST_UPDATE+"]->p where f.CreatedById='"+AgentId+"'"+
                "  return count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
    
    
    public Object getFarmerCreditUpdateByAgent(String AgentId)
    {
       
        String q = " match  (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_FARMCREDIT_UPDATE+"]->p where f.CreatedById='"+AgentId+"'"+
                "  return count(DISTINCT f.Id)"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
    
     public JSONObject getACDIVOCAAgentActivity()
    {
        BiodataModel biodataModel = new BiodataModel();
        AgentModel agentModel = new AgentModel();

        Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
     
        List<AgentWrapper> agent = agentModel.findAllACDIAgents();

        JSONObject xy = new JSONObject();
        JSONArray agents = new JSONArray();

        for (AgentWrapper a : agent) {
            JSONObject y = new JSONObject();

            y.put("name", a.getFirstname() + " " + a.getLastname());
            y.put("farmers", biodataModel.getFarmerCountByAgent(a.getAgentId()));
            y.put("blproduction", biodataModel.getFarmerBaselinProductionCountByAgent(a.getAgentId()));
            y.put("blpostharvest", biodataModel.getFarmerBaselinePostHarvestCountByAgent(a.getAgentId()));
            y.put("blcredit", biodataModel.getFarmerCreditPreviousCountByAgent(a.getAgentId()));
            y.put("fmpproduction", biodataModel.getFarmerFMPProductionCountByAgent(a.getAgentId()));
            y.put("fmppostharvest", biodataModel.getFarmerFMPPostHarvestCountByAgent(a.getAgentId()));
            y.put("fmpcredit", biodataModel.getFarmerCreditByAgent(a.getAgentId()));
            y.put("measured", biodataModel.getFarmerProductionUpdateByAgent(a.getAgentId()));
            y.put("assessed", biodataModel.getFarmerCropAssessment(a.getAgentId()));
            y.put("productionupdate", biodataModel.getFarmerProductionUpdateByAgent(a.getAgentId()));
            y.put("postharvetupdate", biodataModel.getFarmerPostHarvestUpdateByAgent(a.getAgentId()));
            y.put("creditupdate", biodataModel.getFarmerBaselinePostHarvestCountByAgent(a.getAgentId()));

            agents.put(y);
        }
   
        tx.success();
        System.out.println("agents " + agents);
        xy.put("agentactivity", agent);

        return xy;
         
    }
    
}
