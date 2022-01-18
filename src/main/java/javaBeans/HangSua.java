package javaBeans;

import java.io.Serializable;

public class HangSua implements Serializable {
	private String maHangSua;
	private String tenHangSua;
	private String diaChi;
	private String dienThoai;
	private String email;
	
	public HangSua() {
		super();
	}
	
	public String getMaHangSua() {
		return maHangSua;
	}
	public void setMaHangSua(String maHangSua) {
		this.maHangSua = maHangSua;
	}
	public String getTenHangSua() {
		return tenHangSua;
	}
	public void setTenHangSua(String tenHangSua) {
		this.tenHangSua = tenHangSua;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
