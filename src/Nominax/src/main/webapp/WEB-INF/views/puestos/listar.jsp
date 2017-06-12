<%-- 
    Document   : listar
    Created on : Jun 9, 2017, 9:44:09 AM
    Author     : Phenom
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
                <h1 class="page-header">Listado de puestos</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-success" href="/Nominax/puestos/guardar">
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
                                    <th>Descripcion</th>
                                    <th>Salario Minimo</th>
                                    <th>Salario Maximo</th>
                                    <th>Riesgo</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="p" items="${puestos}">
                                    <tr>
                                        <td>${p.idPuesto}</td>
                                        <td><a href="/Nominax/puestos/editar/${p.idPuesto}">
                                                ${p.descripcion}</a></td>
                                        <td>${p.salarioMin}</td>
                                        <td>${p.salarioMax}</td>
                                        <td>${p.riesgo}</td>
                                        <th></th>
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
