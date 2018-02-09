<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main.css">
        <script src="js/main.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-3.3.1.min.js"></script>
    </head>

    <body>

        <div class="container w-25">
            <div class="p-2"></div>
            <div class="card">
                <div class="p-2"></div>
                <form id="login" class="form-signin ml-2 mr-2" action="../login" method="post">
                    <h6 class="form-signin-heading">Login:</h6>
                    <label for="user" class="sr-only">Username</label>
                    <input type="text" id="user" class="form-control" placeholder="Username" required autofocus>
                    <div class="p-2"></div>
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" id="password" class="form-control" placeholder="Password" required>
                    <div class="p-2"></div>
                    <label for="hash" class="sr-only d-none">Hash</label>
                    <input class="sr-only d-none" id="hash" name="hash" type="text">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                    <div class="p-2"></div>
                </form>
            </div>
        </div>

        <script type="text/javascript">
            $('#login').submit(function() {
                var uname = document.getElementById("user").value;
                var password = document.getElementById("password").value;
                var hash = btoa(uname + ":" + password);

                document.getElementById("hash").value = hash;

                return true;
            });
        </script>
    </body>
</html>