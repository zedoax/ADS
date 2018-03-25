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
            <div class="card col-12 mb-3 p-3">
                <div class="card-content">
                    <div class="card-header bg-dark text-light">
                        Truck Database
                    </div>

                    <table class="table table-bordered table-striped text-center">
                        <thead>
                            <tr>
                                <th>Vehicle ID</th>
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
                                    1234567890
                                </th>
                                <th>
                                    <p>Truck</p>
                                </th>
                                <form>
                                    <th>
                                        <select class="custom-select" id="location">
                                            <option value="SAMPLE LOCATION">Sample Location</option>
                                            <option value="SAMPLE LOCATION 2">Sample Location 2</option>
                                        </select>
                                    </th>
                                    <th>
                                        <select class="custom-select" id="location">
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
                            <tr>
                                <th></th>
                                <form>
                                    <th>
                                        <select class="custom-select" id="type">
                                            <option value="truck">Truck</option>
                                            <option value="plane">Plane</option>
                                            <option value="freight">Freight</option>
                                        </select>
                                    </th>
                                    <th>
                                        <select class="custom-select" id="location">
                                            <option value="SAMPLE LOCATION">Sample Location</option>
                                            <option value="SAMPLE LOCATION 2">Sample Location 2</option>
                                        </select>
                                    </th>
                                    <th>
                                        <select class="custom-select" id="location">
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
                                        <button type="submit" class="btn btn-primary">Create</button>
                                    </th>
                                </form>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="card col-12 mb-3 p-3">
                <div class="card-content">
                    <form class="row">
                        <div class="col-5">
                            <label for="saddr">Street Address</label>
                            <input type="text" id="saddr" class="form-control" required>
                        </div>
                        <div class="col-2">
                            <label for="scity">City</label>
                            <input type="text" id="scity" class="form-control" required>
                        </div>
                        <div class="col-1">
                            <label for="sstate">State</label>
                            <select id="sstate" class="custom-select" required>
                                <option value="state">state</option>
                                <option value="state">state</option>
                            </select>
                        </div>
                        <div class="col-2">
                            <label for="szip">Zipcode</label>
                            <input type="number" id="szip" class="form-control" required>
                        </div>
                        <div class="col-2">
                            <label for="submit" class="invisible">Submit</label>
                            <button type="submit" id="submit" class="btn btn-primary form-control">Create</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="card col-12 mb-3 p-3">
                <div class="card-content">
                    <div class="card-header bg-dark text-light">
                        Package Database
                    </div>
                    <table class="table table-bordered table-striped text-center">
                        <thead>
                        <tr>
                            <th>Tracking Number</th>
                            <th>Owner</th>
                            <th>Origin</th>
                            <th>Current Location</th>
                            <th>Destination</th>
                            <th>Update</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th>
                                <p>00000000000000000000000000000</p>
                            </th>
                            <th>
                                <p>Elijah</p>
                            </th>
                            <th>
                                ORIGIN ADDRESS
                            </th>
                            <form>
                                <th>
                                    <select class="custom-select" id="location">
                                        <option value="SAMPLE LOCATION">Sample Location</option>
                                        <option value="SAMPLE LOCATION 2">Sample Location 2</option>
                                    </select>
                                </th>
                                <th>
                                    DESTINATION ADDRESS
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
            <div class="card col-12 mb-3 p-3">
                <div class="card-content">
                    <div class="card-header bg-dark text-light">
                        User Database
                    </div>

                    <table class="table table-bordered table-striped text-center">
                        <thead>
                            <tr>
                                <th>Username</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Address</th>
                                <th>Billing</th>
                                <th>Membership</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th>Zedoax</th>
                                <th>Elijah</th>
                                <th>Bendinsky</th>
                                <th>EXAMPLE ADDRESS</th>
                                <th>XXXX-XXXX-XXXX-XXXX exp.01/2020</th>
                                <form>
                                    <th>
                                        <select class="custom-select" name="membership">
                                            <option value="default">Default</option>
                                            <option value="contract">Contract</option>
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
