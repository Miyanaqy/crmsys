﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>查询客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
	//页面的加载
	/*
	$(function(){
		/*
		// 发送ajax的请求
		var url = "${ pageContext.request.contextPath }/dict_findByCode.action";
		var param = {"dict_type_code":"006"};
		$.post(url,param,function(data){
			// 遍历
			$(data).each(function(i,n){
				$("#levelId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
		},"json");
		
		// 获取来源
		var param = {"dict_type_code":"002"};
		$.post(url,param,function(data){
			// 遍历
			$(data).each(function(i,n){
				$("#sourceId").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
			});
		},"json");
	});
	*/
	$(function(){
		var url="${pageContext.request.contextPath}/dict_findAll.action";
		$.post(url, {"dict_type_code":""}, function(result){
			$(result).each(function(i, n){
				if(n.dict_type_code == "006"){
					$("#levelId").append("<option value='"+ n.dict_id +"'>"+ n.dict_item_name +"</option>");
				}else if(n.dict_type_code == "002"){
					$("#sourceId").append("<option value='"+ n.dict_id +"'>"+ n.dict_item_name +"</option>");
				}else if(n.dict_type_code == "001"){
					$("#industryId").append("<option value='"+ n.dict_id +"'>"+ n.dict_item_name +"</option>");
				}
				
			});
		}, "Json");
		/*
		$.post(url, {"dict_type_code":"002"}, function(result){
			$(result).each(function(i, n){
				$("#sourceId").append("<option value='"+ n.dict_id +"'>"+ n.dict_item_name +"</option>");
			});
		}, "json");
		
		$.post(url, {"dict_type_code":"001"}, function(result){
			$(result).each(function(i, n){
				$("#industryId").append("<option value='"+ n.dict_id +"'>"+ n.dict_item_name +"</option>");
			});
		}, "json");
		*/
		var url1 = "${pageContext.request.contextPath}/user_findAll.action";
		$.post(url1,{"user_name":""}, function(result){
			$(result).each(function(i, n){
				$("#userId").append("<option value='"+ n.user_id +"'>"+ n.user_name +"</option>");
			});
		}, "json");
		
	});
</script>

</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/customer_findByPage.action" method="post" enctype="multipart/form-data">
		
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
								<TD class=manageHead>当前位置：综合查询 &gt; 客户查询</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						    
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id="cust_name"
														style="WIDTH: 180px" maxLength=50 name="cust_name">
								</td>
								<td>客户级别 ：</td>
								<td>
									<select name="level.dict_id" id="levelId">
										<option value="">----请选择----</option>
									</select>
									<!-- <input type="text" name="cust_level" id="cust_level" />-->
								</td>
							</TR>
							
							<TR>
								<td>信息来源 ：</td>
								<td>
									<select name="source.dict_id" id="sourceId">
										<option value="">----请选择----</option>
									</select>
									
								</td>
								
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id="cust_phone"
														style="WIDTH: 180px" maxLength=50 name="cust_phone">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id="cust_mobile"
														style="WIDTH: 180px" maxLength=50 name="cust_mobile">
								</td>
							</TR>
							
							<TR>
								<td>联系地址 ：</td>
								<td>
								<INPUT class=textbox id="cust_address"
														style="WIDTH: 180px" maxLength=50 name="cust_address">
								</td>
								<td>所属行业 ：</td>
								<td>
								<select name="industry.dict_id" id="industryId">
									<option value="">----请选择----</option>
								</select>
								</td>
							</TR>
							<TR>
								<td>负责人 ：</td>
								<td>
								<select name="user.user_id" id="userId">
									<option value="">----请选择----</option>
								</select>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit value="查询 " name=sButton2>
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
