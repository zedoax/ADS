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
        <!-- Page Content -->
        <div class="w-100 p-5 fill bg-dark">
            <div class="p-5"></div>
            <h2 class="text-light p-5 text-center">Amazan Delivery Service</h2>
            <div class="p-5"></div>
            <p class="text-light p-5 text-center">Combining the best service, materials, and shipping routes to bring you quality, speedy delivery of packages.  We provide the best
            in customer assurance, and quality of service.  Want to join?</p>
            <div class="text-light p-5 text-center">
                <a href="../login" class="btn btn-primary d-inline-block">Log In </a>
                <a href="../signup" class="btn btn-primary d-inline-block">Sign Up</a>
            </div>
        </div>

        <!-- Tracking Content -->
        <div class="container pt-3 pb-3">
        <#if trackingid??>
            <div class="card p-5 mb-3">
                <div class="card-content">
                    <div class="row">
                        <#if status=="delivered">
                            <div class="col-4">
                                <i class="fa fa-check-circle fa-10x text-success"></i>
                            </div>
                            <div class="col-8">
                                <div class="row">
                                    <h1>Delivered</h1>
                                </div>
                                <div class="row">
                                    <h5>ADDRESS</h5>
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
                                    <h5>ADDRESS</h5>
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
                            <th>Vehicle</th>
                            <th>Location</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th>Truck</th>
                            <th>EXAMPLE ADDRESS</th>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        <#else>
            <div class="card p-2 mb-3">
                <form>
                    <div class="form-group">
                        <label class="sr-only" for="tracking">Input Tracking Number</label>
                        <#if invalid??>
                            <input type="number" class="form-control is-invalid" id="tracking" placeholder="Tracking Identification" required>
                            <div class="invalid-feedback">
                                ${message}
                            </div>
                        <#else>
                            <input type="number" class="form-control" id="tracking" placeholder="Tracking Identification" required>
                        </#if>
                    </div>
                    <button type="submit" class="btn btn-primary">Track My Package</button>
                </form>
            </div>
        </#if>
        </div>
    </body>
</html>