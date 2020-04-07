$(function () {
    // 信息加载
    $.ajax({
        url: "./test",
        type: "get",
        success: function (result) {
            if (result.code == 200) {
                alert(result.message);
            }
        }
    });

});
