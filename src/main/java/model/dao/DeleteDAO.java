package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

public class DeleteDAO {
	/**
	 * Todoを削除する
	 * 
	 * @return 削除した行数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int deleteTodo(int iTodoId) throws SQLException, ClassNotFoundException {
		int processingNumber = 0;

		// SQL文
		String sDeleteSQL = "DELETE FROM todo WHERE id = ?";

		// DBに接続し、Todoを削除する
		try (Connection con = DBConnection.getConnection(); PreparedStatement pStmt = con.prepareStatement(sDeleteSQL)) {
			// todoIdを設定
			pStmt.setInt(1, iTodoId);

			// SQLの実行
			processingNumber = pStmt.executeUpdate();
		}
		return processingNumber;
	}
}
