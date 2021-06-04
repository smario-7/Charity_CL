<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../includeJSP/headerAdmin.jsp" %>

<div class="slogan container container--70">
  <h1 class="form--steps-container" style="display:inline-grid; justify-content: center;">Edycja:

  </h1>
</div>


<div class="form">
  <div class="form-section--columns-container" style="display: flex; justify-content: center">
    <form:form method="post" modelAttribute="editInstitution">
      <form:hidden path="id"/>
      <div class="form-group form-group--inline">
        <label style="margin-inline: 10px">Fundacja</label>
        <form:input type="text" path="name" class="modalMaxWidth"/>
      </div>
      <div class="form-group form-group--inline">
        <label>Cel i misja</label>
        <form:textarea rows="2" path="description" class="modalMaxWidth"/>
      </div>

      <div class="form-group form-group--inline" style="display: grid; justify-content: center">
        <button type="submit" class="btn btn--without-border active">Zapisz</button>
      </div>
    </form:form>
  </div>
</div>


<%@include file="../includeJSP/footer.jsp" %>