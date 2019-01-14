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
				<p></p>
				<div class="mem_tit">收货地址</div>
				<div class="address">
					<c:forEach items="${addressList }" var="address">
						<div class="a_close">
							<a href="#"><img src="images/a_close.png" /></a>
						</div>
						<table border="0" class="add_t" align="center"
							style="width: 98%; margin: 10px auto;" cellspacing="0"
							cellpadding="0">

							<tr>
								<td colspan="2" style="font-size: 14px; color: #ff4e00;">${address.title }</td>
							</tr>
							<tr>
								<td align="right" width="80">收货人姓名：</td>
								<td>${address.consigneeName }</td>
							</tr>
							<tr>
								<td align="right">配送区域：</td>
								<td>${address.area }</td>
							</tr>
							<tr>
								<td align="right">详细地址：</td>
								<td>${address.specifiedAddress }</td>
							</tr>
							<tr>
								<td align="right">手机：</td>
								<td>${address.consigneeMobilePhone }</td>
							</tr>
							<tr>
								<td align="right">电话：</td>
								<td>${address.consigneePhone }</td>
							</tr>
							<tr>
								<td align="right">电子邮箱：</td>
								<td>${address.consigneeEmail }</td>
							</tr>


						</table>

						<p align="right">
							<c:if test="${address.isDefault==0 }">
								<a href="/shoppingstreet/member_setDefault?addressId=${address.id }" style="color: #ff4e00;">设为默认</a>&nbsp; &nbsp; &nbsp;
							&nbsp;<a href="/shoppingstreet/member_delAddress?addressId=${address.id }" style="color: #ff4e00;">删除</a>&nbsp; &nbsp;
							&nbsp; &nbsp; </c:if>
							<c:if test="${address.isDefault==1 }">
								<font color="#ff4e00">【默认地址】</font>&nbsp; &nbsp; &nbsp;
							&nbsp;</c:if>
							
						</p>
						<div style="border: 1px solid gray; width: 100%;"></div>
					</c:forEach>
				</div>
				<div class="mem_tit">
					<a href="#"><img src="images/add_ad.gif" /></a>
				</div>
				<form action="/shoppingstreet/member_addAddress" method="post"
					id="addAddressForm">
					<table border="0" class="add_tab" style="width: 930px;"
						cellspacing="0" cellpadding="0">
						<tr>
							<td>地址标题</td>
							<td><input type="text" class="add_ipt" name="title"
								value="学校" />（必填）</td>
							<td width="135" align="right">配送地区</td>
							<td style="font-family: '宋体';"><input type="text"
								class="add_ipt" name="area" value="河北秦皇岛" />（必填）</td>

						</tr>
						<tr>
							<td align="right">收货人姓名</td>
							<td style="font-family: '宋体';"><input type="text"
								value="熊思敏" class="add_ipt" name="consigneeName" />（必填）</td>
							<td align="right">电子邮箱</td>
							<td style="font-family: '宋体';"><input type="text"
								value="12345678@qq.com" class="add_ipt" name="consigneeEmail" />（必填）</td>
						</tr>
						<tr>
							<td align="right">详细地址</td>
							<td style="font-family: '宋体';"><input type="text" value="燕大"
								class="add_ipt" name="specifiedAddress" />（必填）</td>
							<td align="right">邮政编码</td>
							<td style="font-family: '宋体';"><input type="text"
								value="610000" class="add_ipt" /></td>
						</tr>
						<tr>
							<td align="right">手机</td>
							<td style="font-family: '宋体';"><input type="text"
								value="1361234587" class="add_ipt" name="consigneeMobilePhone" />（必填）</td>
							<td align="right">电话</td>
							<td style="font-family: '宋体';"><input type="text"
								value="028-12345678" class="add_ipt" name="consigneePhone" /></td>
						</tr>
					</table>
					<p align="right">
						<a onclick="doAddAddress()" class="add_b">保存</a>
					</p>
				</form>


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
	<script>
		function doAddAddress() {
			jQuery("#addAddressForm").submit();
		}
	</script>
</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
