<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>主页</title>
		<link rel="stylesheet" type="text/css" href="../css//main.css" />
		
	</head>
	<body>
		<div id="header">
			<div id="header_tupian"><img src="../images/bilibili.png"  /></div>
			<div id="header_word">
				<div id="p">
					<p >当前用户:${currentUser}  <a href="../servlet/logout.do" id="header_p_a">[安全退出]</a></p>
				</div>
				<div id="con">
				
					<div id="li">
						<a href="#" class="a1">首页</a>
					</div>
					<div id="li">
						<a href="#" class="a1">学院</a>
					</div>
					<div id="li">
						<a href="#" class="a1">简介</a>
					</div>
					
					<div id="li">
						<a href="../servlet/GetDownloadListController" class="a1">下载</a>
					</div>
					
					
					<div id="li">
						<a href="#" class="a1">学生</a>
					</div>
					
					<div id="li">
						<a href="#" class="a1">比赛</a>
					</div>
				</div>

			</div>
			
		</div>
		
		
		<div id="center">
		</div>
		<div id="element"><img src="../images/men.jpg" /></div>
		
	</body>
</html>
