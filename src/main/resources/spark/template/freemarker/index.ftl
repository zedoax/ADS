<!doctype html>
<html class="no-js" lang="">
<head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="js/plugins.js"></script>
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
                <a  class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Packages</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Account</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Tracking</a>
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
            <div class="card">
                <div class="card-content p-3">
                    <div class="card-title">
                        <h5>Ship a package:</h5>
                        <form>
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" id="name" placeholder="Name">
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" id="address" placeholder="Address">
                            </div>
                            <div class="form-group">
                                <label for="zipcode">Zipcode</label>
                                <input type="number" class="form-control" id="zipcode" placeholder="Zipcode">
                            </div>
                            <div class="form-group">
                                <label for="shipping">Shipping Class</label>
                                <select class="custom-select" id="shipping">
                                    <option selected>Choose a service...</option>
                                    <option value="amazany">Amazany (1 day Sunday Delivery)</option>
                                    <option value="overnight">Overnight (1 day)</option>
                                    <option value="firstclass">First Class (2 day)</option>
                                    <option value="priority">Priority (3 day)</option>
                                    <option value="standard">Standard (5-7 day)</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="weight">Package Weight</label>
                                <select class="custom-select" id="shipping">
                                    <option selected>Choose a weight...</option>
                                    <option value="05">0 - 5</option>
                                    <option value="510">5 - 10</option>
                                    <option value="1020">10 - 20</option>
                                    <option value="20-35">20 - 35</option>
                                    <option value="35+">35+</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Create</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
