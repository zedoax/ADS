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
    <a class="navbar-brand" href="../">Amazan </a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a  class="nav-link" href="../">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="../packages">Packages</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="#">Profile <span class="sr-only">(current)</span></a>
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
            <div class="card mb-3">
                <h6 class="card-header text-muted">Update Billing</h6>
                <form class="p-2">
                    <form class="p-2">
                        <div class="form-group row">
                            <div class="col-12">
                                <label for="name">Cardholder</label>
                                <input type="text" id="name" minlength="1" class="form-control" placeholder="Name on Card" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-10">
                                <label for="cnumber">Card Number</label>
                                <input type="number" id="cnumber" min="1000000000000000" max="9999999999999999" class="form-control" placeholder="xxxx-xxxx-xxxx-xxxx" required>
                            </div>
                            <div class="col-2">
                                <label for="cvv2">CVV2</label>
                                <input type="number" id="cvv2" min="100" max="999" class="form-control" placeholder="xxx" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="form-group col-2">
                                <label for="expiry-m">Expiry Date</label>
                                <select id="current-password" class="form-control" required>
                                    <option value="" selected hidden>Month</option>
                                    <option value="January">January</option>
                                    <option value="February">February</option>
                                    <option value="March">March</option>
                                    <option value="April">April</option>
                                    <option value="May">May</option>
                                    <option value="June">June</option>
                                    <option value="July">July</option>
                                    <option value="August">August</option>
                                    <option value="September">September</option>
                                    <option value="October">October</option>
                                    <option value="November">November</option>
                                    <option value="December">December</option>
                                </select>
                            </div>
                            <div class="form-group col-2">
                                <label for="expiry-y" class="invisible">Expiry Year</label>
                                <select id="expiry-y" class="form-control" required>
                                    <option value="" selected hidden>Year</option>
                                    <option value="2017">2017</option>
                                    <option value="2018">2018</option>
                                    <option value="2019">2019</option>
                                    <option value="2020">2020</option>
                                    <option value="2021">2021</option>
                                    <option value="2022">2022</option>
                                </select>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Update Billing</button>
                    </form>
                </form>
            </div>
            <div class="card mb-3">
                <h6 class="card-header text-muted">Password Change</h6>
                <form class="p-2">
                    <div class="form-group">
                        <label for="current-password">Confirm Current Password</label>
                        <input type="password" id="current-password" class="form-control" placeholder="Current Password" required>
                    </div>
                    <div class="form-group">
                        <label for="new-password">New Password</label>
                        <input type="password" id="new-password" class="form-control" placeholder="New Password" required>
                    </div>
                    <div class="form-group">
                        <label for="new-password-confirm">Confirm New Password</label>
                        <input type="password" id="new-password-confirm" class="form-control" placeholder="Confirm New Password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Change Password</button>
                </form>
            </div>
            <div class="card mb-3">
                <h6 class="card-header text-muted">Address Change</h6>
                <form class="p-2">
                    <div class="form-group">
                        <label for="new-address">New Address</label>
                        <input type="text" id="new-address" class="form-control" placeholder="New Address" required>
                    </div>
                    <div class="form-group">
                        <label for="current-password">Confirm Current Password</label>
                        <input type="password" id="current-password" class="form-control" placeholder="Current Password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Change Address</button>
                </form>
            </div>
            <div class="card mb-3">
                <h6 class="card-header text-muted">Name Change</h6>
                <form class="p-2">
                    <div class="form-group">
                        <label for="new-name">New Name</label>
                        <input type="text" id="new-name" class="form-control" placeholder="New Name" required>
                    </div>
                    <div class="form-group">
                        <label for="current-password">Confirm Current Password</label>
                        <input type="password" id="current-password" class="form-control" placeholder="Current Password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Change Name</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>