<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%-- 引入jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户列表</title>
</head>
<body>
        <table border="1" width="50%" align="center">
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>age</th>
                </tr>
            <c:forEach items="${users }" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.age}</td>


                    </tr>


            </c:forEach>

        </table>

</body>
</html>
