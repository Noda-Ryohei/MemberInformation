<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>

<% 
	String msg = (String) request.getAttribute("msg"); 
	if (msg == null) msg = "";
	
// 	この処理どうにかしてまとめられんやろか。
	String name = request.getParameter("name");
	if (name == null) name = "";
	String age = request.getParameter("age");
	if (age == null) age = "";
	String birthYear = request.getParameter("birthYear");
	if (birthYear == null) birthYear = "";
	String birthMonth = request.getParameter("birthMonth");
	if (birthMonth == null) birthMonth = "";
	String birthDay = request.getParameter("birthDay");
	if (birthDay == null) birthDay = "";
	
// 	登録に成功したときは、入力値を消してあげたい。（二重登録防止）
	boolean regd = false;
	if (msg.length() >=5 && msg.substring(0,5).equals("登録に成功") ) regd = true;
%>

<p>会員情報新規登録画面</p>

<form action="../jp.co.aforce.servlet/Register.action" method="post">

	<p>名前<input type="text" name="name" value="<%=regd ? "" : name%>"></p> <!-- 初期値設定保留 -->
	<p>年齢<input type="text" name="age" value="<%=regd ? "" : age%>"></p> <!-- 初期値設定保留 -->
	<p>
		生年月日
		<select name="birthYear">
			<option value=""></option>
			<% 
				for (int i=1920; i<=2020; i++) {
					out.print("<option value=\"" + i + "\"");
					if ( birthYear.equals(String.valueOf(i)) && !regd) {
						out.print("selected");
					}
					out.println(">" + i + "</option>");
				} 
			%>
		</select>
		<select name="birthMonth">
			<option value=""></option>
			<% 
				for (int i=1; i<=12; i++) { 
					out.print("<option value=\"" + i + "\"");
					if (birthMonth.equals(String.valueOf(i)) && !regd) {
						out.print("selected");
					}
					out.println(">" + i + "</option>");
			 	} 
			 %>
		</select>
		<select name="birthDay">
			<option value=""></option>
			<% 
				for (int i=1; i<=31; i++) {
					out.print("<option value=\"" + i + "\"");
					if (birthDay.equals(String.valueOf(i)) && !regd) {
						out.print("selected");
					}
					out.println(">" + i + "</option>");
				} 
			%>
		</select>
	</p>
	<button type="button" onclick="location.href='../jsp/menu.jsp'">戻る</button>
	<button type="submit">登録</button>


</form>
<p><%=msg %></p>

<%@ include file="../footer.html" %>