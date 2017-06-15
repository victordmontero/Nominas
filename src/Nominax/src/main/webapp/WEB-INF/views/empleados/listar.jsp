<%-- 
    Document   : listar
    Created on : Jun 14, 2017, 4:17:32 PM
    Author     : phenom
--%>

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
                <h1 class="page-header">Listado de Empleados</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-success" href="/Nominax/empleados/guardar">
                    <i class="fa fa-plus"></i> Guardar</a>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Listado de puestos
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-puestos">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Cedula</th>
                                    <th>Nombre</th>
                                    <th>Departamento</th>
                                    <th>Puesto</th>
                                    <th>Salario</th>
                                    <th>Nomina</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="e" items="${empleados}">
                                <tr>
                                    <td>${e.idEmpleado}</td>
                                    <td>${e.cedula}</td>
                                    <td><a href="/Nominax/puestos/editar/${e.idEmpleado}">
                                            ${e.nombre}</a></td>
                                    <td>${e.idDepartamento}</td>
                                    <td>${e.idPuesto}</td>
                                    <td>${e.salario}</td>
                                    <td>${e.idNomina}</td>
                                    <th>
                                        <a href="/Nominax/puestos/eliminar/${e.idEmpleado}"><i class="fa fa-trash"></i></a>
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