package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Reply;

public class replyDAO {
	// データベース接続情報
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/inquirydb";
	private static String USER = "root";
	private static String PASS = "root123";

	private static Connection getConnection() {
		try {
			// JDBCドライバーを読み込む
			Class.forName(RDB_DRIVE);

			// Connectionする
			Connection con = DriverManager.getConnection(URL, USER, PASS);

			return con;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	// お問い合わせへの返信一覧
	public ArrayList<Reply> selectAllByInquiryId(int inquiryId) {

		Connection con = null;
		Statement smt = null;

		ArrayList<Reply> replyList = new ArrayList<Reply>();

		try {
			String sql = "SELECT * FROM reply WHERE inquiry_id = '" + inquiryId + "'";
			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			// Replyインスタンス化して、各データを格納して、replyListに追加する
			while (rs.next()) {
				Reply reply = new Reply();
				reply.setReplyId(rs.getInt("id"));
				reply.setInquiryId(rs.getInt("inquiry_id"));
				reply.setUserId(rs.getInt("user_id"));
				reply.setSubject(rs.getString("subject"));
				reply.setContents(rs.getString("contents"));
				reply.setRepliedAt(rs.getString("replied_at"));
				replyList.add(reply);
			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return replyList;
	}

	// お問い合わせへの返信
	public void insert(Reply reply) {

		Connection con = null;
		Statement smt = null;

		try {
			String sql = "INSERT INTO reply VALUES(" + reply.getInquiryId() + ","
					+ reply.getUserId() + ",'" + reply.getSubject() + "','" + reply.getContents() + "','"
					+ reply.getRepliedAt() + "')";
			con = getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}
}
