package com.Agriculture;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class SelectToSql {
	private String url="jdbc:mysql://localhost:3306/word";
	private String driver="com.mysql.jdbc.Driver";
	private String user="root";
	private String  pwd="961215";
	public int x=0;
	   public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	List<Object> list2 = new ArrayList<Object>();
    public Connection getDB(){
    	Connection con = null;
		try {
			Class.forName(driver);
		con=DriverManager.getConnection(url,user,pwd);
		  } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
				}		
    	return con;
	}  
	public List  findBySubj(String value){
		List<String> list1 = new ArrayList<String>();
		Connection con=getDB();
		String sql="select * from jena_g1t1_stmt where Subj like '%"+value+"%'";
		Statement  stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			x++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 try {
			while(rs.next()){
				 String subj=rs.getString("Subj");
				// subj=subj.replaceAll("Uv::http://nyxc#", "").replaceAll(":","");
				 String prop=rs.getString("Prop");
				// prop=prop.replaceAll("Uv::http://nyxc#", "").replaceAll(":","");
				 String obj=rs.getString("Obj");
		
				 list1.add(obj);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 try {
			 rs.close();
			 stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list1;
	}
	public static void main(String[] args) {
		SelectToSql jg= new SelectToSql();
		 List list=jg.findBySubj("中国");
		 System.out.println(list);
		 System.out.println("次数：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：：："+jg.x);
	}
}