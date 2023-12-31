<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户查看</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
	<img class="avatar size-XL l" src="../${ui.image }" style="border-radius:50%;"><!-- static/h-ui/images/ucnter/avatar-default.jpg -->
	<dl style="margin-left:80px; color:#fff">
		<dt>
			<span class="f-18">${ui.username }</span>
			<span class="pl-10 f-12">余额：${ui.money }</span>
			<span class="pl-10 f-12">店铺余额：${ui.dianpumoney }</span>
		</dt>

		<dd class="pt-10 f-12" style="margin-left:0">${ui.jianjie }</dd>
	</dl>
</div>
<div class="pd-20">
	<table class="table">
		<tbody>
			<tr>
				<th class="text-r" width="80">性别：</th>
				<td>${ui.sex.sexname }</td>
			</tr>
			
			<tr>
				<th class="text-r">手机：</th>
				<td>${ui.phone }</td>
			</tr>
			<tr>
				<th class="text-r">邮箱：</th>
				<td>${ui.email }</td>
			</tr>
			<tr>
				<th class="text-r">地址：</th>
				<td>${ui.address }</td>
			</tr>
			<tr>
				<th class="text-r">注册时间：</th>
				<td>${ui.u.createtime }</td>
			</tr>
			<tr>
				<th class="text-r">是否是店铺：</th>
				<td>
					<c:if test="${ui.isdianpu==1 }">
						店铺会员
					</c:if>
					<c:if test="${ui.isdianpu==0 }">
						普通用户
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> 
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
</body>
</html>