$(function(){
    //使用datagrid绑定数据展示
    $('#dg').datagrid({
        title:">>>>已审核出租房管理",
        url:'/shenhe/getHouseByStarts',
        fitColumns: true,
        pagination: true,
        pageList: [5, 10, 15, 20],
        toolbar:"#ToolBar",
        //singleSelect:true,  //只能设置单选
        pageSize:5,
        columns: [[
            {field:'ck',checkbox:true},  //复选框列
            { field: 'id', title: '编号', width: 50, align: "center" },
            { field: 'title', title: '标题', width: 50, align: "center" },
            { field: 'price', title: '价格', width: 50, align: "center" },
            { field: 'floorage', title: '面积', width: 50, align: "center" },
            { field: 'dname', title: '区域', width: 50, align: "center" },
            { field: 'sname', title: '街道', width: 50, align: "center" },
            { field: 'tname', title: '类型', width: 50, align: "center" },
            { field: 'ispass', title: '状态', width: 50, align: "center" ,
                formatter:function(value,row,index){
                    return "已审核";
                }
            },
            { field: 'opt', title: '操作', width: 50, align: "center",
                formatter: function(value,row,index){
                    return "<a href='javascript:delSingle("+row.id+")'>审核</a>";
                }
            }
        ]]
    });
});
