<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../includeJSP/headerAdmin.jsp" %>

<div class="slogan container container--70">
    <h2>
        Fundacje :
    </h2>
    <h1 class="form--steps-container" style="display:inline-grid; justify-content: center;">Nowa Fundacja
        <a href="#popup" class="btn btn--without-border active">Dodaj</a>
    </h1>
</div>

<div class="form">
    <div id="popup" class="modalDialog">
        <div class="form--steps-container">
            <a href="#close" title="Close" class="close">x</a>
            <form:form action="/admin/institution" method="post" modelAttribute="newInstitution">

                <div class="form-group form-group--inline">
                    <label>Fundacja</label>
                    <form:input type="text" path="name" autocomplete="off" class="modalMaxWidth"/>
                </div>
                <div class="form-group form-group--inline">
                    <label>Cel i misja</label>
                    <form:textarea rows="2" path="description" class="modalMaxWidth"/>
                </div>
                <div class="form-group form-group--inline" style="display:grid; justify-content: center;">
                    <button type="submit" class="btn btn--without-border active" data-dismiss="modalDialog">Dodaj
                    </button>
                </div>
            </form:form>
        </div>
    </div>

</div>


<section class="help">
    <div class="help--slides active" data-id="1">
        <ul class="help--slides-items">
            <c:forEach items="${institutions}" var="institution" varStatus="rowCounter">
                <li>
                    <div id="delConfirm${institution.id}" class="modalDialog">
                        <div class="form--steps-container" style="display: flex; justify-content: center">
                            <a href="#close" title="Close" class="close">x</a>
                            <div class="form-group form-group--inline">
                                <a href="/admin/institution/delete/${institution.id}">
                                    <button type="button" class="btn btn--without-border active" data-dismiss="modalDialog">Usuń
                                    </button>
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="col">
                        <div class="title">Fundacja "${institution.name}"</div>
                        <div class="subtitle">Cel i misja: ${institution.description}</div>
                    </div>
                    <a href="/admin/institution/edit/${institution.id}">
                        <button type="button" class="btn btn--without-border">Edytuj</button>
                    </a>
                    <a href="#delConfirm${institution.id}">
                        <button type="button" class="btn btn--without-border">Usuń</button>
                    </a>

                </li>

            </c:forEach>
        </ul>
    </div>

</section>

<%@include file="../includeJSP/footer.jsp" %>