<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table id="userfenshuTable"></table>
<script type="text/javascript">
var u_id='${uid}';
// var userfenshunamagers=userfenshunamager+"${uid}";
	if (typeof (userfenshunamager) != "undefined") {
		userfenshunamager.init();
	} else {
		var userfenshunamager = {
			createTable : function() {
				KX.createTable({
					id : 'userfenshuTable',
					url : '<%=path%>/user/listview?id='+u_id,
					columns : [ [ {
						field : 'id',
						title : 'id',
						width : 30,
						hidden : true
					}, {
						field : 'tablename',
						title : 'tablename',
						width : 60,
						hidden : true
					},{
						field : 'filename',
						title : 'filename',
						hidden : true
					}, {
						field : 'kinds',
						title : 'kinds',
						width : 60,
						hidden : true
					} ,{
						field : 'view',
						title : '界面',
						width : 60,
						align : 'center'
					}] ],
					showCheckBox : true,
					viewFuc : function(rowIndex, rowData) {
						KX.showDialog(800, 600, "查看", "<%=path%>/user/listquestion?id="+u_id+"&tablename="+rowData.tablename+"&kinds="+rowData.kinds, "查看问题得分", "search",
							[ {
								text: '取消',
								iconCls: 'icon-cancel',
								handler: function(){
									KX.closeDialog();
								}
							} ]
						);
					},
					downcarcaseexcel : function(rowDatas){
						$.messager.confirm('操作提示', '确认生成excel文档？', function(r){
							if(r){
								var ids = "";
								var tablenames = "";
								var kinds = "";
								var filenames="";
								for ( var i = 0; i < rowDatas.length; i++) {
									ids += "," + rowDatas[i].id;
									tablenames+= "," + rowDatas[i].tablename;
									kinds+="," + rowDatas[i].kinds;
									filenames+="," + rowDatas[i].filename;
								}	
								tablenames=tablenames.substring(1);
								kinds=kinds.substring(1);
								filenames=filenames.substring(1);
								$.post("<%=path%>/user/createStudentexcel", {"id" : u_id,"tablename":tablenames,"kinds":kinds,"filename":filenames},function(data) {
									if(data[0].ok=="ok"){
										$.messager.confirm('操作提示', '确认下载成功的文件'+data[0].filename+'？', function(r){
												if(r){
													window.open("<%=path%>/user/fileload?fileurl="+data[0].fileurl+"&type=u");
												}
											});
											$.messager.alert('操作提示','题目：'+data[0].shibaiuser+'没有完成，生成失败！','info');
									} 
									else if(data[0].ok=="err"){
										$.messager.alert('操作提示','文件生成失败！','info');
									}
									else if(data[0].ok=="null"){
										$.messager.alert('操作提示','题目：'+data[0].shibaiuser+'没有完成，生成失败！没有成功的excel文件','info');
									}
									else{
										$.messager.alert('操作提示','该题还没完成，生成失败！','info');
									}
								},"json");
							}
						});
					}
				});
			},
			init : function() {
				userfenshunamager.createTable();
			}
		};
		userfenshunamager.init();
	}
</script>
