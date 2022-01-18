package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import javaBeans.HangSua;
import javaBeans.LoaiSua;
import javaBeans.Sua;

@WebServlet("/DanhSachSuaServlet")
public class DanhSachSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DanhSachSuaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // Hien danh sach hang sua va loai sua
        List<HangSua> dshs = HangSuaBL.docHangSua();
        request.setAttribute("dshs", dshs);
        List<LoaiSua> dsls = LoaiSuaBL.docLoaiSua();
        request.setAttribute("dsls", dsls);
        
        String maHangSua, maLoaiSua;
        maHangSua = request.getParameter("maHang");
        maLoaiSua = request.getParameter("maLoai");
        List<Sua> dss;
        
        if(maHangSua != null) {
        	dss = SuaBL.docTheoMaHangSua(maHangSua);
        } else if (maLoaiSua != null) {
        	dss = SuaBL.docTheoMaLoaiSua(maLoaiSua);
        } else {
        	dss = SuaBL.docSua();
        }
        request.setAttribute("dss", dss);
        request.getRequestDispatcher("views/danh-sach-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
