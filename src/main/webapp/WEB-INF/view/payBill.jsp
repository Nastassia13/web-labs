<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:head pageTitle="Заблокировать абонента"/>
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
    <c:if test="${not empty status and not empty account}">
        <h3 style="margin-left: 50px">Абонент заблокирован</h3>
        <h4 style="margin-top: 50px">Счет абонента: ${account}</h4>
        <h4>Статус абонента: ${status}</h4>
    </c:if>
</body>