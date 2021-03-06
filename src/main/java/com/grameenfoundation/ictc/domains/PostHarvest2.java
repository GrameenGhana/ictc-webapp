/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Sep 25, 2015 11:42:44 AM
 * description:
 */
public class PostHarvest2 extends Status implements GeneralInterface {
    
    Node underlyingNode ;

    public PostHarvest2(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

public static String APPLICATIONRATEOFSTORAGECHEMICAL="applicationrateofstoragechemical";
public static String COMPLETIONOFPRODUCEMARKETING="completionofproducemarketing";
public static String COMPLETIONOFTHRESHING="completionofthreshing";
public static String DATEOFCOMPLETINGDRYING="dateofcompletingdrying";
public static String DATETOCOMPLETEDRYING="datetocompletedrying";
public static String DEHUSKINGDATE="dehuskingdate";
public static String FIRSTSALEDATE="firstsaledate";
public static String MAINPOINTOFSALEORCONTACT="mainpointofsaleorcontact";
public static String MANUALTHRESHING="manualthreshing";
public static String MANUALWINNOWING="manualwinnowing";
public static String MARKETINGOCCASIONS="marketingoccasions";
public static String METHODOFDRYINGCOBSPANICLESCHIPSCHU="methodofdryingcobspanicleschipschu";
public static String METHODOFDRYINGGRAIN="methodofdryinggrain";
public static String METHODOFPROCESSINGDEHUSKING="methodofprocessingdehusking";
public static String METHODOFTHRESHING="methodofthreshing";
public static String METHODOFWINNOWING="methodofwinnowing";
public static String MOSTPRODUCESALEDATE="mostproducesaledate";
public static String OTHERAPPLICATIONRATE="otherapplicationrate";
public static String OTHERMETHODFORDRYING="othermethodfordrying";
public static String OTHERMETHODOFDRYINGGRAIN="othermethodofdryinggrain";
public static String OTHERMETHODSOFDEHUSKING="othermethodsofdehusking";
public static String OTHERSALECONTACT="othersalecontact";
public static String OTHERSTORAGECHEMICAL="otherstoragechemical";
public static String POSTHARVESTLOSSES="postharvestlosses";
public static String PRICEATFIRSTSALEDATE="priceatfirstsaledate";
public static String PRICEATMOSTSALEDATE="priceatmostsaledate";
public static String PROCESSINGOFCASSAVA="processingofcassava";
public static String PROPORTIONFORMARKET="proportionformarket";
public static String PROPORTIONOFCASSAVAPROCESSEDINTOCHIPS="proportionofcassavaprocessedintochips";
public static String THERAPPLICATIONRATEOFSTORAGECHEMIC="therapplicationrateofstoragechemic";
public static String TYPEOFBAGUSEDINBULKINGPRODUCT="typeofbagusedinbulkingproduct";
public static String TYPEOFMACHINE="typeofmachine";
public static String TYPEOFMACHINEWINOWING="typeofmachinewinowing";
public static String TYPEOFSTORAGECHEMICAL="typeofstoragechemical";
public static String TYPEOFSTORAGESTRUCTURE="typeofstoragestructure";
public static String DATE_OF_COMPLETING_WINNOWING="date_of_completing_winnowing";
public static String PROPORTION_STORED_WITH_CHEMICAL="proportion_stored_with_chemical";
public static String REFERENCE_SEASON_CURRENT="reference_season_current";
public static String REFERENCE_YEAR_CURRENT="reference_year_current";
public static String UNIT_OF_CHEMICAL_APPLICATION="unit_of_chemical_application";
public static String BUYERNUMBER1="buyernumber1";
public static String CROPCULTIVATEDPH="cropcultivatedph";
public static String DRYINGCOBS1="dryingcobs1";
public static String DRYINGGRAIN1="dryinggrain1";
public static String HARVESTMETHODPH="harvestmethodph";
public static String PROCESSINGCOMBINATION1="processingcombination1";
public static String PROCESSINGCOMPLETED1="processingcompleted1";
public static String SHELLINGMETHOD1="shellingmethod1";
public static String SHELLINGMETHODOTHER1="shellingmethodother1";


public void setShellingmethodother1(String shellingmethodother1) {
underlyingNode.setProperty(SHELLINGMETHODOTHER1,shellingmethodother1);
}

public String getShellingmethodother1(){
          try {
          return (String) underlyingNode.getProperty(SHELLINGMETHODOTHER1);

        } catch (Exception e) {
        }
        return null;
    }


public void setShellingmethod1(String shellingmethod1) {
underlyingNode.setProperty(SHELLINGMETHOD1,shellingmethod1);
}

public String getShellingmethod1(){
          try {
          return (String) underlyingNode.getProperty(SHELLINGMETHOD1);

        } catch (Exception e) {
        }
        return null;
    }



public void setProcessingcompleted1(String processingcompleted1) {
underlyingNode.setProperty(PROCESSINGCOMPLETED1,processingcompleted1);
}

public String getProcessingcompleted1(){
          try {
          return (String) underlyingNode.getProperty(PROCESSINGCOMPLETED1);

        } catch (Exception e) {
        }
        return null;
    }

public void setProcessingcombination1(String processingcombination1) {
underlyingNode.setProperty(PROCESSINGCOMBINATION1,processingcombination1);
}

public String getProcessingcombination1(){
          try {
          return (String) underlyingNode.getProperty(PROCESSINGCOMBINATION1);

        } catch (Exception e) {
        }
        return null;
    }



public void setHarvestmethodph(String harvestmethodph) {
underlyingNode.setProperty(HARVESTMETHODPH,harvestmethodph);
}

public String getHarvestmethodph(){
          try {
          return (String) underlyingNode.getProperty(HARVESTMETHODPH);

        } catch (Exception e) {
        }
        return null;
    }



public void setDryinggrain1(String dryinggrain1) {
underlyingNode.setProperty(DRYINGGRAIN1,dryinggrain1);
}

public String getDryinggrain1(){
          try {
          return (String) underlyingNode.getProperty(DRYINGGRAIN1);

        } catch (Exception e) {
        }
        return null;
    }




public void setDryingcobs1(String dryingcobs1) {
underlyingNode.setProperty(DRYINGCOBS1,dryingcobs1);
}

public String getDryingcobs1(){
          try {
          return (String) underlyingNode.getProperty(DRYINGCOBS1);

        } catch (Exception e) {
        }
        return null;
    }


public void setCropcultivatedph(String cropcultivatedph) {
underlyingNode.setProperty(CROPCULTIVATEDPH,cropcultivatedph);
}

public String getCropcultivatedph(){
          try {
          return (String) underlyingNode.getProperty(CROPCULTIVATEDPH);

        } catch (Exception e) {
        }
        return null;
    }

public void setBuyernumber1(String buyernumber1) {
underlyingNode.setProperty(BUYERNUMBER1,buyernumber1);
}

public String getBuyernumber1(){
          try {
          return (String) underlyingNode.getProperty(BUYERNUMBER1);

        } catch (Exception e) {
        }
        return null;
    }

public void setUnit_of_chemical_application(String unit_of_chemical_application) {
underlyingNode.setProperty(UNIT_OF_CHEMICAL_APPLICATION,unit_of_chemical_application);
}

public String getUnit_of_chemical_application(){
          try {
          return (String) underlyingNode.getProperty(UNIT_OF_CHEMICAL_APPLICATION);

        } catch (Exception e) {
        }
        return null;
    }

public void setReference_year_current(String reference_year_current) {
underlyingNode.setProperty(REFERENCE_YEAR_CURRENT,reference_year_current);
}

public String getReference_year_current(){
          try {
          return (String) underlyingNode.getProperty(REFERENCE_YEAR_CURRENT);

        } catch (Exception e) {
        }
        return null;
    }

public void setReference_season_current(String reference_season_current) {
underlyingNode.setProperty(REFERENCE_SEASON_CURRENT,reference_season_current);
}

public String getReference_season_current(){
          try {
          return (String) underlyingNode.getProperty(REFERENCE_SEASON_CURRENT);

        } catch (Exception e) {
        }
        return null;
    }


public void setProportion_stored_with_chemical(String proportion_stored_with_chemical) {
underlyingNode.setProperty(PROPORTION_STORED_WITH_CHEMICAL,proportion_stored_with_chemical);
}

public String getProportion_stored_with_chemical(){
          try {
          return (String) underlyingNode.getProperty(PROPORTION_STORED_WITH_CHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }



public void setDate_of_completing_winnowing(String date_of_completing_winnowing) {
underlyingNode.setProperty(DATE_OF_COMPLETING_WINNOWING,date_of_completing_winnowing);
}

public String getDate_of_completing_winnowing(){
          try {
          return (String) underlyingNode.getProperty(DATE_OF_COMPLETING_WINNOWING);

        } catch (Exception e) {
        }
        return null;
    }


public void setTypeofstoragestructure(String typeofstoragestructure) {
underlyingNode.setProperty(TYPEOFSTORAGESTRUCTURE,typeofstoragestructure);
}

public String getTypeofstoragestructure(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFSTORAGESTRUCTURE);

        } catch (Exception e) {
        }
        return null;
    }




public void setTypeofstoragechemical(String typeofstoragechemical) {
underlyingNode.setProperty(TYPEOFSTORAGECHEMICAL,typeofstoragechemical);
}

public String getTypeofstoragechemical(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }


public void setTypeofmachinewinowing(String typeofmachinewinowing) {
underlyingNode.setProperty(TYPEOFMACHINEWINOWING,typeofmachinewinowing);
}

public String getTypeofmachinewinowing(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFMACHINEWINOWING);

        } catch (Exception e) {
        }
        return null;
    }


public void setTypeofmachine(String typeofmachine) {
underlyingNode.setProperty(TYPEOFMACHINE,typeofmachine);
}

public String getTypeofmachine(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFMACHINE);

        } catch (Exception e) {
        }
        return null;
    }


public void setTypeofbagusedinbulkingproduct(String typeofbagusedinbulkingproduct) {
underlyingNode.setProperty(TYPEOFBAGUSEDINBULKINGPRODUCT,typeofbagusedinbulkingproduct);
}

public String getTypeofbagusedinbulkingproduct(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFBAGUSEDINBULKINGPRODUCT);

        } catch (Exception e) {
        }
        return null;
    }




public void setTherapplicationrateofstoragechemic(String therapplicationrateofstoragechemic) {
underlyingNode.setProperty(THERAPPLICATIONRATEOFSTORAGECHEMIC,therapplicationrateofstoragechemic);
}

public String getTherapplicationrateofstoragechemic(){
          try {
          return (String) underlyingNode.getProperty(THERAPPLICATIONRATEOFSTORAGECHEMIC);

        } catch (Exception e) {
        }
        return null;
    }



public void setProportionofcassavaprocessedintochips(String proportionofcassavaprocessedintochips) {
underlyingNode.setProperty(PROPORTIONOFCASSAVAPROCESSEDINTOCHIPS,proportionofcassavaprocessedintochips);
}

public String getProportionofcassavaprocessedintochips(){
          try {
          return (String) underlyingNode.getProperty(PROPORTIONOFCASSAVAPROCESSEDINTOCHIPS);

        } catch (Exception e) {
        }
        return null;
    }


public void setProportionformarket(String proportionformarket) {
underlyingNode.setProperty(PROPORTIONFORMARKET,proportionformarket);
}

public String getProportionformarket(){
          try {
          return (String) underlyingNode.getProperty(PROPORTIONFORMARKET);

        } catch (Exception e) {
        }
        return null;
    }

public void setProcessingofcassava(String processingofcassava) {
underlyingNode.setProperty(PROCESSINGOFCASSAVA,processingofcassava);
}

public String getProcessingofcassava(){
          try {
          return (String) underlyingNode.getProperty(PROCESSINGOFCASSAVA);

        } catch (Exception e) {
        }
        return null;
    }

public void setPriceatmostsaledate(String priceatmostsaledate) {
underlyingNode.setProperty(PRICEATMOSTSALEDATE,priceatmostsaledate);
}

public String getPriceatmostsaledate(){
          try {
          return (String) underlyingNode.getProperty(PRICEATMOSTSALEDATE);

        } catch (Exception e) {
        }
        return null;
    }


public void setPriceatfirstsaledate(String priceatfirstsaledate) {
underlyingNode.setProperty(PRICEATFIRSTSALEDATE,priceatfirstsaledate);
}

public String getPriceatfirstsaledate(){
          try {
          return (String) underlyingNode.getProperty(PRICEATFIRSTSALEDATE);

        } catch (Exception e) {
        }
        return null;
    }


public void setPostharvestlosses(String postharvestlosses) {
underlyingNode.setProperty(POSTHARVESTLOSSES,postharvestlosses);
}

public String getPostharvestlosses(){
          try {
          return (String) underlyingNode.getProperty(POSTHARVESTLOSSES);

        } catch (Exception e) {
        }
        return null;
    }



public void setOtherstoragechemical(String otherstoragechemical) {
underlyingNode.setProperty(OTHERSTORAGECHEMICAL,otherstoragechemical);
}

public String getOtherstoragechemical(){
          try {
          return (String) underlyingNode.getProperty(OTHERSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }



public void setOthersalecontact(String othersalecontact) {
underlyingNode.setProperty(OTHERSALECONTACT,othersalecontact);
}

public String getOthersalecontact(){
          try {
          return (String) underlyingNode.getProperty(OTHERSALECONTACT);

        } catch (Exception e) {
        }
        return null;
    }

public void setOthermethodsofdehusking(String othermethodsofdehusking) {
underlyingNode.setProperty(OTHERMETHODSOFDEHUSKING,othermethodsofdehusking);
}

public String getOthermethodsofdehusking(){
          try {
          return (String) underlyingNode.getProperty(OTHERMETHODSOFDEHUSKING);

        } catch (Exception e) {
        }
        return null;
    }

public void setOthermethodofdryinggrain(String othermethodofdryinggrain) {
underlyingNode.setProperty(OTHERMETHODOFDRYINGGRAIN,othermethodofdryinggrain);
}

public String getOthermethodofdryinggrain(){
          try {
          return (String) underlyingNode.getProperty(OTHERMETHODOFDRYINGGRAIN);

        } catch (Exception e) {
        }
        return null;
    }


public void setOthermethodfordrying(String othermethodfordrying) {
underlyingNode.setProperty(OTHERMETHODFORDRYING,othermethodfordrying);
}

public String getOthermethodfordrying(){
          try {
          return (String) underlyingNode.getProperty(OTHERMETHODFORDRYING);

        } catch (Exception e) {
        }
        return null;
    }




public void setOtherapplicationrate(String otherapplicationrate) {
underlyingNode.setProperty(OTHERAPPLICATIONRATE,otherapplicationrate);
}

public String getOtherapplicationrate(){
          try {
          return (String) underlyingNode.getProperty(OTHERAPPLICATIONRATE);

        } catch (Exception e) {
        }
        return null;
    }



public void setMostproducesaledate(String mostproducesaledate) {
underlyingNode.setProperty(MOSTPRODUCESALEDATE,mostproducesaledate);
}

public String getMostproducesaledate(){
          try {
          return (String) underlyingNode.getProperty(MOSTPRODUCESALEDATE);

        } catch (Exception e) {
        }
        return null;
    }


public void setMethodofwinnowing(String methodofwinnowing) {
underlyingNode.setProperty(METHODOFWINNOWING,methodofwinnowing);
}

public String getMethodofwinnowing(){
          try {
          return (String) underlyingNode.getProperty(METHODOFWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }


public void setMethodofthreshing(String methodofthreshing) {
underlyingNode.setProperty(METHODOFTHRESHING,methodofthreshing);
}

public String getMethodofthreshing(){
          try {
          return (String) underlyingNode.getProperty(METHODOFTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }



public void setMethodofprocessingdehusking(String methodofprocessingdehusking) {
underlyingNode.setProperty(METHODOFPROCESSINGDEHUSKING,methodofprocessingdehusking);
}

public String getMethodofprocessingdehusking(){
          try {
          return (String) underlyingNode.getProperty(METHODOFPROCESSINGDEHUSKING);

        } catch (Exception e) {
        }
        return null;
    }


public void setMethodofdryinggrain(String methodofdryinggrain) {
underlyingNode.setProperty(METHODOFDRYINGGRAIN,methodofdryinggrain);
}

public String getMethodofdryinggrain(){
          try {
          return (String) underlyingNode.getProperty(METHODOFDRYINGGRAIN);

        } catch (Exception e) {
        }
        return null;
    }


public void setMethodofdryingcobspanicleschipschu(String methodofdryingcobspanicleschipschu) {
underlyingNode.setProperty(METHODOFDRYINGCOBSPANICLESCHIPSCHU,methodofdryingcobspanicleschipschu);
}

public String getMethodofdryingcobspanicleschipschu(){
          try {
          return (String) underlyingNode.getProperty(METHODOFDRYINGCOBSPANICLESCHIPSCHU);

        } catch (Exception e) {
        }
        return null;
    }



public void setMarketingoccasions(String marketingoccasions) {
underlyingNode.setProperty(MARKETINGOCCASIONS,marketingoccasions);
}

public String getMarketingoccasions(){
          try {
          return (String) underlyingNode.getProperty(MARKETINGOCCASIONS);

        } catch (Exception e) {
        }
        return null;
    }



public void setManualwinnowing(String manualwinnowing) {
underlyingNode.setProperty(MANUALWINNOWING,manualwinnowing);
}

public String getManualwinnowing(){
          try {
          return (String) underlyingNode.getProperty(MANUALWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }


public void setManualthreshing(String manualthreshing) {
underlyingNode.setProperty(MANUALTHRESHING,manualthreshing);
}

public String getManualthreshing(){
          try {
          return (String) underlyingNode.getProperty(MANUALTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }



public void setMainpointofsaleorcontact(String mainpointofsaleorcontact) {
underlyingNode.setProperty(MAINPOINTOFSALEORCONTACT,mainpointofsaleorcontact);
}

public String getMainpointofsaleorcontact(){
          try {
          return (String) underlyingNode.getProperty(MAINPOINTOFSALEORCONTACT);

        } catch (Exception e) {
        }
        return null;
    }


public void setFirstsaledate(String firstsaledate) {
underlyingNode.setProperty(FIRSTSALEDATE,firstsaledate);
}

public String getFirstsaledate(){
          try {
          return (String) underlyingNode.getProperty(FIRSTSALEDATE);

        } catch (Exception e) {
        }
        return null;
    }

public void setDehuskingdate(String dehuskingdate) {
underlyingNode.setProperty(DEHUSKINGDATE,dehuskingdate);
}

public String getDehuskingdate(){
          try {
          return (String) underlyingNode.getProperty(DEHUSKINGDATE);

        } catch (Exception e) {
        }
        return null;
    }


public void setDatetocompletedrying(String datetocompletedrying) {
underlyingNode.setProperty(DATETOCOMPLETEDRYING,datetocompletedrying);
}

public String getDatetocompletedrying(){
          try {
          return (String) underlyingNode.getProperty(DATETOCOMPLETEDRYING);

        } catch (Exception e) {
        }
        return null;
    }

public void setDateofcompletingdrying(String dateofcompletingdrying) {
underlyingNode.setProperty(DATEOFCOMPLETINGDRYING,dateofcompletingdrying);
}

public String getDateofcompletingdrying(){
          try {
          return (String) underlyingNode.getProperty(DATEOFCOMPLETINGDRYING);

        } catch (Exception e) {
        }
        return null;
    }


public void setCompletionofthreshing(String completionofthreshing) {
underlyingNode.setProperty(COMPLETIONOFTHRESHING,completionofthreshing);
}

public String getCompletionofthreshing(){
          try {
          return (String) underlyingNode.getProperty(COMPLETIONOFTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }


public void setCompletionofproducemarketing(String completionofproducemarketing) {
underlyingNode.setProperty(COMPLETIONOFPRODUCEMARKETING,completionofproducemarketing);
}

public String getCompletionofproducemarketing(){
          try {
          return (String) underlyingNode.getProperty(COMPLETIONOFPRODUCEMARKETING);

        } catch (Exception e) {
        }
        return null;
    }


public void setApplicationrateofstoragechemical(String applicationrateofstoragechemical) {
underlyingNode.setProperty(APPLICATIONRATEOFSTORAGECHEMICAL,applicationrateofstoragechemical);
}

public String getApplicationrateofstoragechemical(){
          try {
          return (String) underlyingNode.getProperty(APPLICATIONRATEOFSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }

 public void setUpdate(Node postharvest) {
        underlyingNode.createRelationshipTo(postharvest, ICTCRelationshipTypes.UPDATE);
    }

    public PostHarvestUpdate getUpdate() {
        return new PostHarvestUpdate(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.UPDATE));
    }




}
