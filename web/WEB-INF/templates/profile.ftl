<!DOCTYPE html>
<html>
<head>
    <title>profile</title>
    <link rel="stylesheet" type="text/css" href="/static/profile.css">
    <link href="https://fonts.googleapis.com/css?family=Bai+Jamjuree" rel="stylesheet">

</head>
<body>
<#include "header.ftl">
<div onclick="show('none')" id="gray"></div>
<div id="window">
    <div class="form">
        <form method="post">
            <input type="text" name="name" placeholder="Name"/>
            <input type="text" name="login" placeholder="Login"/>
            <input type="password" name="password" placeholder="Password"/>
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
	text-align: left;">
                    <div class="profile">
                        <img src="src/icon.jpg" height="130px" width="130px">
                    </div>
                    <div class="profile2">${user.getLogin()}<br>${user.getName()}<br><br>
                        <button id="Rec" onclick="show('block')">EDIT</button>
                        <!--если не свой профиль то вместо edit вот эта кнопка, если уже добавлен то status=delete(или просто не показывать кнопку) else add-->
                    <#--<br><button =="Rec" onclick="/actionuser?login=${thisuser}">${status}</button>-->
                    </div>
                </td>

            </tr>
            <tr>
                <td>friends
                    <ul>
                        <#if subscribers ??>
                            <#if subscribers? has_content>
                                <#list subscribers as item>
                        <li id="list">
                            <img src="src/icon.jpg" height="40px" width="40px">${item.getUserSubscriber()}
                        </li>
                                </#list>
                            </#if>
                        </#if>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>watch later
                    <ul>
                        <#if later ??>
                            <#if later? has_content>
                                <#list later as item>
                        <li id="list">
                            <img src="" height="40px" width="40px">${item.getPostponedFilm()}
                        </li>
                                </#list>
                            </#if>
                        </#if>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>liked
                    <ul>
                       <#if liked ??>
                           <#if liked? has_content>
                               <#list liked as item>
                        <li id="list">
                            <img src="" height="40px" width="40px">${item.getLiked()}
                        </li>
                               </#list>
                           </#if>
                       </#if>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>neutral
                    <ul>
                    <#if neutral ??>
                        <#if neutral? has_content>
                            <#list neutral as item>
                        <li id="list">
                            <img src="" height="40px" width="40px">${item.getNeutralFilm()}
                        </li>
                            </#list>
                        </#if>
                    </#if>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>disliked
                    <ul>
                         <#if disliked ??>
                             <#if disliked? has_content>
                                 <#list disliked as item>
                        <li id="list">
                            <img src="" height="40px" width="40px">${item.getDislikedFilm()}
                        </li>
                                 </#list>
                             </#if>
                         </#if>
                    </ul>
                </td>
            </tr>
        </table>
    </div>
    <ul>
        <#if posts ??>
            <#if posts? has_content>
                <#list posts as item>
        <div class="right">
            <li>
                <div class="post">
                    <img style="float: left;" src="src/icon.jpg" height="40px" width="40px">
                    <p style="
				margin-left: 20px;
				float: left;">${user.getLogin()}</p>
                    <p style="
				margin-right: 60px;float: right;">${item.getDateOfPost()}</p></div>
                <br>
                <br>
                <br>
                <div class="text">${item.getText()}</li>
        </div>
                </#list>
            </#if>
        </#if>
    </ul>
</div>

<script>
    //Функция показа
    function show(state) {
        document.getElementById('window').style.display = state;
        document.getElementById('gray').style.display = state;
    }
</script>
</body>
</html>