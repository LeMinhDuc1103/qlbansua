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

@WebServlet("/ThongTinSuaServlet")
public class ThongTinSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThongTinSuaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        List<Sua> dss = SuaBL.docSua();
        request.setAttribute("dss", dss);

        request.getRequestDispatcher("views/thong-tin-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
