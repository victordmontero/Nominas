<%-- 
    Document   : editar
    Created on : Jun 16, 2017, 10:06:37 PM
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
                <h1 class="page-header">Editando ${tid.descripcion}</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Editando ${tid.descripcion}
                    </div>
                    <div class="panel-body">
                        <c:url value="/tid/editar" var="EditarUrl"/>
                        <mvc:form modelAttribute="tid" action="${EditarUrl}" method="POST">
                            <input type="hidden" name="idTipoIngresoDeduccion" value="${tid.idTipoIngresoDeduccion}"/>
                            <input type="hidden" name="estado" value="true"/>
                            <div class="row">
                                <div class="form-group col-lg-12">
                                    <mvc:label path="descripcion">Descripci&oacute;n</mvc:label>
                                    <mvc:input path="descripcion" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="tipo">Tipo</mvc:label>
                                    <mvc:select path="tipo" cssClass="form-control" items="${tipos}"/>
                                </div>
                                <div class="form-group col-lg-6">
                                    <%--<mvc:input path="dependeSalario" cssClass="form-control"/>--%>
                                    <mvc:checkbox path="dependeSalario"/>
                                    <mvc:label path="dependeSalario">Depende de Salario</mvc:label>
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