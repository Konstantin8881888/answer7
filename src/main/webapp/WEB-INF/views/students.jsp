<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Студенты</title>
</head>
<body>
<h1>Студенты</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Возраст</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td><a href="update?id=${student.id}">Изменить</a></td>
            <td><a href="delete?id=${student.id}">Удалить</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2>Добавление студента</h2>
<form method="POST" action="add">
    <label for="name">Имя:</label>
    <input type="text" id="name" name="name"><br>
    <label for="age">Возраст:</label>
    <input type="text" id="age" name="age"><br>
    <input type="submit" value="Добавить">
</form>
</body>
</html>
