<%-- 
    Document   : guardar
    Created on : Jun 9, 2017, 9:36:54 AM
    Author     : Phenom
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
                <h1 class="page-header">Nuevo puesto</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Nuevo Puesto
                    </div>
                    <div class="panel-body">
                        <c:url value="/puestos/guardar" var="GuardarUrl" />
                        <mvc:form modelAttribute="puesto" action="${GuardarUrl}" method="POST" cssClass="puestoVal">
                            <input type="hidden" name="estado" value="true"/>
                            <div class="row">
                                <div class="form-group col-lg-12">
                                    <mvc:label path="descripcion">Descripci&oacute;n</mvc:label>
                                    <mvc:input maxlength="50" path="descripcion" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="salarioMin">Salario M&iacute;nimo</mvc:label>
                                    <mvc:input path="salarioMin" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="salarioMax">Salario M&aacute;ximo</mvc:label>
                                    <mvc:input path="salarioMax" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="riesgo">Riesgo</mvc:label>
                                    <mvc:select path="riesgo" cssClass="form-control" items="${riesgos}" />
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