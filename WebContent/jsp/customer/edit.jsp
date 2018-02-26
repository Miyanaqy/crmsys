<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
$(function(){
	var url="${pageContext.request.contextPath}/dict_findAll.action";
	$.post(url,  function(result){
		var sourceId = "${model.source.dict_id}";
		var levelId = "${model.level.dict_id}";
		var industryId = "${model.industry.dict_id}";
		$(result).each(function(i, n){
			if(n.dict_type_code == "006"){
				if(n.dict_id == levelId){
					$("#levelId").append("<option value='"+ n.dict_id +"' selected>"+ n.dict_item_name +"</option>");
				}else{
					$("#levelId").append("<option value='"+ n.dict_id +"'>"+ n.dict_item_name +"</option>");
				}
			}else if(n.dict_type_code == "002"){
				if(n.dict_id == sourceId){
					$("#sourceId").append("<option value='"+ n.dict_id +"' selected>"+ n.dict_item_name +"</option>");
				}else{
					$("#sourceId").append("<option value='"+ n.dict_id +"'>"+ n.dict_item_name +"</option>");
				}
			}else if(n.dict_type_code == "001"){
				if(n.dict_id == industryId){
					$("#industryId").append("<option value='"+ n.dict_id +"' selected>"+ n.dict_item_name +"</option>");
				}else{
					$("#industryId").append("<option value='"+ n.dict_id +"'>"+ n.dict_item_name +"</option>");
				}
			}
			
		});
	}, "Json");
	
	var url2 = "${pageContext.request.contextPath}/user_findAll.action";
	$.post(url2, function(result){
		var userId = "${model.user.user_id}";
		$(result).each(function(i, n){
			if(n.user_id == userId){
				$("#userId").append("<option value='"+ n.user_id +"' selected>" + n.user_name + "</option>");
			}else{
				$("#userId").append("<option value='"+ n.user_id +"'>" + n.user_name + "</option>");
			}
		});
	}, "json");
});
</script>


</HEAD>
<BODY>
	
	<!-- 修改客户，需要文件上传，必须提供属性：enctype="multipart/form-data" -->
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/customer_update.action" method="post" enctype="multipart/form-data">
		
		<!-- 隐藏的客户的主键，不能忘记 -->
		<input type="hidden" name="cust_id" value="${model.cust_id}"/>
		<!-- 隐藏文件上传的路径 
		<input type="hidden" name="filepath" value=""/>
		-->
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
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
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
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
														style="WIDTH: 180px" maxLength=50 name="cust_name" value="${model.cust_name }">
								</td>
								<td>客户级别 ：</td>
								<td>
									<select name="level.dict_id" id="levelId">
									</select>
									<!-- <input type="text" name="cust_level" id="cust_level" />-->
								</td>
							</TR>
							
							<TR>
								<td>信息来源 ：</td>
								<td>
									<select name="source.dict_id" id="sourceId">
									</select>
									
								</td>
								
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id="cust_phone"
														style="WIDTH: 180px" maxLength=50 name="cust_phone" value="${model.cust_phone }">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id="cust_mobile"
														style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="${model.cust_mobile }">
								</td>
							</TR>
							
							<TR>
								<td>联系地址 ：</td>
								<td>
								<INPUT class=textbox id="cust_address"
														style="WIDTH: 180px" maxLength=50 name="cust_address" value="${model.cust_address }">
								</td>
								<td>所属行业 ：</td>
								<td>
								<select name="industry.dict_id" id="industryId">
								</select>
								</td>
							</TR>
							<TR>
								<td>负责人 ：</td>
								<td>
								<select name="user.user_id" id="userId">
								</select>
								</td>
								
								<td>上传资质：</td>
								<td>
									<input type="file" name="upload" />
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit value="保存 " name=sButton2>
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
