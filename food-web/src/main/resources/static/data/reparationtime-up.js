$("#success-submit").click(function () {
    let serialize = $("#form_add").serialize();
    $.ajax({
        url: './update_reparationtime',
        data: serialize,
        type: 'post',
        success: function (result) {
            if (result.code === 200) {
                alert(result.message);
            } else {
                alert(result.message);
            }
        }
    })
});
$("#select_bt").click(function () {
    let serialize = $("#form_add").serialize();
    $.ajax({
        url: './acquire_reparationtime',
        data: serialize,
        type: 'get',
        success: function (result) {
            console.log(result.data.name);
            if (result.code === 200) {
                $("input[name='name']").val(result.data.name);
            } else {
                alert(result.message);
            }
        }
    })
});