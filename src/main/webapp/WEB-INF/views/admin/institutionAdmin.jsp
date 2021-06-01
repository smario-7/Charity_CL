<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../includeJSP/headerAdmin.jsp" %>

<div class="slogan container container--70">
    <h2>
        Instytucje :
    </h2>

    <div id="popup" class="modalDialog form-group">
        <div> <a href="#close" title="Close" class="close">x</a>
            <input type="text">

        </div>
    </div>

        <ul class="help--slides-items">
            <li>
                <h1>Nowa instytucja
                <a href="#popup" class="btn btn--without-border active">Dodaj</a>
                </h1>


            </li>

        </ul>

    <div id="popup" class="modalDialog">
        <div> <a href="#close" title="Close" class="close">x</a>
            <input type="text">

        </div>
    </div>


</div>

<section class="help">
    <div class="help--slides active" data-id="1">
        <ul class="help--slides-items">
            <c:forEach items="${institutions}" var="institution" varStatus="rowCounter">
                <li>

                    <div class="col">
                        <div class="title">${institution.name}</div>
                        <div class="subtitle">${institution.description}</div>
                    </div>
                    <button type="button" class="btn btn--without-border">Edytuj</button>
                    <button type="button" class="btn btn--without-border">Usuń</button>
                </li>

            </c:forEach>
        </ul>
    </div>

</section>

<%@include file="../includeJSP/footer.jsp" %>