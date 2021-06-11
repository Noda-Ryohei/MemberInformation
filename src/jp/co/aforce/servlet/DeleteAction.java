package jp.co.aforce.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.tool.Action;

public class DeleteAction extends Action {

	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String msg = "";

		//		String referer = request.getHeader("REFERER");
		//		String serverName = request.getServerName();
		//		String serverPort = String.valueOf(request.getServerPort());
		//		String contextPath = request.getContextPath();
		//		referer = referer.replace("http://", "");
		//		referer = referer.replace(serverName, "");
		//		referer = referer.replace(serverPort, "");
		//		referer = referer.replace(contextPath, "");
		//		referer = referer.replace(":", "");
		//		referer = ".." + referer;
		//		String url = request.getHeader("REFERER").replace("http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(), "..");
		//		url = referer;

		String url = "../jsp/delete.jsp";

		//リクエストパラメータから各項目を取得。入力チェック
		//名前を取得
		String name = request.getParameter("name");
		//空文字の判定
		if (name == null || name.length() == 0) {
			msg = "入力されていない項目があります。"; // 数値とは分けて「氏名を入力してください」にしたくもあった。
			request.setAttribute("msg", msg);
			return url;
		}

		//各数値を取得（tryの内部で宣言すると、外側がスコープから外れる)。
		int age;
		int birthYear;
		int birthMonth;
		int birthDay;

		try {
			age = Integer.parseInt(request.getParameter("age"));
			birthYear = Integer.parseInt(request.getParameter("birthYear"));
			birthMonth = Integer.parseInt(request.getParameter("birthMonth"));
			birthDay = Integer.parseInt(request.getParameter("birthDay"));
		} catch (NumberFormatException e) {
			msg = "入力されていない項目があります。";
			// 「数値を入力または選択してください」にしたくもあった。
			//まあ、生年月日がセレクトボックスなので、このエラーメッセージが誤りであることはない。
			request.setAttribute("msg", msg);
			return url;
		}
		String memberNo = request.getParameter("memberNo");
		if (memberNo == null) {
			msg = "会員番号を入力してください。";
			request.setAttribute("msg", msg);
			return url;
		}
		//入力チェックここまで

		//会員beanを作成し各フィールドをセット。
		MemberBean member = new MemberBean();
		member.setMemberNo(memberNo);
		member.setName(name);
		member.setAge(age);
		member.setBirthYear(birthYear);
		member.setBirthMonth(birthMonth);
		member.setBirthDay(birthDay);

		try {
			MemberDAO dao = new MemberDAO();
			int line = dao.delete(member);

			if (line == 1) {
				msg = "削除に成功しました。";
				request.setAttribute("msg", msg);
				return url;
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			msg = "削除に失敗しました。";
			request.setAttribute("msg", msg);
			return url;
		}
	}
}
