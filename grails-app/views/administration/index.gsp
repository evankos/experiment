<%--
  Created by IntelliJ IDEA.
  User: Vaggelis
  Date: 9/19/2016
  Time: 2:12 AM
--%>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="second"/>
    <asset:javascript src="administration.js"/>
</head>
<body>
<div ng-controller="administrationController">
    <div class="col-xs-12">
        <table ng-table="tableParams" show-filter="true" class="table">
            <tbody>
            <tr ng-repeat="result in $data">
                <td data-title="'instruction'"  >
                    {{result.instruction}}
                </td>
                <td data-title="'sentence'"  >
                    {{result.sentence}}
                </td>
                <td data-title="'solution'"  >
                    {{result.solution}}
                </td>
                <td data-title="'time'"  >
                    {{result.time}}
                </td>
            </tr>
            </tbody>
        </table>
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
