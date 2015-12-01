<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<table id="questionTablecr"></table>
<script type="text/javascript">
	if (typeof (questionscr) != "undefined") {
		questionscr.init();
	} else {
		var questionscr = {
			createTable : function() {
				KX.createTable({
					id : 'questionTablecr',
					url : 'questiondatacr',
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
							return KX.puanddj(value);
						}
					}, {
						field : 'question_text',
						title : '问题标题',
						width : 140,
						align : 'left',
					} ] ],
					showCheckBox : true,
					createFuc : function() {
						KX.showDialog(600, 500, '添加问题', 'questionaddui', '添加问题', 'add',
							[ {
								text : '添加',
								iconCls : 'icon-ok',
								handler : function() {
									var questionkinds = $('#questionkinds').val();
									var questionleirong = $.trim($('#questionleirong').val());
									var answerA = $.trim($('#answerA').val());
									var answerB = $.trim($('#answerB').val());
									var answerC = $.trim($('#answerC').val());
									var answerD = $.trim($('#answerD').val());
									var pointA = $.trim($('#pointA').val());
									var pointB = $.trim($('#pointB').val());
									var pointC = $.trim($('#pointC').val());
									var pointD = $.trim($('#pointD').val());
									if(questionleirong == ""){
										$.messager.alert('操作提示','请填写问题要求！','info');
										return ;
									}
									if(answerA == "" || answerB == "" || answerC == "" || answerD == "" || pointA == "" || pointB == "" || pointC == "" || pointD == ""){
										$.messager.alert('操作提示','请将答案的得分填写完整！','info');
										return ;
									}
									if(questionkinds == "zzglnl"){
										questionkinds=1;
									}
									else if(questionkinds == "yynlcs"){
										questionkinds=2;	
									}
									else if(questionkinds == "lbtl"){
										questionkinds=3;
									}
									else if(questionkinds == "rjjwnl"){
										questionkinds=4;
									}
									
									$.post("questionsavecr",{"questionkinds":questionkinds,"questionleirong":questionleirong,"answerA":answerA,"answerB":answerB,"answerC":answerC,"answerD":answerD,"pointA":pointA,"pointB":pointB,"pointC":pointC,"pointD":pointD},function(data){
										if(data=="ok"){
											$.messager.alert('操作提示','问题添加成功！','info');
											KX.refreshTable('questionTablecr');
											KX.closeDialog();
										}
										else if(data=="no"){
											$.messager.alert('操作提示','问题添加失败！','info');
											KX.refreshTable('questionTablecr');
											KX.closeDialog();
										}
										else{
											$.messager.alert('操作提示','系统错误！','info');
											KX.refreshTable('questionTablecr');
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
								$.post("questiondeletecr", {"qid" : ids.substring(1)},function(data) {
									if (data=="ok") {
										$.messager.alert('操作提示','删除成功！','info');
									} else {
										$.messager.alert('操作提示','删除失败！','info');
									}
									KX.refreshTable('questionTablecr');
								});
							}
						});
					},
					viewFuc : function(rowIndex, rowData) {
						KX.showDialog(600, 400, "查看", "questionlookcr?qid="+rowData.id, "查看问题类容", "search",
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
						KX.showDialog(600, 400, '修改问题', "questionupdatepagecr?qid="+rowData.id, '问题类容',
							'search', [ {
								text : '修改',
								iconCls : 'icon-ok',
								handler : function() {
									var questionkinds = $('#questionkinds').val();
									var questionleirong = $.trim($('#questionleirong').val());
									var questionid = $.trim($('#question_id').text());
									var answerA = $.trim($('#answerA').val());
									var answerB = $.trim($('#answerB').val());
									var answerC = $.trim($('#answerC').val());
									var answerD = $.trim($('#answerD').val());
									var pointA = $.trim($('#pointA').val());
									var pointB = $.trim($('#pointB').val());
									var pointC = $.trim($('#pointC').val());
									var pointD = $.trim($('#pointD').val());
// 									alert(answerB+"--"+answerA+"--"+answerC+"--"+answerD+"--"+pointA+"--"+pointB);
									if(questionleirong == ""){
										$.messager.alert('操作提示','请将答案的得分填写完整！','info');
										return ;
									}
									if(answerA == "" || answerB == "" || answerC == "" || answerD == "" || pointA == "" || pointB == "" || pointC == "" || pointD == ""){
										$.messager.alert('操作提示','请将答案的得分填写完整！','info');
										return ;
									}
									if(questionkinds == "zzglnl"){
										questionkinds=1;
									}
									else if(questionkinds == "yynlcs"){
										questionkinds=2;	
									}
									else if(questionkinds == "lbtl"){
										questionkinds=3;
									}
									else if(questionkinds == "rjjwnl"){
										questionkinds=4;
									}
									
									$.post("questionUpdatecr",{"questionid":questionid,"questionkinds":questionkinds,"questionleirong":questionleirong,"answerA":answerA,"answerB":answerB,"answerC":answerC,"answerD":answerD,"pointA":pointA,"pointB":pointB,"pointC":pointC,"pointD":pointD},function(data){
										if(data=="ok"){
											$.messager.alert('操作提示','问题修改成功！','info');
											KX.refreshTable('questionTablecr');
											KX.closeDialog();
										}
										else{
											$.messager.alert('操作提示','问题修改失败！','info');
											KX.refreshTable('questionTablecr');
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
				questionscr.createTable();
			}
		};
		questionscr.init();
	}
</script>
