<%-- 
    Document   : listar
    Created on : Jun 19, 2017, 9:26:44 AM
    Author     : phenom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
    <jsp:attribute name="header">
        <h1>Transacciones</h1>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Transacciones</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-success" href="/Nominax/transacciones/nueva">
                    <i class="fa fa-plus"></i> Nueva</a>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Transacciones
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-puestos">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th colspan="2">Empleado</th>
                                    <th>Tipo Transacci&oacute;n</th>
                                    <th colspan="2">Tipo Ingreso o Deducci&oacute;n</th>
                                    <th>Fecha</th>
                                        <%--<th>Acciones</th>--%>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="t" items="${transacciones}">
                                    <tr>
                                        <td>${t.idTransaccion}</td>
                                        <%--<td><a href="/Nominax/puestos/editar/${t.idTranssacion}">
                                                ${t.empleados.cedula}</a></td>--%>
                                        <td>${t.empleados.nombre}</td>
                                        <td>${t.empleados.cedula}</td>
                                        <td>${t.tipoTransaccion}</td>
                                        <td>${t.tipoIngresoDeduccion.descripcion}</td>
                                        <td>${t.tipoIngresoDeduccion.tipo}</td>
                                        <td>${t.fecha}</td>
                                        <%--<td>
                                            <a href="/Nominax/puestos/eliminar/${p.idPuesto}"><i class="fa fa-trash"></i></a>
                                        </td>--%>
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
