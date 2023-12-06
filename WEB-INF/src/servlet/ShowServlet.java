package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.Inquiry;
import dao.inquiryDAO;

public class ShowServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// エンコードを設定
			response.setContentType("text/html; charset=UTF-8");

			// 画面から送信されるinquiryIdを受け取ります。
			int inquiryId = Integer.parseInt(request.getParameter("id"));

			// inquiryDAOクラスのオブジェクトを生成
			inquiryDAO inquiryDao = new inquiryDAO();

			// お問い合わせの情報を取得
			Inquiry inquiry = inquiryDao.selectById(inquiryId);

			// 取得した情報を「inquiry」という名前でリクエストスコープに登録
			request.setAttribute("inquiry", inquiry);

			request.getRequestDispatcher("/view/show.jsp").forward(request, response);

		} catch (IllegalStateException e) {
			e.printStackTrace();
			error = "DB接続エラーの為、お問い合わせの詳細表示はできませんでした。";
		} catch (Exception e) {
			e.printStackTrace();
			error = "エラーが発生しました。しばらくしてからもう一度お試しください。<br>" + e;
		} finally {
			if (!error.equals("")) {
				cmd = "menu";
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}
