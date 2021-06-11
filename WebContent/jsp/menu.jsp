<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../header.html" %>
<!-- css死闘の跡。 -->
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Servlet/JSP MemberInformation</title> -->
<!-- <link rel="stylesheet" href="../css/style.css"> -->
<!-- </head> -->
<!-- <body> -->
<p class="red">メニュー画面</p>
<p>
	<button type="button" onclick="location.href='register.jsp'">
		会員情報新規登録
	</button>
</p>
<p>
	<button type="button" onclick="location.href='update.jsp'">
		会員情報変更
	</button>
</p>
<p>
	<button type="button" onclick="location.href='delete.jsp'">
		会員情報削除
	</button>
</p>
<%@ include file="../footer.html" %>