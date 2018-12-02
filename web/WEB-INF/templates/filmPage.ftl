<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/ftl; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="/static/filmPage.css">
    <link href="https://fonts.googleapis.com/css?family=Bai+Jamjuree" rel="stylesheet">
</head>
<body>
<#include "header.ftl">
<div onclick="show('none')" id="gray"></div>
<div id="window">
    <div class="form">
        <form method="post">
            <label for="user">Send to</label><br>
            <input required id="user" type="text" name="receiver" placeholder="Login"/><br>
            <label for="comment">Comment<b id="t">0</b><b>/200</b></label><br>
            <textarea id="comment" maxlength="200" oninput="func(this)" type="text" name="comment"
                      placeholder="Awesome Film Bro"></textarea>
            <button type="submit" class="btn btn-primary btn-block btn-large">RECOMMEND</button>
        </form>
    </div>
</div>
<div class="mainBlock">

    <div class="iRec"><img src="/static/icon.jpg" height="200px" width="200px"><br>
        <button onclick="show('block')" id="Rec">Recommend</button>
    </div>
    <div class="FInfo"><h3>${film.getName()}</h3>
        <table>
            <tr>
                <td>Year:</td>
                <td>${film.getYear()}</td>
            </tr>
            <tr>
                <td>Country:</td>
                <td>${film.getCountry()}</td>
            </tr>
            <tr>
                <td>Rate:</td>
                <td>${film.getRate()}</td>
            </tr>
            <tr>
                <td>Category:</td>
                <td>${film.getCategory()}</td>
            </tr>
        </table>
    </div>
    <div class="Rate">
        <form method="post">
            <b>How do you find this film?</b><br>
            <span class="type"><input name="watchlater" type="radio">Watch Later<br></span>
            <span class="type"><input name="like" type="radio">Like<br></span>
            <span class="type"><input name="neutral" type="radio">Neutral<br></span>
            <span class="type"><input name="dislike" type="radio">Dislike<br></span>
            <a><input type="submit"></a>
        </form>
    </div>

    <div class="text">
        <p style="margin-top: 375px"><h5>Description</h5>${film.getDescription()}</p></div>
</div>
<script>
    //Функция показа
    function show(state) {
        document.getElementById('window').style.display = state;
        document.getElementById('gray').style.display = state;
    }
</script>
<script>
    var func = function (el) {
        document.getElementById("t").textContent = el.value.length;
    }
</script>
</body>
</html>