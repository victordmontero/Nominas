<%-- 
    Document   : guardarUsuario
    Created on : Jul 15, 2017, 4:16:45 PM
    Author     : phenom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>

<t:layout>
    
    <jsp:attribute name="scripts">
        <script src="<c:url value="/resources/vendor/jqueryvalidation/jquery.validate.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/nominax/js/jqueryValidation.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/vendor/jqueryvalidation/messages_es.js"/>" type="text/javascript"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Nuevo Usuario</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Nuevo Usuario
                    </div>
                    <div class="panel-body">
                        <c:url value="/security/nuevo-usuario" var="GuardarUrl" />
                        <mvc:form modelAttribute="usuario" action="${GuardarUrl}" method="POST" cssClass="usuarioVal">
                            <input type="hidden" name="estado" value="true"/>
                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <mvc:label path="nombre">Nombre de Usuario</mvc:label>
                                    <mvc:input path="nombre" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="password">Contrase&ntilde;a</mvc:label>
                                    <mvc:password path="password" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="repassword">Reingresar Contrase&ntilde;a</label>
                                    <input type="password" name="repassword" class="form-control"/>
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="roleses">Roles</mvc:label>
                                    <mvc:select path="roleses" cssClass="form-control" items="${roles}" itemLabel="nombreRole" itemValue="idRol"/>
                                </div>
                            </div>
                            <button class="btn btn-success" type="submit">Guardar</button>
                        </mvc:form>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</t:layout>