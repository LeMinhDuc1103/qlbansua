package javaBeans;

import java.io.Serializable;

public class Sua implements Serializable{
	private String maSua;
	private String tenSua;
	private String maHangSua;
	private String maLoaiSua;
	private int trongLuong;
	private int donGia;
	private String tpDinhDuong;
	private String loiIch;
	private String hinh;
	
	public Sua() {
		super();
	}

	public String getMaSua() {
		return maSua;
	}

	public void setMaSua(String maSua) {
		this.maSua = maSua;
	}

	public String getTenSua() {
		return tenSua;
	}

	public void setTenSua(String tenSua) {
		this.tenSua = tenSua;
	}

	public String getMaHangSua() {
		return maHangSua;
	}

	public void setMaHangSua(String maHangSua) {
		this.maHangSua = maHangSua;
	}

	public String getMaLoaiSua() {
		return maLoaiSua;
	}

	public void setMaLoaiSua(String maLoaiSua) {
		this.maLoaiSua = maLoaiSua;
	}

	public int getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(int trongLuong) {
		this.trongLuong = trongLuong;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public String getTpDinhDuong() {
		return tpDinhDuong;
	}

	public void setTpDinhDuong(String tpDinhDuong) {
		this.tpDinhDuong = tpDinhDuong;
	}

	public String getLoiIch() {
		return loiIch;
	}

	public void setLoiIch(String loiIch) {
		this.loiIch = loiIch;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	
}
