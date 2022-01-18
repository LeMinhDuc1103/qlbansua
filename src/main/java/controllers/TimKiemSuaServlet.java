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

@WebServlet("/TimKiemSuaServlet")
public class TimKiemSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimKiemSuaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // Hien thi cbo chon hang sua va loai sua
        List<HangSua> dshs = HangSuaBL.docHangSua();
        request.setAttribute("dshs", dshs);
        List<LoaiSua> dsls = LoaiSuaBL.docLoaiSua();
        request.setAttribute("dsls", dsls);

        // Lay du lieu tu trang html
        String maHangSua, maLoaiSua, tenSua;
        maHangSua = request.getParameter("cboHangSua");
        maLoaiSua = request.getParameter("cboLoaiSua");
        tenSua = request.getParameter("txtTenSuaTim");
        
        // Tim sua theo hang, loai, ten
        List<Sua> dsSua = SuaBL.timSuaTheoHLT(maHangSua, maLoaiSua, tenSua);
        
        // Hien thi ket qua ra trang view
        request.setAttribute("dsSua", dsSua);
        request.setAttribute("soSP", dsSua.size()); // set so san pham tim duoc tu CSDL
        request.getRequestDispatcher("views/tim-kiem-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
