$(function () {


    var user = document.location.search;
    var userId = user.substring(8);

    $.ajax({
        url: './all_userMess',
        data: {"userId": userId},
        type: 'get',
        method: 'get',
        success: function (result) {

            if (result.code == 200) {

                $('.loginitem_h').empty();
                $('.loginitem_h').append(
                    '<div class="userinfo">'
                    + '<div class="userinfo_w" id="userinfo_w">'
                    + '<a href="user-center.html?userId=' + result.data.userId + '" class="avatar">'
                    + '<img src=' + result.data.userImage + '>'
                    + '</a>'
                    + '<a href="user-center.html?userId=' + result.data.userId + '" class="outer">' + result.data.userName + '</a>'
                    + '<div class="top_userinfo_more">'
                    + '<div class="u">'
                    + '<a href="user-center.html?userId=' + result.data.userId + '" class="img">'
                    + '<img src=' + result.data.userImage + '>'
                    + '</a>'
                    + '<div class="n">'
                    + '<a href="user-center.html?userId=' + result.data.userId + '" data-name="' + result.data.userName + '">' + result.data.userName + '</a>'
                    + '<a target="_blank" href="" class="v"></a>'
                    + '</div>'
                    + '</div>'
                    + '<ul class="clearfix">'
                    + '<li>'
                    + '<a href="create-cp.html?userId=' + result.data.userId + '" class="redbtn">发布菜谱</a>'
                    + '<a class="greybtn free" onclick="">发布图文（400积分）</a>'
                    + '</li>'
                    + '<li>'
                    + '<a href="user-center.html?userId=' + result.data.userId + '" class="linkk">我的美食空间</a>'
                    + '</li>'
                    + '<li>'
                    + '<a href="" class="linkk">我的积分成长</a>'
                    + '</li>'
                    + '<li>'
                    + '<a href="./reception/tologout" class="linkk" onclick="logout()">退出登录</a>'
                    + '</li>'
                    + '</ul>'
                    + '</div>'
                    + '</div>'
                    + '<a href="collected.?userId=' + result.data.userId + '" class="outer">收藏</a>'
                    + '<div class="mes">'
                    + '<a href="user-center?userId=' + result.data.userId + '?userId=' + result.data.userId + '" class="outer">消息</a>'
                    + '<div class="topbar_mesbox" id="dr_getmission_box1" style="display: none"></div>'
                    + '</div>'
                    + '</div>'
                    + '</div>'
                    + '</div>');
                document.getElementById("showImg").src = result.data.userImage;

                $('#showName').text(result.data.userName);
                $('#showFans').text(result.data.userFans);
                $('#showFollow').text(result.data.userFollow);

                if (result.data.userAutograph == null) {
                    $('#showAutograph').text("");
                } else {
                    $('#showAutograph').text(result.data.userAutograph);
                }

                $('#showMess').attr('href', 'user-mes.html?userId=' + result.data.userId + '');
                $('#showCenter').attr('href', 'user-center.html?userId=' + result.data.userId + '');
                $('#showNotification').attr('href', 'notification.html?userId=' + result.data.userId + '');
                $('#look_cp').attr('href', 'user-center-cp.html?userId=' + result.data.userId + '');
                $('#look_fans').attr('href', 'following.html?userId=' + result.data.userId + '');
                $('#look_follower').attr('href', 'follower.html?userId=' + result.data.userId + '');

                $('#userCenter').attr('href', 'user-center.html?userId=' + result.data.userId + '');
                $('#userCu').attr('href', 'user-center-user.html?userId=' + result.data.userId + '');
                $('#myTask').attr('href', 'my-task.html?userId=' + result.data.userId + '');
                $('#collected').attr('href', 'collected.html?userId=' + result.data.userId + '');
                $('#like').attr('href', 'like.html?userId=' + result.data.userId + '');
                $('#userForum').attr('href', 'user-forum.html?userId=' + result.data.userId + '');
                $('#recent').attr('href', 'recent.html?userId=' + result.data.userId + '');
                $('#followers').attr('href', 'follower.html?userId=' + result.data.userId + '');

            } else {
                $('.loginitem_h').empty();
                $('.loginitem_h').append('<a href="logon-youpu.html" class="link header_login">注册</a>' + ' <a href="logon-youpu.html" class="link header_register">登录</a>')
            }
        }
    });

})