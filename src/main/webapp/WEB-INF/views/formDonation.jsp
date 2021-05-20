<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>

<%@include file="header.jsp" %>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form action="/formdonation" method="post" modelAttribute="donation">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                    <%--                <span><form:errors path="categories" cssClass="error"/></span>--%>
                <c:forEach items="${categories}" var="category">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:checkbox
                                    name="categories"
                                    path="categories"
                                    value="${category.id}"
                            />
                            <span class="checkbox"></span>
                            <span class="description">
                                    ${category.name}
                            </span>

                        </label>
                    </div>

                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <span><form:errors path="quantity" cssClass="error"/></span>
                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input type="number" name="quantity" step="1" min="1" path="quantity"/>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>


            <!-- STEP 3 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                <span><form:errors path="institution" cssClass="error"/></span>
                <c:forEach items="${institutions}" var="institution">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:radiobutton name="institution" path="institution"
                                              value="${institution.id}"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                                <span class="title">${institution.name}</span>
                                <pan class="subtitle">${institution.description} </span>
                            </span>
                        </label>
                    </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>

            </div>


            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>

                        <span><form:errors path="street" cssClass="error"/></span>
                        <div class="form-group form-group--inline">
                            <label> Ulica <form:input type="text" name="street" path="street"/> </label>
                        </div>

                        <span><form:errors path="city" cssClass="error"/></span>
                        <div class="form-group form-group--inline">
                            <label> Miasto <form:input type="text" name="city" path="city"/> </label>
                        </div>

                        <span><form:errors path="zipCode" cssClass="error"/></span>
                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <form:input type="text" name="zipCode" path="zipCode"
                                                         placeholder="XX-XXX"/>
                            </label>
                        </div>
                        <span><form:errors path="phoneNumber" cssClass="error"/></span>
                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <form:input type="tel" name="phoneNumber" path="phoneNumber"
                                                           pattern="["/>
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <span><form:errors path="pickUpDate" cssClass="error"/></span>
                        <div class="form-group form-group--inline">
                            <label> Data <form:input type="date" name="pickUpDate" path="pickUpDate"/> </label>
                        </div>
                        <span><form:errors path="pickUpTime" cssClass="error"/></span>
                        <div class="form-group form-group--inline">
                            <label> Godzina <form:input type="time" name="pickUpTime" path="pickUpTime"/> </label>
                        </div>
                        <span><form:errors path="pickUpComment" cssClass="error"/></span>
                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea name="pickUpComment" rows="5" path="pickUpComment"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">
                                    4 worki ubrań w dobrym stanie dla dzieci
                                </span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text">
                                    Dla fundacji "Mam marzenie" w Warszawie
                                </span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li>Prosta 51</li>
                                <li>Warszawa</li>
                                <li>99-098</li>
                                <li>123 456 789</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li>13/12/2018</li>
                                <li>15:40</li>
                                <li>Brak uwag</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>
    </div>
</section>

<%@include file="footer.jsp" %>

<script src="js/app.js"></script>
</body>
</html>