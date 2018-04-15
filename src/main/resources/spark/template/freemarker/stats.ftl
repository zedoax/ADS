<!doctype html>
<html class="no-js" lang="">
<head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
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
        <li class="nav-item">
            <a class="nav-link" href="../profile">Profile</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="../tracking">Tracking</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="../admin">Admin</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="#">Stats <span class="sr-only">(current)</span></a>
        </li>
    </ul>
</nav>

<!-- Page Content -->
<div class="container mt-3">
    <div class="card p-3 mb-3">
        <div class="card-content text-center">
            <div class="card-header bg-dark text-light">
                Power Users
            </div>
            <div class="row">
                    <div class="col-4">
                        <div class="row">
                            <h3>Most packages ordered:</h3>
                        </div>
                        <div class="row">
                            <h2>${order_user}</h2>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="row">
                            <h3>Most money spent:</h3>
                        </div>
                        <div class="row">
                            <h2>${money_user}</h2>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="row">
                            <h3>Most customers here:</h3>
                        </div>
                        <div class="row">
                            <h2>${street}</h2>
                        </div>
                    </div>
            </div>
        </div>
    </div>
    <div class="card p-3 mb-3">
        <div class="card-content">
            <div class="card-header bg-dark text-light">
                Missed Packages
            </div>
            <table class="table table-bordered table-striped text-center">
                <thead>
                <tr>
                    <th>Tracking Number</th>
                    <th>Owner</th>
                    <th>Origin</th>
                    <th>Current Vechicle</th>
                    <th>Destination</th>
                    <th>Days until Delivery</th>
                </tr>
                </thead>
                <tbody>
                <#list packages as package>
                <tr>
                    <th>
                        <p>${package.id}</p>
                    </th>
                    <th>
                        <p>${package.owner}</p>
                    </th>
                    <th>
                    ${package.origin}
                    </th>
                    <th>
                    ${package.location}
                    </th>
                    <th>
                    ${package.destination}
                    </th>
                    <th>
                    ${package.eta}
                    </th>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>