package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import model.dao.InsertDAO;
import model.dao.TodoListDAO;
import model.dao.dto.TodoDTO;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert-servlet")
public class InsertServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Todoをデータベースに登録するためのサーブレット
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータのname属性がtodoの値を受け取る
		String sTodoContent = (String) request.getParameter(Parameters.sTODO_Content);
		// リクエストパラメータのname属性がtimeLimitの値を受け取る
		// DAOを生成し、Todoをデータベースに登録する
		InsertDAO insertDAO = new InsertDAO();
		try {
			// 受け取ったパラメータを引数に渡す
			insertDAO.iInsertTodo(sTodoContent);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		response.sendRedirect("list-servlet");
	}

	/**
	 * todoテーブルからtodoを取得し、一覧表示する
	 */
	@Override
	protected void exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		// todoの一覧を保持する変数を宣言
		List<TodoDTO> todoList = new ArrayList<>();

		// DAOを生成し、Todo一覧を取得する
		TodoListDAO todoListDAO = new TodoListDAO();

		// todo一覧を取得する
		todoList = todoListDAO.getTodoList();

		// todo一覧をリクエストスコープに設定する
		request.setAttribute("todoList", todoList);
		// todo一覧画面に遷移する
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		rd.forward(request, response);
	}

}
