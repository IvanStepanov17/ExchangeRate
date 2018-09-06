<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review of exchanges</title>
</head>
<title>Best selling and buying prices</title>
<meta http-equiv="refresh" content="10">
</head>
<body>
	<h2>Current course</h2>
	<hr />
	<p>
		<%
			if (request.getAttribute("purchasePriceHitBTC") != null) {
				out.println(
						"<p>Лучшая цена покупки на HitBTC: " + request.getAttribute("purchasePriceHitBTC") + "</p>");
			}
			if (request.getAttribute("sellingPriceHitBTC") != null) {
				out.println("<p>Лучшая цена продажи на HitBCT: " + request.getAttribute("sellingPriceHitBTC") + "</p>");
			}
			if (request.getAttribute("purchasePricePoloniex") != null) {
				out.println("<p>Лучшая цена покупки на Poloniex: " + request.getAttribute("purchasePricePoloniex")
						+ "</p>");
			}
			if (request.getAttribute("sellingPricePoloniex") != null) {
				out.println(
						"<p>Лучшая цена продажи на Poloniex: " + request.getAttribute("sellingPricePoloniex") + "</p>");
			}
			
			Calendar calendar = new GregorianCalendar();
			String am_pm;
			int hour = calendar.get(Calendar.HOUR);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			if (calendar.get(Calendar.AM_PM) == 0)
				am_pm = "AM";
			else
				am_pm = "PM";
			String CT = hour + ":" + minute + ":" + second + " " + am_pm;
			out.println("Текущее время: " + CT + "\n");
		%>
	</p>
	<hr />
	<br>
	<a href="index.jsp">Вернуться к выбору валюты</a>
</body>
</html>