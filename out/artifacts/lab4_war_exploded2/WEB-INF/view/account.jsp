<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:head pageTitle="Счет абонента"/>
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
    <c:if test="${not empty account}">
        <h2>Счет абонента: ${account}</h2>
    </c:if>
</body>