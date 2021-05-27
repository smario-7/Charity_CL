<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="includeJSP/header.jsp" %>


<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form action="/register" method="post" modelAttribute="user" >

        <span><form:errors path="email" cssClass="error"/></span>
        <div class="form-group">
            <form:input type="email" name="email" placeholder="Email" path="email"/>
        </div>

        <span><form:errors path="password" cssClass="error"/></span>
        <div class="form-group">
            <form:input type="password" name="password" placeholder="Hasło" path="password"/>
        </div>

        <span><form:errors path="passwordRepeat" cssClass="error"/></span>
        <div class="form-group">
            <form:input type="password" name="passwordRepeat" placeholder="Powtórz hasło" path="passwordRepeat"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@include file="includeJSP/footer.jsp"%>