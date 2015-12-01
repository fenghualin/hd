<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table id="usermanagerTable"></table>
<div id="search_alluser" style="width:120px">
	<div data-options="name:'username'">学生编号</div>
	<div data-options="name:'name'">学生姓名</div>
	<div data-options="name:'yidongdianhua'">手机号码</div>
	<div data-options="name:'email'">邮箱</div>
	<div data-options="name:'stu_jigou'">
		  <span>机构</span>
	    <div>
	    	<c:forEach items="${jigoulist}" var="jigoulist">
	        <div class="allgoodsStates" data-options="name:'jigou'" data-val="${jigoulist.id}">${jigoulist.name }</div>
	        </c:forEach>
	    </div>
	</div>
</div>
<div class="jigouval" style="display: none;"></div>
<style type="text/css">
a:hover.l-btn-plain{
	background:none;
	border:1px solid transparent;
}
</style>  
<script type="text/javascript">
var jigouval="";
var tab_index=0;
	$(".allgoodsStates").click(function(){
		var v=$(this).text();
		jigouval=$(this).attr("data-val");
// 		var dataoptions="menu:'#search_alluser',prompt:'"+v+"',searcher:function (value, name) {value = $.trim(value);var q = $('#usermanagerTable').datagrid('options').queryParams;q.querykey = name;q.queryval = value;if (name == 'state' && value !='') return; if (name == 'name' && /^[A-Za-z0-9']+$/.test(value)) { q.queryName = 'pinyin';q.queryValue = value.split('').join('%');}KX.freshTable('usermanagerTable');}";
// 		$("#searchAllUser").attr('data-options',dataoptions);
		$(".searchbox-text").val(v).removeClass("searchbox-prompt");
	});
	if (typeof (usernamager) != "undefined") {
		usernamager.init();
	} else {
		var usernamager = {
			createTable : function() {
				KX.createTable({
					id : 'usermanagerTable',
					url : '<%=path%>/user/userlist',
// 					select : {
// 						w : 150,
// 						url : '<%=path%>/user/jigoudata',
// 						text : 'name',
// 						value : 'value',
// 						onSelected : function(record){
// 							var q = $('#usermanagerTable').datagrid('options').queryParams;
// 							q.queryValue = record.value;
// 							$('#usermanagerTable').datagrid('load');
// 						}
// 					},
					searcher : {
						c : 'searchAllUser',
						w : 300,
						m : 'search_alluser',
						f : function(value, name) {
							value = $.trim(value);
							var q = $('#usermanagerTable').datagrid('options').queryParams;
							q.querykey = name;
							if(name=='jigou'){
								q.queryval = jigouval;
							}
							else q.queryval = value;
							if (name == 'state' && value !='')
								return;
							if (name == 'name' && /^[A-Za-z0-9']+$/.test(value)) {
								q.queryName = 'pinyin';
								q.queryValue = value.split('').join('%');
							}
							KX.freshTable('usermanagerTable');
						}
					},
					columns : [ [ {
						field : 'id',
						title : 'id',
						width : 30,
						hidden : true
					}, {
						field : 'username',
						title : '用户名',
						sortable : 'true',
						width : 60,
						align : 'center'
					}, {
						field : 'name',
						title : '姓名',
						width : 60,
						align : 'center'
					} , {
						field : 'xingbie',
						title : '性别',
						width : 60,
						sortable : 'true',
						align : 'center'
					}, {
						field : 'nianling',
						title : '年龄',
						sortable : 'true',
						width : 60,
						align : 'center'
					}, {
						field : 'xueli',
						title : '学历',
						width : 60,
						sortable : 'true',
						align : 'center'
					}, {
						field : 'nianji',
						title : '年纪',
						sortable : 'true',
						width : 60,
						align : 'center'
					}, {
						field : 'banji',
						title : '班级',
						sortable : 'true',
						width : 60,
						align : 'center'
					}, {
						field : 'jigou',
						title : '所属机构',
						sortable : 'true',
						width : 60,
						align : 'center'
					}, {
						field : 'isuse',
						title : '是否使用',
						sortable : 'true',
						width : 60,
						align : 'center',
						formatter : function(value, row, index) {
							return KX.isuse(value);
						}
					}, {
						field : 'wancheng_time',
						title : '测试完成时间',
						sortable : 'true',
						width : 60,
						align : 'center'
					}] ],
					showCheckBox : true,
					createFuc : function() {
						KX.showDialog(800, 600, '添加用户', '<%=path%>/user/userAddui?type=add', '添加用户', 'add',
							[ {
								text : '添加',
								iconCls : 'icon-ok',
								handler : function() {
									var u_name=$("#u_name").val();
									var u_username=$("#u_username").val();
									var u_password=$("#u_password").val();
									var u_nianling=$("#u_nianling").val();
									var u_xingbie = $('input[name="u_xingbie"]:checked').val();
									var u_minzu=$("#u_minzu").val();
									var u_xueli=$("#u_xueli").val();
									var u_banji=$("#u_banji").val();
									var u_nianji=$("#u_nianji").val();
									var u_xueshengleixing=$("#u_xueshengleixing").val();
									var u_yuanxuexileixing=$("#u_yuanxuexileixing").val();
									var u_shenfenzheng=$("#u_shenfenzheng").val();
									var u_fuqinxingming=$("#u_fuqinxingming").val();
									var u_muqinxingming=$("#u_muqinxingming").val();
									var u_muqinnianling=$("#u_muqinnianling").val();
									var u_fuqinnianling=$("#u_fuqinnianling").val();
									var u_danwei=$("#u_danwei").val();
									var u_gudingdianhua=$("#u_gudingdianhua").val();
									var u_yidongdianhua=$("#u_yidongdianhua").val();
									var u_email=$("#u_email").val();
									var u_dizhi=$("#u_dizhi").val();
									var u_tingli=$("#u_tingli").val();
									var u_shili=$("#u_shili").val();	
									var u_sejue=$("#u_sejue").val();
									var u_money=$("#u_money").val();
									var u_jigou=$("#u_jigou").val();
									var u_group=$("#u_group").val();
									$.post("<%=path%>/user/userAdd",{"u_group":u_group,"u_jigou":u_jigou,"u_name":u_name,"u_username":u_username,"u_password":u_password,"u_xingbie":u_xingbie,"u_nianling":u_nianling,"u_minzu":u_minzu,
									"u_xueli":u_xueli,"u_banji":u_banji,"u_nianji":u_nianji,"u_xueshengleixing":u_xueshengleixing,"u_yuanxuexileixing":u_yuanxuexileixing,"u_shenfenzheng":u_shenfenzheng,
									"u_fuqinxingming":u_fuqinxingming,"u_muqinxingming":u_muqinxingming,"u_muqinnianling":u_muqinnianling,"u_fuqinnianling":u_fuqinnianling,"u_money":u_money,
									"u_danwei":u_danwei,"u_gudingdianhua":u_gudingdianhua,"u_yidongdianhua":u_yidongdianhua,"u_email":u_email,"u_dizhi":u_dizhi,"u_tingli":u_tingli,"u_shili":u_shili,"u_sejue":u_sejue
									},function(data){
										if(data=="ok"){
											$.messager.alert('操作提示','用户添加成功！','info');
											KX.refreshTable('usermanagerTable');
											KX.closeDialog();
										}
										else{
											$.messager.alert('操作提示','用户添加失败！','info');
											KX.refreshTable('usermanagerTable');
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
						$.messager.confirm('操作提示', '确认删除该用户？', function(r){
							if(r){
								var ids = "";
								for ( var i = 0; i < rowDatas.length; i++) {
									ids += "," + rowDatas[i].id;
								}
								$.post("<%=path%>/user/userdelete", {"id" : ids.substring(1)},function(data) {
									if (data=="ok") {
										$.messager.alert('操作提示','删除成功！','info');
									} else {
										$.messager.alert('操作提示','删除失败！','info');
									}
									KX.refreshTable('usermanagerTable');
								});
							}
						});
					},
					viewFuc : function(rowIndex, rowData) {
						KX.showDialog(800, 600, "查看", "<%=path%>/user/userlook?type=look&id="+rowData.id, "查看用户信息", "search",
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
						KX.showDialog(800, 600, '修改用户', "<%=path%>/user/userlook?type=update&id="+rowData.id, '用户信息',
							'search', [ {
								text : '修改',
								iconCls : 'icon-ok',
								handler : function() {
									var u_name=$("#u_name").val();
									var u_id=$("#u_id").val();
									var u_username=$("#u_username").val();
									var u_password=$("#u_password").val();
									var u_nianling=$("#u_nianling").val();
									var u_xingbie = $('input[name="u_xingbie"]:checked').val();
									var u_minzu=$("#u_minzu").val();
									var u_xueli=$("#u_xueli").val();
									var u_banji=$("#u_banji").val();
									var u_nianji=$("#u_nianji").val();
									var u_xueshengleixing=$("#u_xueshengleixing").val();
									var u_yuanxuexileixing=$("#u_yuanxuexileixing").val();
									var u_shenfenzheng=$("#u_shenfenzheng").val();
									var u_fuqinxingming=$("#u_fuqinxingming").val();
									var u_muqinxingming=$("#u_muqinxingming").val();
									var u_muqinnianling=$("#u_muqinnianling").val();
									var u_fuqinnianling=$("#u_fuqinnianling").val();
									var u_danwei=$("#u_danwei").val();
									var u_gudingdianhua=$("#u_gudingdianhua").val();
									var u_yidongdianhua=$("#u_yidongdianhua").val();
									var u_email=$("#u_email").val();
									var u_dizhi=$("#u_dizhi").val();
									var u_tingli=$("#u_tingli").val();
									var u_shili=$("#u_shili").val();	
									var u_sejue=$("#u_sejue").val();
									var u_money=$("#u_money").val();
									var u_jigou=$("#u_jigou").val();
									var u_group=$("#u_group").val();
									var u_zuotijindu=$("#u_zuotijindu").val();
									var u_iswancheng=$("#u_iswancheng").val();
									$.post("<%=path%>/user/userupdate",{"u_group":u_group,"u_jigou":u_jigou,"u_id":u_id,"u_name":u_name,"u_username":u_username,"u_password":u_password,"u_xingbie":u_xingbie,"u_nianling":u_nianling,"u_minzu":u_minzu,
									"u_xueli":u_xueli,"u_banji":u_banji,"u_nianji":u_nianji,"u_xueshengleixing":u_xueshengleixing,"u_yuanxuexileixing":u_yuanxuexileixing,"u_shenfenzheng":u_shenfenzheng,
									"u_fuqinxingming":u_fuqinxingming,"u_muqinxingming":u_muqinxingming,"u_muqinnianling":u_muqinnianling,"u_fuqinnianling":u_fuqinnianling,"u_money":u_money,"u_zuotijindu":u_zuotijindu,"u_iswancheng":u_iswancheng,
									"u_danwei":u_danwei,"u_gudingdianhua":u_gudingdianhua,"u_yidongdianhua":u_yidongdianhua,"u_email":u_email,"u_dizhi":u_dizhi,"u_tingli":u_tingli,"u_shili":u_shili,"u_sejue":u_sejue
									},function(data){
										if(data=="ok"){
											$.messager.alert('操作提示','用户修改成功！','info');
											KX.refreshTable('usermanagerTable');
											KX.closeDialog();
										}
										else{
											$.messager.alert('操作提示','用户修改失败！','info');
											KX.refreshTable('usermanagerTable');
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
					viewFucdata : function(rowIndex, rowData) {
						var index = $('#tabs').tabs('getTab',rowData.username);
						if(index != null){
							$('#tabs').tabs('select',rowData.username);
						}
						else {
							if (typeof (userfenshunamager) != "undefined") {
								$('#tabs').tabs('close',tab_index);
								$('#tabs').tabs('add', {
									title: rowData.username,
									closable: true,
									href: "<%=path%>/user/userfenshuui?uid="+rowData.id
								});
							}
							else{
								$('#tabs').tabs('add', {
									title: rowData.username,
									closable: true,
									href: "<%=path%>/user/userfenshuui?uid="+rowData.id
								});
							}
							tab_index=rowData.username;
						}
					},
// 					downcarcaseFuc : function(rowDatas){
// 						$.messager.confirm('操作提示', '确认生成txt文档？', function(r){
// 							if(r){
// 								var ids = "";
// 								for ( var i = 0; i < rowDatas.length; i++) {
// 									ids += "," + rowDatas[i].id;
// 								}
// 								$.post("<%=path%>/user/createStudenttxt", {"id" : ids.substring(1)},function(data) {
// 									if(data[0].ok=="ok"){
// 										$.messager.confirm('操作提示', '确认下载文件'+data[0].filename+'？', function(r){
// 												if(r){
// 													window.open("<%=path%>/user/fileload?fileurl="+data[0].fileurl+"&type=u");
// 												}
// 											});
// 											$.messager.alert('操作提示','用户：'+data[0].shibaiuser+'生成成功！','info');
// 											KX.refreshTable('usermanagerTable');
// 											KX.closeDialog();
// 									}
// 									else if(data[0].ok=="null"){
// 										$.messager.alert('操作提示','用户：'+data[0].shibaiuser+'题目没有全部做完，生成失败！没有成功文件','info');
// 										KX.refreshTable('usermanagerTable');
// 										KX.closeDialog();
// 									}
// 									 else {
// 										$.messager.alert('操作提示','生成失败！','info');
// 									}
// 									KX.refreshTable('usermanagerTable');
// 								},"json");
// 							}
// 						});
// 					},
					downcarcaseyijian : function(rowDatas){
						$.messager.confirm('操作提示', '确认一键生成？', function(r){
							if(r){
								var ids = "";
								for ( var i = 0; i < rowDatas.length; i++) {
									ids += "," + rowDatas[i].id;
								}
								$.post("<%=path%>/user/yijiancreate", {"id" : ids.substring(1)},function(data) {
									if(data[0].ok=="ok"){
										$.messager.confirm('操作提示', '确认下载文件'+data[0].filename+'？', function(r){
												if(r){
													window.open("<%=path%>/user/fileload?fileurl="+data[0].fileurl+"&type=u");
												}
											});
											$.messager.alert('操作提示','用户：'+data[0].shibaiuser+'一键生成成功！','info');
											KX.refreshTable('usermanagerTable');
											KX.closeDialog();
									}
									/* else if(data[0].ok=="null"){
										$.messager.alert('操作提示','用户：'+data[0].shibaiuser+'题目没有全部做完，生成失败！没有成功文件','info');
										KX.refreshTable('usermanagerTable');
										KX.closeDialog();
									} */
									else {
										$.messager.alert('操作提示','生成失败！','info');
									}
									KX.refreshTable('usermanagerTable');
								},"json");
							}
						});
					},
// 					downcarcasedat : function(rowDatas){
// 						$.messager.confirm('操作提示', '确认生成dat文件？', function(r){
// 							if(r){
// 								var ids = "";
// 								for ( var i = 0; i < rowDatas.length; i++) {
// 									ids += "," + rowDatas[i].id;
// 								}
// 								$.post("<%=path%>/user/createStudentdat", {"id" : ids.substring(1)},function(data) {
// 									if(data[0].ok=="ok"){
// 										$.messager.confirm('操作提示', '确认下载成功的文件'+data[0].filename+'？', function(r){
// 												if(r){
// 													window.open("<%=path%>/user/fileload?fileurl="+data[0].fileurl+"&type=u");
// 												}
// 											});
// 											$.messager.alert('操作提示','用户：'+data[0].shibaiuser+'没有先生成txt文件，生成失败！','info');
// 											KX.refreshTable('usermanagerTable');
// 									} 
// 									else if(data[0].ok=="null"){
// 										$.messager.alert('操作提示','用户：'+data[0].shibaiuser+'没有先生成txt文件，生成失败！没有成功的dat文件','info');
// 										KX.refreshTable('usermanagerTable');
// 										KX.closeDialog();
// 									}
// 									else{
// 										$.messager.alert('操作提示','生成失败！','info');
// 									}
// 									KX.closeDialog();
// 									KX.refreshTable('usermanagerTable');
// 								},"json");
// 							}
// 						});
// 					},
// 					downcarcaseaccess : function(rowDatas){
// 						$.messager.confirm('操作提示', '确认生成access文件？', function(r){
// 							if(r){
// 								var ids = "";
// 								for ( var i = 0; i < rowDatas.length; i++) {
// 									ids += "," + rowDatas[i].id;
// 								}
// 								$.post("<%=path%>/user/createStudentaccess", {"id" : ids.substring(1)},function(data) {
// 									if(data[0].ok=="ok"){
// 										$.messager.confirm('操作提示', '确认下载文档'+data[0].filename+'？', function(r){
// 												if(r){
// 													window.open("<%=path%>/user/fileload?fileurl="+data[0].fileurl+"&type=u");
// 												}
// 											});
// 											$.messager.alert('操作提示','access文件生成成功！','info');
// 											KX.refreshTable('usermanagerTable');
// 									} 
// 									else if(data[0].ok=="no"){
// 										$.messager.alert('操作提示','请先生成dat文件！','info');
// 									}
// 									else{
// 										$.messager.alert('操作提示','生成失败！','info');
// 									}
// 									KX.closeDialog();
// 									KX.refreshTable('usermanagerTable');
// 								},"json");
// 							}
// 						});
// 					},
					changeuserFuc : function(){
						KX.showDialog(400, 300, '生成用户', "<%=path%>/user/userautoAddui", '生成用户初始资料',
							'search', [ {
								text : '生成',
								iconCls : 'icon-ok',
								handler : function() {
									var u_jigou = $("#u_jigou").val();
									var u_money = $("#u_money").val();
									var u_banben = $("#u_banben").val();
									var u_usernumber = $("#u_usernumber").val();
									var userquanxian = $("#userquanxian").val();
									$.post("<%=path%>/user/userautoAdd",{"u_jigou":u_jigou,"u_money":u_money,"u_banben":u_banben,"u_usernumber":u_usernumber,"userquanxian":userquanxian},function(data){
										if(data[0].ok=="ok"){
											$.messager.confirm('操作提示', '确认下载文档'+data[0].filename+'？', function(r){
												if(r){
													window.open("<%=path%>/user/fileload?fileurl="+data[0].fileurl+"&type=u");
												}
											});
											$.messager.alert('操作提示','用户生成成功！','info');
											KX.refreshTable('usermanagerTable');
											KX.closeDialog();
										}
										else{
											$.messager.alert('操作提示','用户生成失败！','info');
											KX.closeDialog();
										}
									},"json");
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
				usernamager.createTable();
			}
		};
		usernamager.init();
	}
</script>
