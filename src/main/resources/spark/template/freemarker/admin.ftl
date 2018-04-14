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
                <li class="nav-item" aria-disabled="true">
                    <a class="nav-link disabled" href="../packages">Packages</a>
                </li>
                <li class="nav-item" aria-disabled="true">
                    <a class="nav-link disabled" href="../profile">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../tracking">Tracking</a>
                </li>
                <li class="nav-item active" aria-disabled="true">
                    <a class="nav-link" href="#">Admin <span class="sr-only">(current)</span></a>
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
                            <#list vehicles as vehicle>
                            <tr>
                                <th>
                                    ${vehicle.id}
                                </th>
                                <th>
                                    <p>${vehicle.type}</p>
                                </th>
                                <th>
                                ${vehicle.origin}
                                </th>
                                <form method="post" action="/updateTruck">
                                    <input type="text" hidden disabled name="vehicle" value="${vehicle.id}" required>
                                    <th>
                                        <select class="custom-select" id="location" name="location">
                                            <option selected disabled hidden>${vehicle.location}</option>
                                            <#list stations as station>
                                            <option value="${station.location}">${station.location}</option>
                                            </#list>
                                        </select>
                                    </th>
                                    <th>
                                        <select class="custom-select" id="destination" name="destination">
                                            <option selected disabled hidden>${vehicle.destination}</option>
                                            <#list stations as station>
                                            <option value="${station.location}">${station.location}</option>
                                            </#list>
                                        </select>
                                    </th>
                                    <th>
                                        <button type="submit" class="btn btn-primary">Update</button>
                                    </th>
                                </form>
                            </tr>
                            </#list>
                            <tr>
                                <th></th>
                                <form name="create_vehicle">
                                    <th>
                                        <select class="custom-select" id="type" name="type">
                                            <option value="truck">truck</option>
                                            <option value="truck">plane</option>
                                            <option value="truck">ship</option>
                                        </select>
                                    </th>
                                    <th>
                                    </th>
                                    <th>
                                        <select class="custom-select" id="location" name="location">
                                        <#list stations as station>
                                            <option value="${station.id}">${station.location}</option>
                                        </#list>
                                        </select>
                                    </th>
                                    <th>
                                        <select class="custom-select" id="destination" name="destination">
                                        <#list stations as station>
                                            <option value="${station.id}">${station.location}</option>
                                        </#list>
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
                    <div class="card-header bg-dark text-light">
                        Station Database
                    </div>
                    <div class="row">
                        <table class="table table-bordered table-striped text-center">
                            <thead>
                            <tr>
                                <th>Station ID</th>
                                <th>Location</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list stations as station>
                            <tr>
                                <th>
                                ${station.id}
                                </th>
                                <th>
                                ${station.location}
                                </th>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
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
                            <th>Current Vechicle</th>
                            <th>Destination</th>
                            <th>Update</th>
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
                            <form>
                                <th>
                                    <select class="custom-select" id="location" name="location">
                                        <option disabled hidden selected>${package.location}</option>
                                        <#list vehicles as vehicle>
                                        <option value="${vehicle.id}">${vehicle.id}</option>
                                        </#list>
                                    </select>
                                </th>
                                <th>
                                    ${package.destination}
                                </th>
                                <th>
                                    <button type="submit" class="btn btn-primary">Update</button>
                                </th>
                            </form>
                        </tr>
                        </#list>
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
                            <#list users as user>
                            <tr>
                                <th>${user.username}</th>
                                <th>${user.firstname}</th>
                                <th>${user.lastname}</th>
                                <th>${user.address}</th>
                                <th>${user.credit}</th>
                                <form method="post" action="/updateUser">
                                    <input hidden disabled name="member" value="${user.username}" required>
                                    <th>
                                        <select class="custom-select" name="membership">
                                            <option selected disabled hidden>${user.membership}</option>
                                            <option value="default">Default</option>
                                            <option value="contract">Contract</option>
                                        </select>
                                    </th>
                                    <th>
                                        <button type="submit" class="btn btn-primary">Update</button>
                                    </th>
                                </form>
                            </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
