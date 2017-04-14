package com.main;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Agriculture.SelectToSql1;
import com.Agriculture.Value;

@Controller
public class MessageAction {
	
	@RequestMapping("/findname")	
	public @ResponseBody  JSON Message( String name ){
		ModelAndView mv = new ModelAndView();
		JSONArray jsonArray = new JSONArray();
		SelectToSql1 s = new SelectToSql1();
		//mv.setViewName("view");
		
		mv.setViewName("select");
		if(!name.equals("")&&!name.equals(" ")){
		int m;
		if(s.findBySubj(name).size()<25)
			m=s.findBySubj(name).size();
		else
			m=25;
		String name1=null;
		for(int i=0;i<m;i++){
			name1=(String)s.findBySubj(name).get(i);
			if(!name1.substring(0, 1).equals("S")&&!name1.substring(0, 1).equals("F"))
		jsonArray.add(s.findBySubj(name).get(i));
		}
		return jsonArray;
		}
		//mv.addObject("value", jsonArray);
		System.out.println("mv::::"+jsonArray);
		return null;
	}
	@RequestMapping("/findename")	
	public @ResponseBody JSON MessageEn( String name ){
		ModelAndView mv = new ModelAndView();
		JSONArray jsonarray = new JSONArray();
		Value v = new Value();	
		mv.setViewName("echarts");
		jsonarray.add(v.getLname(name));
		System.out.println(jsonarray);
		return jsonarray;	
		//mv.addObject("value", jsonArray);		
	}
	
}
