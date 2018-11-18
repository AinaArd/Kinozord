<!DOCTYPE html>
<html>
<head>
    <title>films</title>
    <link rel="stylesheet" type="text/css" href="/static/films.css">
    <link href="https://fonts.googleapis.com/css?family=Bai+Jamjuree" rel="stylesheet">
</head>
<body>
<#include "header.ftl">
<div class="mainBlock">
<#if films ??>
    <#if films? has_content>
        <div id="f1" class="filmsBlock">
            <br>
<#list 0..films?size-1 as item>
        <div class="film_cell"><img src="/static/icon.jpg" width="125px"
                                    height="125px"><br>${films[item].getName()}</div>
</#list>
        </div>
    </#if>
</#if>
</div>
</body>
</html>