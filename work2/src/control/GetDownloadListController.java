package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Download;
import dao.DownloadDao;
@WebServlet(urlPatterns="/servlet/GetDownloadListController")
public class GetDownloadListController extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DownloadDao download=new DownloadDao();
		ArrayList<Download> downlist=download.getdownlist();
		
		HttpSession session=request.getSession();
		session.setAttribute("downloadList", downlist);
		
		RequestDispatcher rd=request.getRequestDispatcher("/download.jsp");
		rd.forward(request, response);
	}

	
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//			
//		DownloadDao download=new DownloadDao();
//		ArrayList<Download> downlist=download.getdownlist();
//		
//		HttpSession session=request.getSession();
//		session.setAttribute("downloadList", downlist);
//		
//		RequestDispatcher rd=request.getRequestDispatcher("/download.jsp");
//		rd.forward(request, response);
//	}


}
