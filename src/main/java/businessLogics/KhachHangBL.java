package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javaBeans.KhachHang;

public class KhachHangBL {
	public static void themKH(KhachHang kh) {
		String sql = "insert into khach_hang (ma_khach_hang, ten_khach_hang, phai, dia_chi, dien_thoai, email) value (?,?,?,?,?,?)";
		try (Connection con = CSDL.getConnection()) {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, kh.getMaKhachHang());
			pst.setString(2, kh.getTenKhachHang());
			pst.setBoolean(3, kh.getPhai());
			pst.setString(4, kh.getDiaChi());
			pst.setString(5, kh.getDienThoai());
			pst.setString(6, kh.getEmail());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
