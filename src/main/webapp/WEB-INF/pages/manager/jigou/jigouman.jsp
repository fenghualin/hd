<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table id="jigoumanTable"></table>
<script type="text/javascript">
	if (typeof (jigoumanger) != "undefined") {
		jigoumanger.init();
	} else {
		var jigoumanger = {
			createTable : function() {
				KX.createTable({
					id : 'jigoumanTable',
					url : '<%=path%>/jigou/jigoudata',
					columns : [ [ {
						field : 'id',
						title : 'id',
						width : 30,
						hidden : true
					}, {
						field : 'name',
						title : '机构名',
						width : 60,
						align : 'center'
					}, {
						field : 'describe',
						title : '描述',
						width : 60,
						align : 'center'
					}
					] ],
					showCheckBox : true,
					createFuc : function() {
						KX.showDialog(400, 300, '添加机构', '<%=path%>/jigou/jigouadd?chaozuo=add', '添加机构', 'add',
							[ {
								text : '添加',
								iconCls : 'icon-ok',
								handler : function() {
									var jigou_name = $("#jigou_name").val();
									var jigou_describe = $("#jigou_describe").val();
									$.post("<%=path%>/jigou/jigouadddata",{"jigou_name":jigou_name,"jigou_describe":jigou_describe},function(data){
										if (data=="ok") {
											$.messager.alert('操作提示','添加成功！','info');
										} else {
											$.messager.alert('操作提示','添加失败！','info');
										}
										KX.refreshTable('jigoumanTable');
										KX.closeDialog();
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
						$.messager.confirm('操作提示', '确认删除该机构？', function(r){
							if(r){
								var ids = "";
								for ( var i = 0; i < rowDatas.length; i++) {
									ids += "," + rowDatas[i].id;
								}
								$.post("<%=path%>/jigou/jigoudelete", {"id" : ids.substring(1)},function(data) {
									if (data=="ok") {
										$.messager.alert('操作提示','删除成功！','info');
									} else {
										$.messager.alert('操作提示','删除失败！','info');
									}
									KX.refreshTable('jigoumanTable');
								});
							}
						});
					},
					viewFuc : function(rowIndex, rowData) {
						KX.showDialog(400, 300, "查看", "<%=path%>/jigou/jigouadd?chaozuo=look&id="+rowData.id, "查看机构", "search",
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
						KX.showDialog(400, 300, '修改机构', "<%=path%>/jigou/jigouadd?chaozuo=update&id="+rowData.id, '机构类容',
							'search', [ {
								text : '修改',
								iconCls : 'icon-ok',
								handler : function() {
									var jigou_name = $("#jigou_name").val();
									var jigou_describe = $("#jigou_describe").val();
									var jigou_id = $("#jigou_id").val();
									$.post("<%=path%>/jigou/jigouupdate",{"jigou_id":jigou_id,"jigou_name":jigou_name,"jigou_describe":jigou_describe},function(data){
										if (data=="ok") {
											$.messager.alert('操作提示','修改成功！','info');
										} else {
											$.messager.alert('操作提示','修改失败！','info');
										}
										KX.refreshTable('jigoumanTable');
										KX.closeDialog();
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
				jigoumanger.createTable();
			}
		};
		jigoumanger.init();
	}
</script>
