<%-- 
    Document   : denied
    Created on : Jul 15, 2017, 1:54:34 PM
    Author     : phenom
--%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
    <jsp:body>
        <div class="row">
            <div class="col-lg-">
                <div class="panel panel-red">
                    <div class="panel-heading">
                        Acceso denegado
                    </div>
                    <div class="panel-body">
                        <p>No tiene los permisos necesarios para acceder a esta funcionalidad</p>
                    </div>
                    <div class="panel-footer">
                        Usuario Actual: <strong><sec:authentication property="principal.username" /></strong>
                    </div>
                </div>
                <!-- /.col-lg-4 -->
            </div>
        </div>
    </jsp:body>


</t:layout>