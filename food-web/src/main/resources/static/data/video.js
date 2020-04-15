$(function () {
    //显示全部
    $.ajax({
        url: './get_videos',
        method: 'get',
        data: {"pageNum": 1, "pageSize": 5},
        success: function (result) {
            if (result.code === 500) {
                alert(result.message)
            } else {
                //渲染表格
                addTable(result.data);
                //渲染分页
                page(result.data)
            }
        }
    });
    //搜索
    $('#find :button').on('click', function () {
        $.ajax({
            url: './find_videos',
            method: 'get',
            data: $('#find').serialize(),
            success: function (result) {
                if (result.code === 500) {
                    alert(result.message)
                } else {
                    $('#table_video tr:not(:first)').remove();
                    $('#page').attr("hidden", "hidden");
                    $.each(result.data, function (i, s) {
                        i = i + 1;
                        $('#tcontent').append(
                            '<tr>' +
                            '<td>' + i + '</td>' +
                            '<td>' + s.userId + '</td>' +
                            '<td>' + s.name + '</td>' +
                            '<td>' + s.label + '</td>' +
                            '<td>' + s.classified + '</td>' +
                            '<td>' + s.number + '</td>' +
                            '<td>' + s.time + '</td>' +
                            '<td>暂无</td>' +
                            '<td><button class="btn btn-info select-btn lookbtn" value="" data-video="' + s.name + '">查看详情</button></td>' +
                            '<td><button class="btn btn-danger delbtn" data-del="' + s.id + '">删除</button></td>' +
                            '<td><button class="btn btn-warning updbtn" data-step="' + s.id + '">详细做法</button></td>' +
                            '</tr>'
                        );
                    })
                }
            }
        })
    });
    //删除
    $(document).on('click', '.delbtn', function () {
        var videoId = parseInt($(this).attr("data-del"));
        $.ajax({
            url: './delete_video',
            method: 'post',
            data: {"videoId": videoId},
            success: function (result) {
                if (result.code === 500) {
                    alert(result.message)
                } else {
                    alert("删除成功！");
                    location.href = result.message;
                }
            }
        })
    });
    //视频详情
    $(document).on('click', '.lookbtn', function () {
        var name = $(this).attr("data-video");
        $('#video_src').attr("src", "upload/" + name);
        $('#myModal1').modal("show");
    });
    //详细做法
    $(document).on('click', '.updbtn', function () {
        var videoId = parseInt($(this).attr("data-step"));
        $.ajax({
            url: './get_steps',
            method: 'get',
            data: {"videoId": videoId},
            success: function (result) {
                if (result.code === 500) {
                    alert(result.message)
                } else {
                    $('#myModal2').modal("show");
                    $('#text').empty();
                    $.each(result.data, function (i, s) {
                        $('#text').val(s.method);
                        $('#receive_id').attr("value", videoId);
                    });
                }
            }
        })
    });
    //修改做法
    $('#upd :button').on('click', function () {
        $.ajax({
            url: './update_steps',
            method: 'post',
            data: $('#upd').serialize(),
            success: function (result) {
                if (result.code === 500) {
                    alert(result.message)
                } else {
                    alert("修改成功！");
                    location.href = result.message;
                }
            }
        })
    });
});


//渲染表格
function addTable(pageInfo) {
    $('#table_video tr:not(:first)').remove();
    $.each(pageInfo.list, function (i, s) {
        i = i + 1;
        $('#tcontent').append(
            '<tr>' +
            '<td>' + i + '</td>' +
            '<td>' + s.userId + '</td>' +
            '<td>' + s.name + '</td>' +
            '<td>' + s.label + '</td>' +
            '<td>' + s.classified + '</td>' +
            '<td>' + s.number + '</td>' +
            '<td>' + s.time + '</td>' +
            '<td>暂无</td>' +
            '<td><button class="btn btn-info select-btn lookbtn" value="" data-video="' + s.name + '">查看详情</button></td>' +
            '<td><button class="btn btn-danger delbtn" data-del="' + s.id + '">删除</button></td>' +
            '<td><button class="btn btn-warning updbtn" data-step="' + s.id + '">详细做法</button></td>' +
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
        num_display_entries: 2,//主体页数
        num_edge_entries: 3, //边缘页数
        callback: function (index) {//定义一个回调函数，用于每次点击页码发起分页查询请求
            //index为当前页码，只不过下标是从0开始，因此需要+1操作
            var pageNum = ++index;
            $.ajax({
                url: './get_videos',
                method: 'get',
                data: {'pageNum': pageNum, 'pageSize': 5},
                success: function (result) {
                    //渲染表格
                    addTable(result.data);
                }
            });
        }
    })
}

