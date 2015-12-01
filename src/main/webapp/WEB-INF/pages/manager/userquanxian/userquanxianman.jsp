<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table id="userquanxianTable"></table>
<script type="text/javascript">
	if (typeof (userquanxian) != "undefined") {
		userquanxian.init();
	} else {
		var userquanxian = {
			createTable : function() {
				KX.createTable({
					id : 'userquanxianTable',
					url : '<%=path%>/group/userquanxianadata',
					columns : [ [ {
						field : 'id',
						title : 'id',
						width : 30,
						hidden : true
					}, {
						field : 'name',
						title : '权限名称',
						width : 40,
						align : 'center'
					} ] ],
					showCheckBox : true,
					createFuc : function() {
						KX.showDialog(600, 500, '添加权限', '<%=path%>/group/userquanxianadd', '添加权限', 'add',
							[ {
								text : '添加',
								iconCls : 'icon-ok',
								handler : function() {
									var mokuaiid="";
									var groupname=$("#quanxuanname").val();
									$("[name='checkbox']").each(function(i,o){
										if($(o).attr("checked") == "checked"){
											mokuaiid=mokuaiid+","+$(o).val();
										}
									});
									mokuaiid=mokuaiid.substring(1);
									$.post("<%=path%>/group/userquanxiasave",{"mokuaiid":mokuaiid,"groupname":groupname},function(data){
										if(data=="ok"){
											$.messager.alert('操作提示','添加成功！','info');
											KX.refreshTable('userquanxianTable');
											KX.closeDialog();
										}
										else{
											$.messager.alert('操作提示','添加失败！','info');
											KX.refreshTable('userquanxianTable');
											KX.closeDialog();
										}
									});
								}
							}, {
								text : '取消',
								iconCls : 'icon-cancel',
								handler : function() {
									KX.closeDialog();
								}
							} ]
						);
					},
					modifyFuc : function(rowIndex, rowData) {
					},
					deleteFuc : function(rowDatas) {
						$.messager.confirm('操作提示', '确认删除该权限？', function(r){
							if(r){
							 	var ids = "";
								for ( var i = 0; i < rowDatas.length; i++) {
									ids += "," + rowDatas[i].id;
								}
								ids=ids.substring(1);
								$.post("<%=path%>/group/groupdelete", {"groupid" : ids},function(data) {
									if (data=="ok") {
										$.messager.alert('操作提示','删除成功！','info');
									} else {
										$.messager.alert('操作提示','删除失败！','info');
									}
									KX.refreshTable('userquanxianTable');
								});
							}
						});
					},
					viewFuc : function(rowIndex, rowData) {
						KX.showDialog(600, 500, "查看", '<%=path%>/group/groupupdateui?chaozuo=look&gid='+rowData.id, "查看问题类容", "search",
							[ {
								text: '取消',
								iconCls: 'icon-cancel',
								handler: function(){
									KX.closeDialog();
								}
							} ]
						);
					},
					modifyFuc : function(rowIndex, rowData) {
						KX.showDialog(600, 500, '修改权限', '<%=path%>/group/groupupdateui?chaozuo=update&gid='+rowData.id, '权限类容',
							'search', [ {
								text : '修改',
								iconCls : 'icon-ok',
								handler : function() {
									var mokuaiid="";
									var groupname=$("#quanxuanname").val();
									$("[name='checkbox']").each(function(i,o){
										if($(o).attr("checked") == "checked"){
											mokuaiid=mokuaiid+","+$(o).val();
										}
									});
									mokuaiid=mokuaiid.substring(1);
									$.post("<%=path%>/group/groupupdate",{"groupid":rowData.id,"mokuaiid":mokuaiid,"groupname":groupname},function(data){
										if(data=="ok"){
											$.messager.alert('操作提示','修改成功！','info');
											KX.refreshTable('userquanxianTable');
											KX.closeDialog();
										}
										else{
											$.messager.alert('操作提示','修改失败！','info');
											KX.refreshTable('userquanxianTable');
											KX.closeDialog();
										}
									});
								}
							}, {
								text : '取消',
								iconCls : 'icon-cancel',
								handler : function() {
									KX.closeDialog();
								}
							} ]
						);
					}
				});
			},
			init : function() {
				userquanxian.createTable();
			}
		};
		userquanxian.init();
	}
</script>
