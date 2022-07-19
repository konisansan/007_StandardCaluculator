package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TodoListDAO;
import model.dao.dto.TodoDTO;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list-servlet")
public class ListServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// todoの一覧を保持する変数を宣言
		List<TodoDTO> todoList = new ArrayList<>();

		// DAOを生成し、Todo一覧を取得する
		TodoListDAO dao = new TodoListDAO();
		try {
			// todo一覧を取得する
			todoList = dao.getTodoList();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// todo一覧をリクエストスコープに設定する
		request.setAttribute("todoList", todoList);
		// todo一覧画面に遷移する
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
		TodoListDAO dao = new TodoListDAO();

		// todo一覧を取得する
		todoList = dao.getTodoList();

		// todo一覧をリクエストスコープに設定する
		request.setAttribute("todoList", todoList);
		// todo一覧画面に遷移する
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		rd.forward(request, response);
	}
}
