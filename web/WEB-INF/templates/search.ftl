<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" type="text/css" href="/static/search.css">
    <link href="https://fonts.googleapis.com/css?family=Bai+Jamjuree" rel="stylesheet">
</head>
<body>
<#include "header.ftl">
<div class="mainBlock">
    <div class="left">
        <form class="custom-dropdown" action="formdata" method="post" name="form1">
            <input class="search" type="text" name="search" placeholder="FILMNAME">
            <p><select name="list1">
                <option name="null" value="hide">Выберите из списка</option>
                <option name="2018">2018</option>
                <option name="2017">2017</option>
                <option name="2016">2016</option>
                <option name="2015">2015</option>
                <option name="2014">2014</option>
            </select></p>
            <p><select name="list1">
                <option name="null" value="hide">Выберите из списка</option>
                <option name="2018">2018</option>
                <option name="2017">2017</option>
                <option name="2016">2016</option>
                <option name="2015">2015</option>
                <option name="2014">2014</option>
            </select></p>
            <p><select name="list1">
                <option name="null" value="hide">Выберите из списка</option>
                <option name="2018">2018</option>
                <option name="2017">2017</option>
                <option name="2016">2016</option>
                <option name="2015">2015</option>
                <option name="2014">2014</option>
            </select></p>
            <p><input class="Rec" type="submit" value="Отправить"></p>
        </form>

    </div>
    <div class="right" >

        <br>
        <br>
        <div class="film_cell"><a href=""><img src="/static/icon.jpg" width="125px" height="125px"><br>FILMNAME</a></div>
        <div class="film_cell"><a href=""><img src="/static/icon.jpg" width="125px" height="125px"><br>FILMNAME</a></div>
        <div class="film_cell"><a href=""><img src="/static/icon.jpg" width="125px" height="125px"><br>FILMNAME</a></div>
        <div class="film_cell"><a href=""><img src="/static/icon.jpg" width="125px" height="125px"><br>FILMNAME</a></div>
        <div class="film_cell"><a href=""><img src="/static/icon.jpg" width="125px" height="125px"><br>FILMNAME</a></div>
    </div>
</div>
</body>
</html>