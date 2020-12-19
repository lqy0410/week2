package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Download;
import vo.User;

public class DownloadDao {
	public  ArrayList<Download> getdownlist(){
		ArrayList<Download> down=new ArrayList<Download>() ; 
		
		Download download=null;
		
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立数据库的连接
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=UTF-8",
														"root",
														"123456");
			//创建语句
			String sql="select *from t_downloadlist";
			PreparedStatement pst=con.prepareStatement(sql);
			//执行语句
			ResultSet rs=pst.executeQuery();
			//处理结果
			while(rs.next()){
//				int id, String name, String path, String description,
//				int size, int star, String image, String time
				download=new Download(rs.getInt("id"),
										  rs.getString("name"),
										  rs.getString("path"),
										  rs.getString("description"),
										  rs.getInt("size"),
										  rs.getInt("star"),
										  rs.getString("image"),
										  rs.getString("time"));
				down.add(download);
				}
			//关闭连接
			con.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return down;
	}
	public String getaddr(int id){
		String addr="";
		Download download=null;
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立数据库的连接
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?useUnicode=true&characterEncoding=UTF-8",
														"root",
														"123456");
			//创建语句
			String sql="select *from t_downloadlist where id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,id);
			//执行语句
			ResultSet rs=pst.executeQuery();
			//处理结果
			if(rs.next()){
//				int id, String name, String path, String description,
//				int size, int star, String image, String time
				download=new Download(rs.getInt("id"),
										  rs.getString("name"),
										  rs.getString("path"),
										  rs.getString("description"),
										  rs.getInt("size"),
										  rs.getInt("star"),
										  rs.getString("image"),
										  rs.getString("time"));
			
				}
			//关闭连接
			con.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return addr=download.getPath();
	}
}
