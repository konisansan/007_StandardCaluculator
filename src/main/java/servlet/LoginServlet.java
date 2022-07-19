package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.Parameters;
import constant.SessionInfo;
import model.dao.LoginDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	/**
	 * GETメソッドでリクエストを受け付けた時はログイン画面を表示する login.jspを画面に表示
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * POSTメソッドでリクエストを受け付けた時はログイン認証を行う 成功した時はTodo一覧画面に遷移 失敗した時はログイン画面に戻す
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストからidとパスワードを取得する
		String sId = request.getParameter(Parameters.sLOGIN_ID);
		String sPassword = request.getParameter(Parameters.sLOGIN_PASSWORD);

		// ユーザーidを格納します。
		String sLoginId = "";

		// LoginDAOを生成します。
		LoginDAO loginDao = new LoginDAO();

		// データベースに接続し、入力データがusersテーブルにあればユーザーidを取得します。
		try {
			sLoginId = loginDao.LoginAuthenticate(sId, sPassword);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 遷移先のパスを格納します。
		String sPath = "";
		// loginIdが空文字かどうかでログイン成否を判定します。
		if (sLoginId != "") {
			// セッションにログインIDを保持します。
			HttpSession session = request.getSession();
			session.setAttribute(SessionInfo.sLOGIN_USER_ID, sLoginId);
			sPath = "list-servlet";
		} else {
			sPath = "login.jsp";
		}

		// 設定されているパスに遷移する
		request.getRequestDispatcher(sPath).forward(request, response);
	}

}
