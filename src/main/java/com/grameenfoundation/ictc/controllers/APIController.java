/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.BaselineProduction;
import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.domains.MeetingSetting;
import com.grameenfoundation.ictc.domains.PostHarvest2;
import com.grameenfoundation.ictc.domains.ProductionNew;
import com.grameenfoundation.ictc.models.BaselineProductionModel;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.MeetingSettingModel;
import com.grameenfoundation.ictc.models.MobileTrackerModel;
import com.grameenfoundation.ictc.models.PostHarvestModel;
import com.grameenfoundation.ictc.models.ProductionModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingActivityWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingSettingWrapper;
import com.grameenfoundation.ictc.wrapper.MobileTrackerWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author skwakwa
 */
@WebServlet(name = "APIController", urlPatterns = {"/api/v1"})
public class APIController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

        // Set the header response type
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("application/json;charset=UTF-8");

            String serviceCode = request.getParameter("action");
            JSONObject jSONObject = new JSONObject();
            System.out.println("action " + serviceCode);
            //<editor-fold desc="Meetings API">
            if (serviceCode.equalsIgnoreCase("cmeeting")) {
                MeetingSettingModel msm = new MeetingSettingModel();
                String crop = request.getParameter("crop");
                List<MeetingSettingWrapper> meetingSettings = new ArrayList<MeetingSettingWrapper>();
                if (crop.isEmpty()) {
                    String[] crops = new String[]{"Maize", "Cassava", "Yam", "Rice"};
                    JSONArray cropArray = new JSONArray();
                    for (String crop1 : crops) {
                        JSONObject object = new JSONObject();
                        object.put("name", crop1);
                        meetingSettings = msm.findPerCrop(crop1);
                        JSONArray meetSet = new JSONArray();
                        System.out.println("Crops :" + crop1);
                        for (MeetingSettingWrapper meetingSetting : meetingSettings) {
                            JSONObject obj = new JSONObject();
//                            obj.put(MeetingSetting.CROP, meetingSetting.getCrop());
                            obj.put(MeetingSetting.START_DATE, meetingSetting.getStartDate());
                            obj.put(MeetingSetting.END_DATE, meetingSetting.getEndDate());
                            obj.put(MeetingSetting.MEETING_INDEX, meetingSetting.getMeetingIndex());
                            obj.put(MeetingSetting.TYPE, meetingSetting.getType());
                            JSONArray jarray = new JSONArray();
                            for (MeetingActivityWrapper aw : meetingSetting.getMeetingActivities()) {
                                JSONObject job = new JSONObject();
                                job.put("idx", aw.getIndex());
                                job.put("name", aw.getName());
                                jarray.put(job);
                            }
                            obj.put("activity", jarray);
                            meetSet.put(obj);
                        }
                        object.put("meeting", meetSet);
                        cropArray.put(object);
                    }
                    jSONObject.put("rc", "00");
                    jSONObject.put("crops", cropArray);
                    out.print(jSONObject);
                } else {
                    meetingSettings = msm.findPerCrop(crop);

                    JSONArray meetSet = new JSONArray();
                    for (MeetingSettingWrapper meetingSetting : meetingSettings) {
                        JSONObject obj = new JSONObject();
                        obj.put(MeetingSetting.CROP, meetingSetting.getCrop());
                        obj.put(MeetingSetting.START_DATE, meetingSetting.getStartDate());
                        obj.put(MeetingSetting.END_DATE, meetingSetting.getEndDate());
                        obj.put(MeetingSetting.MEETING_INDEX, meetingSetting.getMeetingIndex());
                        obj.put(MeetingSetting.TYPE, meetingSetting.getType());
                        JSONArray jarray = new JSONArray();
                        for (MeetingActivityWrapper aw : meetingSetting.getMeetingActivities()) {
                            JSONObject job = new JSONObject();
                            job.put("idx", aw.getIndex());
                            job.put("name", aw.getName());
                            jarray.put(job);
                        }
                        obj.put("activity", jarray);
                        meetSet.put(obj);
                    }
                    jSONObject.put("rc", "00");
                    jSONObject.put("meeting", meetSet);
                    out.print(jSONObject);
                }
            } //</editor-fold>
            else if (serviceCode.equalsIgnoreCase("sync")) {
                String data = request.getParameter("data");
                JSONArray jsonArray = new JSONArray(data);
                int length = jsonArray.length();

                String validIds = "";
                MobileTrackerModel trackerModel = new MobileTrackerModel();
                for (int i = 0; i < length; i++) {
                    JSONObject j = jsonArray.getJSONObject(i);
                    String userId = j.getString("user_id");
                    String id = j.getString("id");
                    long startTime = j.getLong("start_time");
                    long endTime = j.getLong("end_time");
                    String module = j.getString("module");
                    String dt = j.getString("data");

                    MobileTrackerWrapper mobileTracker = new MobileTrackerWrapper(id, userId, module, dt, startTime, endTime);

                    if (trackerModel.create(mobileTracker) != null) {
                        validIds += id + ",";
                    }
                }
                if (!validIds.isEmpty()) {
                    validIds = validIds.substring(0, validIds.length() - 2);
                }
                JSONObject js = new JSONObject();
                js.put("rc", "00");
                js.put("ids", validIds);
                
                out.print(js);

            }else if("fdetails".equalsIgnoreCase(serviceCode))
            {
                 Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx(); 
                 List<BiodataWrapper> bw = new BiodataModel().getBioData("","");
                 System.out.println("Farmer count " + bw.size());
                 BiodataModel biodataModel = new BiodataModel();
                 ProductionModel productionModel = new ProductionModel();
                 PostHarvestModel postHarvestModel = new PostHarvestModel();
                 BaselineProductionModel baselineProductionModel = new BaselineProductionModel();
                 
                 JSONArray fa = new JSONArray();
                 
       if (null != bw) {
                                
               for(BiodataWrapper bb :bw)
                {
                    
                    JSONObject production = new JSONObject();
                    JSONObject postHarvest = new JSONObject();
                    JSONObject farmer = new JSONObject();
                    JSONObject details = new JSONObject();
                    JSONObject baselineproduction = new JSONObject();

                     //biodata
                Biodata b = biodataModel.getBiodata("Id", bb.getFarmID());
                
                 if(null!=b)
                {
              
                farmer.put(Biodata.FIRST_NAME,b.getFirstname());
                farmer.put(Biodata.LAST_NAME, b.getLastname());
                farmer.put(Biodata.AGE,b.getAge());
                farmer.put(Biodata.COMMUNITY,b.getCommunity());
                farmer.put(Biodata.GENDER, b.getGender());
                farmer.put(Biodata.EDUCATION,b.getEducation());
                farmer.put(Biodata.FARMERID, b.getId());
               // farmer.put(Biodata.FARM_AREA, b.getFarmarea());
                farmer.put(Biodata.MAJOR_CROP,b.getMajorCrop());
                farmer.put(Biodata.MARITAL_STATUS,b.getMaritalstatus());
                farmer.put(Biodata.NICKNAME, b.getNickname());
                farmer.put(Biodata.NUMBER_OF_CHILDREN,b.getNumberofchildren());
                farmer.put(Biodata.NUMBER_OF_DEPENDANTS,b.getNumberofdependants());
                farmer.put(Biodata.REGION,b.getRegion());
                farmer.put(Biodata.VILLAGE,b.getVillage());
                
                }
                 
                   //Production
                ProductionNew  p =  productionModel.getProduction("Id", bb.getFarmID());
                
                if(null!=p)
                {
                    
                 System.out.println("Production " + p.getAcresofland() + "farmer " + b.getFirstname());
                 production.put( ProductionNew.ACRESOFLAND,p.getAcresofland());
                 production.put( ProductionNew.APPLICATIONMONTHOFHERBICIDEDATE,p.getApplicationmonthofherbicidedate());
                 production.put(ProductionNew.APPLICATIONOFBASALFERTILIZER, p.getApplicationofbasalfertilizer());
                 production.put(ProductionNew.APPLICATIONOFBASALFERTILIZERDATE,p.getApplicationofbasalfertilizerdate());
                 production.put(ProductionNew.APPLICATIONOFTOPDRESSFERTILIZER, p.getApplicationoftopdressfertilizer());
                 production.put(ProductionNew.DATEFIFTHPOSTGEMWEEDCONTROL, p.getDatefifthpostgemweedcontrol());
                 production.put(ProductionNew.DATEFIRSTMANUALWEEDCONTROL,p.getDatefirstmanualweedcontrol());
                 production.put(ProductionNew.DATEFOURTHPOSTGEMWEEDCONTROL,p.getDatefourthpostgemweedcontrol());
                 production.put(ProductionNew.DATEOFSECONDMANUALWEEDCONTROL,p.getDateofsecondmanualweedcontrol());
                 production.put(ProductionNew.DATETHIRDMANUALWEEDCONTROL,p.getDatethirdmanualweedcontrol());
                 production.put(ProductionNew.LANDCLEARINGDATE,p.getLandclearingdate());
                 production.put(ProductionNew.METHODOFBASALFERTILIZERAPPLICATION,p.getMethodofbasalfertilizerapplication());
                 production.put(ProductionNew.METHODOFBASALFERTILIZERAPPLICATIONOTHER,p.getMethodofbasalfertilizerapplicationother());
                 production.put(ProductionNew.METHODOFLANDCLEARING,p.getMethodoflandclearing());
                 production.put(ProductionNew.METHODOFLANDPREPARATION,p.getMethodoflandpreparation());
                 production.put(ProductionNew.METHODTOPDRESSFERTILIZERAPP,p.getMethodtopdressfertilizerapp());
                 production.put(ProductionNew.NAMEOFCROPVARIETY,p.getNameofcropvariety());
                 production.put(ProductionNew.NAMEOFCROPVARIETYCASSAVA,p.getNameofcropvarietycassava());
                 production.put(ProductionNew.NAMEOFCROPVARIETYRICE,p.getNameofcropvarietyrice());
                 production.put(ProductionNew.NAMEOFCROPVARIETYYAM,p.getNameofcropvarietyyam());
                 production.put(ProductionNew.OTHERFERTILIZER,p.getOtherfertilizer());
                 production.put(ProductionNew.PLANTINGDATE,p.getPlantingdate());
                 production.put(ProductionNew.PLANTINGDISTANCEBETWEENPLANTSMAIZE,p.getPlantingdate());
                 production.put(ProductionNew.PLANTINGDISTANCEBETWEENPLANTSMAIZEYC,p.getPlantingdistancebetweenplantsmaizeyc());
                 production.put(ProductionNew.PLANTINGDISTANCEBETWEENPLANTSRICE,p.getPlantingdistancebetweenplantsrice());
                 production.put(ProductionNew.PLANTINGDISTANCEBETWEENROWSMAIZE,p.getPlantingdistancebetweenrowsmaize());
                 production.put(ProductionNew.PLANTINGDISTANCEBETWEENROWSYC,p.getPlantingdistancebetweenrowsyc());
                 production.put(ProductionNew.PLOUGHINGDATE,p.getPloughingdate());
                 production.put(ProductionNew.POSTPLANTHERBICIDEUSE,p.getPostplantherbicideuse());
                 production.put(ProductionNew.QUANTITYOFBASALFERTILIZERPURCHASEDAPPLY,p.getQuantityofbasalfertilizerpurchasedapply());
                 production.put(ProductionNew.QUANTITYOFTOPDRESSERFERTILIZERPURCHASED,p.getQuantityoftopdresserfertilizerpurchased());
                 production.put(ProductionNew.QUANTITYPOSTPLANTHERBICIDE,p.getQuantitypostplantherbicide());
                 production.put(ProductionNew.REFILLINGGAPSOCCURENCE,p.getRefillinggapsoccurence());
                 production.put(ProductionNew.REFILLINGGAPSPROPORTION,p.getRefillinggapsproportion());
                 production.put(ProductionNew.SEEDBEDFORMTYPE,p.getSeedbedformtype());
                 production.put(ProductionNew.SEEDBEDPREPARATIONDATE,p.getSeedbedformtype());
                 production.put(ProductionNew.SOURCEOFSEEDORPLANTINGMATERIAL,p.getSourceofseedorplantingmaterial());
                 production.put(ProductionNew.SOURCEOFSEEDORPLANTINGMATERIALOTHER,p.getSourceofseedorplantingmaterialother());
                 production.put(ProductionNew.TARGETYIELDPERACRE,p.getTargetyieldperacre());
                 production.put(ProductionNew.TIMEOFAPPLICATIONTOPDRESSING,p.getTimeofapplicationtopdressing());
                 production.put(ProductionNew.TIMEOFHARVEST,p.getTimeofharvest());
                 production.put(ProductionNew.TOPDRESSFERTILIZEROTHER,p.getTopdressfertilizerother());
                 production.put(ProductionNew.TYPEOFBASALFERTILIZER,p.getTypeofbasalfertilizer());
                 production.put(ProductionNew.TYPEOFFERTILIZERTOPDRESSING,p.getTypeoffertilizertopdressing());
                 production.put(ProductionNew.TYPEOFHERBICIDEPOSTPLANTWEED,p.getTypeofherbicidepostplantweed());
                 
                 
                }
                    
                  PostHarvest2 ph = postHarvestModel.getPostHarvest("Id", bb.getFarmID());
                 if(null!=ph)
                {
                 System.out.println("Post Harvest " + ph.getApplicationrateofstoragechemical() + "farmer " + b.getFirstname());
                 postHarvest.put(PostHarvest2.APPLICATIONRATEOFSTORAGECHEMICAL,ph.getApplicationrateofstoragechemical());
                 postHarvest.put(PostHarvest2.COMPLETIONOFPRODUCEMARKETING,ph.getCompletionofproducemarketing());
                 postHarvest.put(PostHarvest2.COMPLETIONOFTHRESHING,ph.getCompletionofthreshing());
                 postHarvest.put(PostHarvest2.DATEOFCOMPLETINGDRYING,ph.getDateofcompletingdrying());
                 postHarvest.put(PostHarvest2.DATETOCOMPLETEDRYING,ph.getDatetocompletedrying());
                 postHarvest.put(PostHarvest2.DEHUSKINGDATE,ph.getDehuskingdate());
                 postHarvest.put(PostHarvest2.FIRSTSALEDATE,ph.getFirstsaledate());
                 postHarvest.put(PostHarvest2.MAINPOINTOFSALEORCONTACT,ph.getMainpointofsaleorcontact());
                 postHarvest.put(PostHarvest2.MANUALTHRESHING,ph.getManualthreshing());
                 postHarvest.put(PostHarvest2.MANUALWINNOWING,ph.getManualwinnowing());
                 postHarvest.put(PostHarvest2.MARKETINGOCCASIONS,ph.getMarketingoccasions());
                 postHarvest.put(PostHarvest2.METHODOFDRYINGCOBSPANICLESCHIPSCHU,ph.getMethodofdryingcobspanicleschipschu());
                 postHarvest.put(PostHarvest2.METHODOFDRYINGGRAIN,ph.getMethodofdryinggrain());
                 postHarvest.put(PostHarvest2.METHODOFTHRESHING,ph.getMethodofthreshing());
                 postHarvest.put(PostHarvest2.METHODOFWINNOWING,ph.getMethodofwinnowing());
                 postHarvest.put(PostHarvest2.MOSTPRODUCESALEDATE,ph.getMostproducesaledate());
                 postHarvest.put(PostHarvest2.OTHERAPPLICATIONRATE,ph.getOtherapplicationrate());
                 postHarvest.put(PostHarvest2.OTHERMETHODFORDRYING,ph.getOthermethodfordrying());
                 postHarvest.put(PostHarvest2.OTHERMETHODOFDRYINGGRAIN,ph.getOthermethodofdryinggrain());
                 postHarvest.put(PostHarvest2.OTHERMETHODSOFDEHUSKING,ph.getOthermethodsofdehusking());
                 postHarvest.put(PostHarvest2.OTHERSALECONTACT,ph.getOthersalecontact());
                 postHarvest.put(PostHarvest2.OTHERSTORAGECHEMICAL,ph.getOtherstoragechemical());
                 postHarvest.put(PostHarvest2.POSTHARVESTLOSSES,ph.getPostharvestlosses());
                 postHarvest.put(PostHarvest2.PRICEATFIRSTSALEDATE,ph.getPriceatfirstsaledate());
                 postHarvest.put(PostHarvest2.PRICEATMOSTSALEDATE,ph.getPriceatmostsaledate());
                 postHarvest.put(PostHarvest2.PROCESSINGOFCASSAVA,ph.getProcessingofcassava());
                 postHarvest.put(PostHarvest2.PROPORTIONFORMARKET,ph.getProportionformarket());
                 postHarvest.put(PostHarvest2.PROPORTIONOFCASSAVAPROCESSEDINTOCHIPS,ph.getProportionofcassavaprocessedintochips());
                 postHarvest.put(PostHarvest2.THERAPPLICATIONRATEOFSTORAGECHEMIC,ph.getTherapplicationrateofstoragechemic());
                 postHarvest.put(PostHarvest2.TYPEOFBAGUSEDINBULKINGPRODUCT,ph.getTypeofbagusedinbulkingproduct());
                 postHarvest.put(PostHarvest2.TYPEOFMACHINE,ph.getTypeofmachine());
                 postHarvest.put(PostHarvest2.TYPEOFMACHINEWINOWING,ph.getTypeofmachinewinowing());
                 postHarvest.put(PostHarvest2.TYPEOFSTORAGECHEMICAL,ph.getTypeofstoragechemical());
                 postHarvest.put(PostHarvest2.TYPEOFSTORAGESTRUCTURE,ph.getTypeofstoragestructure());
                }   
                 
                 BaselineProduction bp = baselineProductionModel.getProduction("Id",bb.getFarmID());
                 
                 if(null!=bp)
                 {
                     baselineproduction.put(BaselineProduction.APPLIC_BASAL_FERT_BASE, bp.getApplic_basal_fert_base());
                     baselineproduction.put(BaselineProduction.APPLIC_POSTPLANT_HERB_DATE_BASE, bp.getApplic_postplant_herb_date_base());
                     baselineproduction.put(BaselineProduction.APPLIC_TOPDRESS_FERT_BASE, bp.getApplic_topdress_fert_base());
                     baselineproduction.put(BaselineProduction.AREA_CULTIVATED_BASE, bp.getArea_cultivated_base());
                     baselineproduction.put(BaselineProduction.CROP_TO_CULTIVATE_BASE, bp.getCrop_to_cultivate_base());
                     baselineproduction.put(BaselineProduction.DATE_FIFTH_MANUAL_WEED_BASE, bp.getDate_fifth_manual_weed_base());
                     baselineproduction.put(BaselineProduction.DATE_FIRST_MANUAL_WEED_BASE, bp.getDate_first_manual_weed_base());
                     baselineproduction.put(BaselineProduction.DATE_FOURTH_MANUAL_WEED_BASE, bp.getDate_fourth_manual_weed_base());
                     baselineproduction.put(BaselineProduction.DATE_OF_HARVEST_BASE,bp.getDate_of_harvest_base());
                     baselineproduction.put(BaselineProduction.DATE_SECOND_MANUAL_WEED_BASE,bp.getDate_second_manual_weed_base());
                     baselineproduction.put(BaselineProduction.DATE_THIRD_MANUAL_WEED_BASE,bp.getDate_third_manual_weed_base());
                     baselineproduction.put(BaselineProduction.DISTANCE_BETWEEN_PLANTS_BASE,bp.getDistance_between_plants_base());
                     baselineproduction.put(BaselineProduction.DISTANCE_BETWEEN_ROWS_BASE,bp.getDistance_between_rows_base());
                     baselineproduction.put(BaselineProduction.LAND_CLEARING_DATE_BASE,bp.getLand_clearing_date_base());
                     baselineproduction.put(BaselineProduction.METHOD_BFERT_APPLIC_BASE,bp.getMethod_bfert_applic_base());
                     baselineproduction.put(BaselineProduction.METHOD_OF_LAND_CLEARING_BASE,bp.getMethod_of_land_clearing_base());
                     baselineproduction.put(BaselineProduction.METHOD_OF_LAND_PREPARATION_BASE,bp.getMethod_of_land_preparation_base());
                     baselineproduction.put(BaselineProduction.METHOD_TOPDRESS_FERT_BASE,bp.getMethod_topdress_fert_base());
                     baselineproduction.put(BaselineProduction.NAME_OF_CROP_VARIETY_CULTIVATED_BASE,bp.getName_of_crop_variety_cultivated_base());
                     baselineproduction.put(BaselineProduction.NAME_OF_OTHER_VARIETY_BASE,bp.getName_of_other_variety_base());
                     baselineproduction.put(BaselineProduction.NAME_OF_VARIETY_CASS_BASE,bp.getName_of_variety_cass_base());
                     baselineproduction.put(BaselineProduction.NAME_OF_VARIETY_RICE_BASE,bp.getName_of_variety_rice_base());
                     baselineproduction.put(BaselineProduction.NAME_OF_VARIETY_YAM,bp.getName_of_variety_yam());
                     
                     
                 }
                 
                 
                 
                  
                 farmer.put("production",production);
                 farmer.put("postharvest",postHarvest);
                 
                 
                 
                 details.put("farmer",farmer);
                 
                 fa.put(details);
                    
                }
                 tx.success();
                 out.print(fa);
                 System.out.println("Output " + fa);
               
                } else {

                    JSONObject obj = new JSONObject();
                    obj.put("rc", "05");
                    obj.put("msg", "Invalid Action");
                    out.print(obj);
                }
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
