<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
    <title>welcome</title>
</head>
<body bgcolor="#00ffff">

<form action="/welcome" method="POST">

    <div class="form-group row">
        <label for="uname" class="col-sm-2 col-form-label">Username:</label>
        <div class="col-sm-7">
            <input type="text" class="form-control" name="username" placeholder="Enter Admin ID">
        </div>
    </div>

    <div class="form-group row">
        <label for="pass" class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-7">
            <input type="password" class="form-control" name="password"
                placeholder="Enter Password">
        </div>
    </div>
    <div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>

</form>

</body>
</html>
