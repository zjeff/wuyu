<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>物语</title>
	<link rel="stylesheet" href="../style/main.css">
</head>
<body>
	<div id="container">
		<div id="logo">
			<h1><a href="#" title="物语">物语</a></h1>
		</div>
		<div id="nav">
			<ul id="navul">
				<li class="navli"><a class="nava" href=""><span>教育首页</span></a></li>
				<li class="navli"><a class="nava" href=""><span>物语事业</span></a></li>
				<li class="navli"><a class="nava active" href=""><span>新闻动态</span></a></li>
				<li class="navli"><a class="nava" href=""><span>教育品牌咨询</span></a></li>
				<li class="navli"><a class="nava" href=""><span>教育品牌研</span></a></li>
				<li class="navli"><a class="nava" href=""><span>精彩案例</span></a></li>
				<li class="navli"><a class="nava" href=""><span>联系我们</span></a></li>
			</ul>
		</div>
		<div id="banner"><a href=""><img src="../images/ads1.jpg" alt="" width="998" height="324"></a></div>
		<div id="maincontent">
			<div id="case" class="content">
				<ul class="taglist">
					<li><a href="" class="active"><span>小学案例</span></a></li>
					<li><a href=""><span>中学案例</span></a></li>
					<li><a href=""><span>高中案例</span></a></li>
					<li class="more"><a href="">更多&gt;&gt;</a></li>
				</ul>
				<ul class="contentdetail">
                    <c:forEach var="school" items="${level1}">
					<li>
						<a class="imgs" href=""
                           title="<c:out value="${school.school_logo}" />">
                            <img src="../images/${school.school_logo}" width="105" hei
                                 ght="95" alt=""></a>
						<a href="">${school.school_name}</a>
					</li>
                    </c:forEach>
					<li>
						<a class="imgs" href="" title="南京晓庄学院附属小学"><img src="../images/p2.jpg" width="105" height="95" alt=""></a>
						<a href="">南京晓庄学院附属小学</a>
					</li>
					<li>
						<a class="imgs" href="" title="南京晓庄学院附属小学"><img src="../images/p3.jpg" width="105" height="95" alt=""></a>
						<a href="">南京晓庄学院附属小学</a>
					</li>
					<li>
						<a class="imgs" href="" title="南京晓庄学院附属小学"><img src="../images/p4.jpg" width="105" height="95" alt=""></a>
						<a href="">南京晓庄学院附属小学</a>
					</li>
					<li>
						<a class="imgs" href="" title="南京晓庄学院附属小学"><img src="../images/p5.jpg" width="105" height="95" alt=""></a>
						<a href="">南京晓庄学院附属小学</a>
					</li>
				</ul>
			</div>
			<div id="caseother" class="content">
				<ul class="taglist">
					<li><a href="" class="active"><span>全日制学校案例</span></a></li>
					<li class="more"><a href="">更多&gt;&gt;</a></li>
				</ul>
				<ul class="contentdetail">
					<li>
						<a class="imgs" href="" title="南京晓庄学院附属小学"><img src="../images/p13.jpg" width="105" height="95" alt=""></a>
						<a href="">南京晓庄学院附属小学</a>
					</li>
					<li>
						<a class="imgs" href="" title="南京晓庄学院附属小学"><img src="../images/p14.jpg" width="105" height="95" alt=""></a>
						<a href="">南京晓庄学院附属小学</a>
					</li>
					<li>
						<a class="imgs" href="" title="南京晓庄学院附属小学"><img src="../images/p15.jpg" width="105" height="95" alt=""></a>
						<a href="">南京晓庄学院附属小学</a>
					</li>
				</ul>
			</div>
			<ul id="news">
				<li class="newslist contact">
					<h2 id="contact">联系方式</h2>
					<ul>
						<li><span>地址：</span>杭州拱墅区舟山东路七古登路建华文化才创意产业园</li>
						<li><span>电话：</span>0571-88282027<br />0571-88282027</li>
						<li><span>传真：</span>0571-88282027</li>
						<li><span>Mail：</span>cehua@zjkedao.com</li>
						<li><span>QQ：</span>786155996<br />738928847</li>
					</ul>
				</li>
				<li class="newslist">
					<h2>我们的团队</h2>
					<div id="imglist">
						<img src="../images/a1.jpg" width="229" height="148" alt="">
					</div>
					<div id="paginate">
						<a href="" class="active">1</a>
						<a href="">2</a>
						<a href="">3</a>
						<a href="">4</a>
						<a href="">5</a>
					</div>
				</li>
				<li class="newslist">
					<h2>校园动态</h2>
					<ul id="newdynamic">
                        <c:forEach var="feed" items="${feeds}">
						<li><a href="">${feed.title}</a></li>
                        </c:forEach>
					</ul>
					<div id="more">
						<a href="" title="更多">more</a>
					</div>
				</li>
				<li class="newslist">
					<h2>校内通知</h2>
					<h4>尊敬的师长，新年好！</h4>
					<p>21日上午，清华大学牵头的自主招生“华约”联盟，发布了2014年招生的联合公告。不过，从2011年起即加入“华约”的中国人民大学，未出现在公告名单中，“华约”7校联盟随之缩减为6校。</p>
					<p>21日上午，清华大学牵头的自主招生“华约”联盟，发布了2014年招生的联合公告。不过，从2011年起即加入“华约”的中国人民校。</p>
				</li>
			</ul>
		</div>
		<div id="column"></div>
		<div id="bottomlinks">
			<p>
				友情链接：
				<a href="">塑胶球场</a><span>&nbsp;|&nbsp;</span>
				<a href="">宁波学校家具</a><span>&nbsp;|&nbsp;</span>
				<a href="">vi设计</a><span>&nbsp;|&nbsp;</span>
				<a href="">幼儿园彩绘</a><span>&nbsp;|&nbsp;</span>
				<a href="">北京市教育网</a><span>&nbsp;|&nbsp;</span>
				<a href="">福建省奥翔塑胶跑道</a><span>&nbsp;|&nbsp;</span>
				<a href="">净化工程公司</a>
			</p>
			<p>
				版权所有：物语创意 copyright 2012 www.zjkedao.com all rights reserve
			</p>
			<p>技术支持： 玖零信息</p>
		</div>
	</div>
</body>
</html>