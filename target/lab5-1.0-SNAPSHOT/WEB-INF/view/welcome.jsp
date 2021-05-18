<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:head pageTitle="Телефонная станция"/>
<header>
    <a href="${pageContext.servletContext.contextPath}/station" class="main">Телефонная станция</a>
</header>
<body>
<h5 style="margin-top: 50px">
    Администратор осуществляет подключение Абонентов. Абонент может выбрать одну или несколько из предоставляемых Услуг.<br>
    Абонент оплачивает Счет за разговоры и Услуги. Администратор может просмотреть список неоплаченных Счетов и
    заблокировать Абонента.
</h5>
<a href="${pageContext.request.contextPath}/station?command=login" class="a">Вход</a><br>
<a href="${pageContext.request.contextPath}/station?command=registration" class="a">Регистрация</a>
</body>