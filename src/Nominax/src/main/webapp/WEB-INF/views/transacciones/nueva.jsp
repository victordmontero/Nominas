<%-- 
    Document   : nueva
    Created on : Jun 19, 2017, 9:26:56 AM
    Author     : phenom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.Date" %>
<t:layout>
    <jsp:attribute name="scripts">
        <script src="<c:url value="/resources/vendor/jqueryvalidation/jquery.validate.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/nominax/js/jqueryValidation.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/vendor/jqueryvalidation/messages_es.js"/>" type="text/javascript"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Nueva Transacci&oacute;n</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Nueva Transacci&oacute;n
                    </div>
                    <div class="panel-body">
                        <c:url value="/transacciones/nueva" var="NuevaUrl" />
                        <mvc:form modelAttribute="transaccion" action="${NuevaUrl}" method="POST" cssClass="transaccionVal">
                            <c:set var="resultDateString"/>
                            <fmt:formatDate value="${transaccion.fecha}" pattern="MM/dd/yyyy" var="resultDateString" />

                            <input type="hidden" name="fecha" 
                                   value="<c:out value="${resultDateString}"/>" />
                            <input type="hidden" name="estado" value="true" />
                            <div class="row">
                                <div class="form-group col-lg-12">
                                    <mvc:label path="empleados.idEmpleado">Empleado</mvc:label>
                                    <mvc:select path="empleados.idEmpleado" cssClass="form-control"
                                                items="${empleados}"
                                                itemLabel="nombre"
                                                itemValue="idEmpleado"/>
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="tipoTransaccion">Tipo Transacci&oacute;n</mvc:label>
                                    <mvc:input path="tipoTransaccion" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="tipoIngresoDeduccion.idTipoIngresoDeduccion">
                                        Tipo de Ingreso o Deducci&oacute;n</mvc:label>
                                    <mvc:select path="tipoIngresoDeduccion.idTipoIngresoDeduccion"
                                                cssClass="form-control" items="${tids}"
                                                itemLabel="descripcion"
                                                itemValue="idTipoIngresoDeduccion"/>
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="monto">Monto</mvc:label>
                                    <mvc:input path="monto" cssClass="form-control"/>
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