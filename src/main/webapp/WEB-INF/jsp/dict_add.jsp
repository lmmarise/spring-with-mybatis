<%--dict_add.jsp--%>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    <title>字典维护</title>
</head>
<body>
<form action="${path}/dicts/add" method="post">
    <input type="hidden" value="${model.id}">
    <table>
        <c:if test="${msg != null}">
            <tr>
                <th colspan="2" style="color: red; max-width: 400px;">
                    ${msg}
                </th>
            </tr>
        </c:if>
        <tr>
            <th colspan="2">字典维护</th>
        </tr>
        <tr>
            <th>类别名</th>
            <td><input type="text" name="code" value="${model.code}"></td>
        </tr>
        <tr>
            <th>字典名</th>
            <td><input type="text" name="name" value="${model.name}"></td>
        </tr>
        <tr>
            <th>字典值</th>
            <td><input type="text" name="value" value="${model.value}"></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="保存">
                <input type="button" onclick="backToList()" value="取消">
            </th>
        </tr>
    </table>
    <script type="application/javascript">
        function backToList() {
            location.href = '${path}/dicts';
        }
    </script>
</form>
</body>
</html>
