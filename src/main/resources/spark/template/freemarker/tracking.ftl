<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
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
                <li class="nav-item active">
                    <a class="nav-link" href="#">Tracking <span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </nav>

        <!-- Page Content -->
        <div class="container mt-3">
            <#if package??>
                <div class="card p-5 mb-3">
                    <div class="card-content">
                        <div class="row">
                            <#if package.status=="delivered">
                                <div class="col-4">
                                    <i class="fa fa-check-circle fa-10x text-success"></i>
                                </div>
                                <div class="col-8">
                                    <div class="row">
                                        <h1>Delivered</h1>
                                    </div>
                                    <div class="row">
                                        <h5>${package.destination}</h5>
                                    </div>
                                </div>
                            <#elseif package.status=="late">
                                <div class="col-4">
                                    <i class="fa fa-check-circle fa-10x text-success"></i>
                                </div>
                                <div class="col-8">
                                    <div class="row">
                                        <h1>Late</h1>
                                    </div>
                                    <div class="row">
                                        <h5>${package.destination}</h5>
                                    </div>
                                </div>
                            <#elseif package.status=="lost">
                                <div class="col-4">
                                    <i class="fa fa-check-circle fa-10x text-success"></i>
                                </div>
                                <div class="col-8">
                                    <div class="row">
                                        <h1>Sorry, it appears we have lost your package</h1>
                                    </div>
                                    <div class="row">
                                        <h5>${package.destination}</h5>
                                    </div>
                                </div>
                            <#else>
                                <div class="col-4">
                                    <i class="fa fa-times-circle fa-10x text-danger"></i>
                                </div>
                                <div class="col-8">
                                    <div class="row">
                                        <h1>On it's way</h1>
                                    </div>
                                    <div class="row">
                                        <h5>${package.location}</h5>
                                    </div>
                                </div>
                            </#if>
                        </div>
                    </div>
                </div>
                <div class="card p-3 mb-3">
                    <div class="card-content">
                        <div class="card-header bg-dark text-light">
                            Tracking
                        </div>

                        <table class="table table-bordered table-striped text-center">
                            <thead>
                                <tr>
                                    <th>Date</th>
                                    <th>Vehicle</th>
                                    <th>Location</th>
                                </tr>
                            </thead>
                            <tbody>
                                <#list tracking as entry>
                                <tr>
                                    <th>${entry.date}</th>
                                    <th>${entry.vehicle_type}</th>
                                    <th>${entry.location}</th>
                                </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            <#else>
                <div class="card p-2 mb-3">
                    <form name="tracking_form" method="get" action="/tracking">
                        <div class="form-group">
                            <label class="sr-only" for="tracking">Input Tracking Number</label>
                            <#if invalid??>
                                <input type="number" class="form-control is-invalid" id="tracking" name="id" placeholder="Tracking Identification" required>
                            <#else>
                                <input type="number" class="form-control" id="tracking" name="id" placeholder="Tracking Identification" required>
                            </#if>
                            <div class="invalid-feedback">
                                <#if message??>
                                    ${message}
                                </#if>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Track My Package</button>
                    </form>
                </div>
            </#if>
        </div>
    </body>
</html>