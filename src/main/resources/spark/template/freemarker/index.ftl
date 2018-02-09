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
<nav class="nav navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Amazan </a>
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <a  class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="/packages">Packages</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="/profile">Profile</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="/tracking">Tracking</a>
        </li>
    </ul>
    <ul class="nav navbar-nav">
        <li class="nav-item">
            <form class="form-inline" method="post" action="/logout">
                <button class="btn btn-toolbar" type="submit">Logout</button>
            </form>
        </li>
    </ul>
</nav>

<!-- Page Content -->
<div class="container col-sm-10">
    <div class="row pt-4 pb-4">
        <div class="col-sm-8">
            <div class="card">
                <div class="card-content">
                    <div class="card-header">
                        Notifications
                    </div>
                    <div class="card-body">
                        <div class="card card-noshadow p-2">
                            <div class="card-body">
                                <p>This is a sample notification</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="card" id="create">
                <div class="card-content p-3">
                    <div class="card-title">
                        <h6 class="text-muted">Ship a package:</h6>
                        <form class="form-control border-0" onsubmit="createPackage()">
                            <div class="form-group row">
                                <div class="col-5">
                                    <label for="name">First Name</label>
                                    <input type="text" class="form-control" id="fname" minlength="1" placeholder="First Name" required>
                                </div>
                                <div class="col-7">
                                    <label for="name">Last Name</label>
                                    <input type="text" class="form-control" id="lname" minlength="1" placeholder="Last Name" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" id="address" minlength="7" placeholder="Address" required>
                            </div>
                            <div class="form-group">
                                <label for="zipcode">Zipcode</label>
                                <input type="number" class="form-control" id="zipcode" min="10000" max="99999" placeholder="ex. 11111" required>
                            </div>
                            <div class="form-group">
                                <label for="shipping">Shipping Class</label>
                                <select class="custom-select" id="shipping" required>
                                    <option selected hidden value="">Choose a service...</option>
                                    <option value="amazany">Amazany (1 day Sunday Delivery)</option>
                                    <option value="overnight">Overnight (1 day)</option>
                                    <option value="firstclass">First Class (2 day)</option>
                                    <option value="priority">Priority (3 day)</option>
                                    <option value="standard">Standard (5-7 day)</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="weight">Package Weight</label>
                                <select class="custom-select" id="weight" required>
                                    <option selected hidden value="">Choose a weight...</option>
                                    <option value="05">0 - 5</option>
                                    <option value="510">5 - 10</option>
                                    <option value="1020">10 - 20</option>
                                    <option value="20-35">20 - 35</option>
                                    <option value="35+">35+</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Create</button>
                        </form>
                        <p class="text-success d-none" id="create-success">You're all set!</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Scripting -->
<script>
    function createPackage() {
        event.preventDefault();
        event.stopPropagation();

        var fname = document.getElementById("fname").value;
        var lname = document.getElementById("lname").value;
        var address = document.getElementById("address").value;
        var zipcode = document.getElementById("zipcode").value;
        var shipping = document.getElementById("shipping").value;
        var weight = document.getElementById("weight").value;

        var data = {
            fname: fname,
            lname: lname,
            address: address,
            zipcode: zipcode,
            shipping: shipping,
            weight: weight
        };

        $.ajax({
            type: "post",
            url: "/create",
            data: "data",
            statusCode: {
                201: createSuccess
            }
        });

        return false;
    }
    var createSuccess = function(data, textStatus, jqXHR) {
        document.getElementById("create").classList.add("border-success");
        document.getElementById("create-success").classList.remove("d-none");

    }
</script>

</body>
</html>
