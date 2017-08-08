<%-- 
    Document   : index
    Created on : Aug 2, 2017, 10:15:01 PM
    Author     : phenom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>

<c:set var="titulo" value="Generar Reporte"/>

<t:layout>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${titulo}</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        ${titulo}
                    </div>
                    <div class="panel-body">
                        <c:url value="/departamentos/editar" var="EditarUrl" />
                        <form action="${EditarUrl}" method="POST">
                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <mvc:label path="nominas.idNomina">Nomina</mvc:label>
                                    <mvc:select path="nominas.idNomina" cssClass="form-control" items="${nominas}" itemLabel="descripcion" itemValue="idNomina"/>
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="departamentos.idDepartamento">Departamento</mvc:label>
                                    <mvc:select path="departamentos.idDepartamento" cssClass="form-control" items="${departamentos}"
                                                itemLabel="nombre" itemValue="idDepartamento"/>
                                </div>
                            </div>
                            <button class="btn btn-success" type="submit">Generar Reporte</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</t:layout>
