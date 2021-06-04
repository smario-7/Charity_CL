<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="pl">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
  <title>Charity</title>
  <link rel="stylesheet" href="/css/style.css"/>
  <link rel="stylesheet" href="/css/styleAdmin.css"/>
</head>
<body>

<header class="header--form-page">
  <nav class="container container--70">
    <ul class="nav--actions">
      <li class="logged-user">
        admin:  ${emailUser}
        <ul class="dropdown">
          <li><a href="">Profil</a></li>
          <li><a href="#">Moje zbiórki</a></li>
          <li><a href="/admin/institution">Fundacje</a></li>
          <li><a href="#">Użytkownicy</a></li>
          <li><a href="#">Administratorzy</a></li>
          <li><a href="/logout">Wyloguj</a></li>
        </ul>
      </li>
    </ul>

    <ul>
      <li><a href="/admin" class="btn btn--without-border active">Start</a></li>
      <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
      <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
      <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
      <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
    </ul>
  </nav>

</header>
