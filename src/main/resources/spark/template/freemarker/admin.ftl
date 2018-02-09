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
                    <a class="nav-link" href="#">Admin <span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </nav>

        <!-- Page Content -->
        <div class="container col-10 p-3">
            <div class="card col-12 p-2">
                <div class="card-content">
                    <div class="card-header bg-dark text-light">
                        Package Status
                    </div>

                    <table class="table table-bordered table-striped text-center">
                        <thead>
                            <tr>
                                <th>Vehicle Type</th>
                                <th>Origin</th>
                                <th>Current Location</th>
                                <th>Destination</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th>
                                    <p>Truck</p>
                                </th>
                                <th>
                                    <p>SAMPLE LOCATION</p>
                                </th>
                                <form>
                                    <th>
                                        <select class="custom-select" id="destination">
                                            <option value="SAMPLE LOCATION">Sample Location</option>
                                            <option value="SAMPLE LOCATION 2">Sample Location 2</option>
                                        </select>
                                    </th>
                                    <th>
                                        <select class="custom-select" id="destination">
                                            <option value="SAMPLE LOCATION">Sample Location</option>
                                            <option value="SAMPLE LOCATION 2">Sample Location 2</option>
                                        </select>
                                    </th>
                                    <th>
                                        <button type="submit" class="btn btn-primary">Update</button>
                                    </th>
                                </form>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="card col-12 p-2">
                <div class="card-content">
                    <div class="card-header bg-dark text-light">
                        Vehicle Status
                    </div>

                    <table class="table table-bordered table-striped text-center">
                        <thead>
                            <tr>
                                <th>Vehicle Type</th>
                                <th>Origin</th>
                                <th>Current Location</th>
                                <th>Destination</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th></th>
                                <th></th>
                                <form>
                                    <th>
                                        <select class="custom-select" id="destination">
                                            <option value="SAMPLE LOCATION">Sample Location</option>
                                            <option value="SAMPLE LOCATION 2">Sample Location 2</option>
                                        </select>
                                    </th>
                                    <th>
                                        <select class="custom-select" id="destination">
                                            <option value="SAMPLE LOCATION">Sample Location</option>
                                            <option value="SAMPLE LOCATION 2">Sample Location 2</option>
                                        </select>
                                    </th>
                                    <th>
                                        <button type="submit" class="btn btn-primary">Update</button>
                                    </th>
                                </form>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
