<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core">

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                crossorigin="anonymous">
            <title>Make Order</title>
        </head>

        <body >
        <h1>MENU</h1>
        <tr>
            <td>
                <h3><c:out value="Food Items" /></h3>
            </td>
        </tr>
        <c:forEach var="FoodList" items="${foodbeverageList}">
            <tr>
                <td>
                    <c:out value="${FoodList.name}" />
                    <br/>
                </td>
            </tr>
        </c:forEach>
        <br/>
        <h3>Enter your choice food</h3>
        <form action="/addfoodtocart" method="post" modelAttribute="orderItemList">
            <tr>
                <td>Food name and</td>
                <td>quantity</td>
                <br/>
            </tr>
            <tr>
                <td><input type="text" name="food1" placeholder="Enter food name"></td>
                <td><input type="number" name="quantity1" placeholder="Enter quantity"></td>
            </tr>
            <br/>
            <tr>
                <td><input type="text" name="food2" placeholder="Enter food name"></td>
                <td><input type="number" name="quantity2" placeholder="Enter quantity"></td>
            </tr>

            <br/>
            <button type="submit" class="btn btn-primary">Submit</button>

        </form>
        </body>

        </html>
