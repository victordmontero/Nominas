<%-- 
    Document   : guardar
    Created on : Jun 14, 2017, 4:25:29 PM
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
                <h1 class="page-header">Nuevo Empleado</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Nuevo Empleado
                    </div>
                    <div class="panel-body">
                        <c:url value="/empleados/guardar" var="GuardarUrl" />
                        <mvc:form modelAttribute="empleado" action="${GuardarUrl}" method="POST" cssClass="empleadoVal">
                            <input type="hidden" name="estado" value="true"/>
                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <mvc:label path="cedula">Cedula</mvc:label>
                                    <mvc:input path="cedula" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="nombre">Nombre</mvc:label>
                                    <mvc:input path="nombre" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="salario">Salario</mvc:label>
                                    <mvc:input path="salario" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="departamentos.idDepartamento">Departamento</mvc:label>
                                    <mvc:select path="departamentos.idDepartamento" cssClass="form-control" items="${departamentos}" itemLabel="nombre" itemValue="idDepartamento" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="puestos.idPuesto">Puesto</mvc:label>
                                    <mvc:select path="puestos.idPuesto" cssClass="form-control" items="${puestos}" itemLabel="descripcion" itemValue="idPuesto"/>
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="nominas.idNomina">Nomina</mvc:label>
                                    <mvc:select path="nominas.idNomina" cssClass="form-control" items="${nominas}" itemLabel="descripcion" itemValue="idNomina"/>
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
