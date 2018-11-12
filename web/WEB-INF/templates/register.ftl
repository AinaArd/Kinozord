<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign in Form</title>
    <link rel="stylesheet" type="text/css" href="/static/AuthStyle.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
<div class="login">
    <h1>Registration</h1>
    <form method="post" enctype="multipart/form-data" <#--onsubmit="return validate_form();"-->>
        <input type="text" name="name" placeholder="Name" required/>
        <input type="text" id="login" name="login" placeholder="Login" required/>
        <input type="password" id="password" name="password" placeholder="Password" required/>
        <input type="file" name="file" id="file" accept="image/jpeg, image/png, image/jpg">
        <input type="submit" class="btn btn-primary btn-block btn-large"/>
    </form>
</div>
<script type="text/javascript">
    var validate_form = function () {
        var l = document.getElementById("login");
        var p = document.getElementById("password");
        var re = /^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\d.-]{2,19}$/;
        if (!re.test(l.value)) {
            alert("wrong login");
        }
        ;
        var re2 = /(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}/;
        if (!re2.test(p.value)) {
            alert("wrong password");
        }
        ;
        return re.test(l.value) && re2.test(p.value);
    }
</script>
</body>
</html>
