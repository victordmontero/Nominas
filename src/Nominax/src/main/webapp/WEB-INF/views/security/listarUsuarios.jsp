<%-- 
    Document   : listarUsuarios
    Created on : Jul 15, 2017, 4:18:42 PM
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
                <c:set var="Titulo" value="Listado de Usuarios"/>
                <h1 class="page-header">${Titulo}</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <a class="btn btn-success" href="<c:url value="/security/nuevo-usuario"/>">
                    <i class="fa fa-plus"></i> Nuevo Usuario</a>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        ${Titulo}
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover datatable" id="dataTables-puestos">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:url value="/security/eliminar-usuario" var="EliminarUrl" />
                                <c:forEach var="usuario" items="${usuarios}">
                                    <tr>
                                        <td><a href="<c:url value="/security/editar-usuario" />/${usuario.idUsuario}">
                                                ${usuario.nombre}</a></td>
                                        <td>${usuario.roleses.iterator().next().nombreRole}</td>
                                        <td>
                                            <a href="${EliminarUrl}/${usuario.idUsuario}"><i class="fa fa-trash"></i></a>
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
