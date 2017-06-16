<%-- 
    Document   : editar
    Created on : Jun 16, 2017, 10:21:17 AM
    Author     : phenom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<t:layout>

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
                        <mvc:form modelAttribute="departamento" action="/Nominax/departamentos/editar" method="POST">
                            <input type="hidden" name="idDepartamento" value="${departamento.idDepartamento}"/>
                            <input type="hidden" name="estado" value="${departamento.estado}"/>
                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <mvc:label path="nombre">Nombre</mvc:label>
                                    <mvc:input path="nombre" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="ubicacion">Ubicacion</mvc:label>
                                    <mvc:input path="ubicacion" cssClass="form-control" />
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
