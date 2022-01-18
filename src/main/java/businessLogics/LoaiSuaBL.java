package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.LoaiSua;

public class LoaiSuaBL {
	public static List<LoaiSua> docLoaiSua() {
		List<LoaiSua> dsls = new ArrayList<LoaiSua>();
		try (Connection con = CSDL.getConnection() ) {
			Statement stm = con.createStatement();
			String sql = "select * from loai_sua";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				LoaiSua ls = new LoaiSua();
				ls.setMaLoaiSua(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
				dsls.add(ls);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsls;
	}
}
