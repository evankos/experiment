<%--
  Created by IntelliJ IDEA.
  User: Vaggelis
  Date: 9/19/2016
  Time: 2:12 AM
--%>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>
<body>
<div ng-controller="experimentController">

    <div class="row text-center" >
        <div class="jumbotron" ng-show="!done">
            {{solution.order}} : {{solution.sentence}}</br>
            <textarea id="text" ></textarea></br>
            <a class="btn btn-primary" href="#" id="rec" ng-click="startButton($event)" ng-class="{ active: !registering }">{{recognizing ? "Stop Listening" : "Listen"}}</a>
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
</div>
</body>
</html>
