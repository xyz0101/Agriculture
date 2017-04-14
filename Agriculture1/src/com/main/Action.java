package com.main;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Bean.Category;

import com.Agriculture.SelectToSql;
import com.Agriculture.Value;
@Controller
public class Action {
		@RequestMapping("/toselect")
		public String toSelect(){
			return "select";
		}
		@RequestMapping("/view")
		public ModelAndView view(@RequestParam("name") String name ){			
			JSONObject jsonobject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			JSONArray jsonArrayLink = new JSONArray();
			ModelAndView model = new ModelAndView();		
			SelectToSql s = new SelectToSql();				
			Value v = new Value();	
			name=v.getName(name);
			jsonobject.put("id", (int)0);			
			jsonobject.put("category", (int)0);
			jsonobject.put("name", name);				
			jsonobject.put("label", name);			
			jsonobject.put("symbolSize", (int)40);
			jsonobject.put("ignore", (boolean)false);
			jsonobject.put("flag", (boolean)true);
			jsonArray.add(jsonobject);
			if(name==null){
				model.setViewName("error");//跳转视图			
			}else{			
				model.setViewName("echarts");//跳转视图
			}
			System.out.println("叙词名为:::::::::::::::::::"+name);
			v.getLname(name);
			System.out.println("英文名为:::::::::::::::::::"+v.getEname(name));
			/**
			 * 添加各个属性到jsonarray
			 */
			JSONObject jsonobjecte = new JSONObject();
			jsonobjecte.put("source", (int)1);
			jsonobjecte.put("target", (int)0);
			jsonobjecte.put("name", Category.Ename_relation);
			jsonArrayLink.add(jsonobjecte);
			jsonobject.put("id", "1");			
			jsonobject.put("category", (int)1);
			String E_name=v.getEname(name);
			if(E_name.equals("null"))
				E_name="Null";
			jsonobject.put("name", E_name);
			jsonobject.put("label", E_name);
			jsonobject.put("symbolSize", (int)20);
			jsonobject.put("ignore", (boolean)true);
			jsonobject.put("flag", (boolean)true);
			jsonArray.add(jsonobject);
			int count=2;
			List c = v.getC(name);
			if(c.size()>0){
				System.out.println("C数目=="+c.size());
				JSONObject jsonobjectc = new JSONObject();
				JSONObject jsonobjectlinkc = new JSONObject();
			for(int i=0;i<c.size();i++){
				jsonobjectc.put("id", (int)count);		
				jsonobjectc.put("category", (int)1);
				jsonobjectc.put("name", c.get(i));
				jsonobjectc.put("label", c.get(i));
				jsonobjectc.put("symbolSize", (int)20);
				jsonobjectc.put("ignore", (boolean)true);
				jsonobjectc.put("flag", (boolean)true);
				jsonArray.add(jsonobjectc);
				jsonobjectlinkc.put("source", (int)count);
				jsonobjectlinkc.put("target", (int)0);
				jsonobjectlinkc.put("name",Category.C_relation);
				jsonArrayLink.add(jsonobjectlinkc);
				count++;
			}
		}	
			List d =v.getD(name);
			if(d.size()>0){
				System.out.println("D数目=="+d.size());
				JSONObject jsonobjectd = new JSONObject();
				JSONObject jsonobjectlinkd = new JSONObject();
			for(int i=0;i<d.size();i++){
				jsonobjectd.put("id", count);		
				jsonobjectd.put("category", (int)1);
				jsonobjectd.put("name", (String)d.get(i));
				jsonobjectd.put("label", (String)d.get(i));
				jsonobjectd.put("symbolSize", (int)20);
				jsonobjectd.put("ignore", (boolean)true);
				jsonobjectd.put("flag", (boolean)true);
				jsonArray.add(jsonobjectd);
				jsonobjectlinkd.put("source", (int)count);
				jsonobjectlinkd.put("target",(int)0);
				jsonobjectlinkd.put("name",Category.D_relation);
				jsonArrayLink.add(jsonobjectlinkd);
				count++;
				System.out.println(d.get(i));
			}
		}	
			List y =v.getY(name);
			if(y.size()>0){
				System.out.println("Y数目=="+y.size());
				JSONObject jsonobjecty = new JSONObject();
				JSONObject jsonobjectlinky = new JSONObject();
			for(int i=0;i<v.getY(v.getName(name)).size();i++){
				jsonobjecty.put("id", count);				
				jsonobjecty.put("category", (int)1);
				jsonobjecty.put("name", y.get(i));
				jsonobjecty.put("label",y.get(i));
				jsonobjecty.put("symbolSize", (int)20);
				jsonobjecty.put("ignore", (boolean)true);
				jsonobjecty.put("flag", (boolean)true);
				jsonArray.add(jsonobjecty);
				jsonobjectlinky.put("source", (int)count);
				jsonobjectlinky.put("target", (int)0);
				jsonobjectlinky.put("name",Category.Y_relation);
				jsonArrayLink.add(jsonobjectlinky);
				count++;
			}
		}	List s1=v.getS1(name);
			if(s1.size()>0){
				System.out.println("S1数目=="+s1.size());
				JSONObject jsonobjectS1 = new JSONObject();
				JSONObject jsonobjectlinkS1 = new JSONObject();
				for(int i=0;i<s1.size();i++){
				jsonobjectS1.put("id", (int)count);
				jsonobjectS1.put("category", (int)1);
				jsonobjectS1.put("name", s1.get(i));
				jsonobjectS1.put("label",s1.get(i));
				jsonobjectS1.put("symbolSize", (int)20);
				jsonobjectS1.put("ignore", (boolean)true);
				jsonobjectS1.put("flag", (boolean)true);
				jsonArray.add(jsonobjectS1);
				jsonobjectlinkS1.put("source", (int)count);
				jsonobjectlinkS1.put("target", (int)0);
				count++;
				String str01=(String) s1.get(i);
				List s2=v.getS2(str01);
				if(s.findBySubj(str01).size()>0){
				System.out.println("S2数目=="+s2.size());
				jsonobjectlinkS1.put("name",Category.S_relation);
				int f01=count;
				JSONObject jsonobjectS2 = new JSONObject();
				JSONObject jsonobjectlinkS2 = new JSONObject();
				for(int j=0;j<v.getS2(str01).size();j++){
				jsonobjectS2.put("id", (int)count);
				jsonobjectS2.put("category", (int)Category.S2_c);
				jsonobjectS2.put("name",s2.get(j));
				jsonobjectS2.put("label",s2.get(j));
				jsonobjectS2.put("symbolSize", (int)20);
				jsonobjectS2.put("ignore", (boolean)true);
				jsonobjectS2.put("flag", (boolean)true);
				jsonArray.add(jsonobjectS2);
				jsonobjectlinkS2.put("source", (int)count);
				jsonobjectlinkS2.put("target", (int)(f01-j-1));
				count++; f01++;
				
				String str02=(String) v.getS1(v.getName(name)).get(i);
				List s3=v.getS3(str02);
				if(s.findBySubj(str02).size()>0){
				System.out.println("S3数目=="+s3.size());
				jsonobjectlinkS2.put("name",Category.S_relation);
				int f02=count;
				JSONObject jsonobjectS3 = new JSONObject();
				JSONObject jsonobjectlinkS3 = new JSONObject();
				for(int k=0;k<s3.size();k++){
				jsonobjectS3.put("id", (int)count);
				jsonobjectS3.put("category", (int)Category.S3_c);
				jsonobjectS3.put("name", s3.get(k));
				jsonobjectS3.put("label",s3.get(k));
				jsonobjectS3.put("symbolSize", (int)20);
				jsonobjectS3.put("ignore",(boolean) true);
				jsonobjectS3.put("flag", (boolean)true);
				jsonArray.add(jsonobjectS3);
				jsonobjectlinkS3.put("source", (int)count);
				jsonobjectlinkS3.put("target", (int)(f02-k-1));
				count++;
				f02++;
				String str03=(String) s3.get(k);
				List s4 = v.getS4(str03);
				if(s.findBySubj(str03).size()>0){
				System.out.println("S4数目=="+s4.size());
				jsonobjectlinkS3.put("name",Category.S_relation);
				int f03=count;

				JSONObject jsonobjectS4 = new JSONObject();

				JSONObject jsonobjectlinkS4 = new JSONObject();

				for(int l=0;l<v.getS4(str03).size();l++){
				jsonobjectS4.put("id", (int)count);
				jsonobjectS4.put("category", (int)Category.S4_c);
				jsonobjectS4.put("name", s4.get(l));
				jsonobjectS4.put("label", s4.get(l));
				jsonobjectS4.put("symbolSize", (int)20);
				jsonobjectS4.put("ignore",(boolean) true);
				jsonobjectS4.put("flag",(boolean) true);
				jsonArray.add(jsonobjectS4);
				//System.out.println("添加S4成功::::::::::::::::::::"+v.getS4(str03).get(l));
				jsonobjectlinkS4.put("source",(int)count);
				jsonobjectlinkS4.put("target", (int)(f03-l-1));
				count++;
				f03++;
				String str04=(String) s4.get(l);
				List s5 = v.getS5(str04);
				if(s.findBySubj(str04).size()>0){
				System.out.println("S5数目=="+s5.size());
				jsonobjectlinkS4.put("name",Category.S_relation);
				int f04=count;
				JSONObject jsonobjectS5 = new JSONObject();
				JSONObject jsonobjectlinkS5 = new JSONObject();
				for(int m=0;m<s5.size();m++){
				jsonobjectS5.put("id", (int)count);
				jsonobjectS5.put("category", (int)Category.S5_c);
				jsonobjectS5.put("name",s5.get(m));
				jsonobjectS5.put("label",s5.get(m));
				jsonobjectS5.put("symbolSize", (int)20);
				jsonobjectS5.put("ignore", (boolean)true);
				jsonobjectS5.put("flag",(boolean) true);
				jsonArray.add(jsonobjectS5);
				jsonobjectlinkS5.put("source", (int)count);
				jsonobjectlinkS5.put("target",(int)(f04-m-1));
				count++;
				f04++;
				String str05=(String) s5.get(m);
				List s6 = v.getS6(str05);
				if(s.findBySubj(str05).size()>0){
				System.out.println("S6数目=="+s6.size());
				jsonobjectlinkS5.put("name",Category.S_relation);
				int f05=count;
				JSONObject jsonobjectS6 = new JSONObject();
				JSONObject jsonobjectlinkS6 = new JSONObject();
				for(int n=0;n<s6.size();n++){
				jsonobjectS6.put("id", (int)count);
				jsonobjectS6.put("category", (int)Category.S6_c);
				jsonobjectS6.put("name", s6.get(n));
				jsonobjectS6.put("label",s6.get(n));
				jsonobjectS6.put("symbolSize", (int)20);
				jsonobjectS6.put("ignore", (boolean)true);
				jsonobjectS6.put("flag", (boolean)true);
				jsonArray.add(jsonobjectS5);
				jsonobjectlinkS6.put("source", (int)count);
				jsonobjectlinkS6.put("target", (int)(f05-n-1));
				jsonobjectlinkS6.put("name","LastSuperClass");
				jsonArrayLink.add(jsonobjectlinkS6);
				count++;
				f05++;
				}
				}
				else
				jsonobjectlinkS5.put("name","LastSuperClass");
				jsonArrayLink.add(jsonobjectlinkS5);
				}
				}
				else
				jsonobjectlinkS4.put("name","LastSuperClass");
				jsonArrayLink.add(jsonobjectlinkS4);
				}
				}
				else
				jsonobjectlinkS3.put("name","LastSuperClass");
				jsonArrayLink.add(jsonobjectlinkS3);
				}
				}
				else
				jsonobjectlinkS2.put("name","LastSuperClass");
				jsonArrayLink.add(jsonobjectlinkS2);
				}
				}
				else
				jsonobjectlinkS1.put("name","LastSuperClass");
				jsonArrayLink.add(jsonobjectlinkS1);
				}
				}
			//FFFFFFFFFFF
			List f1 = v.getF1(name);
			if(f1.size()>0){
				System.out.println("F1数目=="+f1.size());
				JSONObject jsonobjectf1 = new JSONObject();
				JSONObject jsonobjectlinkf1 = new JSONObject();
			for(int i=0;i<f1.size();i++){
				jsonobjectf1.put("id", (int)count);
				jsonobjectf1.put("category", (int)1);
				jsonobjectf1.put("name", f1.get(i));
				jsonobjectf1.put("label", f1.get(i));
				jsonobjectf1.put("symbolSize", (int)20);
				jsonobjectf1.put("ignore", (boolean)true);
				jsonobjectf1.put("flag", (boolean)true);
				jsonArray.add(jsonobjectf1);
				jsonobjectlinkf1.put("source", (int)count);		
				jsonobjectlinkf1.put("target", (int)0);
				count++;
				String str01=(String)f1.get(i);
				List f2 = v.getF2(str01);
				if(s.findBySubj(str01).size()>0){
					System.out.println("F2数目=="+f2.size());
					jsonobjectlinkf1.put("name",Category.F_relation);										
					int f01=count;
					JSONObject jsonobjectf2 = new JSONObject();
					JSONObject jsonobjectlinkf2 = new JSONObject();
					for(int j=0;j<f2.size();j++){
					jsonobjectf2.put("id", (int)count);
					jsonobjectf2.put("category", (int)Category.F2_c);
					jsonobjectf2.put("name",f2.get(j));
					jsonobjectf2.put("label",f2.get(j));
					jsonobjectf2.put("symbolSize", (int)20);
					jsonobjectf2.put("ignore", (boolean)true);
					jsonobjectf2.put("flag", (boolean)true);
					jsonArray.add(jsonobjectf2);
					jsonobjectlinkf2.put("source", (int)count);
					jsonobjectlinkf2.put("target", (int)(f01-j-1));
					count++;
					f01++;
					String str02=(String) f2.get(j);
					List f3 = v.getF3(str02);
					if(s.findBySubj(str02).size()>0){
						System.out.println("F3数目=="+f3.size());
						jsonobjectlinkf2.put("name",Category.F_relation);							
						int f02=count;
						JSONObject jsonobjectf3 = new JSONObject();
						JSONObject jsonobjectlinkf3 = new JSONObject();
						for(int k=0;k<f3.size();k++){
						jsonobjectf3.put("id", (int)count);
						jsonobjectf3.put("category", (int)Category.F3_c);
						jsonobjectf3.put("name", f3.get(k));
						jsonobjectf3.put("label",f3.get(k));
						jsonobjectf3.put("symbolSize", (int)20);
						jsonobjectf3.put("ignore",(boolean) true);
						jsonobjectf3.put("flag", (boolean)true);
						jsonArray.add(jsonobjectf3);
						jsonobjectlinkf3.put("source", (int)count);
						jsonobjectlinkf3.put("target", (int)(f02-k-1));
						count++;
						f02++;
						String str03=(String)f3.get(k);
						List f4 = v.getF4(str03);
						if(s.findBySubj(str03).size()>0){
							System.out.println("F4数目=="+f4.size());
							jsonobjectlinkf3.put("name",Category.F_relation);							
							int f03=count;
						
							JSONObject jsonobjectf4 = new JSONObject();
					
							JSONObject jsonobjectlinkf4 = new JSONObject();
					
							for(int l=0;l<f4.size();l++){
							jsonobjectf4.put("id", (int)count);
							jsonobjectf4.put("category", (int)Category.F4_c);
							jsonobjectf4.put("name",f4.get(l));			
							jsonobjectf4.put("label",f4.get(l));
							jsonobjectf4.put("symbolSize", (int)20);
							jsonobjectf4.put("ignore",(boolean) true);
							jsonobjectf4.put("flag",(boolean) true);
							jsonArray.add(jsonobjectf4);
							//System.out.println("添加F4成功::::::::::::::::::::"+v.getF4(str03).get(l));
							jsonobjectlinkf4.put("source",(int)count);
							jsonobjectlinkf4.put("target", (int)(f03-l-1));
							count++;
							f03++;
							String str04=(String) f4.get(l);
							List f5 = v.getF5(str04);
							if(s.findBySubj(str04).size()>0){
								System.out.println("F5数目=="+f5.size());
								jsonobjectlinkf4.put("name",Category.F_relation);
								int f04=count;
								JSONObject jsonobjectf5 = new JSONObject();
								JSONObject jsonobjectlinkf5 = new JSONObject();
								for(int m=0;m<f5.size();m++){
								jsonobjectf5.put("id", (int)count);							
								jsonobjectf5.put("category", (int)Category.F5_c);
								jsonobjectf5.put("name",f5.get(m));
								jsonobjectf5.put("label",f5.get(m));
								jsonobjectf5.put("symbolSize", (int)20);
								jsonobjectf5.put("ignore", (boolean)true);
								jsonobjectf5.put("flag",(boolean) true);
								jsonArray.add(jsonobjectf5);
								jsonobjectlinkf5.put("source", (int)count);
								jsonobjectlinkf5.put("target",(int)(f04-m-1));
								count++;
								f04++;
								String str05=(String) f5.get(m);
								List f6 = v.getF6(str05);
								if(s.findBySubj(str05).size()>0){
									System.out.println("F6数目=="+f6.size());
									jsonobjectlinkf5.put("name",Category.F_relation);
											int f05=count;
											JSONObject jsonobjectf6 = new JSONObject();
											JSONObject jsonobjectlinkf6 = new JSONObject();
											for(int n=0;n<f6.size();n++){
											jsonobjectf6.put("id", (int)count);																					
											jsonobjectf6.put("category", (int)Category.F6_c);
											jsonobjectf6.put("name", f6.get(n));
											jsonobjectf6.put("label",f6.get(n));
											jsonobjectf6.put("symbolSize", (int)20);
											jsonobjectf6.put("ignore", (boolean)true);
											jsonobjectf6.put("flag", (boolean)true);
											jsonArray.add(jsonobjectf5);
											jsonobjectlinkf6.put("source", (int)count);
											jsonobjectlinkf6.put("target", (int)(f05-n-1));
											jsonobjectlinkf6.put("name",Category.F_last_relation);
											jsonArrayLink.add(jsonobjectlinkf6);
											count++;
											f05++;
									}				
								}							
								else
								jsonobjectlinkf5.put("name",Category.F_last_relation);
								jsonArrayLink.add(jsonobjectlinkf5);
								}	
							}							
							else
							jsonobjectlinkf4.put("name",Category.F_last_relation);
							jsonArrayLink.add(jsonobjectlinkf4);
							}	
						}							
						else
						jsonobjectlinkf3.put("name",Category.F_last_relation);
						jsonArrayLink.add(jsonobjectlinkf3);
						}	
					}							
					else
					jsonobjectlinkf2.put("name",Category.F_last_relation);
					jsonArrayLink.add(jsonobjectlinkf2);
					}	
				}							
				else
				jsonobjectlinkf1.put("name",Category.F_last_relation);
				jsonArrayLink.add(jsonobjectlinkf1);			
				}	
			}			
			model.addObject("aa", jsonArray);
			model.addObject("bb", jsonArrayLink);
			System.out.println(s.getX());
			return model;		
			}
		}