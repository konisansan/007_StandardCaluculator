package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import model.dao.InsertDAO;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert-servlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Todoをデータベースに登録するためのサーブレット
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータのname属性がtodoの値を受け取る
		String todo = (String) request.getParameter(Parameters.TODO);
		// リクエストパラメータのname属性がtimeLimitの値を受け取る
		// DAOを生成し、Todoをデータベースに登録する
		InsertDAO dao = new InsertDAO();
		try {
			// 受け取ったパラメータを引数に渡す
			dao.insertTodo(todo);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		response.sendRedirect("list-servlet");
	}

}
