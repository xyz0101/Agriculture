package com.Agriculture;

import java.util.Comparator;

public class Compare implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		char a[]=((String) o1).toCharArray();
		char b[]=((String) o2).toCharArray();
		int str1 = 0;
		int str2 = 0;
		
		for(int i=0;i<(int)(((String) o1).length());i++){
			if(a[i]=='¡¾'){
				 str1=i;
				break;
			}
				 str1=(int)(((String) o1).length());
		}
		
	
		for(int j=0;j<(int)(((String) o2).length());j++){
			if(b[j]=='¡¾'){
				 str2=j;
				break;
			}
				 str2=(int)(((String) o2).length());
		}
		return str1-str2;
	}

}
