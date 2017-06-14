<%-- 
    Document   : guardar
    Created on : Jun 14, 2017, 4:25:29 PM
    Author     : phenom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<t:layout>
    
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
                        <mvc:form modelAttribute="empleado" action="guardar" method="POST">
                            <div class="row">
                                <div class="form-group col-lg-12">
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
                                    <mvc:label path="departamentos">Departamento</mvc:label>
                                    <mvc:select path="departamentos" cssClass="form-control" items="${departamentos}" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="puestos">Puesto</mvc:label>
                                    <mvc:select path="puestos" cssClass="form-control" items="${puestos}" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="nominas">Nomina</mvc:label>
                                    <mvc:select path="nominas" cssClass="form-control" items="${nominas}" />
                                </div>
                                <input type="hidden" value="estado" value="true"/>
                            </div>
                            <button class="btn btn-success" type="submit">Guardar</button>
                        </mvc:form>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</t:layout>
