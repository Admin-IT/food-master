$(function () {
    $.ajax({
        url: './food_info',
        type: 'get',
        data: {'pageNum': 1, 'pageSize': 10},
        success: function (result) {
            if (result.code == 500) {
                alert(result.message);
            } else {
                //渲染表格
                addTable(result.data);
                //渲染分页
                page(result.data);
            }
        }
    });

    $(document).on("click", ".btnLook", function () {
        var id = $(this).attr("data-id");
        alert(id);
        $('#myModal').modal("show");
    })
})

//渲染表格
function addTable(pageInfo) {
    $('#all_list tr:not(:first)').remove();
    $.each(pageInfo.list, function (index, obj) {
        index = index + 1;
        $('#tbodys').append(
            '<tr>' +
            '<td>' + index + '</td>' +
            '<td>' + obj.foodId + '</td>' +
            '<td>' + obj.foodName + '</td>' +
            '<td>' + obj.foodCuisine + '</td>' +
            '<td>' + obj.foodClassified + '</td>' +
            '<td>' + obj.userId + '</td>' +
            '<td><button name="select-btn" class="btn btn-info select-btn btnLook" value="" data-id="' + obj.foodId + '">查看详情</button></td>' +
            '</tr>'
        );
    });
}

//分页
function page(pageInfo) {
    $("#page").pagination(pageInfo.total, { //第一个参数指定共多少条记录
        items_per_page: pageInfo.pageSize, // 每页显示多少条记录
        next_text: ">", //下一页按钮图标
        prev_text: "<", //上一页按钮图标
        num_display_entries: 5,//主体页数
        num_edge_entries: 2, //边缘页数
        callback: function (index) {//定义一个回调函数，用于每次点击页码发起分页查询请求
            //index为当前页码，只不过下标是从0开始，因此需要+1操作
            var pageNum = ++index;
            $.ajax({
                url: './food_info',
                method: 'get',
                data: {'pageNum': pageNum, 'pageSize': 10},
                success: function (result) {
                    //渲染表格
                    addTable(result.data);
                }
            });
        }
    })
}


