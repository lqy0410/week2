package control;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;
import dao.UserDao;

@WebServlet(urlPatterns = "/servlet/LoginController")

public class LoginController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//��ֹ����
		
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String vcode=request.getParameter("vcode");
		
		HttpSession session=request.getSession();
		String rcode=(String)session.getAttribute("verityCode");
		
		//ת�������url-pattern
		String Path="";
		
		if(!vcode.equalsIgnoreCase(rcode)){
			request.setAttribute("info", "��֤�벻��ȷ");
			Path="/error.jsp";
		}
		else{
			UserDao userDao=new UserDao();
			if(userDao.get(userName) == null){
				request.setAttribute("info", "��������û���������");
				Path="/error.jsp";
			}
			else{
				User user=userDao.get(userName);
				if(!user.getPassword().equals(password)){
					request.setAttribute("info", "��������û��������벻ƥ��");
					Path="/error.jsp";
				}
				else{
					session.setAttribute("currentUser", user.getUserName());
					Path="/main.jsp";
				}
			}
		}

		RequestDispatcher rd=request.getRequestDispatcher(Path);
		rd.forward(request, response);
	}

}
