<%-- 
    Document   : guardar
    Created on : Jun 16, 2017, 11:26:45 PM
    Author     : phenom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>

<t:layout>

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Asociar Nuevo Encargado</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Asociar Nuevo Encargado
                    </div>
                    <div class="panel-body">
                        <mvc:form modelAttribute="empdep" action="guardar" method="POST">
                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <mvc:label path="id.idEmpleado">Empleado</mvc:label>
                                    <mvc:select path="id.idEmpleado" cssClass="form-control" 
                                                items="${emps}" itemLabel="nombre" itemValue="idEmpleado" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="id.idDepartamento">Departamento</mvc:label>
                                    <mvc:select path="id.idDepartamento" cssClass="form-control"
                                                items="${departamentos}" itemLabel="nombre" itemValue="idDepartamento" />
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
