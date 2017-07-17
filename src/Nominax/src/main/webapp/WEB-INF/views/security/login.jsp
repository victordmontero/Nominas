<%-- 
    Document   : login
    Created on : Jul 13, 2017, 10:01:21 AM
    Author     : phenom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Nominax Login</title>

        <!-- Bootstrap Core CSS -->
        <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="<c:url value="/resources/vendor/metisMenu/metisMenu.min.css" />" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="<c:url value="/resources/dist/css/sb-admin-2.css" />" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Iniciar Sesi&oacute;n</h3>
                        </div>
                        <div class="panel-body">
                            <c:url var="loginUrl" value="/signin" />
                            <form action="${loginUrl}" method="post" role="form">

                                <c:if test="${param.error != null}">
                                    <div class="alert alert-danger">
                                        <p>Nombre o contrase&ntilde;a invalida</p>
                                    </div>
                                </c:if>
                                
                                <c:if test="${param.signout != null}">
                                    <div class="alert alert-success">
                                        <p>Has cerrado la sesi&oacute;n correctamente</p>
                                    </div>
                                </c:if>

                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Nombre de usuario" name="username" type="text" autofocus>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Contrase&ntilde;a" name="password" type="password" value="">
                                    </div>
                                    <!--<div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                        </label>
                                    </div>-->
                                    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
                                    <!-- Change this to a button or input when using this as a form -->

                                    <button type="submit" class="btn btn-lg btn-success btn-block">Iniciar Sesi&oacute;n</button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- jQuery -->
        <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="<c:url value="/resources/vendor/metisMenu/metisMenu.min.js"/>"></script>

        <!-- Custom Theme JavaScript -->
        <script src="<c:url value="/resources/dist/js/sb-admin-2.js"/>"></script>

    </body>

</html>

