var array = new Array(); //数组
//js中的二维数组的下标可以使字符串
array['北京市'] = ["朝阳区", "昌平区", "海淀区"];
array['山东省'] = ["青岛市", "烟台市", "泰安市"];
array['河南省'] = ["郑州市", "洛阳市", "开封市"];
array['河北省'] = ["石家庄市", "唐山市", "邢台市"];
array['广东省'] = ["广州市", "汕头市", "湛江市", "江门市", "佛山市", "韶关市", "茂名市", "肇庆市", "惠州市", "珠海市", "深圳市", "潮州市", "中山市", "东莞市", "汕尾市", "阳江市", "河源市"];
array['湖北省'] = ["武汉市", "黄石市", "襄阳市", "荆州市", "宜昌市", "十堰市", "孝感市", "荆门市", "鄂州市", "黄冈市", "咸宁市", "随州市"];

function initProvince() {
    for (var i in array) {
        var provinceObj = document.getElementById("province");
        //创建一个选项
        /**
         * 参数一是：展示数据
         * 参数二是：value属性的值
         */
        var option = new Option(i, i); //jquery
        provinceObj.add(option); //把创建的option添加到下拉列表中

    }
}

function changeCity() {
    var provinceName = document.getElementById("province").value;
    //得到第一个下拉列表的值
    var city = document.getElementById("city")``;
    //清空第二个下拉列表
    //方法一
    //city.innerHTML = "";
    //方法二
    city.options.length = 1;
    for (var p in array) {
        if (p == provinceName) {
            //遍历每个省份的城市
            for (var c in array[p]) {
                //创建一个option
                var option = new Option(array[p][c], array[p][c]);
                var city = document.getElementById("city");
                city.add(option);
            }
        }
    }
}

function initProvinces() {
    for (var i in array) {
        var provinceObj = document.getElementById("local_province");
        //创建一个选项
        /**
         * 参数一是：展示数据
         * 参数二是：value属性的值
         */
        var option = new Option(i, i); //jquery

        provinceObj.add(option); //把创建的option添加到下拉列表中

    }
}

function changeCitys() {
    var provinceName = document.getElementById("local_province").value;
    //得到第一个下拉列表的值
    var city = document.getElementById("local_city");
    //清空第二个下拉列表
    //方法一
    //city.innerHTML = "";
    //方法二
    city.options.length = 1;
    for (var p in array) {
        if (p == provinceName) {
            //遍历每个省份的城市
            for (var c in array[p]) {
                //创建一个option
                var option = new Option(array[p][c], array[p][c]);
                var city = document.getElementById("local_city");
                city.add(option);
            }
        }
    }
}