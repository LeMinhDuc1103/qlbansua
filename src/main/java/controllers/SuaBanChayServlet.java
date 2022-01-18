package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SuaBL;
import javaBeans.Sua;

@WebServlet("/SuaBanChayServlet")
public class SuaBanChayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuaBanChayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //Hien ten sua ban chay cot ben trai
        List<Sua> tenSBC = SuaBL.docSuaBanChay();
        request.setAttribute("tenSBC", tenSBC);
        
        //Hien thi thong tin sua ban chay
        List<Sua> dsSBC;
        String maSua;
        maSua = request.getParameter("maSua");
        if (maSua != null) {
        	dsSBC = SuaBL.suaBanChayTheoMa(maSua);
        } else {
        	dsSBC = tenSBC;
        }
        request.setAttribute("dsSBC", dsSBC);		
        request.getRequestDispatcher("views/sua-ban-chay.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
