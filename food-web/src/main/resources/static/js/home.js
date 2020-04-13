$(function () {
    $('#loging_shade').show();
});

$(document).on('click', '#login_test', function () {
    loginAdministrator();
    $('.pop_shade').css('display', 'none');
});

// 管理员登录
function loginAdministrator() {
    var account = $('#administratorAccount').val();
    var password = $('#administratorPassword').val();
    if (account != "" && password != "") {
        $.ajax({
            url: './login_administrator',
            type: 'post',
            data: {administratorAccount: account, administratorPassword: password},
            success: function (result) {
                pop(result.message);
            }
        });
    }
}

function loginFrm() {

}

// 弹窗
function pop(text) {
    $('.pop').text(text);
    $('.pop').fadeIn();
    setTimeout(function () {
        $('.pop').fadeOut();
    }, 1000);
}