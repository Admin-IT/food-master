$(function () {

    var user = document.location.search;
    var userId = user.substring(8);
    $.ajax({
        url: 'http://127.0.0.1:8088/food/all_userMess',
        data: {"userId": userId},
        type: 'get',
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
                    + '<a href="./reception/tologout" class="linkk">退出登录</a>'
                    + '</li>'
                    + '</ul>'
                    + '</div>'
                    + '</div>'
                    + '<a href="collected.html?userId=' + result.data.userId + '" class="outer">收藏</a>'
                    + '<div class="mes">'
                    + '<a href="user-center?userId=' + result.data.userId + '" class="outer">消息</a>'
                    + '<div class="topbar_mesbox" id="dr_getmission_box1" style="display: none"></div>'
                    + '</div>'
                    + '</div>'
                    + '</div>'
                    + '</div>');

                $('#showEmail').text(result.data.userEmail);

                $('#showName').val(result.data.userName);
                $('#gender').val(result.data.userSex);
                $('#profession').val(result.data.userOccupation);

                var hometown = result.data.userHometown;
                var location = result.data.userLocation;

                $('#province').val(hometown.substring(0, 3));
                $('#local_province').val(location.substring(0, 3));

                // $("#province").find("option,selected").text(hometown.substring(0,3));

                $("#city").find("option,selected").text(hometown.substring(3));
                $("#city").attr("value", hometown.substring(3));

                $("#local_city").find("option,selected").text(location.substring(3));
                $("#local_city").attr("value", location.substring(3));

                $('#return_user').attr('href', 'user-center.html?userId=' + result.data.userId + '');
                $('#look_mes').attr('href', 'user-mes.html?userId=' + result.data.userId + '');
                $('#lookEmail').attr('href', 'email.html?userId=' + result.data.userId + '');
                $('#lookPass').attr('href', 'password.html?userId=' + result.data.userId + '');
                $('#lookPhone').attr('href', 'phone.html?userId=' + result.data.userId + '');
                $('#lookPhoto').attr('href', 'photo.html?userId=' + result.data.userId + '');

                var a = result.data.userBirthday;
                var year = a.substring(0, 4);
                var month = a.substring(5, 7);
                var day = a.substring(8, 10);
                $('#birthday_year').val(year);
                $('#birthday_month').val(month);
                $('#birthday_day').val(day);
                $('.textarea1').text(result.data.userAutograph);
            } else {
                $('.loginitem_h').empty();
                $('.loginitem_h').append('<a href="logon-youpu.html" class="link header_login">注册</a>' + ' <a href="logon-youpu.html" class="link header_register">登录</a>')
            }
        }
    });


    $('#f1 :button').on('click', function () {
        $.ajax({
            url: './upUser?userId=' + userId + '',
            data: $("#f1").serialize(),
            success: function (result) {
                if (result.code == 500) {
                    alert(result.message);
                } else {
                    alert("修改成功");
                    window.location.href = 'user-center.html?userId=' + userId + '';
                }
            }
        })
    })

});