﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>查询客户拜访记录</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>

<!-- 日期插件，使用jquery -->
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.4.2.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/jquery/jquery.datepick.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery.datepick-zh-CN.js"></script>

<script type="text/javascript">
	$(function(){
		//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
		$('#beginDate').datepick({dateFormat: 'yy-mm-dd'}); 
		$('#endDate').datepick({dateFormat: 'yy-mm-dd'}); 
		$('#beginNextDate').datepick({dateFormat: 'yy-mm-dd'}); 
		$('#endNextDate').datepick({dateFormat: 'yy-mm-dd'});
		
		// 发送ajax请求
		var url = "${pageContext.request.contextPath }/customer_findAll.action";
		$.post(url,function(result){
			$(result).each(function(){
				$("#customerId").append("<option value='"+this.cust_id+"'>"+this.cust_name+"</option>");
			});
		},"json");
		
	});
	function loadLinkman(){
		var cust_id = $("#customerId").val();
		var url = "${pageContext.request.contextPath}/linkman_findByCriteria.action";
		$.post(url, {"customer.cust_id":cust_id}, function(result){
			$("#linkmanId").html("<option value=''>----请选择----</opiton>");
			$(result).each(function(){
				$("#linkmanId").append("<option value='"+ this.link_id +"'>" + this.link_name + "</opiton>");
			});
		}, "json");
	}
</script>

</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/visit_findByPage.action" method=post>
		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						 height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：综合查询&gt; 客户拜访记录查询</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>客户名称：</td>
								<td>
									<select name="customer.cust_id" id="customerId" onChange="loadLinkman()">
										<option value="">----请选择----</option>
									</select>
								</td>
								<td>被拜访人：</td>
								<td>
									<select name="linkman.link_id" id="linkmanId">
										<option>----请选择----</option>
									</select>
								</td>
								
								
							</tr>
							
							<TR>
								
								<td>拜访地点：</td>
								<td>
									<INPUT class=textbox style="WIDTH: 180px" maxLength=50 name="visit_address">
								</td>
							</TR>
							<tr>
							<td>拜访时间从：</td>
								<td>
									<INPUT class=textbox id="beginDate" style="WIDTH: 180px" name="beginDate" readonly="readonly">
								</td>
								
								<td>到：</td>
								<td>
									<INPUT class=textbox id="endDate" style="WIDTH: 180px" name="endDate" readonly="readonly">
								</td>
							</tr>
							<TR>
								<td>下次拜访时间从 ：</td>
								<td>
									<INPUT class=textbox id="beginNextDate" style="WIDTH: 180px"  name="beginNextDate" readonly="readonly">
								</td>
								<td>到：</td>
								<td>
									<INPUT class=textbox id="endNextDate" style="WIDTH: 180px" name="endNextDate" readonly="readonly">
								</td>
							</TR>
							
						
							
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="查询 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
