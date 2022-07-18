package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.dao.dto.TodoDTO;

public class UpdateDAO {
	/**
	 * Todoデータを更新する
	 * @param id
	 * @param todo
	 * @return 更新行数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int updateTodo(int id, String todo) throws SQLException, ClassNotFoundException {
		// 変更した行数を返却するための変数
		int processingNumber = 0;

		// SQLを作成
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE ");
		sql.append("    todo ");
		sql.append(" SET ");
		sql.append("    todo = ? ");
		sql.append(" WHERE ");
		sql.append("    id = ? ");

		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql.toString())) {
			// パラメータに値を設定する
			pstmt.setString(1, todo);
			pstmt.setInt(2, id);

			// SQLを実行し、実行行数を受け取る
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
	
	public TodoDTO getTodo(int id) throws SQLException, ClassNotFoundException {
		// 取得したTodoを格納する変数
		TodoDTO todo = new TodoDTO();

		// Idを指定してTodoを取得するSQL
		String sql = "SELECT id, todo FROM todo where id = ? ";

		// DBに接続し、Todoを取得する
		try (Connection con = DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, id);

			// SQLを実行しTodoを取得する
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				// DBから取得したTodoの情報をtodoに持たせる
				todo.setId(res.getInt("id"));
				todo.setTodo(res.getString("todo"));
			}
		}

		return todo;

	}
}
