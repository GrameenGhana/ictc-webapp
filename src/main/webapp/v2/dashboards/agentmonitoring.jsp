<%-- 
    Document   : agentmonitoring
    Created on : Nov 15, 2016, 4:03:45 PM
    Author     : Joseph George Davis
--%>

<%@page import="com.grameenfoundation.ictc.utils.BIDashboard"%>
<%@page import="com.grameenfoundation.ictc.utils.BIDataManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.*"%>
<%
     BIDashboard data = new BIDashboard("acdivoca");
     BIDataManager bi = BIDataManager.getInstance();
    JSONObject y = bi.getACDIVOCAAgentActivity();
    JSONArray ja = y.getJSONArray("agentactivity");
    JSONObject b = new JSONObject();
    

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agent Monitoring Activity</title>
          <content tag="stylesheets">
        <!-- Datatables -->
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    </content>
    </head>
    <body>
        <!-- Agent Monitoring -->
            <div style="margin-bottom: 30px" class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Agent Activity Monitoring <small></small></h2>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                       <table id="agent-monitoring-table" class="table table-striped table-bordered jambo_table">
                            <thead>
                            <tr>
                                <th>Agent</th>
                                <th>No farmers with access to Agent</th>
                                <th>No farmers taken through Previous performance (Production)</th>
                                <th>No farmers taken through Previous performance (Post-harvest)</th>
                                <th>No farmers taken through Previous performance (Credit)</th>
                                <th>No farmers coached to produce Farm Management Plan on Production</th>
                                <th>No farmers coached to produce Farm Management Plan on Post-harvest</th>
                                <th>No farmers coached to produce Farm Management Plan on Farm Credit</th>
                                <th>No farms measured by Agent</th>
                                <th>No farms accessed by Agent</th>
                                <th>No of Updated records [FMP production]</th>
                                <th>No of Updated records [FMP Post-harvest / Marketing] </th>
                                <th>Number of Updated records [Credit]</th>
                                
                            </tr>
                            </thead>
                            <tbody>
                            <!--<tr>
                                <td>Agents Registered (% of target)</td>
                                <td><%= data.getAgentRegistrationTotalForACDI() %> / <%= data.getAgentRegistrationTargetForACDI() %> (<%= data.getAgentRegistrationProgressForACDI()%>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) with more than 50 Previous Performance surveys (Production, Post-harvest, Credit) completed</td>
                                <td><%= data.getAgentPPTotalForACDI() %> (<%= data.getAgentPPProgressForACDI() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) with more than 50 FMP (Production, Post-harvest, Credit) completed</td>
                                <td><%= data.getAgentFMPTotalForACDI() %> (<%= data.getAgentFMPProgressForACDI() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) with more than 50 FMP Update (Production, Harvest, Post-harvest, Marketing, Credit) completed</td>
                                <td><%= data.getAgentFMPUpdateTotalForACDI() %> (<%= data.getAgentFMPUpdateProgressForACDI() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) who have measured more than 50 farms</td>
                                <td><%= data.getAgentFarmsMeasuredTotalForACDI() %> (<%= data.getAgentFarmsMeasuredProgressForACDI() %>%)</td>
                            </tr>
                            <tr>
                                <td style="width: 20%">Number of agents (% of target) who have assessed more than 50 farms</td>
                                <td><%= data.getAgentFarmsAssessedTotalForACDI() %> (<%= data.getAgentFarmsAssessedProgressForACDI() %>%)</td>
                            </tr>-->
                            <% for (int i =0;i<ja.length();i++) { b = ja.getJSONObject(i);%>
                               
                            <tr>
                                <td><%= b.getString("name") %></td>
                                <td><%= b.get("farmers") %></td>
                                <td><%= b.get("blproduction") %></td>
                                <td><%= b.get("blpostharvest")%></td>
                                <td><%= b.get("blcredit")%></td>
                                <td><%= b.get("fmpproduction")%></td>
                                <td><%= b.get("fmppostharvest")%></td>
                                <td><%= b.get("fmpcredit")%></td>
                                <td><%= b.get("measured")%></td>
                                <td><%= b.get("assessed")%></td>
                                <td><%= b.get("productionupdate") %></td>
                                <td><%= b.get("postharvestupdate") %></td>
                                <td><%= b.get("creditupdate")  %></td>
                            </tr>
                            <% }%>
                            
                            
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
    </body>
    <content tag="scripts">
        <!-- Datatables -->
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/jszip/dist/jszip.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/pdfmake/build/pdfmake.min.js"></script>
        <script src="<%= request.getContextPath()%>/theme/gentelella/vendors/pdfmake/build/vfs_fonts.js"></script>

        <!-- Datatables -->
        <script>
            $(document).ready(function() {
              /**  var getAjaxUrl = function(table) {
                    return  "<%= request.getContextPath() %>/api/v1?action=get_bi_data&partner=ACDIVOCA"
                            + "&gender=" + $("#gender-"+table).val()
                            + "&location=" + $("#location-"+table).val()
                            + "&crop=" + $("#crop-"+table).val()
                            + "&data_set=gf-get-" + table;
                }**/

                var options = {
                    dom: "Bfrtip",
                    buttons: [
                        { extend: "copy", className: "btn-sm" },
                        { extend: "csv", className: "btn-sm" },
                        { extend: "excel", className: "btn-sm" },
                        { extend: "pdfHtml5", className: "btn-sm" },
                        { extend: "print", className: "btn-sm" },
                    ],
                    responsive: true,
                    paging: false,
                    searching: false
                };

                $("#farmer-monitoring-table").DataTable(options);
                $('#agent-monitoring-table').DataTable(options);

              /**  var oajax =  {ajax:{ url: getAjaxUrl("output-table")  }};
                var ocolumns = {columns: [ { "data": "indicator" }, { "data": "farmers" }, { "data": "area" } ]};
                var oopts = $.extend({}, options, oajax, ocolumns);
                var outputTable = $('#output-table').DataTable(oopts);

                $("#gender-output-table").change(function() { console.log("changing"); outputTable.ajax.url(getAjaxUrl("output-table")).load(); });
                $("#location-output-table").change(function() { outputTable.ajax.url(getAjaxUrl("output-table")).load(); });
                $("#crop-output-table").change(function() { outputTable.ajax.url(getAjaxUrl("output-table")).load(); });**/
            });
        </script>
        <!-- /Datatables -->
         <!-- jQuery Sparklines -->
    <script>
    $(document).ready(function() {
        var options = {
            type: 'line',
            width: '200',
            height: '40',
            lineColor: '#26B99A',
            fillColor: 'rgba(223, 223, 223, 0.57)',
            lineWidth: 2,
            spotColor: '#26B99A',
            minSpotColor: '#26B99A'
        };

        $(".sparkline_line").sparkline([2, 4, 3, 4, 5, 4, 5, 4, 3, 4, 5, 6, 4, 5, 6, 3, 5], {
            type: 'line',
            lineColor: '#26B99A',
            fillColor: '#ffffff',
            width: 85,
            spotColor: '#34495E',
            minSpotColor: '#34495E'
        });


        $(".sparkline_tf").sparkline([300],options);
        $(".sparkline_tc").sparkline([300], options);
        $(".sparkline_ta").sparkline([300], options);
    });
    </script>
    <!-- /jQuery Sparklines -->

    </content>
</html>
