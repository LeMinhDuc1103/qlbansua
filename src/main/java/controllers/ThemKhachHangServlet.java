package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.KhachHangBL;
import javaBeans.KhachHang;

@WebServlet("/ThemKhachHangServlet")
public class ThemKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThemKhachHangServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Lay du lieu tu trang html
		String maKH, tenKH, diaChi, dienThoai, email;
		boolean phai = false;
		maKH = request.getParameter("txtMaKH");
		tenKH = request.getParameter("txtTenKH");
		diaChi = request.getParameter("txtDiaChi");
		dienThoai = request.getParameter("txtDienThoai");
		email = request.getParameter("txtEmail");
		if (request.getParameter("rdbPhai") != null) {
			if (request.getParameter("rdbPhai").equals("Nam")) {
				phai = false;
			} else {
				phai = true;
			}
		}

		// Khoi tao doi tuong khach hang moi
		KhachHang kh = new KhachHang();
		kh.setMaKhachHang(maKH);
		kh.setTenKhachHang(tenKH);
		kh.setPhai(phai);
		kh.setDiaChi(diaChi);
		kh.setDienThoai(dienThoai);
		kh.setEmail(email);

		// Them khach hang vao CSDL
		KhachHangBL.themKH(kh);
		request.getRequestDispatcher("views/them-khach-hang.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
