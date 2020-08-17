package ngoan_7C4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import ngoan_7C4.sinhvien;

public class sinhvienDbUtil {
	private DataSource dataSource;

	public sinhvienDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<sinhvien> getsinhviens() throws Exception {
		List<sinhvien> sinhvien = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {

			myConn = dataSource.getConnection();

			String sql = "select * from sinh_vien order by masv";
			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {

				int masv = myRs.getInt("masv");
				String hoten = myRs.getString("hoten");
				String tenkhoa = myRs.getString("tenkhoa");
				String gioitinh = myRs.getString("gioitinh");
				int diemtin = myRs.getInt("diemtin");
				

				sinhvien tempsinhvien = new sinhvien(masv, hoten, tenkhoa, gioitinh, diemtin);

				sinhvien.add(tempsinhvien);
			}
			return sinhvien;
		} finally {

			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();

			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addsinhvien(sinhvien thesinhvien) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {

			myConn = dataSource.getConnection();

			String sql = "insert into sinh_vien " + "(hoten, tenkhoa, gioitinh ,diemtin) " + "values (? , ? , ? ,? )";
			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, thesinhvien.getHoten());
			myStmt.setString(2, thesinhvien.getTenkhoa());
		
			myStmt.setString(3, thesinhvien.getGioitinh());
			myStmt.setInt(4, thesinhvien.getDiemtin());

			myStmt.execute();
		} finally {

			close(myConn, myStmt, null);
		}
	}

	public sinhvien getsinhvien(String thesinhvienid) throws Exception {

		sinhvien thesinhvien = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int masv;
		try {
			masv = Integer.parseInt(thesinhvienid);

			myConn = dataSource.getConnection();

			String sql = "select * from sinh_vien where masv=?";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, masv);

			myRs = myStmt.executeQuery();

			if (myRs.next()) {
			
				String hoten = myRs.getString("hoten");
				String tenkhoa= myRs.getString("tenkhoa");
				String gioitinh = myRs.getString("gioitinh");
				int diemtin = myRs.getInt("diemtin");

				thesinhvien = new sinhvien(masv, hoten, tenkhoa, gioitinh, diemtin);
			} else {
				throw new Exception("Could not find student masv: " + masv);
			}
			return thesinhvien;
		} finally {

			close(myConn, myStmt, myRs);
		}
	}

	public void updatesinhvien(sinhvien thesinhvien) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {

			myConn = dataSource.getConnection();

			String sql = "update sinh_vien " + "set hoten=?,tenkhoa=?, gioitinh=?,diemtin=? " + "where masv=?";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, thesinhvien.getHoten());
			myStmt.setString(2, thesinhvien.getTenkhoa());
			myStmt.setString(3, thesinhvien.getGioitinh());
			myStmt.setInt(4, thesinhvien.getDiemtin());
			myStmt.setInt(5, thesinhvien.getMasv());

			myStmt.execute();
		} finally {

			close(myConn, myStmt, null);
		}
	}

	public void deletesinhvien(String themasv) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {

			int masv = Integer.parseInt(themasv);

			myConn = dataSource.getConnection();

			String sql = "delete from sinh_vien where masv=?";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setInt(1, masv);

			myStmt.execute();
		} finally {

			close(myConn, myStmt, null);
		}
	}

}
