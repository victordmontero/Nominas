<%-- 
    Document   : editarUsuario
    Created on : Jul 15, 2017, 4:20:45 PM
    Author     : phenom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>

<t:layout>

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Editar ${usuario.nombre}</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Editar ${usuario.nombre}
                    </div>
                    <div class="panel-body">
                        <c:url value="/editar-usuario" var="EditarUrl" />
                        <mvc:form modelAttribute="usuario" action="${EditarUrl}" method="POST">
                            <input type="hidden" name="estado" value="true"/>
                            <input type="hidden" name="idUsuario" value="${usuario.idUsuario}"/>
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
                                    <mvc:label path="roleses">Roles</mvc:label>
                                    <mvc:select path="roleses" cssClass="form-control" items="${roles}" itemLabel="nombreRole" itemValue="idRol" multiple="true" />
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
