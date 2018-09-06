<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ajax.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#ajax").click(
				function() {
					$.ajax({
						type : "POST",
						url : "ajax",
						success : function(msg) {
							$(".user").empty();
							for ( var i = 0; i < msg.length; i++) {
								var p = "<p> " + msg[i].username + "   "
										+ msg[i].address + "-->"
										+ msg[i].birthday + "</p>";
								$(".user").append(p);
							}
						}
					});
				});
	});
</script>


</head>

<body>
	<a href="javascript:void(0);" id="ajax">ajax</a>

	<div class="user"></div>
</body>
</html>
