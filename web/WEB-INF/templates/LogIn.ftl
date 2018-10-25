<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="../../static/AuthStyle.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>

<body>

<div class="login">
    <h1>Login</h1>
    <form method="post">
        <input type="text" name="u" placeholder="Username" required="required"/>
        <input type="password" name="p" placeholder="Password" required="required"/>
        <center style="color: white;">Remember me<input class="c" type="checkbox" name="c"/></center>
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    </form>
</div>


</body>

</html>
