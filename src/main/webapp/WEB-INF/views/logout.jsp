<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Charity</title>
    <link rel="stylesheet" href="css/styleAdmin.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div class="logout">
    <form action="<c:url value="/logout"/>" method="post">

        <input class="btn btn--large" type="button" onclick="history.back()" value="Wróć"/>
        <input class="btn btn--large" type="submit" value="Wyloguj"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>

</body>
</html>


