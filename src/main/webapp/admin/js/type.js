$(function () {
    $('#dg').datagrid({
        url:'/koo/query',
        pagination:true,
        pageList:[3,6,9,12],
        pageSize:5,
        toolbar:"#ToolBar",
        //singleSelect:true,//只能设置单选
        columns:[[
            { field : 'ck', checkbox : true },
            {field:'id',title:'编号',width:100},
            {field:'name',title:'姓名',width:100},
            {field:'opt',title:'操作',width:100,
                formatter:function (vlaue,row,index) {
                    return "<a href='javascript:deletewu("+row.id+")'>删除</a>";
                }
            }
        ]]
    });
});
function Add() {
    $("#AddDialog").dialog("open").dialog('setTitle',"添加房屋");
}

function CloseDialog(obj){
    $("#"+obj).dialog("close");
}

//保存
function SaveDialog(){
    //跳转到后台实现保存
    //传统:取值-->通过$.ajax方法发送异步请求实现添加
    $('#ModiyDialogForm').form('submit', {
        url:"/koo/add",  //提交的服务器地址
        success:function(data){ //成功的回调函数
            //data接收服务器返回值json字符串（不是json对象）
            var obj=$.parseJSON(data);
            if(obj.result>0){
                $("#AddDialog").dialog("close");  //关闭
                //alert("添加成功");
                $("#dg").datagrid('reload'); //刷新
                $.messager.alert('提示框','恭喜添加成功!');
            }
            else
            {
                $.messager.alert('提示框','系统正在维护!');
            }
        }
    });
}
//弹出修改对话框
function ModifyBySelect(){
    //判断有没有选择修改的记录
    //获取所有选中行，返回的数据，如果没有选中返回空
    var SelectRows = $("#dg").datagrid('getSelections');
    if(SelectRows.length!=1){
        $.messager.alert('提示框','你还没有选中行，或者选择了多行');
        return;
    }
    //选择了一行
    //还原数据
    var SelectRow = SelectRows[0];  //获取当前行的json:{"id":1000,"name":"丰台"}
    //打开编辑对话框
    $("#UpDialog").dialog("open").dialog('setTitle',"修改区域");
    //获得行对象的数据加载到表单中显示
    //注意:SelectRow表示的就是当前行的Json:{"id":1000,"name":"丰台"}
    // 表单对象名称与json对象的键相同即可还原
    $("#ModiyDialogForm1").form('load',SelectRow);

}

function ModifyBySelect1(){
    //跳转到后台实现保存
    //传统:取值-->通过$.ajax方法发送异步请求实现添加
    $('#ModiyDialogForm1').form('submit', {
        url:"/koo/update",  //提交的服务器地址
        success:function(data){ //成功的回调函数
            //data接收服务器返回值json字符串（不是json对象）
            var obj=$.parseJSON(data);
            if(obj.result>0){
                $("#UpDialog").dialog("close");  //关闭
                //alert("添加成功");
                $("#dg").datagrid('reload'); //刷新
                $.messager.alert('提示框','恭喜添加成功!');
            }
            else
            {
                $.messager.alert('提示框','系统正在维护!');
            }
        }
    });
}

function DeleteByFruitName(){
    //判断有无选中行
    var SelectRows = $("#dg").datagrid('getSelections');
    if(SelectRows.length==0){
        $.messager.alert('提示框','你还没有选中行,操作过细点');
        return;
    }

    //获取选中项的值   拼成:1,2,3
    var delValue="";
    for(var i=0;i< SelectRows.length;i++){
        delValue=delValue+SelectRows[i].id+",";
    }
    delValue=delValue.substring(0,delValue.length-1);

    //alert(delValue);

    //发送异步请求到服务器
    $.post("/koo/delete",{"ids":delValue},function(data){
        if(data.result>0){
            $("#dg").datagrid('reload'); //刷新
            //alert("添加成功");
            $.messager.alert('提示框','恭喜你成功删除'+data.result+'行!');
        }
        else
        {
            $.messager.alert('提示框','系统正在维护!');
        }
    },"json");
}
