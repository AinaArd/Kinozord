<!DOCTYPE html>
<html>
<head>
    <title>Main page</title>
    <link rel="stylesheet" type="text/css" href="/static/headerStyle.css">
    <link href="https://fonts.googleapis.com/css?family=Bai+Jamjuree" rel="stylesheet">
</head>
<body>
<div class="navbar">
    <div class="dropdown">
        <button class="dropbtn">KinoZord
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a href="#">Afisha</a>
            <a href="/films">Films</a>
            <a href="#">Subscription</a>
            <a href="/search">Search</a>
            <a href="/profile">Profile/Log in</a>
        </div>
    </div>
    <form class="example" method="post" action="#">
        <input type="text" placeholder="Search.." name="search">
        <button type="submit">GO<i class="fa fa-search"></i></button>
    </form>
</div>
<br>
<br>

<#macro block>
</#macro>


</body>
</html>