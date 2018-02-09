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
            <div class="card m-5 p-3">
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