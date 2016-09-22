<%--
  Created by IntelliJ IDEA.
  User: Vaggelis
  Date: 9/13/2016
  Time: 9:14 PM
--%>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>
<body>
<div ng-controller="loginController">
    <div class="row text-center" >
        <div class="jumbotron">
            Subject Name: <input id="name" ng-model="subject.name"></br>
            Subject Unique ID: <input id="uid" ng-model="subject.id"></br>
            <a class="btn btn-primary" href="#" ng-click="register()" ng-class="{ active: registering }">Set Active</a>
        </div>
    </div>
    <footer class="text-center">
        <div>
            ERROR : {{error.message}}
        </div>
    </footer>
</div>
</body>
</html>

