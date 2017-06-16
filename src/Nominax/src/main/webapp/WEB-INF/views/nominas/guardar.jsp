<%-- 
    Document   : guardar
    Created on : Jun 16, 2017, 4:01:16 PM
    Author     : phenom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<t:layout>
    
    <jsp:body>
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Nuevo tipo de nomina</h1>  
            </div>
        </div>

        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Nuevo tipo de nomina
                    </div>
                    <div class="panel-body">
                        <mvc:form modelAttribute="nomina" action="guardar" method="POST">
                            <input type="hidden" name="estado" value="true"/>
                            <div class="row">
                                <div class="form-group col-lg-12">
                                    <mvc:label path="descripcion">Descripci&oacute;n</mvc:label>
                                    <mvc:input path="descripcion" cssClass="form-control" />
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