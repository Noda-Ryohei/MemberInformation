package jp.co.aforce.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.tool.Action;

public class SearchAction extends Action {

	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String msg = "";
		//		String url = request.getHeader("REFERER").replace("http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(), "..");
		String url = "../jsp/update.jsp";
		String memberNo = request.getParameter("memberNo");

		try {
			MemberDAO dao = new MemberDAO();
			MemberBean member = dao.search(memberNo);

			if (member != null) {
				request.setAttribute("member", member);
				request.setAttribute("msg", msg);
				return url;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			msg = "該当する会員情報が見つかりません。";
			request.setAttribute("msg", msg);
			return url;
		}
	}
}
