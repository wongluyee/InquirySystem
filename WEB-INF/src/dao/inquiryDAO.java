package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.Inquiry;

public class inquiryDAO {
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

	// お問い合わせ一覧（管理者）
	public ArrayList<Inquiry> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Inquiry> inquiryList = new ArrayList<Inquiry>();

		try {
			String sql = "SELECT * FROM inquiry ORDER BY sent_at DESC;";
			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			// Inquiryインスタンス化して、各データを格納して、inquiryListに追加する
			while (rs.next()) {
				Inquiry inquiry = new Inquiry();
				inquiry.setInquiryId(rs.getInt("id"));
				inquiry.setEmail(rs.getString("email"));
				inquiry.setName(rs.getString("name"));
				inquiry.setSentAt(rs.getTimestamp("sent_at").toLocalDateTime());
				inquiry.setCategory(rs.getInt("category_id"));
				inquiry.setContents(rs.getString("contents"));
				inquiry.setAge(rs.getString("age"));
				inquiry.setGender(rs.getString("gender"));
				inquiry.setAddress(rs.getString("address"));
				inquiry.setIsReplied(rs.getInt("is_replied"));
				inquiryList.add(inquiry);
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
		return inquiryList;
	}

	// お問い合わせ詳細（管理者）
	public Inquiry selectById(int id) {

		Connection con = null;
		Statement smt = null;

		Inquiry inquiry = new Inquiry();

		try {
			String sql = "SELECT * FROM inquiry WHERE id = '" + id + "'";
			con = getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			// 結果セットからお問い合わせデータを取り出し、inquiryオブジェクトに格納する
			while (rs.next()) {
				inquiry.setInquiryId(rs.getInt("id"));
				inquiry.setEmail(rs.getString("email"));
				inquiry.setName(rs.getString("name"));
				inquiry.setSentAt(rs.getTimestamp("sent_at").toLocalDateTime());
				inquiry.setCategory(rs.getInt("category"));
				inquiry.setContents(rs.getString("contents"));
				inquiry.setAge(rs.getString("age"));
				inquiry.setGender(rs.getString("gender"));
				inquiry.setAddress(rs.getString("address"));
				inquiry.setIsReplied(rs.getInt("is_replied"));
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
		return inquiry;
	}

	// お問い合わせ追加・送信（サイト訪問者）
	public void insert(Inquiry inquiry) {

		Connection con = null;
		Statement smt = null;

		try {
			String sql = "INSERT INTO inquiry (email, name, sent_at, category, contents, age, gender, address) VALUES('" + inquiry.getEmail() + "','"
					+ inquiry.getName() + "','" + inquiry.getSentAt() + "'," + inquiry.getCategory() + ",'"
					+ inquiry.getContents() + "','" + inquiry.getAge() + "','" + inquiry.getGender() + "','"
					+ inquiry.getAddress() + "')";
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
