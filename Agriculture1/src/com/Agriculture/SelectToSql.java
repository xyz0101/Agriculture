package com.Agriculture;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class SelectToSql {
	private String url="jdbc:mysql://localhost:3306/word?useUnicode=true&characterEncoding=gbk";
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
				 subj=subj.replaceAll("Uv::http://nyxc#", "").replaceAll(":","");
				 String prop=rs.getString("Prop");
				 prop=prop.replaceAll("Uv::http://nyxc#", "").replaceAll(":","");
				 String obj=rs.getString("Obj");
				obj= obj.replaceAll("Lv:0::", "").replaceAll(":","");
//				 System.out.println(subj);
//				 System.out.println(prop);
//				 System.out.println(obj);
				// list1.add(subj);
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
		 List list=jg.findBySubj("Ö¹ÐºÒ©¡¾74F¡¿");
		 System.out.println(list);
		 System.out.println("´ÎÊý£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º"+jg.x);
	}
}