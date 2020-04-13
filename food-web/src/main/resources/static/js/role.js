$(function () {
    $('.pop').css("display", "none");
    listAdministrator();
});

// 添加管理员
$(document).on('click', '#addAdmin', function () {
    // $("#up_role").get(0).selectedIndex = 1;
    $('#add_pop').css("display", "flex");
});

// 添加管理员-提交
$(document).on('click', '#add_data', function () {
    var flag = true;

    $(".adminInfo_add").each(function () {
        if ($(this).val() == '') {
            popMessage('请填写完整信息！');
            flag = false;
            return false;
        }
        if ($('#add_role option:selected').val() == "请选择") {
            popMessage('请选择角色！');
            flag = false;
            return false;
        }
    });
    if (flag == true) {
        addAdminAdmin();
        setTimeout(function () {
            authorityRole();
        }, 3000); // 延时5秒
        $('#add_pop').css("display", "none");
        popMessage("提交成功");
    }

});

// 添加管理员-取消
$(document).on('click', '#add_close', function () {
    $('#add_pop').css("display", "none");
});

// 查看
$(document).on('click', '.selectAdmin', function () {
    selectAdminById($(this).attr("id"));
});

// 修改信息
$(document).on('click', '.upAdmin', function () {
    var id1 = $(this).attr("id") + "";
    var id2 = id1.substring(2);
    upSelectAdminById(id2);
    $("#up_id").attr("disabled", true);
    $("#up_account").attr("disabled", "disabled");
    $('#up').css("display", "flex");
});

// 修改-提交
$(document).on('click', '#up_data', function () {
    var flag = true;
    $(".adminInfo_up").each(function () {
        if ($(this).val() == '') {
            popMessage('请填写完整信息！');
            flag = false;
            return false;
        }
        if ($('#up_role option:selected').val() == "请选择") {
            popMessage('请选择角色！');
            flag = false;
            return false;
        }
    });
    if (flag == true) {
        upAdminAdminById();
        upRoleById();
        $('#up').css("display", "none");
        popMessage("提交成功");
    }

});

// 修改-取消
$(document).on('click', '#up_close', function () {
    $('#up').css("display", "none");
    $("#up_id").removeAttr("disabled");
    $("#up_account").removeAttr("disabled");
});


function listAdministrator() {

    $.ajax({
        url: './list_administrator',
        type: 'get',
        success: function (result) {
            $.each(result.data, function (index, obj) {
                $('#administrator').append(
                    '<tr >' +
                    '<td>' + obj.administratorName + '</td>' +
                    '<td>' + obj.role.roleAuthority + '</td>' +
                    '<td>' +
                    '<button class="btn btn-primary selectAdmin" id="' + obj.administratorId + '">查看</button>' +
                    '<span>|</span>' +
                    '<button class="btn btn-primary upAdmin" id="up' + obj.administratorId + '">修改信息</button>' +
                    '<span>|</span>' +
                    '<button class="btn btn-primary">分配角色</button>' +
                    '<span>|</span>' +
                    '<button class="btn btn-primary">刷新</button>' +
                    '</td>' +
                    '</tr>' +
                    '<tr>' +
                    '</tr>' +
                    '<tr style="display: none" id="tr' + obj.administratorId + '">' +
                    '<td>' +
                    '<div>ID：' + obj.administratorId + '</div>' +
                    '<div>Name：' + obj.administratorName + ' </div>' +
                    '<div>Sex：' + obj.administratorSex + ' </div>' +
                    '</td>' +
                    '<td>' +
                    '<div>Account：' + obj.administratorAccount + '</div>' +
                    '<div>Password：' + obj.administratorPassword + '</div>' +
                    '<div>Role：' + obj.role.roleAuthority + '</div>' +
                    '</td>' +
                    '<td>' +
                    '<div>Email：' + obj.administratorEmail + '</div>' +
                    '<div>Tel：' + obj.administratorTel + '</div>' +
                    '</td>' +
                    '</tr>'
                );
            });
        }
    });
}


function selectAdminById(id) {
    if (($("#tr" + id).css('display')) === 'none') {
        $("#tr" + id).css('display', '');
    } else {
        $("#tr" + id).css('display', 'none');
    }
}

function upSelectAdminById(id) {
    $.ajax({
        url: './select_administrator',
        type: 'get',
        data: {administratorId: id},
        success: function (result) {
            $('#up_id').val(result.data.administratorId);
            $('#up_account').val(result.data.administratorAccount);
            $('#up_password').val(result.data.administratorPassword);
            $('#up_name').val(result.data.administratorName);
            $('#up_sex').val(result.data.administratorSex);
            $('#up_email').val(result.data.administratorEmail);
            $('#up_tel').val(result.data.administratorTel);
            if ("超级管理员" == result.data.role.roleAuthority) {
                $("#up_role option[value='超级管理员']").prop("selected", true);
            } else {
                $("#up_role option[value='管理员']").prop("selected", true);
            }
        }
    });
}

function upAdminAdminById() {
    $.ajax({
        url: './up_administrator',
        type: 'post',
        data: {
            administratorId: $('#up_id').val(), administratorAccount: $('#up_account').val(),
            administratorPassword: $('#up_password').val(), administratorName: $('#up_name').val(),
            administratorSex: $('#up_sex').val(), administratorEmail: $('#up_email').val(),
            administratorTel: $('#up_tel').val()
        },
        success: function (result) {
            console.log(result.message);
        }
    });
}

function upRoleById() {
    $.ajax({
        url: './up_role',
        type: 'post',
        data: {administratorId: $('#up_id').val(), roleAuthority: $('#up_role option:selected').val()},
        success: function (result) {
            console.log(result.message);
        }
    });
}

function addAdminAdmin() {
    $.ajax({
        url: './add_administrator',
        type: 'post',
        data: {
            administratorId: $('#add_id').val(), administratorAccount: $('#add_account').val(),
            administratorPassword: $('#add_password').val(), administratorName: $('#add_name').val(),
            administratorSex: $('#add_sex').val(), administratorEmail: $('#add_email').val(),
            administratorTel: $('#add_tel').val()
        },
        success: function (result) {
            console.log(result.message);
        }
    });
}

function authorityRole() {
    $.ajax({
        url: './authority_role',
        type: 'post',
        data: {administratorAccount: $('#add_account').val(), roleAuthority: $('#add_role option:selected').val()},
        success: function (result) {
            console.log(result.message);
        }
    });
}


// 弹窗
function popMessage(text) {
    $('.pop_message').text(text);
    $('.pop_message').fadeIn();
    setTimeout(function () {
        $('.pop_message').fadeOut();
    }, 1000);
}