<%-- 
    Document   : editar
    Created on : Jun 16, 2017, 10:21:17 AM
    Author     : phenom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<t:layout>
    <jsp:attribute name="scripts">
        <script src="<c:url value="/resources/vendor/jqueryvalidation/jquery.validate.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/nominax/js/jqueryValidation.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/vendor/jqueryvalidation/messages_es.js"/>" type="text/javascript"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Editando ${departamento.nombre}</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Editando ${departamento.nombre}
                    </div>
                    <div class="panel-body">
                        <c:url value="/departamentos/editar" var="EditarUrl" />
                        <mvc:form modelAttribute="departamento" action="${EditarUrl}" method="POST" cssClass="departamentoVal">
                            <input type="hidden" name="idDepartamento" value="${departamento.idDepartamento}"/>
                            <input type="hidden" name="estado" value="${departamento.estado}"/>
                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <mvc:label path="nombre">Nombre</mvc:label>
                                    <mvc:input maxlength="50" path="nombre" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="ubicacion">Ubicacion</mvc:label>
                                    <mvc:input maxlength="25" path="ubicacion" cssClass="form-control" />
                                </div>
                            </div>
                            <button class="btn btn-success" type="submit">Guardar</button>
                        </mvc:form>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</t:layout>
