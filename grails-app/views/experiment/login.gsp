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
    <asset:javascript src="login.js"/>
</head>
<body>
    <div class="container-fluid">
        <div ng-controller="loginController">
            <div class="col-xs-12">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label for="name" class="col-xs-2 control-label">Subject Name</label>
                        <div class="col-xs-10">
                            <input id="name" class="form-control" ng-model="subject.name" type="text">
                        </div>
                    </div>
                    %{--<div class="form-group">--}%
                        %{--<label for="uid" class="col-xs-2 control-label">Subject Unique ID</label>--}%
                        %{--<div class="col-xs-10">--}%
                            %{--<input id="uid" class="form-control" ng-model="subject.id" type="text">--}%
                        %{--</div>--}%
                    %{--</div>--}%
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="pull-right">
                                <button class="btn btn-default" ng-click="register()">Set Active</button>
                            </div>
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
    </div>
</body>
</html>

