package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Sua;

public class SuaBL {
	public static List<Sua> docSua() {
		List<Sua> dss = new ArrayList<Sua>();
		try (Connection con = CSDL.getConnection()){
			Statement stm = con.createStatement();
			String sql = "select * from sua";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				dss.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dss;
	}
	
	public static List<Sua> docTheoMaHangSua(String maHangSua) {
		List<Sua> dss = new ArrayList<Sua>();
		try (Connection con = CSDL.getConnection()){
			Statement stm = con.createStatement();
			String sql = "select * from sua where ma_hang_sua = '"+ maHangSua +"'";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				dss.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dss;
	}	
	
	public static List<Sua> docTheoMaLoaiSua(String maLoaiSua) {
		List<Sua> dss = new ArrayList<Sua>();
		try (Connection con = CSDL.getConnection()){
			Statement stm = con.createStatement();
			String sql = "select * from sua where ma_loai_sua = '"+ maLoaiSua +"'";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				dss.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dss;
	}
	
	public static void themSuaMoi(Sua sm) {
		String sql = "insert into sua (ma_sua, ten_sua, ma_hang_sua, ma_loai_sua, trong_luong, don_gia, tp_dinh_duong, loi_ich, hinh)"
				+ " value (?,?,?,?,?,?,?,?,?)";
		try (Connection con = CSDL.getConnection()){
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, sm.getMaSua());
			pst.setString(2, sm.getTenSua());
			pst.setString(3, sm.getMaHangSua());
			pst.setString(4, sm.getMaLoaiSua());
			pst.setInt(5, sm.getTrongLuong());
			pst.setInt(6, sm.getDonGia());
			pst.setString(7, sm.getTpDinhDuong());
			pst.setString(8, sm.getLoiIch());
			pst.setString(9, sm.getHinh());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Sua> timSuaTheoHLT(String maHangSua, String maLoaiSua, String tenSua) {
		List<Sua> dsSua = new ArrayList<Sua>();
		String sql = "select * from sua where ma_hang_sua = ? and ma_loai_sua = ? and ten_sua like ?";
		try (Connection con = CSDL.getConnection()){
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, maHangSua);
			pst.setString(2, maLoaiSua);
			pst.setString(3, "%"+tenSua+"%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				dsSua.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSua;
	}
	
	public static List<Sua> docSuaBanChay() {
		List<Sua> suaBC = new ArrayList<Sua>();
		try (Connection con = CSDL.getConnection()) {
			Statement stm = con.createStatement();
			String sql = "select s.*, sum(cthd.So_luong) as tsl from sua as s inner join ct_hoadon as cthd on s.Ma_sua = cthd.Ma_sua "
						+"group by s.Ma_sua order by tsl desc";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				suaBC.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suaBC;
	}
	
	public static List<Sua> suaBanChayTheoMa(String maSua) {
		List<Sua> suaBC = new ArrayList<Sua>();
		try (Connection con = CSDL.getConnection()) {
			Statement stm = con.createStatement();
			String sql = "select * from sua where ma_sua = '"+ maSua +"'";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Sua s = new Sua();
				s.setMaSua(rs.getString("ma_sua"));
				s.setTenSua(rs.getString("ten_sua"));
				s.setMaHangSua(rs.getString("ma_hang_sua"));
				s.setMaLoaiSua(rs.getString("ma_loai_sua"));
				s.setTrongLuong(rs.getInt("trong_luong"));
				s.setDonGia(rs.getInt("don_gia"));
				s.setTpDinhDuong(rs.getString("tp_dinh_duong"));
				s.setLoiIch(rs.getString("loi_ich"));
				s.setHinh(rs.getString("hinh"));
				suaBC.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suaBC;
	}
}
