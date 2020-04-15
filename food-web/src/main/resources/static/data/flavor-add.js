$("#success-submit").click(function () {
    let serialize = $("#form_add").serialize();
    $.ajax({
        url: './add_flavor',
        data: $("#form_add").serialize(),
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