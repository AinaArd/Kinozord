<!DOCTYPE html>
<html>
<head>
    <title>profile</title>
    <link rel="stylesheet" type="text/css" href="../../static/profile.css">
    <link href="https://fonts.googleapis.com/css?family=Bai+Jamjuree" rel="stylesheet">

</head>
<body>
<div onclick="show('none')" id="gray"></div>
<div id="window">
    <div class="form">
        <form method="post">
            <input type="text" name="newName" placeholder="Name"/>
            <input type="text" name="newLogin" placeholder="Login"/>
            <input type="password" name="newPassword" placeholder="Password"/>
            <input type="password" name="pcheck" placeholder="Repeat password"/>
            <button type="submit" class="btn btn-primary btn-block btn-large">EDIT</button>
        </form>
    </div>
</div>
<div class="mainBlock">
    <div class="left">
        <table>
            <tr>
                <td style="
	vertical-align: middle;
	text-align: left;"><div class="profile">
                    <img src="../../static/icon.jpg" height="130px" width="130px">
                </div><div class="profile2">{loginFromDB}<br>{realName}<br><button onclick="show('block')">EDIT</button></div></td>
            </tr>
            <tr>
                <td>friends
                    <ul>
                        <li id="list">
                            <img src="../../static/icon.jpg" height="40px" width="40px"> FRIEND
                        </li>
                        <li id="list">
                            <img src="../../static/icon.jpg" height="40px" width="40px"> FRIEND
                        </li>
                        <li id="list">
                            <img src="../../static/icon.jpg" height="40px" width="40px"> FRIEND
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>watch later
                    <ul>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>liked
                    <ul>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>neutral
                    <ul>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>disliked
                    <ul>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                        <li id="list">
                            <img src="" height="40px" width="40px"> FILM
                        </li>
                    </ul>
                </td>
            </tr>
        </table>
    </div>
    <ul>
        <div class="right">
            <li>
                <div class="post">
                    <img style="float: left;" src="../../static/icon.jpg" height="40px" width="40px">
                    <p style="
				margin-left: 20px;
				float: left;">LOGIN</p> <p style="
				margin-right: 60px;float: right;">DATE</p></div>
                <br>
                <br>
                <br>
                <div class="text">Free vector icons - SVG, PSD, PNG, EPS & Icon Font - Thousands of ...
                    https://www.flaticon.com/
                    Перевести эту страницу
                    1157500+ Free vector icons in SVG, PSD, PNG, EPS format or as ICON FONT. Thousands of free icons in the largest database of free vector icons!
                    ‎Vector icon packs · ‎Login · ‎Teamwork · ‎Packs
                    User - Icons8
                    https://icons8.ru/icon/3225/пользователь
                    Пользователь icon. It is the drawing ... Идентифицированный пользователь-мужчина icon ... Thus, it only makes sense for you to choose your user icon well.</div>
            </li>
        </div>
        <div class="right">
            <li>
                <div class="post">
                    <img style="float: left;" src="../../static/icon.jpg" height="40px" width="40px">
                    <p style="
				margin-left: 20px;
				float: left;">LOGIN</p> <p style="
				margin-right: 60px;float: right;">DATE</p></div>
                <br>
                <br>
                <br>
                <div class="text">Free vector icons - SVG, PSD, PNG, EPS & Icon Font - Thousands of ...
                    https://www.flaticon.com/
                    Перевести эту страницу
                    1157500+ Free vector icons in SVG, PSD, PNG, EPS format or as ICON FONT. Thousands of free icons in the largest database of free vector icons!
                    ‎Vector icon packs · ‎Login · ‎Teamwork · ‎Packs
                    User - Icons8
                    https://icons8.ru/icon/3225/пользователь
                    Пользователь icon. It is the drawing ... Идентифицированный пользователь-мужчина icon ... Thus, it only makes sense for you to choose your user icon well.</div>
            </li>
        </div>
    </ul>
</div>

<script>
    //Функция показа
    function show(state)
    {
        document.getElementById('window').style.display = state;
        document.getElementById('gray').style.display = state;
    }
</script>
</body>
</html>