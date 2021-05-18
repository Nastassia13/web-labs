<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:head pageTitle="Телефонная станция"/>
<header>
    <a href="${pageContext.servletContext.contextPath}/station" class="main">Телефонная станция</a>
</header>
<body>
<form method="post" class="form">
    <div>
        <label>
            <input name="login" placeholder="Введите логин">
        </label>
    </div>
    <div>
        <label>
            <input name="password" placeholder="Введите пароль" type="password">
        </label>
    </div>
    <div>
        <button class="button">
            <div style="color: white">Войти</div>
        </button>
    </div>
</form>
<c:if test="${error ne null}">
    <div style="color: red; margin-left: 50px">
            ${error}
    </div>
</c:if>
<br>
<a href="${pageContext.servletContext.contextPath}/station" style="margin-left: 50px">Войти без авторизации</a>
</body>