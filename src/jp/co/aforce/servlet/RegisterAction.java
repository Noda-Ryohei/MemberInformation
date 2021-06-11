package jp.co.aforce.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.tool.Action;

public class RegisterAction extends Action {

	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		String msg = "";

		//遷移元URL取得挑戦の跡
		//		String referer = request.getHeader("REFERER");
		//		String url = request.getHeader("REFERER").replace("http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(), "..");
		String url = "../jsp/register.jsp";
		//		System.out.println(referer);

		//リクエストパラメータから各項目を取得。入力チェック
		//名前を取得
		String name = request.getParameter("name");
		//空文字の判定
		if (name.length() == 0) { //isEmptyメソッドがある。
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
		//入力チェックここまで

		//会員番号を生成。
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String memberNo = "A" + format.format(new Date());

		//会員beanを作成し各フィールドをセット。
		MemberBean member = new MemberBean();
		member.setMemberNo(memberNo);
		member.setName(name);
		member.setAge(age);
		member.setBirthYear(birthYear);
		member.setBirthMonth(birthMonth);
		member.setBirthDay(birthDay);

		//DAOを作成して挿入を実行、更新した行数が返ってくる。

		try {
			MemberDAO dao = new MemberDAO();
			int line = dao.insert(member);

			if (line == 1) { //登録成功。
				msg = "登録に成功しました。<br>会員番号は「" + memberNo + "」です。";
				request.setAttribute("msg", msg);
				return url;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			msg = "登録に失敗しました。";
			request.setAttribute("msg", msg);
			return url;
		}
	}
}
