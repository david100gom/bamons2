<html>
<head>

</head>
<body>
<form action="/login" method="post">
    <div class="input-group input-sm">
        <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
    </div>
    <div class="input-group input-sm">
        <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
    </div>
    <input type="hidden" name="${_csrf.parameterName!}" value="${_csrf.token!}" />

    <div class="form-actions">
        <input type="submit" value="Log in">
    </div>
</form>
</body>
</html>