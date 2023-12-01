package servlet;

import java.time.LocalDateTime;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.Inquiry;
import dao.inquiryDAO;

public class InquiryServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// inquiryDAOをインスタンス化し、insertメソッドを呼び出す
			inquiryDAO inquiryDao = new inquiryDAO();

			// 画面からの入力情報を受け取るためのエンコードを設定
			response.setContentType("text/html; charset=UTF-8");

			// フォーム項目のパラメータを取得する
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			int category = Integer.parseInt(request.getParameter("category"));
			String contents = request.getParameter("contents");
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");

			// お問い合わせ送信日時
			LocalDateTime currentDateTime = LocalDateTime.now();


			// Inquiryオブジェクトに格納
			Inquiry inquiry = new Inquiry(email, name, currentDateTime, category, contents, age, gender, address);

			// Inquiryオブジェクトに格納されたデータをデータベースに登録
			inquiryDao.insert(inquiry);

		} catch (IllegalStateException e) {
			e.printStackTrace();
			error = "DB接続エラーの為、お問い合わせを送信できませんでした。";
		} catch (Exception e) {
			e.printStackTrace();
			error = "エラーが発生しました。しばらくしてからもう一度お試しください。<br>" + e;
		} finally {
			if (error.equals("")) {
				// フォワード
				request.getRequestDispatcher("/view/inquirySent.jsp").forward(request,  response);
			} else {
				cmd = "form";
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
