<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:head pageTitle="Услуги"/>
<header>
    <a href="${pageContext.servletContext.contextPath}/station" class="main">Телефонная станция</a>
</header>
<body>
    <h2>Доступные услуги</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Название услуги</th>
            <th>Стоимость</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${services}">
            <tr>
                <th>${service.id}</th>
                <th>${service.name}</th>
                <th>${service.cost}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>