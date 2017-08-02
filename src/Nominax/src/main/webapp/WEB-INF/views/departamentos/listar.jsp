<%-- 
    Document   : listar
    Created on : Jun 15, 2017, 8:25:32 AM
    Author     : phenom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<c:set var="titulo" value="Listado de departamentos"/>
<t:layout>
    <jsp:attribute name="header">
        <h1>${titulo}</h1>
    </jsp:attribute>

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
                <h1 class="page-header">${titulo}</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-success" href="<c:url value="/departamentos/guardar"/>">
                    <i class="fa fa-plus"></i> Guardar</a>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        ${titulo}
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered no-footer datatable" id="dataTables-puestos">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Ubicacion</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:url value="/departamentos/eliminar" var="EliminarUrl"/>
                                <c:forEach var="d" items="${departamentos}">
                                    <tr>
                                        <td>${d.idDepartamento}</td>
                                        <td><a href="/Nominax/departamentos/editar/${d.idDepartamento}">
                                                ${d.nombre}</a></td>
                                        <td>${d.ubicacion}</td>
                                        <td>
                                            <a href="${EliminarUrl}/${d.idDepartamento}"><i class="fa fa-trash"></i></a>
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


