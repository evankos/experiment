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

<body class="container">

%{--<button onclick="talk()">Talk It!</button>--}%
<header class="text-center">
    <h1>Experiment<small>speak and write</small></h1>
</header>
<div class="row text-center" >
    <div class="jumbotron" ng-show="registering">
        Subject Name: <input id="name" ng-model="subject.name"></br>
        Subject Unique ID: <input id="uid" ng-model="subject.id"></br>
        <a class="btn btn-primary" href="#" ng-click="register()" ng-class="{ active: registering }">Set Active</a>
    </div>
</div>
<div class="row text-center" >
        <div class="jumbotron" ng-show="!registering && !done">
            {{iteration.orders[orderIndex]}} : {{iteration.sentences[iteration.sequence[sequenceIndex_]]}}</br>
            <textarea id="text" ></textarea></br>
            <a class="btn btn-primary" href="#" id="rec" ng-click="listen()" ng-class="{ active: !registering }">{{listening ? "Stop Listening" : "Listen"}}</a>
            <a class="btn btn-primary" href="#"  ng-click="send()" ng-class="{ active: !registering }">send</a>
        </div>
</div>


<div class="row text-center" >
    <div  class="jumbotron" ng-show="done" class="text-center">
        DONE
    </div>
</div>

<footer class="text-center">
    <div>
        ERROR : {{error.message}}
    </div>
</footer>

</body>
</html>