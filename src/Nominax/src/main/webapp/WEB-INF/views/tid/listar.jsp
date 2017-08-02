<%-- 
    Document   : listar
    Created on : Jun 16, 2017, 9:38:49 PM
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
                <h1 class="page-header">Listado de Tipo de Ingreso y Deducciones</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-success" href="<c:url value="/tid/guardar"/>">
                    <i class="fa fa-plus"></i> Guardar</a>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Listado de Tipo de Ingreso y Deducciones
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover datatable" id="dataTables-puestos">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Descripcion</th>
                                    <th>Tipo</th>
                                    <th>Depende de Salario</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:url value="/tid/eliminar" var="EliminarUrl" />
                                <c:forEach var="tid" items="${tids}">
                                    <tr>
                                        <td>${tid.idTipoIngresoDeduccion}</td>
                                        <td><a href="/Nominax/tid/editar/${tid.idTipoIngresoDeduccion}">
                                                ${tid.descripcion}</a></td>
                                        <td>${tid.tipo}</td>
                                        <td>${tid.dependeSalario}</td>
                                        <td>
                                            <a href="${EliminarUrl}/${tid.idTipoIngresoDeduccion}"><i class="fa fa-trash"></i></a>
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
