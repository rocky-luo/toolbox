/**
 * Created by rocky on 17/2/24.
 */

$(document).ready(function(){
    // bind
    bind();
    postInit();
});

//绑定事件
function bind() {
    //绑定数据库select
    $("#databases").change(function () {
        database =  $(this).val();
        console.log(database);
        $.ajax({
            url:"/mysql/tables",
            data:{
                database:database
            },
            success:function(data){
                console.log(data);
                $tables = $("#tables");
                $tables.empty();
                d = JSON.parse(data);
                for (i in d.data){
                    v = d.data[i];
                    $option = $("<option>").val(v).text(v);
                    if (i==0) {
                        $option.attr("selected",true);
                    }
                    $tables.append($option);
                }
            }
        })

    });
    //绑定javabean按钮
    $("#javabean-bn").click(function(){
        $code = $("#code-block");
        database = $("#databases").val();
        table = $("#tables").val();
        $code.empty();
        $.ajax({
            url:"/mysql/javabean",
            data:{
                database:database,
                table:table
            },
            success:function (data) {
                d = JSON.parse(data);
                $code.text(d.data);
            }
        });
    });

    //绑定mapper按钮
    $("#mapper-bn").click(function(){
        $code = $("#code-block");
        database = $("#databases").val();
        table = $("#tables").val();
        $code.empty();
        $.ajax({
            url:"/mysql/mapper",
            data:{
                database:database,
                table:table
            },
            success:function (data) {
                d = JSON.parse(data);
                $code.text(d.data);
            }
        });
    });

    //绑定dao按钮
    $("#dao-bn").click(function(){
        $code = $("#code-block");
        database = $("#databases").val();
        table = $("#tables").val();
        $code.empty();
        $.ajax({
            url:"/mysql/dao",
            data:{
                database:database,
                table:table
            },
            success:function (data) {
                d = JSON.parse(data);
                $code.text(d.data);
            }
        });
    });


    databaseSelectInit();
}

function postInit() {
    $("#databases").change();
}

//初始化数据库select
function databaseSelectInit() {
    $databases = $("#databases");
    $databases.empty();
    $.ajax({
        url:"/mysql/databases",
        async:false,
        success:function(data) {
            d = JSON.parse(data);
            for (i in d.data) {
                v = d.data[i];
                $option = $("<option>").val(v).text(v);
                if (i == 0) {
                    $option.attr("selected",true);
                }
                $databases.append($option);
            }
        }
    })
}