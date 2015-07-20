<%--
  Created by IntelliJ IDEA.
  User: kiran
  Date: 7/20/15
  Time: 10:14 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>grailslogin - Homepage</title>
    <meta name="layout" content="main" />
</head>

<body>
<g:form url="[controller:'user',action:'loginHandle']">
    <fieldset>
        <legend>Login</legend>
        <label for="username">user Name: </label>
        <g:textField name="username" value="${UserInstance?.username}"/><br/>
        <label for="password">Password: </label>
        <g:passwordField type="password" name="password" value="${UserInstance?.password}"/> <br/>
        <g:submitButton class="button" name="submitButton" value="Login" />
    </fieldset>
</g:form>
</body>
</html>