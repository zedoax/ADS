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
<div class="container">
    <div class="card m-2 p-2">
        <form>
            <label class="sr-only" for="tracking">Input Tracking Number</label>
            <div class="p-2"></div>
            <input type="number" class="form-control" id="tracking" placeholder="Tracking Identification" required>
            <div class="p-2"></div>
            <button type="submit" class="btn btn-primary">Track My Package</button>
        </form>
    </div>
</div>
</body>
</html>