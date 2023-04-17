<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core">

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
            <title>FoodBeverage</title>
        </head>

        <body bgcolor="#00ffff">
            <a href="/add/foodbeverage">Add New FoodBeverage</a><br>
            <c:forEach var="FoodBeverage" items="${foodbeveragelist}">
                <tr>
                    <td>
                        <c:out value="${FoodBeverage.name}" />
                    </td>
                    <br/>
                    <br/>
                </tr>
            </c:forEach>

        </body>
        </html>
