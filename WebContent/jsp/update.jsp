<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>

<%@ page import="jp.co.aforce.bean.MemberBean" %>
<% 
	String msg = (String) request.getAttribute("msg"); 
	if (msg == null) msg = "";
	MemberBean member = (MemberBean) request.getAttribute("member");
%>

<p>会員情報変更画面</p>

<form action="../jp.co.aforce.servlet/Search.action" method="post">
	<p>
		<input type="text" name="memberNo" value="${member.memberNo}" <% if (member != null) out.print("disabled"); %>>
		<button type="submit"<% if (member != null) out.print("disabled"); %>>表示</button>
	</p>
</form>


<form action="../jp.co.aforce.servlet/Update.action" method="post">

	<input type="text" name="memberNo" value="${member.memberNo}" style="display: none;">
	<p>名前<input type="text" name="name" value="${member.name}" <% if (member == null) out.print("disabled"); %>></p>
	<p>年齢<input type="text" name="age" value="${member.age}" <% if (member == null) out.print("disabled"); %>></p>
	<p>
		生年月日
		<select name="birthYear">
			<option value="" disabled></option>
			<% 
				for (int i=1920; i<=2020; i++) {
					out.print("<option value=\"" + i +"\""); 
					if (member == null) {
						out.print("disabled");
					} else if (i == member.getBirthYear()) {
						out.print("selected"); 
					}
					out.println(">" + i + "</option>");
				} 
			%>
		</select>
		<select name="birthMonth">
			<option value="" disabled></option>
			<% 
				for (int i=1; i<=12; i++) {
					out.print("<option value=\"" + i +"\""); 
					if (member == null) {
						out.print("disabled");
					} else if (i == member.getBirthMonth()) {
						out.print("selected"); 
					}
					out.println(">" + i + "</option>");
				} 
			%>
		</select>
		<select name="birthDay">
			<option value="" disabled></option>
			<% 
				for (int i=1; i<=31; i++) {
					out.print("<option value=\"" + i +"\""); 
					if (member == null) {
						out.print("disabled");
					} else if (i == member.getBirthDay()) {
						out.print("selected"); 
					} 
					out.println(">" + i + "</option>");
				} 
			%>
		</select>
	</p>
	<button type="button" onclick="location.href='../jsp/menu.jsp'">戻る</button>
	<button type="submit" <% if (member == null) out.print("disabled"); %>>登録</button>


</form>
<p><%=msg %></p>

<%@ include file="../footer.html" %>