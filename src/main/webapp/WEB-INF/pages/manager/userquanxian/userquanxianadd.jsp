<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
 .quanxianadd label{display:block;float:left;}
.quanxianadd input, .quanxianadd em{ float:left; font-style: normal;margin-left:10px;}
.quanxianadd em{line-height: 20px;}
 .quanxianadd label input{border:none;}
  .quanxianselect div{
  	margin-left:10px;float:left;
  }
 .quanxianselect div ul li{
 	float:left;
 	list-style: none;
 	width:150px;
 }
  .quanxianselect div ul li ul{
  	margin-left:10px;
  }
</style>
<table class="quanxianadd">
<c:if test="${chaozhuo == 'update'}">
<tr><td>权限名称：</td><td><input type="text" id="quanxuanname" value="${group.name}" /><input type="hidden" value="${group.id}" id="groupid" /></td></tr>
	<tr><td>选择模块：</td>
		<td width="500">
			<div class="quanxianselect">
				<div style="width:150px;float:left;" id="">
				<ul >   
				     <li>   
				        <span>一模块</span>   
				        <ul>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="10"/><em>1.1 选择反应</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="11"/><em>1.2 图形匹配</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="12"/><em>1.3 语音回路</em></label>
				            </li>  
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="13"/><em>1.4 中央处理器</em></label>
				            </li>  
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="14"/><em>1.5 视空板</em></label>
				            </li>   
				        </ul>   
				    </li>   
				</ul>  
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>二模块</span>   
				        <ul>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="15"/><em>2.1 数学比较</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="16"/><em>2.2 数学运算</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="17"/><em>2.3 语言检测</em></label>
				            </li>  
				            <li>  
				            	<label><input type="checkbox" name='checkbox' value="18"/><em>2.4 走迷津</em></label> 
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>三模块</span>   
				        <ul>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="19"/><em>3.1 目标搜索</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="20"/><em>3.2 目标比较</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="21"/><em>3.3 目标拼图</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="22"/><em>3.4 人际交往能力A</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="23"/><em>3.5 人际交往能力B</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>四模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="24"/><em>4.1 空间操作</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="25"/><em>4.2 空间推理</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="26"/><em>4.3 表象能力</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="27"/><em>4.4 思维转换</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>五模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="28"/><em>5.1 空间比例判断</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="29"/><em>5.2 门萨艺术</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="30"/><em>5.3 色彩对比</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>六模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="31"/><em>6.1 音调形象</em></label>
				            </li>   
				            <li>  
				            <label><input type="checkbox" name='checkbox' value="32"/><em>6.2 音长</em></label> 
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="33"/><em>6.3 节奏</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="34"/><em>6.4 音的记忆</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="35"/><em>6.5 音的鉴赏</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>七模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="36"/><em>7.1 组织管理能力</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="37"/><em>7.2 概念推理</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="38"/><em>7.3 逻辑推理</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>八模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="39"/><em>8.1 职业心向</em></label>
				            </li>   
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>九模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="40"/><em>9.1 人格测验1</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="41"/><em>9.2 人格测验2</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="42"/><em>9.3 人格投射1</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="43"/><em>9.4 人格投射2</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div> 
			</div>
		</td></tr>
</c:if>
<c:if test="${chaozhuo == 'look'}">
<tr><td>权限名称：</td><td><input type="text" id="quanxuanname" value="${group.name}" disabled="disabled" /></td></tr>
	<tr><td>选择模块：</td>
		<td width="500">
			<div class="quanxianselect">
				<div style="width:150px;float:left;" id="">
				<ul >   
				     <li>   
				        <span>一模块</span>   
				        <ul>   
				            <li>   
				            	<label><input type="checkbox" disabled="disabled"  name='checkbox' value="10"/><em>1.1 选择反应</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" disabled="disabled"  name='checkbox' value="11"/><em>1.2 图形匹配</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" disabled="disabled"  name='checkbox' value="12"/><em>1.3 语音回路</em></label>
				            </li>  
				            <li>   
				            	<label><input type="checkbox"  disabled="disabled" name='checkbox' value="13"/><em>1.4 中央处理器</em></label>
				            </li>  
				            <li>   
				            	<label><input type="checkbox" disabled="disabled"  name='checkbox' value="14"/><em>1.5 视空板</em></label>
				            </li>   
				        </ul>   
				    </li>   
				</ul>  
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>二模块</span>   
				        <ul>   
				            <li>   
				            	<label><input type="checkbox"  disabled="disabled" name='checkbox' value="15"/><em>2.1 数学比较</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" disabled="disabled"  name='checkbox' value="16"/><em>2.2 数学运算</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" disabled="disabled"  name='checkbox' value="17"/><em>2.3 语言检测</em></label>
				            </li>  
				            <li>  
				            	<label><input type="checkbox" disabled="disabled"  name='checkbox' value="18"/><em>2.4 走迷津</em></label> 
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>三模块</span>   
				        <ul>   
				            <li>   
				            	<label><input type="checkbox" disabled="disabled"  name='checkbox' value="19"/><em>3.1 目标搜索</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" disabled="disabled"  name='checkbox' value="20"/><em>3.2 目标比较</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="21"/><em>3.3 目标拼图</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="22"/><em>3.4 人际交往能力A</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="23"/><em>3.5 人际交往能力B</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>四模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="24"/><em>4.1 空间操作</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" disabled="disabled"  name='checkbox' value="25"/><em>4.2 空间推理</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" disabled="disabled"  name='checkbox' value="26"/><em>4.3 表象能力</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="27"/><em>4.4 思维转换</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>五模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="28"/><em>5.1 空间比例判断</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="29"/><em>5.2 门萨艺术</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="30"/><em>5.3 色彩对比</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>六模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="31"/><em>6.1 音调形象</em></label>
				            </li>   
				            <li>  
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="32"/><em>6.2 音长</em></label> 
				            </li>   
				            <li>   
				            <label><input type="checkbox" disabled="disabled"  name='checkbox' value="33"/><em>6.3 节奏</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="34"/><em>6.4 音的记忆</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" disabled="disabled"  name='checkbox' value="35"/><em>6.5 音的鉴赏</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>七模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" disabled="disabled"  name='checkbox' value="36"/><em>7.1 组织管理能力</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox"  disabled="disabled" name='checkbox' value="37"/><em>7.2 概念推理</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" disabled="disabled"  name='checkbox' value="38"/><em>7.3 逻辑推理</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>八模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" disabled="disabled"  name='checkbox' value="39"/><em>8.1 职业心向</em></label>
				            </li>   
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>九模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" disabled="disabled"  name='checkbox' value="40"/><em>9.1 人格测验1</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" disabled="disabled"  name='checkbox' value="41"/><em>9.2 人格测验2</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" disabled="disabled"  name='checkbox' value="42"/><em>9.3 人格投射1</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" disabled="disabled" name='checkbox' value="43"/><em>9.4 人格投射2</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div> 
			</div>
		</td></tr>
</c:if>
<c:if test="${chaozhuo == 'add'}">
	<tr><td>权限名称：</td><td><input type="text" id="quanxuanname" /></td></tr>
	<tr><td>选择模块：</td>
		<td width='500px'>
			<!-- <label><input type="checkbox" name='checkbox' value="1"/><em>一模块</em></label>
			<label><input type="checkbox" name='checkbox' value="2"/><em>二模块</em></label>
			<label><input type="checkbox" name='checkbox' value="3"/><em>三模块</em></label>
			<label><input type="checkbox" name='checkbox' value="4"/><em>四模块</em></label>
			<label><input type="checkbox" name='checkbox' value="5"/><em>五模块</em></label>
			<label><input type="checkbox" name='checkbox' value="6"/><em>六模块</em></label>
			<label><input type="checkbox" name='checkbox' value="7"/><em>七模块</em></label>
			<label><input type="checkbox" name='checkbox' value="8"/><em>八模块</em></label>
			<label><input type="checkbox" name='checkbox' value="9"/><em>九模块</em></label> -->
				<div class="quanxianselect">
				<div style="width:150px;float:left;" id="">
				<ul >   
				     <li>   
				        <span>一模块</span>   
				        <ul>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="10"/><em>1.1 选择反应</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="11"/><em>1.2 图形匹配</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="12"/><em>1.3 语音回路</em></label>
				            </li>  
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="13"/><em>1.4 中央处理器</em></label>
				            </li>  
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="14"/><em>1.5 视空板</em></label>
				            </li>   
				        </ul>   
				    </li>   
				</ul>  
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>二模块</span>   
				        <ul>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="15"/><em>2.1 数学比较</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="16"/><em>2.2 数学运算</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="17"/><em>2.3 语言检测</em></label>
				            </li>  
				            <li>  
				            	<label><input type="checkbox" name='checkbox' value="18"/><em>2.4 走迷津</em></label> 
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>三模块</span>   
				        <ul>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="19"/><em>3.1 目标搜索</em></label>
				            </li>   
				            <li>   
				            	<label><input type="checkbox" name='checkbox' value="20"/><em>3.2 目标比较</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="21"/><em>3.3 目标拼图</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="22"/><em>3.4 人际交往能力A</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="23"/><em>3.5 人际交往能力B</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>四模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="24"/><em>4.1 空间操作</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="25"/><em>4.2 空间推理</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="26"/><em>4.3 表象能力</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="27"/><em>4.4 思维转换</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>五模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="28"/><em>5.1 空间比例判断</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="29"/><em>5.2 门萨艺术</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="30"/><em>5.3 色彩对比</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>六模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="31"/><em>6.1 音调形象</em></label>
				            </li>   
				            <li>  
				            <label><input type="checkbox" name='checkbox' value="32"/><em>6.2 音长</em></label> 
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="33"/><em>6.3 节奏</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="34"/><em>6.4 音的记忆</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="35"/><em>6.5 音的鉴赏</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>七模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="36"/><em>7.1 组织管理能力</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="37"/><em>7.2 概念推理</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="38"/><em>7.3 逻辑推理</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>八模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="39"/><em>8.1 职业心向</em></label>
				            </li>   
				        </ul>   
				    </li>   
				</ul>
			</div>
			<div style="width:150px;float:left;">
				<ul >   
				    <li>   
				        <span>九模块</span>   
				        <ul>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="40"/><em>9.1 人格测验1</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="41"/><em>9.2 人格测验2</em></label>
				            </li>   
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="42"/><em>9.3 人格投射1</em></label>
				            </li>  
				            <li>   
				            <label><input type="checkbox" name='checkbox' value="43"/><em>9.4 人格投射2</em></label>
				            </li>  
				        </ul>   
				    </li>   
				</ul>
			</div> 
			</div>
			<br style="clear:both">
		</td></tr>
</c:if>
</table>
<script type="text/javascript">
var mokuaigroup="${mokuaigroup}";
if(mokuaigroup!=""){
	mokuaigroup=mokuaigroup.split(",");
	$("[name='checkbox']").each(function(i,o){
		for(var y=0;y<mokuaigroup.length;y++){
			if($(o).val() == mokuaigroup[y]){
				$(o).attr("checked","checked");
			}
		}
	});
}
// $(".easyui-tree").tree({
// 	data:[{    
//     "id": 1,    
//     "text": "一模块",    
//     "state": "open",    
//     "children": [{    
//         "id": 11,    
//         "text": "1.1 选择反应"   
//     },{    
//         "id": 12,    
//         "text": "1.2 图形匹配"   
//     },{
//     	"id":13,
//     	"text":"1.3 语音回路"
//     }]    
// },{    
//     "id": 2,    
//     "text": "Node 2",    
//     "state": "closed"   
// }],
// checkbox:true
// });
</script>