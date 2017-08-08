<%-- 
    Document   : layout
    Created on : Jun 1, 2017, 6:21:33 AM
    Author     : Phenom
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@tag description="Layout" pageEncoding="windows-1252"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="titulo" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" required="false" %>
<%@attribute name="side" fragment="true" required="false" %>
<%@attribute name="styles" fragment="true" required="false" %>
<%@attribute name="scripts" fragment="true" required="false" %>


<%-- Declaraciones de las hojas de estilo--%>
<spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"
            var="bootstrapCSS" />

<spring:url value="/resources/vendor/metisMenu/metisMenu.min.css"
            var="metisMenuCSS" />

<spring:url value="/resources/dist/css/sb-admin-2.css"
            var="sbAdmin2CSS" />

<spring:url value="/resources/vendor/font-awesome/css/font-awesome.min.css"
            var="fontAwasomeCSS" />

<%-- Declaraciones de las hojas de estilo--%>

<%-- Declaraciones de las Scripts--%>
<spring:url value="/resources/vendor/jquery/jquery.min.js"
            var="jqueryJs" />

<spring:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"
            var="bootstrapJs" />

<spring:url value="/resources/vendor/metisMenu/metisMenu.min.js"
            var="metisMenuJS" />

<spring:url value="/resources/dist/js/sb-admin-2.js"
            var="sbAdmin2JS" />
<%-- Declaraciones de las Scripts--%>

<%-- any content can be specified here e.g.: --%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>${titulo}</title>

        <!-- Bootstrap Core CSS -->
        <link href="${bootstrapCSS}" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="${metisMenuCSS}" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="${sbAdmin2CSS}" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${fontAwasomeCSS}" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Another CSS -->
        <jsp:invoke fragment="styles"/>

    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/Nominax/">Nominax</a>
                </div>
                <!-- /.navbar-header -->

                <ul class="nav navbar-top-links navbar-right">
                    <!-- /.dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <sec:authentication property="principal.username" /> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <!--<li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                            </li>
                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                            </li>
                            <li class="divider"></li>-->
                            <li><a href="<c:url value="/security/signout"/>"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li class="sidebar-search">
                                <div class="input-group custom-search-form">
                                    <input type="text" class="form-control" placeholder="Search...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </span>
                                </div>
                                <!-- /input-group -->
                            </li>

                            <!-- Aqui el menu lateral -->
                            <%--<li>
                                <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                            </li>--%>
                            <li>
                                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Administracion<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="/Nominax/empleados/listar">Empleados</a>
                                    </li>
                                    <li>
                                        <a href="/Nominax/departamentos/listar">Departamentos</a>
                                    </li>
                                    <li>
                                        <a href="/Nominax/puestos/listar">Puestos</a>
                                    </li>
                                    <li>
                                        <a href="/Nominax/tid/listar">Tipos de Ingresos y Deducciones</a>
                                    </li>
                                    <li>
                                        <a href="/Nominax/nominas/listar">Nominas</a>
                                    </li>
                                    <li>
                                        <a href="/Nominax/empdep/listar">Encargados</a>
                                    </li>
                                    <li>
                                        <a href="/Nominax/transacciones/listar">Transacciones</a>
                                    </li>
                                    <%-- Especial para la seguridad --%>
                                    <sec:authorize access="hasRole('ADMIN')">
                                        <li>
                                            <a href="<c:url value="/security/listar-usuarios" />">Usuarios</a>
                                        </li>
                                    </sec:authorize>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li>
                                <a href="<c:url value="/reporte/"/>"><i class="fa fa-table fa-fw"></i> Reportes</a>
                            </li>
                            <%-- 
                            <li>
                                <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="panels-wells.html">Panels and Wells</a>
                                    </li>
                                    <li>
                                        <a href="buttons.html">Buttons</a>
                                    </li>
                                    <li>
                                        <a href="notifications.html">Notifications</a>
                                    </li>
                                    <li>
                                        <a href="typography.html">Typography</a>
                                    </li>
                                    <li>
                                        <a href="icons.html"> Icons</a>
                                    </li>
                                    <li>
                                        <a href="grid.html">Grid</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            
                            <li>
                                <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="#">Second Level Item</a>
                                    </li>
                                    <li>
                                        <a href="#">Second Level Item</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level <span class="fa arrow"></span></a>
                                        <ul class="nav nav-third-level">
                                            <li>
                                                <a href="#">Third Level Item</a>
                                            </li>
                                            <li>
                                                <a href="#">Third Level Item</a>
                                            </li>
                                            <li>
                                                <a href="#">Third Level Item</a>
                                            </li>
                                            <li>
                                                <a href="#">Third Level Item</a>
                                            </li>
                                        </ul>
                                        <!-- /.nav-third-level -->
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            <li class="active">
                                <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a class="active" href="blank.html">Blank Page</a>
                                    </li>
                                    <li>
                                        <a href="login.html">Login Page</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                            --%>
                            <%-- Aqui el contenido --%>
                            <jsp:invoke fragment="side"/>
                            <%-- Aqui el contenido --%>
                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>

            <!-- Page Content -->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <jsp:doBody/>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="${jqueryJs}"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="${bootstrapJs}"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="${metisMenuJS}"></script>

        <!-- Custom Theme JavaScript -->
        <script src="${sbAdmin2JS}"></script>

        <!-- Custom JavaScript -->
        <jsp:invoke fragment="scripts" />

    </body>

</html>


