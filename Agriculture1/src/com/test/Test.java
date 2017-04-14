package com.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class Test {
	
	public static void main(String[] args) {
		JSONObject jsonobject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		jsonobject.put("name", "haha");
		jsonobject.put("age", "12");
		jsonobject.put("sex", "ÄÐ");
		jsonArray.add(jsonobject);
		//JSONArray jsonArray1 = new JSONArray();
		JSONObject jsonobject1 = new JSONObject();
		jsonobject1.put("name", "haha");
		jsonobject1.put("age", "12");
		jsonobject1.put("sex", "ÄÐ");
		String s="°¡";
		char[] a ;
		a=s.toCharArray();
		System.out.println("aaa::"+a);
		System.out.println("ascii::"+(int)a[0]);
		//JSONObject jsonobject2 = new JSONObject();
		//jsonobject2.put(jsonobject, jsonobject1);
		jsonArray.add(jsonobject1);
		System.out.println(jsonArray);
		System.out.println("hhhhhhhhhh"+new Integer('¡¾'));
	}
}

