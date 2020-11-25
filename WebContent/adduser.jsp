<%@page import="com.official.bean.Doc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
 <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
 <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
.form-group{
width:40%;
float:left;
margin-top:30px;
}
label{
width:28%;
float:left;
margin-top:5px;
margin-left:5px;
}
.form-control{
width:67%;
}
.btn{
width:150px;
height:40px;
border:0px;
border-radius:5px;
background-color:orange;
color:black;
margin-left:auto;
margin-top:28px
}
</style>
</head>
<body>
	<div>
	<form name="myForm" method="post" action="addUser">
        <table border="1">
            <tr>
                <td>用户名</td>
                <td><input name="username" type="text" /></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input name="password" type="text" /></td>
            </tr>
            <tr>
                <td>用户权限ID</td>
                <td><input name="permissionId" type="text" /></td>
            </tr>
             <tr>
                <td>职位</td>
                <td><input name="job" type="text" /></td>
            </tr>
            <tr>
                <td><input type="reset" value="重置" /></td>
                <td><input type="submit" value="提交" /></td>
            </tr>
        </table>
    </form>
	
	</div>
</body>

</script>
</html>