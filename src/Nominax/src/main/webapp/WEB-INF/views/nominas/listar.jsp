<%-- 
    Document   : listar
    Created on : Jun 16, 2017, 3:57:49 PM
    Author     : phenom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:layout>
    <jsp:attribute name="styles">
        <link href="<c:url value="/resources/vendor/datatables/css/jquery.dataTables.css"/>" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/resources/vendor/datatables-plugins/dataTables.bootstrap.css"/>"/>
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <script src="<c:url value="/resources/vendor/datatables/js/jquery.dataTables.js"/>"></script>
        <script src="<c:url value="/resources/vendor/datatables-plugins/dataTables.bootstrap.js" />"></script>
        <script src="<c:url value="/resources/nominax/js/datatable.js"/>" type="text/javascript"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Listado de tipos de nominas</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-success" href="<c:url value="/nominas/guardar"/>">
                    <i class="fa fa-plus"></i> Guardar</a>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Listado de tipos de nominas
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover datatable" id="dataTables-puestos">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>descripcion</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:url value="/nominas/eliminar" var="EliminarUrl"/>
                                <c:forEach var="n" items="${nominas}">
                                    <tr>
                                        <td>${n.idNomina}</td>
                                        <td><a href="/Nominax/nominas/editar/${n.idNomina}">
                                                ${n.descripcion}</a></td>
                                        <td>
                                            <a href="${EliminarUrl}/${n.idNomina}"><i class="fa fa-trash"></i></a>
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
