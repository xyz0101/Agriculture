package com.Agriculture;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SelectToSql1 {
	private String url="jdbc:mysql://localhost:3306/word?useUnicode=true&characterEncoding=gbk";
	private String driver="com.mysql.jdbc.Driver";
	private String user="root";
	private String  pwd="961215";
	int x=0;
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
		List<String> list = new ArrayList<String>();
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
				 list1.add(subj);
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
		 int c=0;
		 list.add(list1.get(0));
		 for(int i=0;i<list1.size();i++){
			 if(!list1.get(i).equals(list.get(c))&&(!list1.get(i).substring(0, 1).equals("S")&&!list1.get(i).substring(0, 1).equals("F"))){
				 c++;
				 list.add(list1.get(i));
			 }
		 }
		 Collections.sort(list,new Compare());
		return list;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SelectToSql1 jg= new SelectToSql1();
		 List list=jg.findBySubj("Ë®µ¾");
		 Collections.sort(list,new Compare());
		System.out.println(list);
		System.out.println("´ÎÊý2£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º£º"+jg.x);
	}
}