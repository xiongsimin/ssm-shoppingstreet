<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->

<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>

<script type="text/javascript" src="js/select.js"></script>


<title>购物街</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/Head.jsp"%>
	<div class="i_bg bg_color">
		<!--Begin 用户中心 Begin -->
		<div class="m_content">
			<%@ include file="/WEB-INF/jsp/Member_Left.jsp"%>
			<div class="m_right">
				<div class="m_des">
					<table border="0" style="width: 870px; line-height: 22px;"
						cellspacing="0" cellpadding="0">
						<tr valign="top">
							<td width="115"><img src="images/user2.jpg" width="90"
								height="90" /></td>
							<td>
								<div class="m_user">${sessionScope.userName }</div>
								<p>
									等级：注册用户 <br /> <font color="#ff4e00">您还差 270 积分达到 分红100</font><br />
									上一次登录时间: 2015-09-28 18:19:47<br /> 您还没有通过邮件认证 <a href="#"
										style="color: #ff4e00;">点此发送认证邮件</a>
								</p>
								<div class="m_notice">用户中心公告！</div>
							</td>
						</tr>
					</table>
				</div>

				<!-- <div class="mem_t">资产信息</div>
				<table border="0" class="mon_tab"
					style="width: 870px; margin-bottom: 20px;" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="33%">用户等级：<span style="color: #555555;">普通会员</span></td>
						<td width="33%">消费金额：<span>￥200元</span></td>
						<td width="33%">返还积分：<span>99R</span></td>
					</tr>
					<tr>
						<td>账户余额：<span>￥200元</span></td>
						</td>
						<td>红包个数：<span style="color: #555555;">3个</span></td>
						</td>
						<td>红包价值：<span>￥50元</span></td>
						</td>
					</tr>
					<tr>
						<td colspan="3">订单提醒： <font style="font-family: '宋体';">待付款(<span>0</span>)
								&nbsp; &nbsp; &nbsp; &nbsp; 待收货(<span>2</span>) &nbsp; &nbsp;
								&nbsp; &nbsp; 待评论(<span>1</span>)
						</font>
						</td>
					</tr>
				</table> -->

				<div class="mem_t">账号信息</div>
				<table border="0" class="acc_tab" style="width: 870px;"
					cellspacing="0" cellpadding="0">
					<tr>
						<td class="td_l">用户ID：</td>
						<td>${user.id }</td>
					</tr>
					<tr>
						<td class="td_l b_none">身份证号：</td>
						<td>522124***********8</td>
					</tr>
					<tr>
						<td class="td_l b_none">电 话：</td>
						<td>${user.phone }</td>
					</tr>
					<tr>
						<td class="td_l">邮 箱：</td>
						<td>${user.email }</td>
					</tr>
					<tr>
						<td class="td_l b_none">注册时间：</td>
						<td>2019/1/10</td>
					</tr>
					<tr>
						<td class="td_l">完成订单：</td>
						<td>0</td>
					</tr>
					<tr>
						<td class="td_l b_none">邀请人：</td>
						<td>${user.inviterName }</td>
					</tr>
					<tr>
						<td class="td_l">登录次数：</td>
						<td>3</td>
					</tr>
				</table>


			</div>
		</div>
		<!--End 用户中心 End-->
		<!--Begin Footer Begin -->
		<div class="b_btm_bg b_btm_c">
			<div class="b_btm">
				<table border="0"
					style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="72"><img src="images/b1.png" width="62"
							height="62" /></td>
						<td><h2>正品保障</h2>正品行货 放心购买</td>
					</tr>
				</table>
				<table border="0"
					style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="72"><img src="images/b2.png" width="62"
							height="62" /></td>
						<td><h2>满38包邮</h2>满38包邮 免运费</td>
					</tr>
				</table>
				<table border="0"
					style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="72"><img src="images/b3.png" width="62"
							height="62" /></td>
						<td><h2>天天低价</h2>天天低价 畅选无忧</td>
					</tr>
				</table>
				<table border="0"
					style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="72"><img src="images/b4.png" width="62"
							height="62" /></td>
						<td><h2>准时送达</h2>收货时间由你做主</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="b_nav">
			<dl>
				<dt>
					<a href="#">新手上路</a>
				</dt>
				<dd>
					<a href="#">售后流程</a>
				</dd>
				<dd>
					<a href="#">购物流程</a>
				</dd>
				<dd>
					<a href="#">订购方式</a>
				</dd>
				<dd>
					<a href="#">隐私声明</a>
				</dd>
				<dd>
					<a href="#">推荐分享说明</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<a href="#">配送与支付</a>
				</dt>
				<dd>
					<a href="#">货到付款区域</a>
				</dd>
				<dd>
					<a href="#">配送支付查询</a>
				</dd>
				<dd>
					<a href="#">支付方式说明</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<a href="#">会员中心</a>
				</dt>
				<dd>
					<a href="#">资金管理</a>
				</dd>
				<dd>
					<a href="#">我的收藏</a>
				</dd>
				<dd>
					<a href="#">我的订单</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<a href="#">服务保证</a>
				</dt>
				<dd>
					<a href="#">退换货原则</a>
				</dd>
				<dd>
					<a href="#">售后服务保证</a>
				</dd>
				<dd>
					<a href="#">产品质量保证</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<a href="#">联系我们</a>
				</dt>
				<dd>
					<a href="#">网站故障报告</a>
				</dd>
				<dd>
					<a href="#">购物咨询</a>
				</dd>
				<dd>
					<a href="#">投诉与建议</a>
				</dd>
			</dl>
			<div class="b_tel_bg">
				<a href="#" class="b_sh1">新浪微博</a> <a href="#" class="b_sh2">腾讯微博</a>
				<p>
					服务热线：<br /> <span>400-123-4567</span>
				</p>
			</div>
			<div class="b_er">
				<div class="b_er_c">
					<img src="images/er.gif" width="118" height="118" />
				</div>
				<img src="images/ss.png" />
			</div>
		</div>
		<div class="btmbg">
			<div class="btm">
				备案/许可证编号：京ICP备070360号 Copyright © 2016-2019 购物街 All Rights Reserved.
				复制必究 , Technical Support: ICT Group <br /> <img
					src="images/b_1.gif" width="98" height="33" /><img
					src="images/b_2.gif" width="98" height="33" /><img
					src="images/b_3.gif" width="98" height="33" /><img
					src="images/b_4.gif" width="98" height="33" /><img
					src="images/b_5.gif" width="98" height="33" /><img
					src="images/b_6.gif" width="98" height="33" />
			</div>
		</div>
		<!--End Footer End -->
	</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
