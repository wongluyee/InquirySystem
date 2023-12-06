package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Reply;
import bean.User;
import dao.inquiryDAO;
import dao.replyDAO;
import util.SendMail;

public class ReplyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = null;

		int inquiryId = 0;

		try {
			// セッションから"user"のUserオブジェクトを取得する（userIdを取得するため）
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");

			// セッション切れの場合はerror.jspに遷移する
			if (user == null) {
				error = "セッションが切れたため、再度ログインしてください。";
				cmd = "logout";
				return;
			}

			// 画面からの入力情報を受け取るためのエンコードを設定
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");

			// フォーム項目のパラメータを取得する
			String email = request.getParameter("email");
			inquiryId = Integer.parseInt(request.getParameter("id"));
			int userId = user.getUserid();
			String subject = request.getParameter("subject");
			String contents = request.getParameter("contents");

			// 返信日時
			LocalDateTime currentDateTime = LocalDateTime.now();

			// Replyオブジェクトに格納
			Reply reply = new Reply(inquiryId, userId, subject, contents, currentDateTime);

			// replyDAOをインスタンス化し、insertメソッドを呼び出す
			replyDAO replyDao = new replyDAO();
			// Replyオブジェクトに格納されたデータをデータベースに登録
			replyDao.insert(reply);

			// メール送信する
			SendMail sendMail = new SendMail();
			String emailSubject = "RE: #" + inquiryId + " " + subject;

			sendMail.sendEmail(email, emailSubject, contents);

			// お問い合わせを返信済みにする
			inquiryDAO inquiryDao = new inquiryDAO();
			inquiryDao.updateStatus(inquiryId);

		} catch (IllegalStateException e) {
			e.printStackTrace();
			error = "DB接続エラーの為、返信できませんでした。";
		} catch (Exception e) {
			e.printStackTrace();
			error = "エラーが発生しました。しばらくしてからもう一度お試しください。<br>" + e;
		} finally {
			if (error.equals("")) {
				// フォワード
				request.getRequestDispatcher("/show?id=" + inquiryId).forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
