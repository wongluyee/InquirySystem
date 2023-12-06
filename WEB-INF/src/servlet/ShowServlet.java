package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.Inquiry;
import bean.Reply;
import bean.User;
import dao.inquiryDAO;
import dao.replyDAO;

public class ShowServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			// エンコードを設定
			response.setContentType("text/html; charset=UTF-8");

			// inquiryIdを受け取ります。
			int inquiryId = Integer.parseInt(request.getParameter("id"));

			// inquiryDAOクラスのオブジェクトを生成
			inquiryDAO inquiryDao = new inquiryDAO();

			// お問い合わせの情報を取得
			Inquiry inquiry = inquiryDao.selectById(inquiryId);

			// 取得した情報を「inquiry」という名前でリクエストスコープに登録
			request.setAttribute("inquiry", inquiry);

			// 返信一覧
			// replyDAOクラスのオブジェクトを生成
			replyDAO replyDao = new replyDAO();

			// すべての返信を格納する配列を作成、selectAllByInquiryIdメソッドを呼び出し
			ArrayList<Reply> list = replyDao.selectAllByInquiryId(inquiryId);

			// 検索結果を持ってlist.jspにフォワード
			request.setAttribute("list", list);

			request.getRequestDispatcher("/view/show.jsp").forward(request, response);

		} catch (IllegalStateException e) {
			e.printStackTrace();
			error = "DB接続エラーの為、お問い合わせの詳細表示はできませんでした。";
		} catch (Exception e) {
			e.printStackTrace();
			error = "エラーが発生しました。しばらくしてからもう一度お試しください。<br>" + e;
		} finally {
			if (!error.equals("")) {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}
