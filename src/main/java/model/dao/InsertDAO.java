package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

/**
 * Todoをデータベースに登録するクラス
 * @author yuhablog
 */
public class InsertDAO {

	/**
	 * Todoをデータベースに登録する
	 *
	 * @param todoの内容
	 * @param 期限
	 * @return 登録数
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int iInsertTodo(String sTodoContent)throws ClassNotFoundException, SQLException {
		// 更新した行数を返却するための変数
		int iProcessingNumber = 0;

		// 実行するSQL
		String sInsertSQL = "INSERT INTO todo (content) VALUES (?)";

		// SQLを実行する
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pStmt = con.prepareStatement(sInsertSQL)) {
			// パラメータに値を設定する
			// 1つ目のパラメータにtodoの内容を設定
			pStmt.setString(1, sTodoContent);
			// SQLを実行し、実行行数を受け取る
			iProcessingNumber = pStmt.executeUpdate();
		}
		return iProcessingNumber;
	}
}