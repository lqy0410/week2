package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.User;

public class UserDao {
	
	
	
	
	public User get(String username){
		User user=null;
		
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立数据库的连接
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=UTF-8",
														"root",
														"123456");

			//创建语句
			String sql="select *from t_user where userName=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,username);
			//执行语句
			ResultSet rs=pst.executeQuery();
			
			//处理结果
			if(rs.next()){
			
				user=new User(rs.getString("userName"),
							  rs.getString("password"),
							  rs.getString("chrName"),
							  rs.getString("role")
							  );
			}
			//关闭连接
			con.close();
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
}
