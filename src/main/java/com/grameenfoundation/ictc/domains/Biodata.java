/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import com.grameenfoundation.ictc.models.FarmerGPSModel;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.wrapper.FarmGPSLocationWrapper;
import com.grameenfoundation.ictc.wrapper.FarmerInputReceivedWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

/**
 *
 * @author Joseph George Davis
 * @date Jul 16, 2015 12:08:21 PM description:
 */
public class Biodata extends Status implements GeneralInterface {

    public static String FIRST_NAME = "firstname";
    public static String LAST_NAME = "lastname";
    public static String NICKNAME = "nickname";
    public static String COMMUNITY = "community";
    public static String VILLAGE = "village";
    public static String DISTRICT = "district";
    public static String REGION = "region";
    public static String AGE = "age";
    public static String GENDER = "gender";
    public static String MARITAL_STATUS = "maritalstatus";
    public static String NUMBER_OF_CHILDREN = "numberofchildren";
    public static String NUMBER_OF_DEPENDANTS = "numberofdependants";
    public static String EDUCATION = "education";
    public static String MAJOR_CROP = "majorcrop";
    public static String CLUSTER = "cluster";
    public static String FARMERID = "Id";
    public static String FARM_AREA = "farm_area";
    public static String FARM_PERIMETER = "farmperimeter";
    public static String TELEPHONENUMBER = "telephonenumber";
    public static String FARMERIMAGE = "farmerimage";
    public static String DISTRICTS_ASHANTI = "Districts_Ashanti";
    public static String DISTRICTS_BRONGAHAFO = "Districts_BrongAhafo";
    public static String DISTRICTS_VOLTA = "Districts_Volta";
    public static String IMAGE_URL = "image_url";
    public static String CREATED_BY = "CreatedById";
    public static String DISRICTRESIDENCEASH="disrictresidenceash";
    public static String DISTRICTRESIDENCEBA="districtresidenceba";
    public static String DISTRICTRESIDENCEVOLTA="districtresidencevolta";
    public static String NUMBEROFDEPENDANTSMALE="numberofdependantsmale";
    public static String NUMBEROFDEPENDENTSFEMALE="numberofdependentsfemale";
    public static String REGIONRESIDENCE="regionresidence";
    public static String DATACOLLECTEDBY="DataCollectedBy";
    public static String ACDIVOCAFARMERID="ACDIVOCAFARMERID";
    public static String MAIDENAME="maidename";
    public static String FAMER_TYPE="Famer_type";
    public static String MARRIAGE_NAME="marriage_name";
    public static String WORKINGWITHLIST="WorkingWithList";
    public static String DATEOFBIRTH="dateofbirth";
    public static String NOMALEEMPLOYEES="NoMaleEmployees";
    public static String NOFEMALEEMPLOYEES="NoFemaleEmployees";
    public static String MSMETYPE="MSMEType";
    public static String FKFARMERHHPROFILE="fkFarmerHHProfile";
    public static String ISWITHFBO="isWithFBO";
    public static String FKFBOPROFILE="fkFBOProfile";
    public static String FBOPOSITION="FBOPosition";
    public static String ISOUTGROWER="isOutGrower";
    public static String FKNUCLEUSFARMERPROFILE="fkNucleusFarmerProfile";
    public static String FKAGGREGATORPROFILE="fkAggregatorProfile";
    public static String OUTGROWERGROUPNAME="OutgrowerGroupName";
    public static String ISWITHPA="isWithPA";
    public static String PANAME="PAName";
    public static String PAOFFICE="PAOffice";
    public static String REMARKS="Remarks";
    public static String DATACOLLCETEDBY="DataCollcetedBy";
    public static String DATAREVIEWEDBY="DataReviewedBy";
    public static String DATECOLLECTED="DateCollected";
    public static String DATEREVIEWED="DateReviewed";
    public static String FKFYNAME="fkFYName";
    public static String SUBOFFICE="SubOffice";
    public static String SYNC="Sync";
    
     public String getImage_url() {
          try {
          return (String) underlyingNode.getProperty(IMAGE_URL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setImage_url(String image_url) {
       underlyingNode.setProperty(IMAGE_URL,image_url);
    }
    
    
    
public void setSync(String sync) {
underlyingNode.setProperty(SYNC,sync);
}

public String getSync(){
          try {
          return (String) underlyingNode.getProperty(SYNC);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setSubOffice(String suboffice) {
underlyingNode.setProperty(SUBOFFICE,suboffice);
}

public String getSubOffice(){
          try {
          return (String) underlyingNode.getProperty(SUBOFFICE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setFkFYName(String fkfyname) {
underlyingNode.setProperty(FKFYNAME,fkfyname);
}

public String getFkFYName(){
          try {
          return (String) underlyingNode.getProperty(FKFYNAME);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setDateReviewed(String datereviewed) {
underlyingNode.setProperty(DATEREVIEWED,datereviewed);
}

public String getDateReviewed(){
          try {
          return (String) underlyingNode.getProperty(DATEREVIEWED);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setDateCollected(String datecollected) {
underlyingNode.setProperty(DATECOLLECTED,datecollected);
}

public String getDateCollected(){
          try {
          return (String) underlyingNode.getProperty(DATECOLLECTED);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setDataReviewedBy(String datareviewedby) {
underlyingNode.setProperty(DATAREVIEWEDBY,datareviewedby);
}

public String getDataReviewedBy(){
          try {
          return (String) underlyingNode.getProperty(DATAREVIEWEDBY);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDataCollcetedBy(String datacollcetedby) {
underlyingNode.setProperty(DATACOLLCETEDBY,datacollcetedby);
}

public String getDataCollcetedBy(){
          try {
          return (String) underlyingNode.getProperty(DATACOLLCETEDBY);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setRemarks(String remarks) {
underlyingNode.setProperty(REMARKS,remarks);
}

public String getRemarks(){
          try {
          return (String) underlyingNode.getProperty(REMARKS);

        } catch (Exception e) {
        }
        return null;
    }
public void setPAOffice(String paoffice) {
underlyingNode.setProperty(PAOFFICE,paoffice);
}

public String getPAOffice(){
          try {
          return (String) underlyingNode.getProperty(PAOFFICE);

        } catch (Exception e) {
        }
        return null;
    }
    public void setPAName(String paname) {
        underlyingNode.setProperty(PANAME, paname);
    }

    public String getPAName() {
        try {
            return (String) underlyingNode.getProperty(PANAME);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setIsWithPA(String iswithpa) {
underlyingNode.setProperty(ISWITHPA,iswithpa);
}

public String getIsWithPA(){
          try {
          return (String) underlyingNode.getProperty(ISWITHPA);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setOutgrowerGroupName(String outgrowergroupname) {
underlyingNode.setProperty(OUTGROWERGROUPNAME,outgrowergroupname);
}

public String getOutgrowerGroupName(){
          try {
          return (String) underlyingNode.getProperty(OUTGROWERGROUPNAME);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFkAggregatorProfile(String fkaggregatorprofile) {
underlyingNode.setProperty(FKAGGREGATORPROFILE,fkaggregatorprofile);
}

public String getFkAggregatorProfile(){
          try {
          return (String) underlyingNode.getProperty(FKAGGREGATORPROFILE);

        } catch (Exception e) {
        }
        return null;
    }

public void setFkNucleusFarmerProfile(String fknucleusfarmerprofile) {
underlyingNode.setProperty(FKNUCLEUSFARMERPROFILE,fknucleusfarmerprofile);
}

public String getFkNucleusFarmerProfile(){
          try {
          return (String) underlyingNode.getProperty(FKNUCLEUSFARMERPROFILE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setIsOutGrower(String isoutgrower) {
underlyingNode.setProperty(ISOUTGROWER,isoutgrower);
}

public String getIsOutGrower(){
          try {
          return (String) underlyingNode.getProperty(ISOUTGROWER);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFBOPosition(String fboposition) {
underlyingNode.setProperty(FBOPOSITION,fboposition);
}

public String getFBOPosition(){
          try {
          return (String) underlyingNode.getProperty(FBOPOSITION);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFkFBOProfile(String fkfboprofile) {
underlyingNode.setProperty(FKFBOPROFILE,fkfboprofile);
}

public String getFkFBOProfile(){
          try {
          return (String) underlyingNode.getProperty(FKFBOPROFILE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setIsWithFBO(String iswithfbo) {
underlyingNode.setProperty(ISWITHFBO,iswithfbo);
}

public String getIsWithFBO(){
          try {
          return (String) underlyingNode.getProperty(ISWITHFBO);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setFkFarmerHHProfile(String fkfarmerhhprofile) {
underlyingNode.setProperty(FKFARMERHHPROFILE,fkfarmerhhprofile);
}

public String getFkFarmerHHProfile(){
          try {
          return (String) underlyingNode.getProperty(FKFARMERHHPROFILE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setMSMEType(String msmetype) {
underlyingNode.setProperty(MSMETYPE,msmetype);
}

public String getMSMEType(){
          try {
          return (String) underlyingNode.getProperty(MSMETYPE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setNoFemaleEmployees(String nofemaleemployees) {
underlyingNode.setProperty(NOFEMALEEMPLOYEES,nofemaleemployees);
}

public String getNoFemaleEmployees(){
          try {
          return (String) underlyingNode.getProperty(NOFEMALEEMPLOYEES);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setNoMaleEmployees(String nomaleemployees) {
underlyingNode.setProperty(NOMALEEMPLOYEES,nomaleemployees);
}

public String getNoMaleEmployees(){
          try {
          return (String) underlyingNode.getProperty(NOMALEEMPLOYEES);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDateofbirth(String dateofbirth) {
underlyingNode.setProperty(DATEOFBIRTH,dateofbirth);
}

public String getDateofbirth(){
          try {
          return (String) underlyingNode.getProperty(DATEOFBIRTH);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setWorkingWithList(String workingwithlist) {
underlyingNode.setProperty(WORKINGWITHLIST,workingwithlist);
}

public String getWorkingWithList(){
          try {
          return (String) underlyingNode.getProperty(WORKINGWITHLIST);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setMarriage_name(String marriage_name) {
underlyingNode.setProperty(MARRIAGE_NAME,marriage_name);
}

public String getMarriage_name(){
          try {
          return (String) underlyingNode.getProperty(MARRIAGE_NAME);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamer_type(String famer_type) {
underlyingNode.setProperty(FAMER_TYPE,famer_type);
}

public String getFamer_type(){
          try {
          return (String) underlyingNode.getProperty(FAMER_TYPE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setMaidename(String maidename) {
underlyingNode.setProperty(MAIDENAME,maidename);
}

public String getMaidename(){
          try {
          return (String) underlyingNode.getProperty(MAIDENAME);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setACDIVOCAFARMERID(String acdivocafarmerid) {
underlyingNode.setProperty(ACDIVOCAFARMERID,acdivocafarmerid);
}

public String getACDIVOCAFARMERID(){
          try {
          return (String) underlyingNode.getProperty(ACDIVOCAFARMERID);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
    
    
public void setDataCollectedBy(String datacollectedby) {
underlyingNode.setProperty(DATACOLLECTEDBY,datacollectedby);
}

public String getDataCollectedBy(){
          try {
          return (String) underlyingNode.getProperty(DATACOLLECTEDBY);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setRegionresidence(String regionresidence) {
underlyingNode.setProperty(REGIONRESIDENCE,regionresidence);
}

public String getRegionresidence(){
          try {
          return (String) underlyingNode.getProperty(REGIONRESIDENCE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setNumberofdependentsfemale(String numberofdependentsfemale) {
underlyingNode.setProperty(NUMBEROFDEPENDENTSFEMALE,numberofdependentsfemale);
}

public String getNumberofdependentsfemale(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFDEPENDENTSFEMALE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setNumberofdependantsmale(String numberofdependantsmale) {
underlyingNode.setProperty(NUMBEROFDEPENDANTSMALE,numberofdependantsmale);
}

public String getNumberofdependantsmale(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFDEPENDANTSMALE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDistrictresidencevolta(String districtresidencevolta) {
underlyingNode.setProperty(DISTRICTRESIDENCEVOLTA,districtresidencevolta);
}

public String getDistrictresidencevolta(){
          try {
          return (String) underlyingNode.getProperty(DISTRICTRESIDENCEVOLTA);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setDistrictresidenceba(String districtresidenceba) {
underlyingNode.setProperty(DISTRICTRESIDENCEBA,districtresidenceba);
}

public String getDistrictresidenceba(){
          try {
          return (String) underlyingNode.getProperty(DISTRICTRESIDENCEBA);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setDisrictresidenceash(String disrictresidenceash) {
underlyingNode.setProperty(DISRICTRESIDENCEASH,disrictresidenceash);
}

public String getDisrictresidenceash(){
          try {
          return (String) underlyingNode.getProperty(DISRICTRESIDENCEASH);

        } catch (Exception e) {
        }
        return null;
    }

    
     public void setCreatedById(String createBy) {
        
        underlyingNode.setProperty(CREATED_BY, createBy);
    }

    public String getCreatedById() {
        try {
            return (String) underlyingNode.getProperty(CREATED_BY);

        } catch (Exception e) {
        }
        return null;
    }
    

    public void setImage_Url(String image_url) {
        underlyingNode.setProperty(IMAGE_URL, image_url);
    }

    public String getImage_Url() {
        try {
            return (String) underlyingNode.getProperty(IMAGE_URL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setDistricts_Volta(String districts_volta) {
        underlyingNode.setProperty(DISTRICTS_VOLTA, districts_volta);
    }

    public String getDistricts_Volta() {
        try {
            return (String) underlyingNode.getProperty(DISTRICTS_VOLTA);

        } catch (Exception e) {
        }
        return null;
    }

    public void setDistricts_BrongAhafo(String districts_brongahafo) {
        underlyingNode.setProperty(DISTRICTS_BRONGAHAFO, districts_brongahafo);
    }

    public String getDistricts_BrongAhafo() {
        try {
            return (String) underlyingNode.getProperty(DISTRICTS_BRONGAHAFO);

        } catch (Exception e) {
        }
        return null;
    }

    public void setDistricts_Ashanti(String districts_ashanti) {
        underlyingNode.setProperty(DISTRICTS_ASHANTI, districts_ashanti);
    }

    public String getDistricts_Ashanti() {
        try {
            return (String) underlyingNode.getProperty(DISTRICTS_ASHANTI);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFarmerimage(String farmerimage) {
        underlyingNode.setProperty(FARMERIMAGE, farmerimage);
    }

    public String getFarmerimage() {
        try {
            return (String) underlyingNode.getProperty(FARMERIMAGE);

        } catch (Exception e) {
        }
        return null;
    }

    //public static String ID ="id";
    Node underlyingNode;

    public Biodata(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

    public void setTelephonenumber(String telephonenumber) {
        underlyingNode.setProperty(TELEPHONENUMBER, telephonenumber);
    }

    public String getTelephonenumber() {
        try {
            return (String) underlyingNode.getProperty(TELEPHONENUMBER);

        } catch (Exception e) {
        }
        return null;
    }

    public String getFarmperimeter() {
        try {
            return (String) underlyingNode.getProperty(FARM_PERIMETER);

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return "";
    }

    public void setFarmperimeter(String farmperimeter) {
        underlyingNode.setProperty(FARM_PERIMETER, farmperimeter);
    }

    public String getFarmarea() {
        try {
            return (String) underlyingNode.getProperty(FARM_AREA);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return "";
    }

    public void setFarmarea(String farmarea) {
        underlyingNode.setProperty(FARM_AREA, farmarea);
    }

    public String getFirstname() {
        try {
            return (String) underlyingNode.getProperty(FIRST_NAME);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setFirstname(String firstname) {
        underlyingNode.setProperty(FIRST_NAME, firstname);
    }

    public String getLastname() {
        try {
            return (String) underlyingNode.getProperty(LAST_NAME);

        } catch (Exception e) {
        }
        return "";
    }

    public void setLastname(String lastname) {
        underlyingNode.setProperty(LAST_NAME, lastname);
    }

    public String getNickname() {
        try {
            return (String) underlyingNode.getProperty(NICKNAME);

        } catch (Exception e) {
        }
        return "";
    }

    public void setNickname(String nickname) {
        underlyingNode.setProperty(NICKNAME, nickname);
    }

    public String getCommunity() {
        try {
            return (String) underlyingNode.getProperty(COMMUNITY);

        } catch (Exception e) {
        }
        return "";
    }

    public void setCommunity(String community) {
        underlyingNode.setProperty(COMMUNITY, community);
    }

    public String getDistrict() {
        try {
            return (String) underlyingNode.getProperty(DISTRICT);

        } catch (Exception e) {
        }
        return "";
    }

    public void setDistrict(String district) {
        underlyingNode.setProperty(DISTRICT, district);
    }

    public String getVillage() {
        try {
            return (String) underlyingNode.getProperty(VILLAGE);

        } catch (Exception e) {
        }
        return "";
    }

    public void setVillage(String village) {
        underlyingNode.setProperty(VILLAGE, village);
    }

    public String getRegion() {
        try {
            return (String) underlyingNode.getProperty(REGION);

        } catch (Exception e) {
        }
        return "";
    }

    public void setRegion(String region) {
        underlyingNode.setProperty(REGION, region);
    }

    public String getAge() {
        try {
            return (String) underlyingNode.getProperty(AGE);

        } catch (Exception e) {
        }
        return "";
    }

    public void setAge(String age) {
        underlyingNode.setProperty(AGE, age);
    }

    public String getGender() {
        try {
            return (String) underlyingNode.getProperty(GENDER);

        } catch (Exception e) {
        }
        return "";
    }

    public void setGender(String gender) {
        underlyingNode.setProperty(GENDER, gender);
    }

    public String getMaritalstatus() {
        try {
            return (String) underlyingNode.getProperty(MARITAL_STATUS);

        } catch (Exception e) {
        }
        return "";
    }

    public void setMaritalstatus(String maritalstatus) {
        underlyingNode.setProperty(MARITAL_STATUS, maritalstatus);
    }

    public String getNumberofchildren() {
        try {
            return (String) underlyingNode.getProperty(NUMBER_OF_CHILDREN);

        } catch (Exception e) {
        }
        return "";
    }

    public void setNumberofchildren(String numberofchildren) {
        underlyingNode.setProperty(NUMBER_OF_CHILDREN, numberofchildren);
    }

    public String getNumberofdependants() {
        try {
            return (String) underlyingNode.getProperty(NUMBER_OF_DEPENDANTS);

        } catch (Exception e) {
        }
        return "";
    }

    public void setNumberofdependants(String numberofdependants) {
        underlyingNode.setProperty(NUMBER_OF_DEPENDANTS, numberofdependants);
    }

    public String getMajorCrop() {
        try {
            return (String) underlyingNode.getProperty(MAJOR_CROP);

        } catch (Exception e) {
        }
        return "";
    }

    public void setMajorCrop(String majorcrop) {
        underlyingNode.setProperty(MAJOR_CROP, majorcrop);
    }

    public String getEducation() {
        try {
            return (String) underlyingNode.getProperty(EDUCATION);

        } catch (Exception e) {
        }
        return "";
    }

    public void setCluster(String cluster) {
        underlyingNode.setProperty(CLUSTER, cluster);
    }

    public void setEducation(String education) {
        underlyingNode.setProperty(EDUCATION, education);
    }

    public String getCluster() {
        try {
            return (String) underlyingNode.getProperty(CLUSTER);

        } catch (Exception e) {
        }
        return "";
    }

    public void setFarmerID(String farmerID) {
        underlyingNode.setProperty(FARMERID, farmerID);
    }

    public String getFarmerID() {
        try {
            return (String) underlyingNode.getProperty(FARMERID);

        } catch (Exception e) {
        }
        return "";
    }

    public void setFarmManagement(Node farmManagement) {
        underlyingNode.createRelationshipTo(farmManagement, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT);
    }

    public FarmManagement getFarmManagement() {
        return new FarmManagement(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT));
    }

    public void setFarmOperation(Node farmOperation) {
        underlyingNode.createRelationshipTo(farmOperation, ICTCRelationshipTypes.HAS_FARM_OPERATION);
    }

    public Operations getFarmOperation() {
        return new Operations(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_OPERATION));
    }

    public void setHarvest(Node harvest) {
        underlyingNode.createRelationshipTo(harvest, ICTCRelationshipTypes.HAS_HARVEST);
    }

    public Harvest getHavest() {
        return new Harvest(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_HARVEST));
    }

    public void setPostHarvest(Node postHarvest) {
        underlyingNode.createRelationshipTo(postHarvest, ICTCRelationshipTypes.HAS_POSTHARVEST);
    }

    public PostHarvest2 getPostHavest2() {
        return new PostHarvest2(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_POSTHARVEST));
    } public PostHarvest getPostHavest() {
        return new PostHarvest(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_POSTHARVEST));
    }

    public void setStorage(Node storage) {
        underlyingNode.createRelationshipTo(storage, ICTCRelationshipTypes.HAS_STORAGE);
    }

    public Storage getStorage() {
        return new Storage(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_STORAGE));
    }

    public void setMarketing(Node marketing) {
        underlyingNode.createRelationshipTo(marketing, ICTCRelationshipTypes.HAS_MARKETING);
    }

    public Marketing getMarketing() {
        return new Marketing(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_MARKETING));
    }

    public void setTechNeeds(Node techNeeds) {
        underlyingNode.createRelationshipTo(techNeeds, ICTCRelationshipTypes.HAS_TECHNEEDS);
    }

    public TechnicalNeed getTechNeeds() {
        return new TechnicalNeed(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_TECHNEEDS));
    }

    public void setFMP(Node fmp) {
        underlyingNode.createRelationshipTo(fmp, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT_PLAN);
    }

    public FarmManagementPlan getFMP() {
        return new FarmManagementPlan(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT_PLAN));
    }

    public void setFarmerMeeting(Node Meeting) {
        underlyingNode.createRelationshipTo(Meeting, ICTCRelationshipTypes.HAS_MEETING);
    }

    public Meeting getFarmerMeeting() {
        return new Meeting(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_MEETING));
    }

    public void setProduction(Node production) {
        underlyingNode.createRelationshipTo(production, ICTCRelationshipTypes.HAS_PRODUCTION);
    }
    
    public void setProductionUpdate(Node productionupdate) {
        underlyingNode.createRelationshipTo(productionupdate, ICTCRelationshipTypes.HAS_PRODUCTION_UPDATE);
    }
    
    
    public ProductionUpdate getProductionUpdate()
    {
          return new ProductionUpdate(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_PRODUCTION_UPDATE));
    }
    
    
    
    public ProductionNew getProduction() {
        return new ProductionNew(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_PRODUCTION));
    }
    
    public void setProductionBudgetUpdate(Node productionBudgetUpdate)
    {
         underlyingNode.createRelationshipTo(productionBudgetUpdate, ICTCRelationshipTypes.HAS_PRODUCTION_BUDGET_UPDATE);
    }
    
    public FmpProductionBudgetUpdate getProductionBudgetUpdate()
    {
        return new FmpProductionBudgetUpdate(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_PRODUCTION_BUDGET_UPDATE));
    }

    public void setProfiling(Node profiling) {
        underlyingNode.createRelationshipTo(profiling, ICTCRelationshipTypes.HAS_PROFILING);
    }

    public Profiling getProfiling() {
        return new Profiling(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_PROFILING));
    }

    public void setBP(Node BP) {
        underlyingNode.createRelationshipTo(BP, ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION);
    }

    public BaselineProduction getBP() {
        return new BaselineProduction(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION));
    }

    public void setBPB(Node BPB) {
        underlyingNode.createRelationshipTo(BPB, ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION_BUDGET);
    }

    public BaselineProductionBudget getBPB() {
        return new BaselineProductionBudget(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION_BUDGET));
    }

    public void setBPHB(Node BPB) {
        underlyingNode.createRelationshipTo(BPB, ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST_BUDGET);
    }

    public BaselinePostHarvestBudget getBPHB() {
        return new BaselinePostHarvestBudget(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST_BUDGET));
    }

    public void setBPH(Node BPB) {
        underlyingNode.createRelationshipTo(BPB, ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST);
    }

    public BaselinePostHarvest getBPH() {
        return new BaselinePostHarvest(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST));
    }

    public void setFMPPB(Node BPB) {
        underlyingNode.createRelationshipTo(BPB, ICTCRelationshipTypes.HAS_PRODUCTION_BUDGET);
    }

    public FmpProductionBudget getFMPPB() {
        return new FmpProductionBudget(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_PRODUCTION_BUDGET));
    }

    public void setFMPPHB(Node BPBNode) {
        underlyingNode.createRelationshipTo(BPBNode, ICTCRelationshipTypes.HAS_POSTHARVEST_BUDGET);
    }

    public FmpPostHarvestBudget getFMPPHB() {
        return new FmpPostHarvestBudget(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_POSTHARVEST_BUDGET));
    }

    public void setFCA(Node FCANode) {
        underlyingNode.createRelationshipTo(FCANode, ICTCRelationshipTypes.HAS_FIELD_CROP_ASSESSMENT);
    }

    public FieldCropAssessment getFCA() {
        return new FieldCropAssessment(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FIELD_CROP_ASSESSMENT));
    }
    
    
     public void setFarmCreditPlan(Node FCPNode) {
        underlyingNode.createRelationshipTo(FCPNode, ICTCRelationshipTypes.HAS_FARMCREDIT_PLAN);
    }
    
    public FarmCreditPlan getFarmCreditPlan() {
        return new FarmCreditPlan(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARMCREDIT_PLAN));
    }
    
     public void setFarmCreditPrevious(Node FCPNode) {
        underlyingNode.createRelationshipTo(FCPNode, ICTCRelationshipTypes.HAS_FARMCREDIT_PREVIOUS);
    }
     
      public FarmCreditPlan getFarmCreditPrevious() {
        return new FarmCreditPlan(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARMCREDIT_PREVIOUS));
    }
     
       public void setFarmCreditUpdate(Node FCPNode) {
        underlyingNode.createRelationshipTo(FCPNode, ICTCRelationshipTypes.HAS_FARMCREDIT_UPDATE);
    }
       
       
     public FarmCreditUpdate getFarmCreditUpdate() {
    
        return new FarmCreditUpdate(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARMCREDIT_UPDATE));
    }
     
     
     public void setPostHarvestUpdate(Node PHUNode)
     {
         underlyingNode.createRelationshipTo(PHUNode,ICTCRelationshipTypes.HAS_POSTHARVEST_UPDATE);
     }
     
     public PostHarvestUpdate getPostHarvestUpdate()
     {
         return new PostHarvestUpdate(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_POSTHARVEST_UPDATE));
     }
     
     public void setPostHarvestBudgetUpdate(Node PHBUNode)
     {
         underlyingNode.createRelationshipTo(PHBUNode,ICTCRelationshipTypes.HAS_POSTHARVEST_BUDGET_UPDATE);
     }
     
    public List<Node> getNodeList(Direction direction, ICTCRelationshipTypes relType) {
//          List<Node> n= (Neo4jServices.findNodeFromRelations(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_MEETING));
        List<Node> n = (Neo4jServices.findNodeFromRelations(underlyingNode, direction, relType));
        return n;
    }

    public List<Node> getMeeting() {
//          List<Node> n= (Neo4jServices.findNodeFromRelations(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_MEETING));
//          List<Node> n= (Neo4jServices.findNodeFromRelations(underlyingNode, direction, relType));
        return getNodeList(Direction.OUTGOING, ICTCRelationshipTypes.HAS_MEETING);
//          return  n;
    }
    
    public Node getUpdate(Node update)
    {
        try
        {
        return Neo4jServices.findNodeFromRelation(update, Direction.OUTGOING, ICTCRelationshipTypes.UPDATE);
        }
        catch(Exception ex)
        {
            //ex.printStackTrace();
            return null;
        }
    }

    public List<FarmerInputReceivedWrapper> getFarmInputs() {
        List<Node> nodes = getNodeList(Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_INPUT);

        List<FarmerInputReceivedWrapper> received = new ArrayList<>();

        for (Node node : nodes) {
            FarmerInputReceived setting = new FarmerInputReceived(node);
            FarmerInputReceivedWrapper fic = new FarmerInputReceivedWrapper();

            fic.setStatus(setting.getStatus());
            fic.setName(setting.getName());
            fic.setQty(setting.getQty());
            received.add(fic);
        }
        return received;

    }

     public List<FarmGPSLocationWrapper> getFarmGps() {
        List<Node> nodes = getNodeList(Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_GPS);

        List<FarmGPSLocationWrapper> received = new ArrayList<>();

        for (Node node : nodes) {
            FarmGPSLocation m = new FarmGPSLocation(node);
            FarmGPSLocationWrapper fic = new FarmGPSLocationWrapper();
//fic.setFarmerId(m.getFarmerId());
                fic.setId(m.getGPSId());
                fic.setLatitude(m.getLatitude());
                fic.setLongitude(m.getLongitude());
            received.add(fic);
        }
        return received;

    }

    public List<MeetingWrapper> getMeetingDetails() {
        List<Node> n = getMeeting();
        List<MeetingWrapper> met = new ArrayList<>();
        for (Node met1 : n) {
            Meeting m = new Meeting(met1);
            MeetingWrapper mr = new MeetingWrapper();

            mr.setType(m.getType());
            mr.setMeetingIndex(m.getMeetingIndex());
            mr.setSeason(m.getSeason());
            mr.setStartDate(m.getStartdate());
            mr.setEndDate(m.getEnddate());
            mr.setAttended(m.getAttended());

            met.add(mr);

        }
        return met;
    }
}
