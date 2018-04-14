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
                Vehicle
            </div>
            <table class="table table-bordered table-striped text-center">
                <thead>
                <tr>
                    <th>Vehicle ID</th>
                    <th>Type</th>
                    <th>Origin</th>
                    <th>Location</th>
                    <th>Destination</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>
                    ${vehicle.id}
                    </th>
                    <th>
                    ${vehicle.type}
                    </th>
                    <th>
                     ${vehicle.origin}
                    </th>
                    <th>
                    ${vehicle.location}
                    </th>
                    <th>
                    ${vehicle.destination}
                    </th>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card col-12 mb-3 p-3">
        <div class="card-content">
            <div class="card-header bg-dark text-light">
                Current Packages
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
                <#list current as package>
                <tr>
                    <th>
                        <a href="/admin?tracking=${package.id}">${package.id}</a>
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
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card col-12 mb-3 p-3">
        <div class="card-content">
            <div class="card-header bg-dark text-light">
                Delivered Packages
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
                <#list delivered as package>
                <tr>
                    <th>
                        <a href="/admin?tracking=${package.id}">${package.id}</a>
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
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
