<%--
  Created by IntelliJ IDEA.
  User: Vaggelis
  Date: 9/13/2016
  Time: 9:14 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>INDEX PAGE</title>
</head>

<body>
<input id="text">
%{--<button onclick="talk()">Talk It!</button>--}%
<button id="rec" ng-click="listen()">{{listening ? "Stop Listening" : "Listen"}}</button>
</body>
</html>