package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import bean.User;
import dao.userDAO;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// セッションオブジェクトの生成
			HttpSession session = request.getSession();

			// UserDAOクラスのオブジェクトを生成
			userDAO userDao = new userDAO();

			// エンコードを設定
			response.setContentType("text/html; charset=UTF-8");

			// email, password入力パラメータを取得する
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			// user情報を取得
			User user = userDao.selectByUser(email, password);

			// userが見つからない場合
			if (user == null) {
				request.setAttribute("message", "入力内容が間違っています。");
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);
				return;
			}

			// クッキー設定
			if (user != null) {
				session.setAttribute("user",  user);
				Cookie userCookie = new Cookie("email", user.getEmail());
				Cookie passwordCookie = new Cookie("password", user.getPassword());
				userCookie.setMaxAge(172800);
				passwordCookie.setMaxAge(172800);
				response.addCookie(userCookie);
				response.addCookie(passwordCookie);
				request.getRequestDispatcher("/list").forward(request, response);
			}

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログインはできませんでした。";
		} catch (Exception e) {
			e.printStackTrace();
			error = "エラーが発生しました。しばらくしてからもう一度お試しください。<br>" + e;
		} finally {
			if (!error.equals("")) {
				cmd = "logout";
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}
