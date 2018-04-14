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
<!-- Navigation Content -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Amazan </a>
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a  class="nav-link" href="../">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="../packages">Packages</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="../profile">Profile</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="../tracking">Tracking</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="../admin">Admin <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="../admin/stats">Stats</a>
        </li>
    </ul>
</nav>

<!-- Page Content -->
<div class="container col-10 p-3">
    <div class="card col-12 mb-3 p-3">
        <div class="card-content">
            <div class="card-header bg-dark text-light">
                Package Information
            </div>
            <table class="table table-bordered table-striped text-center">
                <thead>
                <tr>
                    <th>Tracking Number</th>
                    <th>Owner</th>
                    <th>Origin</th>
                    <th>Current Vechicle</th>
                    <th>Destination</th>
                    <th>Hazardous</th>
                    <th>International</th>
                    <th>Cost</th>
                </tr>
                </thead>
                <tbody>
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
                    <#if package.hazardous>
                        yes
                    <#else>
                        no
                    </#if>
                    </th>
                    <th>
                    <#if package.international>
                        yes
                    <#else>
                        no
                    </#if>
                    </th>
                    <th>
                        ${package.price?string.currency}
                    </th>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card col-8 mb-3 p-3">
        <div class="card-content">
            <div class="card-header bg-dark text-light">
                Package Log
            </div>

            <table class="table table-bordered table-striped text-center">
                <thead>
                <tr>
                    <th>Date</th>
                    <th>Vehicle</th>
                    <th>Vehicle ID</th>
                    <th>Location</th>
                </tr>
                </thead>
                <tbody>
                <#list log as entry>
                <tr>
                    <th>${entry.date}</th>
                    <th>${entry.vehicle_type}</th>
                    <th><a href="/admin?vehicle=${entry.id}">${entry.id}</a></th>
                    <th>${entry.location}</th>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
