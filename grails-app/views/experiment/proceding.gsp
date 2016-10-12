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
    <asset:javascript src="experiment.js"/>
</head>
<body>
    <div ng-controller="experimentController">
        <div class="col-xs-12">
            <div class="form-horizontal">
                <div class="form-group">
                    <h2 class="col-xs-4">{{solution.order}} <span class="label label-default">{{solution.sentence}}</span></h2>
                </div>
            </div>
            <div class="form-horizontal">
                <div class="form-group">
                    <uib-progressbar max="max" value="dynamic"><span style="color:white; white-space:nowrap;">{{dynamic}} / {{max}}</span></uib-progressbar>
                </div>
            </div>

            <div class="form-horizontal">
                <div class="form-group">
                    <div class="col-xs-10">
                        <textarea  rows="5" class="form-control" id="text" style="font-family: monospace" ng-disabled="recognizing"></textarea>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-0 col-xs-offset-0">
                    <div class="pull-left">
                        %{--<button class="btn btn-default" ng-click="startButton($event)">{{recognizing ? "Stop Listening" : "Listen"}}</button>--}%
                        <button class="btn btn-warning" ng-click="logout()">Logout</button>
                    </div>
                </div>
                <div class="col-xs-9 col-xs-offset-0">
                    <div class="pull-right">
                        %{--<button class="btn btn-default" ng-click="startButton($event)">{{recognizing ? "Stop Listening" : "Listen"}}</button>--}%
                        <button class="btn btn-default" ng-click="send_secure()" >Send</button>
                    </div>
                </div>
            </div>
        </div>

        <footer class="text-center">
            <div class="container-fluid">
                <div class="row">
                   {{error.message}}
                </div>
            </div>
        </footer>
    </div>
</body>
</html>
