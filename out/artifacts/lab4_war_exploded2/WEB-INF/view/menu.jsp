<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:head pageTitle="Телефонная станция"/>
<header>
    <h1 class="main">Телефонная станция</h1>
    <c:if test="${user eq null}">
        <a href="${pageContext.servletContext.contextPath}/station?command=login"
           style="float: right; margin-right: 50px">Войти</a>
        <a href="${pageContext.servletContext.contextPath}/station?command=registration"
           style="float: right; margin-right: 50px">Зарегестрироваться</a>
    </c:if>
    <c:if test="${user ne null}">
        <a href="${pageContext.servletContext.contextPath}/station?command=logout"
           style="float: right; margin-right: 50px">Выйти</a>
    </c:if>
</header>
<body>
<h5>
    Администратор осуществляет подключение Абонентов. Абонент может выбрать одну или несколько из предоставляемых Услуг.<br>
    Абонент оплачивает Счет за разговоры и Услуги. Администратор может просмотреть список неоплаченных Счетов и
    заблокировать Абонента.
</h5>
<c:if test="${user.type eq 'admin' or user.type eq 'client'}">
    <a href="${pageContext.request.contextPath}/station?command=subscriberServices"
       class="list-group-item list-group-item-action">
        Вывести информацию об услугах, используемых заданным абонентом
    </a>
</c:if>
<c:if test="${user.type eq 'admin' or user.type eq 'client'}">
    <a href="${pageContext.request.contextPath}/station?command=account" class="list-group-item list-group-item-action">
        Вывести счет заданного абонента
    </a>
</c:if>
<c:if test="${user.type eq 'admin' or user.type eq 'client' or user eq null}">
    <a href="${pageContext.request.contextPath}/station?command=services"
       class="list-group-item list-group-item-action">
        Вывести список доступных услуг
    </a>
</c:if>
<c:if test="${user.type eq 'admin'}">
    <a href="${pageContext.request.contextPath}/station?command=payBill" class="list-group-item list-group-item-action">
        Оплатить счет, заблокировать абонента
    </a>
</c:if>
<p></p>
<p>
    Последний сеанс: ${cookie.lastTime.value}
</p>
<p>
    Количество посещений: ${cookie.countVisits.value}
</p>
</body>