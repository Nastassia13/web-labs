<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:head pageTitle="Услуги абонента"/>
<header>
    <a href="${pageContext.servletContext.contextPath}/station" class="main">Телефонная станция</a>
</header>
<body>
<form method="post">
    <label class="form">
        <input name="idSubscriber" placeholder="Введите id абонента" type="number" value="${param.idSubscriber}">
    </label>
    <button class="button">
        <div style="color: white">
            Ок
        </div>
    </button>
</form>
    <c:if test="${not empty subscriberServices}">
        <h2>Услуги абонента</h2>
        <table class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Название услуги</th>
                <th>Стоимость</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="service" items="${subscriberServices}">
                <tr>
                    <th>${service.id}</th>
                    <th>${service.name}</th>
                    <th>${service.cost}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>