<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core">

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                crossorigin="anonymous">
            <title>Ingredients</title>
        </head>

        <body>
            <div class="nav justify-content-center">
                <a href="/add/ingredient"><h3>Add New Ingredients</h3></a><br>
            </div>
            <div>
                <table class="table table-striped">
                    <tr>
                        <th scope="col">
                            <c:out value="Ingredient Name" />
                        </th>
                        <th scope="col">
                            <c:out value="Available Quantity" />
                        </th>
                        <th scope="col">
                            <c:out value="Threshold Quantity" />
                        </th>
                    </tr>
                    <c:forEach var="Ingredient" items="${ingredientsList}">
                        <tr>
                            <td>
                                <c:out value="${Ingredient.name}" />
                            </td>
                            <td>
                                <c:out value="${Ingredient.availableQuantity}" />
                            </td>
                            <td>
                                <c:out value="${Ingredient.thresholdQuantity}" />
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </body>

        </html>
