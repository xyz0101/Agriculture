package com.Agriculture;
import java.util.ArrayList;
import java.util.List;
public class Value {
	SelectToSql se = new SelectToSql();
	SelectToSql1 se1 = new SelectToSql1();
	List list = new ArrayList();
	public String getName(String str){
		if(str!=null){
		list=se1.findBySubj(str);	
		}
		return (String) list.get(0);
	}
	public String getEname(String str){
		list=se.findBySubj(str);
		char[] e;
		char[] e1 = new char[100];
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			e=str1.toCharArray();
			if(str1.substring(0, 2)!="F1"&&str1.substring(0, 2)!="S1"&&((int)e[1]>=65&&(int)e[1]<=122)){
				if(str1.substring(0, 4).equals("null")||str1.substring(0, 4).equals("Null")){
					return "Null";
				}
				if(str1.contains("¡¾")==false){
				return  str1;
				}else {
					int j=0;
					while(new Integer(e[j])!=12304){	
						e1[j]=e[j];
						j++;
					}
					if(j==0)
						return "Null";
					return new String(e1);
				}
				//return "Null";
			}
		}
		return "Null";
	}
	public String getLname(String str){
		list=se.findBySubj(str);
		char[] e;
		char[] e1 = new char[100];
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			e=str1.toCharArray();
			if(str1.substring(0, 2)!="F1"&&str1.substring(0, 2)!="S1"&&((int)e[1]>=65&&(int)e[1]<=122)){
				if(str1.substring(0, 4).equals("null")||str1.substring(0, 4).equals("Null")){
					return "Null";
				}
				int j=0;
				if(str1.contains("¡¾")==true){
				while(true){
					if(new Integer(e[j])==12304){
						break;
					}
					j++;
				}
				int k=0;
				j++;
				while(new Integer(e[j])!=12305){
					e1[k++]=e[j];
					j++;
				}
				
				System.out.println("À­¶¡ÎÄÎª£º£º£º£º£º£º"+new String(e1).trim());
				return new String(e1).trim();
				}else return "Null";
				}
			}
			return "Null";
}
	public List getY(String str){
		List list1 = new ArrayList();
		char[] y;
		list=se.findBySubj(str);		
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			y=str1.toCharArray();
			if(str1.substring(0, 1).equals("Y")&&(int)y[1]>122){
				list1.add(list.get(i));
			}
		}
		return list1;
	}	
	public List getD(String str){
		List list1 = new ArrayList();
		char[] d;
		list=se.findBySubj(str);		
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			d=str1.toCharArray();
			if(str1.substring(0, 1).equals("D")&&(int)d[1]>122){
				list1.add(list.get(i));
			}
		}
		return list1;
	}	
	public List getC(String str){
		List list1 = new ArrayList();
		list=se.findBySubj(str);	
		char[] c;
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			c=str1.toCharArray();
			if((str1.substring(0,1).equals("C")||str1.substring(0,1).equals("c"))&&(int)c[1]>122){
				list1.add(list.get(i));
			}
		}
		return list1;
	}	
	public List getS1(String str){	
		List list1 = new ArrayList();
		list=se.findBySubj(str);		
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			if(str1.substring(0, 2).equals("S1")){
				list1.add(list.get(i));
			}
		}
		return list1;
	}	
	public List getS2(String str){	
		List list1 = new ArrayList();
		list=se.findBySubj(str);		
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			if(str1.substring(0, 2).equals("S2")){
				list1.add(list.get(i));
			}
		}
		return list1;
	}	
	public List getS3(String str){	
		List list1 = new ArrayList();
		list=se.findBySubj(str);		
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			if(str1.substring(0, 2).equals("S3")){
				list1.add(list.get(i));
			}
		}
		return list1;
	}	
	public List getS4(String str){	
		List list1 = new ArrayList();
		list=se.findBySubj(str);		
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			if(str1.substring(0, 2).equals("S4")){
				list1.add(list.get(i));
			}
		}
		return list1;
	}	
	public List getS5(String str){	
		List list1 = new ArrayList();
		list=se.findBySubj(str);		
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			if(str1.substring(0, 2).equals("S5")){
				list1.add(list.get(i));
			}
		}
		return list1;
	}	
	public List getS6(String str){	
		List list1 = new ArrayList();
		list=se.findBySubj(str);		
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			if(str1.substring(0, 2).equals("S6")){
				list1.add(list.get(i));
			}
		}
		return list1;
	}	
	public List getF1(String str){
		List list1 = new ArrayList();
		list=se.findBySubj(str);		
		for(int i=0;i<list.size();i++){
			String str1=(String) list.get(i);
			if(str1.substring(0, 2).equals("F1")){
				list1.add(list.get(i));
			}
		}
		return list1;
	}
public List getF2(String str){
	List list1 = new ArrayList();
	list=se.findBySubj(str);		
	for(int i=0;i<list.size();i++){
		String str1=(String) list.get(i);
		if(str1.substring(0, 2).equals("F2")){
			list1.add(list.get(i));
		}
	}
	return list1;
}
public List getF3(String str){
	List list1 = new ArrayList();
	list=se.findBySubj(str);		
	for(int i=0;i<list.size();i++){
		String str1=(String) list.get(i);
		if(str1.substring(0, 2).equals("F3")){
			list1.add(list.get(i));
		}
	}
	return list1;
}
public List getF4(String str){
	List list1 = new ArrayList();
	list=se.findBySubj(str);		
	for(int i=0;i<list.size();i++){
		String str1=(String) list.get(i);
		if(str1.substring(0, 2).equals("F4")){
			list1.add(list.get(i));
		}
	}
	return list1;
}
public List getF5(String str){
	
	List list1 = new ArrayList();
	list=se.findBySubj(str);		
	for(int i=0;i<list.size();i++){
		String str1=(String) list.get(i);
		if(str1.substring(0, 2).equals("F5")){
			list1.add(list.get(i));
		}
	}
	return list1;
}
public List getF6(String str){
	List list1 = new ArrayList();
	list=se.findBySubj(str);		
	for(int i=0;i<list.size();i++){
		String str1=(String) list.get(i);
		if(str1.substring(0, 2).equals("F6")){
			list1.add(list.get(i));
		}
	}
	return list1;
}
}
