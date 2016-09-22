<!doctype html>
<html>
    <head>
        <title>Your Browser is not Supported</title>
        <meta name="layout" content="main">
        <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
    </head>
    <body>
        <ul class="errors">
            <li>Browser ${request.getHeader("User-Agent")} is <b>not supported</b></li>
        </ul>
    </body>
</html>
