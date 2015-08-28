<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>ICTC - <decorator:title default="Default" /></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes">    
        <link href="<%= request.getContextPath()%>/theme/egrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/egrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/egrap/css/font-awesome.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/egrap/css/style.css" rel="stylesheet">
        <link href="<%= request.getContextPath()%>/theme/egrap/css/pages/dashboard.css" rel="stylesheet">

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="navbar navbar-fixed-top">

            <div class="navbar-inner">

                <div class="container">

                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <a class="brand" href="<%=request.getContextPath()%>">
                        ICTChallenge				
                    </a>		

                    <div class="nav-collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">						
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="icon-cog"></i>
                                    Agent  Account
                                    <b class="caret"></b>
                                </a>

                                <ul class="dropdown-menu">
                                    <li><a href="javascript:;">Settings</a></li>
                                    <li><a href="javascript:;">Help</a></li>
                                </ul>						
                            </li>

                            <li class="dropdown">						
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="icon-user"></i> 
                                    ictchallenge
                                    <b class="caret"></b>
                                </a>

                                <ul class="dropdown-menu">
                                    <li><a href="javascript:;">Profile</a></li>
                                    <li><a href="javascript:;">Logout</a></li>
                                </ul>						
                            </li>
                        </ul>

                        <form class="navbar-search pull-right">
                            <input type="text" class="search-query" placeholder="Search">
                        </form>

                    </div><!--/.nav-collapse -->	

                </div> <!-- /container -->

            </div> <!-- /navbar-inner -->

        </div> <!-- /navbar -->





        <div class="subnavbar">

            <div class="subnavbar-inner">

                <div class="container">

                    <ul class="mainnav">

                        <li>
                            <a href="<%=request.getContextPath()%>">
                                <i class="icon-dashboard"></i>
                                <span>Dashboard</span>
                            </a>	    				
                        </li>



                        <li>
                            <a href="<%=request.getContextPath()%>/reports">
                                <i class="icon-list-alt"></i>
                                <span>Reports</span>
                            </a>    				
                        </li>

                        <li>					
                            <a href="<%=request.getContextPath()%>/farmer">
                                <i class="icon-facetime-video"></i>
                                <span>Farmers</span>
                            </a>  									
                        </li>




                        <li class="">					
                            <a href="<%=request.getContextPath()%>/agent">
                                <i class="icon-code"></i>
                                <span>Agents</span>
                            </a>  									
                        </li>

                        <li class="dropdown">					
                            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="icon-long-arrow-down"></i>
                                <span>Settings</span>
                                <b class="caret"></b>
                            </a>	

                            <ul class="dropdown-menu">
                                <li><a href="<%=request.getContextPath()%>/region">Region</a></li>
                                <li><a href="<%=request.getContextPath()%>/district">District</a></li>
                                <li><a href="<%=request.getContextPath()%>/category">Category</a></li>

                            </ul>    				
                        </li>

                    </ul>

                </div> <!-- /container -->

            </div> <!-- /subnavbar-inner -->

        </div> <!-- /subnavbar -->



        <div class="main">

            <div class="main-inner">

                <div class="container">

                    <div class="row">

                        <div class="span12">      		

                            <div class="widget ">

                                <div class="widget-header">
                                    <i class="icon-user"></i>
                                    <h3><decorator:title default="Page Title" /></h3>
                                </div> <!-- /widget-header -->

                                <div class="widget-content">


                                    <decorator:body />

                                </div> <!-- /widget-content -->

                            </div> <!-- /widget -->

                        </div> <!-- /span8 -->




                    </div> <!-- /row -->

                </div> <!-- /container -->

            </div> <!-- /main-inner -->

        </div> <!-- /main -->




        <div class="extra">

            <div class="extra-inner">

                <div class="container">

                    <div class="row">
                        <div class="span3">
                            <h4></h4>
                            <ul>
                                     </ul>
                        </div>
                        <!-- /span3 -->
                        <div class="span3">
                            <h4>
                                </h4>
                            <ul>
                                                </ul>
                        </div>
                        <!-- /span3 -->
                        <div class="span3">
                            <h4></h4>
                            <ul>
                              
                            </ul>
                        </div>
                        <!-- /span3 -->
                        <div class="span3">
                            <h4>
                               </h4>
                            <ul>
                               </ul>
                        </div>
                        <!-- /span3 -->
                    </div> <!-- /row -->

                </div> <!-- /container -->

            </div> <!-- /extra-inner -->

        </div> <!-- /extra -->




        <div class="footer">

            <div class="footer-inner">

                <div class="container">

                    <div class="row">

                        <div class="span12">
                            &copy; 2015 <a href="http://www.egrappler.com/">ICTC - Powered by Grameen Foundation</a>.
                        </div> <!-- /span12 -->

                    </div> <!-- /row -->

                </div> <!-- /container -->

            </div> <!-- /footer-inner -->

        </div> <!-- /footer -->



        <script src="<%= request.getContextPath()%>/theme/egrap/js/jquery-1.7.2.min.js"></script>

        <script src="<%= request.getContextPath()%>/theme/egrap/js/bootstrap.js"></script>
        <script src="<%= request.getContextPath()%>/theme/egrap/js/base.js"></script>
    </script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>

    <script src="<%= request.getContextPath()%>/theme/egrap/js/map.js"></script>
</script>
<script type="text/javascript">
   <decorator:getProperty property="page.scripts"/>
</script>
</body>

</html>