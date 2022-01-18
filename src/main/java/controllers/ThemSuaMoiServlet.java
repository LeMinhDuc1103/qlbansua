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

@WebServlet("/ThemSuaMoiServlet")
public class ThemSuaMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemSuaMoiServlet() {
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
        request.getRequestDispatcher("views/them-sua-moi.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
		// Lay du lieu tu trang html
        String maSua, tenSua, maHangSua, maLoaiSua, trongLuong, donGia, tpDinhDuong, loiIch, hinh;
        maSua = request.getParameter("txtMaSua");
        tenSua = request.getParameter("txtTenSua");
        maHangSua = request.getParameter("cboHangSua");
        maLoaiSua = request.getParameter("cboLoaiSua");
        trongLuong = request.getParameter("txtTrongLuong");
        donGia = request.getParameter("txtDonGia");
        tpDinhDuong = request.getParameter("txtTPDinhDuong");
        loiIch = request.getParameter("txtLoiIch");
        hinh = request.getParameter("txtHinh");
        
        // Khoi tao doi tuong sua moi
        Sua sm = new Sua();
        sm.setMaSua(maSua);
        sm.setTenSua(tenSua);
        sm.setMaHangSua(maHangSua);
        sm.setMaLoaiSua(maLoaiSua);
        sm.setTrongLuong(Integer.parseInt(trongLuong));
        sm.setDonGia(Integer.parseInt(donGia));
        sm.setTpDinhDuong(tpDinhDuong);
        sm.setLoiIch(loiIch);
        sm.setHinh(hinh);
        
        // Them sua moi vao CSDL
        SuaBL.themSuaMoi(sm);
		doGet(request, response);
	}

}
