package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;

/**
 * ログイン認証を行うためにデータベースに接続するクラス
 *
 * @author yuhablog
 */
public class LoginDAO {

	/**
	 * usersテーブルに、IDとパスワードが合致するユーザーがいるか確認します。
	 * @param id
	 * @param password
	 * @return 成功: id / 失敗: 空文字
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String LoginAuthenticate(String sId, String sPassword) throws SQLException, ClassNotFoundException {
		// ID or 空文字(返却用変数)を格納します。
		String sReturnId = "";
		// SQLを作成します。(StringBuilderクラスのappendメソッドで文字列を結合)
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(" SELECT ");
		sbSql.append("	id ");
		sbSql.append(" FROM ");
		sbSql.append("	users ");
		sbSql.append(" WHERE ");
		sbSql.append("	id = ? ");
		sbSql.append(" AND ");
		sbSql.append("	password = ? ");

		// DBに接続しユーザー情報を取得します。
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pStmt = con.prepareStatement(sbSql.toString())) {
			pStmt.setString(1, sId);
			pStmt.setString(2, sPassword);

			// SQLを実行し、実行結果を格納します。
			ResultSet resultSQL = pStmt.executeQuery();

			// idとパスワードが合致するユーザーが存在する場合、ユーザーIDを設定します。
			if(resultSQL.next()) {
				sReturnId = resultSQL.getString("id");
			}
		}
		return sReturnId;
	}
}
