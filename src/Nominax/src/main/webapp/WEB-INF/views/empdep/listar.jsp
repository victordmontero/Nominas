<%-- 
    Document   : listar
    Created on : Jun 16, 2017, 11:18:17 PM
    Author     : phenom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
    <jsp:attribute name="styles">

    </jsp:attribute>

    <jsp:attribute name="scripts">

    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Listado de Encargados</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-success" href="/Nominax/empdep/guardar">
                    <i class="fa fa-plus"></i> Guardar</a>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Listado de Encargados
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-puestos">
                            <thead>
                                <tr>
                                    <th>Id de Empleado</th>
                                    <th>Id de Departamento</th>
                                    <th>Cedula</th>
                                    <th>Nombre</th>
                                    <th>Departamento</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="e" items="${empdeps}">
                                <tr>
                                    <td>${e.id.idEmpleado}</td>
                                    <td>${e.id.idDepartamento}</td>
                                    <td>${e.empleados.cedula}</td>
                                    <td><a href="/Nominax/empdep/editar/${e.id.idEmpleado}/${e.id.idDepartamento}">
                                            ${e.empleados.nombre}</a></td>
                                    <td><a href="/Nominax/empdep/editar/${e.id.idEmpleado}/${e.id.idDepartamento}">
                                            ${e.departamentos.nombre}</a></td>
                                    <th>
                                        <a href="/Nominax/empdep/eliminar/${e.id.idEmpleado}/${e.id.idDepartamento}"><i class="fa fa-trash"></i></a>
                                    </th>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
        </div>
    </jsp:body>

</t:layout>