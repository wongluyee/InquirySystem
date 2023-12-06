package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.Inquiry;
import bean.User;
import dao.inquiryDAO;

public class ListServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = null;

		try {
			// セッションから"user"のUserオブジェクトを取得する（権限確認のため）
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			// セッション切れの場合はerror.jspに遷移する
			if (user == null) {
				error = "セッションが切れたため、再度ログインしてください。";
				cmd = "logout";
				return;
			}
			// inquiryDAOクラスのオブジェクトを生成
			inquiryDAO inquiryDao = new inquiryDAO();

			// お問合せを格納する配列を作成、selectAllメソッドを呼び出し
			ArrayList<Inquiry> list = inquiryDao.selectAll();

			// 検索結果を持ってlist.jspにフォワード
			request.setAttribute("list", list);

		} catch (IllegalStateException e) {
			e.printStackTrace();
			error = "DB接続エラーの為、一覧表示はできませんでした。";
		} catch (Exception e) {
			e.printStackTrace();
			error = "エラーが発生しました。しばらくしてからもう一度お試しください。<br>" + e;
		} finally {
			if (error.equals("")) {
				// 一覧画面へ
				request.getRequestDispatcher("/view/list.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}