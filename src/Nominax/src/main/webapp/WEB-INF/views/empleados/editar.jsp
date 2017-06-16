<%-- 
    Document   : editar
    Created on : Jun 14, 2017, 4:31:09 PM
    Author     : phenom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<t:layout>
    
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Editando ${empleado.nombre}</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Editando ${empleado.nombre}
                    </div>
                    <div class="panel-body">
                        <mvc:form modelAttribute="empleado" action="/Nominax/empleados/editar" method="POST">
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
                                    <mvc:select path="departamentos.idDepartamento" cssClass="form-control" items="${departamentos}"
                                                itemLabel="nombre" itemValue="idDepartamento"/>
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="puestos.idPuesto">Puesto</mvc:label>
                                    <mvc:select path="puestos.idPuesto" cssClass="form-control" items="${puestos}"
                                                itemLabel="descripcion" itemValue="idPuesto"/>
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="nominas.idNomina">Nomina</mvc:label>
                                    <mvc:select path="nominas.idNomina" cssClass="form-control" items="${nominas}" itemLabel="descripcion" itemValue="idNomina"/>
                                </div>
                                <input type="hidden" name="estado" value="${empleado.estado}"/>
                                <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}"/>
                            </div>
                            <button class="btn btn-success" type="submit">Guardar</button>
                        </mvc:form>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</t:layout>
