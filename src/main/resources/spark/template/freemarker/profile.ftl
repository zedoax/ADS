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
                    <h4>${member.firstname}, ${member.lastname}</h4>
                    <p class="font-italic text-muted">@${member.username}</p>
                    <p class="font-weight-bold">${member.address}</p>
                </div>
            </div>
        </div>
        <div class="col-9">
            <div class="card mb-3">
                <h6 class="card-header text-muted">Update Billing</h6>
                <form class="p-2">
                    <form class="p-2" method="post" action="/updateBilling">
                        <div class="form-group row">
                            <div class="col-12">
                                <label for="name">Cardholder</label>
                                <input type="text" id="name" name="name" minlength="1" class="form-control" placeholder="Name on Card" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-10">
                                <label for="cnumber">Card Number</label>
                                <input type="number" id="cnumber" name="cnumber" min="1000000000000000" max="9999999999999999" class="form-control" placeholder="xxxx-xxxx-xxxx-xxxx" required>
                            </div>
                            <div class="col-2">
                                <label for="cvv2">CVV2</label>
                                <input type="number" id="cvv2" name="cvv2" min="100" max="999" class="form-control" placeholder="xxx" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="form-group col-2">
                                <label for="expiry-m">Expiry Date</label>
                                <select id="expiry-m" name="expiry-m" class="form-control" required>
                                    <option value="" selected hidden disabled>Month</option>
                                    <option value="01">January</option>
                                    <option value="02">February</option>
                                    <option value="03">March</option>
                                    <option value="04">April</option>
                                    <option value="05">May</option>
                                    <option value="06">June</option>
                                    <option value="07">July</option>
                                    <option value="08">August</option>
                                    <option value="09">September</option>
                                    <option value="10">October</option>
                                    <option value="11">November</option>
                                    <option value="12">December</option>
                                </select>
                            </div>
                            <div class="form-group col-2">
                                <label for="expiry-y" class="invisible">Expiry Year</label>
                                <select id="expiry-y" name="expiry-y" class="form-control" required>
                                    <option value="" selected hidden disabled>Year</option>
                                    <option value="17">2017</option>
                                    <option value="18">2018</option>
                                    <option value="19">2019</option>
                                    <option value="20">2020</option>
                                    <option value="21">2021</option>
                                    <option value="22">2022</option>
                                </select>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Update Billing</button>
                    </form>
                </form>
            </div>
            <div class="card mb-3">
                <h6 class="card-header text-muted">Password Change</h6>
                <form class="p-2" method="post" action="/changePassword">
                    <div class="form-group">
                        <label for="current-password">Confirm Current Password</label>
                        <input type="password" id="current-password" name="current-password" class="form-control" placeholder="Current Password" required>
                    </div>
                    <div class="form-group">
                        <label for="new-password">New Password</label>
                        <input type="password" id="new-password" name="new-password" class="form-control" placeholder="New Password" required>
                    </div>
                    <div class="form-group">
                        <label for="new-password-confirm">Confirm New Password</label>
                        <input type="password" id="new-password-confirm" name="new-password-confirm" class="form-control" placeholder="Confirm New Password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Change Password</button>
                </form>
            </div>
            <div class="card mb-3">
                <h6 class="card-header text-muted">Address Change</h6>
                <form class="p-2" method="post" action="/changeAddress">
                    <div class="form-group">
                        <label for="new-address">New Address</label>
                        <input type="text" id="new-address" name="new-address" class="form-control" placeholder="New Address" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Change Address</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>