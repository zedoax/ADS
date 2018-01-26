<!doctype html>
<html class="no-js" lang="">
<head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="js/plugins.js"></script>
    <script src="js/main.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
</head>

<body>
<!-- Navigation Content -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="../">Amazan </a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a  class="nav-link" href="../">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="../packages">Packages</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="#">Account <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="../tracking">Tracking</a>
        </li>
    </ul>
</nav>

<!-- Page Content -->
<div class="container col-sm-12 mt-3 mb-3">
    <div class="row">
        <div class="col-3">
            <div class="card">
                <object data="PROFILE URL GOES HERE" class="m-2 rounded-circle w-50 border mx-auto d-block" type="image/png">
                    <img src="img/defprof.png" class="rounded-circle w-100" alt="Profile Image">
                </object>
                <div class="m-2">
                    <h4>Firstname, Lastname</h4>
                    <p class="font-italic text-muted">@Username</p>
                    <p class="font-weight-bold">XXX ADDRESS ST. XXXXX</p>
                </div>
            </div>
        </div>
        <div class="col-9">
            <div class="card">
                <h5 class="pl-2 pt-2">Password Change:</h5>
                <form class="m-2">
                    <label for="current-password" class="sr-only">Input Current Password</label>
                    <input type="password" id="current-password" class="form-control" placeholder="Current Password" required>
                    <div class="p-2"></div>
                    <label for="new-password" class="sr-only">New Password</label>
                    <input type="password" id="new-password" class="form-control" placeholder="New Password" required>
                    <div class="p-2"></div>
                    <label for="new-password-confirm" class="sr-only">Confirm New Password</label>
                    <input type="password" id="new-password-confirm" class="form-control" placeholder="Confirm New Password" required>
                    <div class="p-2"></div>
                    <button type="submit" class="btn btn-primary">Change Password</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>