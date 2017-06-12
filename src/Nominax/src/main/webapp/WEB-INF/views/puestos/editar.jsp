<%-- 
    Document   : editar
    Created on : Jun 12, 2017, 12:09:20 PM
    Author     : phenom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<t:layout>
    
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Editando ${puesto.descripcion}</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Editando ${puesto.descripcion}
                    </div>
                    <div class="panel-body">
                        <mvc:form modelAttribute="puesto" action="/Nominax/puestos/editar" method="POST">
                            <input type="hidden" name="idPuesto" value="${puesto.idPuesto}"/>
                            <div class="row">
                                <div class="form-group col-lg-12">
                                    <mvc:label path="descripcion">Descripci&oacute;n</mvc:label>
                                    <mvc:input path="descripcion" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="salarioMin">Salario M&iacute;nimo</mvc:label>
                                    <mvc:input path="salarioMin" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="salarioMax">Salario M&aacute;ximo</mvc:label>
                                    <mvc:input path="salarioMax" cssClass="form-control" />
                                </div>
                                <div class="form-group col-lg-6">
                                    <mvc:label path="riesgo">Riesgo</mvc:label>
                                    <mvc:select path="riesgo" cssClass="form-control" items="${riesgos}" />
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
