<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core">

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
                integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
                crossorigin="anonymous">
            <title>Add a new ingredient</title>
        </head>

        <body>
            <form action="/saveIngredient" method="post">
                <div class="form-group row">
                    <label for="itemName" class="col-sm-2 col-form-label">Item Name</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="name" placeholder="Enter ingredient name">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="itemQuantity" class="col-sm-2 col-form-label">Available Item Quantity</label>
                    <div class="col-sm-7">
                        <input type="number" class="form-control" name="availableQuantity"
                            placeholder="Enter available quantity">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="itemQuantity" class="col-sm-2 col-form-label">Threshold Item Quantity</label>
                    <div class="col-sm-7">
                        <input type="number" class="form-control" name="thresholdQuantity"
                            placeholder="Set threshold quantity">
                    </div>
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </body>

        </html>
