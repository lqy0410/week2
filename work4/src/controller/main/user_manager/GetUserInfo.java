package controller.main.user_manager;

import com.google.gson.Gson;
import dao.UserDao;
import vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(urlPatterns = "/getUserInfo.do")
public class GetUserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取客户端传送的参数userName
        String userName = request.getParameter("userName");

        UserDao dao = new UserDao();

        User user = dao.getUserByUserName(userName);

        HashMap<String,Object> map = new HashMap<>();
        if(user != null){
            map.put("code",0);
            map.put("info",user);
        }else{
            map.put("code",-1);
            map.put("info","找不到该用户!");
        }

        String jsonStr = new Gson().toJson(map);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
        out.flush();
        out.close();
    }

}
