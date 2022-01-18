package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.HangSua;

public class HangSuaBL {
	public static List<HangSua> docHangSua() {
		List<HangSua> dshs = new ArrayList<HangSua>();
		try (Connection con = CSDL.getConnection()) {
			Statement stm = con.createStatement();
			String sql = "select ma_hang_sua, ten_hang_sua from hang_sua";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				HangSua hs = new HangSua();
				hs.setMaHangSua(rs.getString("ma_hang_sua"));
				hs.setTenHangSua(rs.getString("ten_hang_sua"));
				dshs.add(hs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dshs;
	}
}
