<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link rel="stylesheet" type="text/css" href="/static/search.css">
    <link href="https://fonts.googleapis.com/css?family=Bai+Jamjuree" rel="stylesheet">
</head>
<body>
<#include "header.ftl">
<div class="mainBlock">
    <div class="left">
        <form class="custom-dropdown" <#--action="formdata"--> method="post" name="form1">
            <input class="search" type="text" name="name" placeholder="FILMNAME">
            <p><select name="year">
                <option name="searchCategory" value="Выберите из списка"></option>
                <option name="1994">1994</option>
                <option name="2009">2009</option>
                <option name="2010">2010</option>
                <option name="2014">2014</option>
                <option name="2018">2018</option>
            </select></p>
            <p><select name="country">
                <option name="null" value="hide"></option>
                <option name="USA">USA</option>
                <option name="USA, UK">USA, UK</option>
            </select></p>
            <p><select name="rate">
                <option name="null" value="hide"></option>
                <option name="1">1</option>
                <option name="2">2</option>
                <option name="3">3</option>
                <option name="4">4</option>
                <option name="5">5</option>
                <option name="6">6</option>
                <option name="7">7</option>
                <option name="8">8</option>
                <option name="9">9</option>
                <option name="10">10</option>
            </select></p>
            <p><input class="Rec" type="submit"/></p>
        </form>

    </div>
    <div class="right">
        <br>
        <br>
        <#if films ??>
            <#if films? has_content>
                <#list films as item>
        <div class="film_cell"><a href=""><img src="/static/icon.jpg" width="125px" height="125px"><br>${item.getName()}
                </a>
                </#list>
            </#if>
        </#if>
    </div>
    </div>
</div>
</body>
</html>