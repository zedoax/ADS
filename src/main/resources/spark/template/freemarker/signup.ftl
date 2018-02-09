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

<div class="container col-5">
    <div class="p-2"></div>
    <div class="card">
        <div class="p-2"></div>
        <form id="signup" method="post" action="../signup" class="form-signin ml-2 mr-2">
            <h6 class="form-signin-heading text-muted">Sign up</h6>
            <div class="row">
                <div class="col-5">
                    <label for="first-name">First Name</label>
                    <input type="text" name="first-name" class="form-control" minlength="3" placeholder="First Name" required autofocus>
                </div>
                <div class="col-7">
                    <label for="user">Last Name</label>
                    <input type="text" name="last-name" class="form-control" minlength="3" placeholder="Last Name" required>
                </div>
            </div>
            <div class="p-2"></div>
            <label for="user">Username</label>
            <input type="text" name="user" id="user" class="form-control" minlength="8" maxlength="16" placeholder="Username" required>
            <div class="p-2"></div>
            <label for="password">Password</label>
            <input type="password" id="password" class="form-control" minlength="10" maxlength="25" placeholder="Password" required>
            <div class="invalid-feedback">
                Passwords do not match
            </div>
            <div class="p-2"></div>
            <label for="password-confirm">Confirm Password</label>
            <input type="password" id="password-confirm" class="form-control" minlength="10" maxlength="25" placeholder="Confirm Password" required>
            <div class="invalid-feedback">
                Passwords do not match
            </div>
            <label for="hash" class="sr-only d-none">Hash</label>
            <input class="sr-only d-none" name="hash" id="hash" type="text">
            <input class="sr-only d-none" name="hash-confirm" id="hash-confirm" type="text">
            <div class="p-2"></div>
            <label for="address">Address</label>
            <input type="text" name="address" class="form-control" placeholder="Street Address" required>
            <div class="p-2"></div>
            <label for="zipcode">Zipcode</label>
            <input type="number" name="zipcode" max="99999" min="10000" class="form-control" placeholder="Zipcode" required>
            <div class="p-2"></div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Create Account</button>
            <div class="p-2"></div>
        </form>
    </div>

    <script type="text/javascript">
        $('#signup').submit(function() {
            var uname = document.getElementById("user").value;
            var password = document.getElementById("password").value;
            var passwordConfirm = document.getElementById("password-confirm").value;
            var hash = btoa(uname + ":" + password);
            var hashConfirm = btoa(uname + ":" + passwordConfirm);

            document.getElementById("hash").value = hash;
            document.getElementById("hash-confirm").value = hashConfirm;

            if(!(hash === hashConfirm)) {
                document.getElementById("password").classList.add("is-invalid");
                document.getElementById("password-confirm").classList.add("is-invalid");

                event.preventDefault();
                event.stopPropagation();

            } else {
                document.getElementById("password").classList.remove("is-invalid");
                document.getElementById("password-confirm").classList.remove("is-invalid");

            }

            return true;

        });
    </script>
</div>

</body>
</html>