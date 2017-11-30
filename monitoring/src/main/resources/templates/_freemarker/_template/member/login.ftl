<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SB Admin - Start Bootstrap Template</title>
    <!-- Bootstrap core CSS-->
    <link href="/admin_page/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="/admin_page/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template-->
    <link href="/admin_page/css/sb-admin.css" rel="stylesheet">
    <script>

        function login() {
            $('#loginForm')
                    .attr('action','/login')
                    .attr('method', 'POST')
                    .submit();
        }

    </script>
</head>

<body class="bg-dark">
<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
            <form id="loginForm">
                <div class="form-group">
                    <!--<label for="exampleInputEmail1">Email address</label>-->
                    <input class="form-control" id="username" name="username" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <!--<label for="exampleInputPassword1">Password</label>-->
                    <input class="form-control" id="password" name="password" type="password" placeholder="Password">
                </div>
                <div class="form-group">
                    <div class="form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox"> Remember Password</label>
                    </div>
                </div>
                <a class="btn btn-primary btn-block" href="javascript:login();">Login</a>
                <input type="hidden" name="${_csrf.parameterName!}" value="${_csrf.token!}" />
            </form>
            <div class="text-center">
                <a class="d-block small mt-3" href="register.html">Register an Account</a>
                <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap core JavaScript-->
<script src="/admin_page/vendor/jquery/jquery.min.js"></script>
<script src="/admin_page/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="/admin_page/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>