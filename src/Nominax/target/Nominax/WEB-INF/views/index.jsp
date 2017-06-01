<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>

    <jsp:attribute name="header">
        <h1>El Header</h1>
    </jsp:attribute>

    <jsp:attribute name="side">
        <li>
            <a href="#">El Side Menu</a>
            <ul class="nav nav-second-level">
                <li>
                    <a href="#">Desde index</a>
                </li>
                <li>
                    <a href="#">Desde index</a>
                </li>
            </ul>
        </li>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <p>El Footer</p>
    </jsp:attribute>

    <jsp:attribute name="styles">
        <!--Agregar hojas de estilo-->
    </jsp:attribute>

    <jsp:attribute name="scripts">
        <!--Agregar Scripts-->
    </jsp:attribute>

    <jsp:body>
        <h1 class="page-header">El Body</h1>
    </jsp:body>
</t:layout>