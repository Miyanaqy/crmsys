<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
}
TD {
	FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
}

.error{
	COLOR:RED;
}
</STYLE>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
function checkUsername(){
	var username = $("#user_name").val();
	if(username.trim() != ""){
		var url = "${pageContext.request.contextPath}/user_checkUsername.action";
		var param = {"user_name":username};
		$.post(url, param, function(result){
			if(result ==	 "no"){
				$("#user_name_msg").addClass("error");
				$("#user_name_msg").html("用户名已被使用");
			}else{
				$("#user_name_msg").removeClass("error");
				$("#user_name_msg").html("用户名可以使用");
			}
		})
	}else{
		$("#user_name_msg").addClass("error");
		$("#user_name_msg").html("用户名不能为空");
	}
}

function checkPassword(){
	var password = $("#user_password").val();
	if(password.trim() == ""){
		$("#user_password_msg").addClass("error");
		$("#user_password_msg").html("密码不能为空");
	}else{
		$("#user_password_msg").removeClass("error");
		$("#user_password_msg").html("");
	}
}
</script>

<META content="MSHTML 6.00.6000.16809" name=GENERATOR></HEAD>
<BODY>
<FORM id=form1 name=form1 action="${ pageContext.request.contextPath }/user_regist.action" method=post >

<DIV id=UpdatePanel1>
<DIV id=div1 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
<DIV id=div2 
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>


<DIV>&nbsp;&nbsp; </DIV>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
  <TBODY>
  <TR>
    <TD style="HEIGHT: 105px"><IMG src="images/login_1.gif" 
  border=0></TD></TR>
  <TR>
    <TD background=images/regist.jpg height=300>
      <TABLE height=300 cellPadding=0 width=900 border=0>
        <TBODY>
        <TR>
          <TD colSpan=2 height=35></TD></TR>
        <TR>
          <TD width=360></TD>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              <TR>
                <TD style="HEIGHT: 28px" width=80>登 录 名：</TD>
                <TD style="HEIGHT: 28px" width=150><INPUT id=user_name 
                  style="WIDTH: 130px" name="user_name" onblur="checkUsername()"></TD>
                <TD style="HEIGHT: 28px" width=370><SPAN 
                  id=user_name_msg 
                  style="FONT-WEIGHT: bold">请输入登录名</SPAN></TD></TR>
              <TR>
                <TD style="HEIGHT: 28px">登录密码：</TD>
                <TD style="HEIGHT: 28px"><INPUT id=user_password style="WIDTH: 130px" 
                  type=password name="user_password" onblur="checkPassword()"></TD>
                <TD style="HEIGHT: 28px"><SPAN id=user_password_msg 
                  style="FONT-WEIGHT: bold">请输入密码</SPAN></TD></TR>
              
              <TR>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD></TR>
              <TR>
                <TD></TD>
                <TD>
                
                <input type="submit" value="注册"/>
                  
              </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD><IMG src="images/login_3.jpg" 
border=0></TD></TR></TBODY></TABLE></DIV></DIV>


</FORM></BODY></HTML>


</body>
</html>