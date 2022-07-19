package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.Parameters;
import model.dao.UpdateDAO;
import model.dao.dto.TodoDTO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update-servlet")
public class UpdateServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
	}

	@Override
	protected void exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		// メソッドを取得
		String sMethod = request.getMethod();

		// リクエストメソッドの種類によって呼ぶ関数を変える
		if (sMethod.equals("GET")) {
			getGetRequest(request, response);
		} else if (sMethod.equals("POST")) {
			getPostRequest(request, response);
		}
	}

	/**
	 * GETリクエストを受け取った時の処理
	 */
	protected void getGetRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		// リクエストパラメータからtodoIdを取得する
		int iTodoId = 0;
		try {
			iTodoId = Integer.parseInt(request.getParameter(Parameters.sTODO_ID));
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("list-servlet").forward(request, response);
		}

		UpdateDAO updateDAO = new UpdateDAO();
		TodoDTO todoDTO = new TodoDTO();

		// todoの取得
		todoDTO = updateDAO.getTodo(iTodoId);

		request.setAttribute("todo", todoDTO);
		request.getRequestDispatcher("WEB-INF/jsp/update.jsp").forward(request, response);
	}

	/**
	 * POSTリクエストを受け取った時の処理
	 */
	protected void getPostRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		// リクエストパラメータから値を取得
		request.setCharacterEncoding("UTF-8");
		String sTodoContent = request.getParameter(Parameters.sTODO_Content);
		int iTodoId = Integer.parseInt(request.getParameter(Parameters.sTODO_ID));
		
		// DAOを生成し、Todoを更新する
		UpdateDAO updateDAO = new UpdateDAO();
		
		// 受け取ったパラメータを元にデータベースを更新する
		updateDAO.updateTodo(sTodoContent, iTodoId);
		response.sendRedirect("list-servlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータから値を取得する
		request.setCharacterEncoding("UTF-8");
		String sTodoContent = request.getParameter(Parameters.sTODO_Content);
		int iTodoId = Integer.parseInt(request.getParameter(Parameters.sTODO_ID));

		// DAOを生成し、Todoを更新する
		UpdateDAO updateDAO = new UpdateDAO();
		try {
			// 受け取ったパラメータを元にデータベースを更新する
			updateDAO.updateTodo(sTodoContent, iTodoId);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		response.sendRedirect("list-servlet");
	}

	/**
	 * リクエストパラメータから送られてきたTodoのIDをもとにDBからデータを取得し、画面に表示する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータからtodoIdを取得する
		int todoId = Integer.parseInt(request.getParameter(Parameters.sTODO_ID));

		UpdateDAO updateDAO = new UpdateDAO();
		TodoDTO todoDTO = new TodoDTO();
		try {
			// todoの取得
			todoDTO = updateDAO.getTodo(todoId);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("content", todoDTO);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

}
