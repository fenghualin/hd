<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<table id="questionTable2"></table>
<script type="text/javascript">
	if (typeof (questions2) != "undefined") {
		questions2.init();
	} else {
		var questions2 = {
			createTable : function() {
				KX.createTable({
					id : 'questionTable2',
					url : '<%=path%>/questionmanager/questiondata2',
					columns : [ [ {
						field : 'id',
						title : 'id',
						hidden : true
					}, {
						field : 'name',
						title : '问题分类',
						width : 20,
						align : 'center',
						formatter : function(value, row, index) {
							return KX.puanddj2(value);
						}
					}, {
						field : 'question_text',
						title : '问题标题',
						width : 140,
						align : 'left',
					},{
						field : 'inverted',
						title : '是否倒序',
						width : 10,
						align : 'center',
						formatter : function(value, row, index) {
							return KX.inverteds(value);
						}
					}
					
					 ] ],
					showCheckBox : true,
					createFuc : function() {
						KX.showDialog(600, 500, '添加问题', '<%=path%>/questionmanager/questionaddui2', '添加问题', 'add',
							[ {
								text : '添加',
								iconCls : 'icon-ok',
								handler : function() {
									var questionkinds = $('#questionkinds2').val();
									var questionleirong = $.trim($('#questionleirong2').val());
									var questioninverted = $('#questioninverted').val();
									var answerA = $.trim($('#answerA2').val());
									var answerB = $.trim($('#answerB2').val());
									var answerC = $.trim($('#answerC2').val());
									var answerD = $.trim($('#answerD2').val());
									var answerE = $.trim($('#answerE2').val());
									var pointA = $.trim($('#pointA2').val());
									var pointB = $.trim($('#pointB2').val());
									var pointC = $.trim($('#pointC2').val());
									var pointD = $.trim($('#pointD2').val());
									var pointE = $.trim($('#pointE2').val());
// 									alert(questionkinds+"--"+questionleirong+"--"+answerA+"--"+pointA+"--"+answerB+"--"+pointB+"--"+answerC+"--"+pointC+"--"+answerD+"--"+pointD+"--"+answerE+"--"+pointE);
									if(questionleirong == ""){
										$.messager.alert('操作提示','请填写问题要求！','info');
										return ;
									}
									if(answerA == "" || answerB == "" || answerC == "" || answerD == "" || answerE == "" || pointA == "" || pointB == "" || pointC == "" || pointD == "" || pointE == "" ){
										$.messager.alert('操作提示','请将答案的得分填写完整！','info');
										return ;
									}
									if(questioninverted == "no"){
										$.messager.alert('操作提示','请选择答案是否倒序！','info');
										return ;
									}
									if(questionkinds == "rjjwnl2"){
										questionkinds=1;
									}
									else if(questionkinds == "zyxxnl"){
										questionkinds=2;	
									}
									else if(questionkinds == "rgjc1"){
										questionkinds=3;
									}
									else if(questionkinds == "rgjc2"){
										questionkinds=4;
									}
									
									$.post("<%=path%>/questionmanager/questionsave2",{"questionkinds":questionkinds,"questionleirong":questionleirong,"answerA":answerA,"answerB":answerB,"answerC":answerC,"answerD":answerD,"answerE":answerE,"pointA":pointA,"pointB":pointB,"pointC":pointC,"pointD":pointD,"pointE":pointE,"questioninverted":questioninverted},function(data){
										if(data=="ok"){
											$.messager.alert('操作提示','问题添加成功！','info');
											KX.refreshTable('questionTable2');
											KX.closeDialog();
										}
										else{
											$.messager.alert('操作提示','问题添加失败！','info');
											KX.refreshTable('questionTable2');
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
						$.messager.confirm('操作提示', '确认删除该问题？', function(r){
							if(r){
							 	var ids = "";
								for ( var i = 0; i < rowDatas.length; i++) {
									ids += "," + rowDatas[i].id;
								}
								$.post("<%=path%>/questionmanager/questiondelete2", {"qid" : ids.substring(1)},function(data) {
									if (data=="ok") {
										$.messager.alert('操作提示','删除成功！','info');
									} else {
										$.messager.alert('操作提示','删除失败！','info');
									}
									KX.refreshTable('questionTable2');
								});
							}
						});
					},
					viewFuc : function(rowIndex, rowData) {
						KX.showDialog(600, 500, "查看", "<%=path%>/questionmanager/questionlook2?qid="+rowData.id, "查看问题类容", "search",
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
						KX.showDialog(600, 500, '修改问题', "<%=path%>/questionmanager/questionupdatepage2?qid="+rowData.id, '问题类容',
							'search', [ {
								text : '修改',
								iconCls : 'icon-ok',
								handler : function() {
									var questionkinds = $('#questionkinds2').val();
									var questionleirong = $.trim($('#questionleirong2').val());
									var questioninverted = $('#questioninverted').val();
									var questionid = $.trim($('#question_id2').text());
									var answerA = $.trim($('#answerA2').val());
									var answerB = $.trim($('#answerB2').val());
									var answerC = $.trim($('#answerC2').val());
									var answerD = $.trim($('#answerD2').val());
									var answerE = $.trim($('#answerE2').val());
									var pointA = $.trim($('#pointA2').val());
									var pointB = $.trim($('#pointB2').val());
									var pointC = $.trim($('#pointC2').val());
									var pointD = $.trim($('#pointD2').val());
									var pointE = $.trim($('#pointE2').val());
// 									alert(questionkinds+"--"+questionleirong+"--"+answerA+"--"+pointA+"--"+answerB+"--"+pointB+"--"+answerC+"--"+pointC+"--"+answerD+"--"+pointD+"--"+answerE+"--"+pointE);
									if(questionleirong == ""){
										$.messager.alert('操作提示','请填写问题要求！','info');
										return ;
									}
									if(answerA == "" || answerB == "" || answerC == "" || answerD == "" || answerE == "" || pointA == "" || pointB == "" || pointC == "" || pointD == "" || pointE == "" ){
										$.messager.alert('操作提示','请将答案的得分填写完整！','info');
										return ;
									}
									if(questioninverted == "no"){
										$.messager.alert('操作提示','请选择答案是否倒序！','info');
										return ;
									}
									if(questionkinds == "rjjwnl2"){
										questionkinds=1;
									}
									else if(questionkinds == "zyxxnl"){
										questionkinds=2;	
									}
									else if(questionkinds == "rgjc1"){
										questionkinds=3;
									}
									else if(questionkinds == "rgjc2"){
										questionkinds=4;
									}
									
									$.post("<%=path%>/questionmanager/questionUpdate2",{"questionid":questionid,"questionkinds":questionkinds,"questionleirong":questionleirong,"answerA":answerA,"answerB":answerB,"answerC":answerC,"answerD":answerD,"answerE":answerE,"pointA":pointA,"pointB":pointB,"pointC":pointC,"pointD":pointD,"pointE":pointE,"questioninverted":questioninverted},function(data){
										if(data=="ok"){
											$.messager.alert('操作提示','问题修改成功！','info');
											KX.refreshTable('questionTable2');
											KX.closeDialog();
										}
										else{
											$.messager.alert('操作提示','问题修改失败！','info');
											KX.refreshTable('questionTable2');
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
				questions2.createTable();
			}
		};
		questions2.init();
	}
</script>
