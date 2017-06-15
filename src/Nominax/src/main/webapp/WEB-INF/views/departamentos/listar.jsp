<%-- 
    Document   : listar
    Created on : Jun 15, 2017, 8:25:32 AM
    Author     : phenom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
    <jsp:attribute name="header">
        <h1>Listado de Puestos</h1>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Listado de departamentos</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-success" href="/Nominax/departamentos/guardar">
                    <i class="fa fa-plus"></i> Guardar</a>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Listado de departamentos
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-puestos">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Ubicacion</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="d" items="${departamentos}">
                                <tr>
                                    <td>${d.idDepartamento}</td>
                                    <td><a href="/Nominax/departamentos/editar/${d.idDepartamento}">
                                            ${d.nombre}</a></td>
                                    <td>${d.ubicacion}</td>
                                    <td>
                                        <a href="/Nominax/departamentos/eliminar/${d.idDepartamento}"><i class="fa fa-trash"></i></a>
                                    </td>
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


