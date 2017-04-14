<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'view.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.4.3.min.js"></script> 
<script type="text/javascript" src="js/jquery-1.4.3.js"></script> 
<script type="text/javascript"> 
$(function() {  
    ajax_request();  
});
var ajax_request = function(){ 
//ajax服务端通信
$.ajax({ 
url:"findname", //服务器的地址 
data:$("#txt").attr("value",'name'), //参数 
dataType:"json", //返回数据类型 
type:"POST", //请求类型
 error:function(data){  
            alert("shibai");  
        },   
success:function(data){ 
	//var obj1 = $.parseJSON(data); 
	alert("23232323");
	alert(${requestScope.value });
	 var state_value = ${requestScope.value };  //result是和action中定义的result变量的get方法对应的
	// alert(state_value); 
if(state_value.length) { 
//遍历data，添加到自动完成区 
$.each(state_value, function(index,term) { 
//创建li标签,添加到下拉列表中 
$('<li></li>').text(term).appendTo($autocomplete) 
.addClass('clickable') 
.hover(function(){ 
//下拉列表每一项的事件，鼠标移进去的操作 
$(this).siblings().removeClass('highlight'); 
$(this).addClass('highlight'); 
selectedItem = index; 
},function(){ 
//下拉列表每一项的事件，鼠标离开的操作 
$(this).removeClass('highlight'); 
//当鼠标离开时索引置-1，当作标记 
selectedItem = -1; 
}) 
.click(function(){ 
//鼠标单击下拉列表的这一项的话，就将这一项的值添加到输入框中 
$searchInput.val(term); 
//清空并隐藏下拉列表 
$autocomplete.empty().hide(); 
}); 
});//事件注册完毕 
//设置下拉列表的位置，然后显示下拉列表 
var ypos = $searchInput.position().top; 
var xpos = $searchInput.position().left; 
$autocomplete.css('width',$searchInput.css('width')); 
$autocomplete.css({'position':'relative','left':xpos + "px",'top':ypos +"px"}); 
setSelectedItem(0); 
//显示下拉列表 
$autocomplete.show(); 
} 
} 
}); 
}; 
</script>
  </head>
  
  <body>
   <center>
   <form action="view" method="post">
   <div id = "search">
  <b>请输入关键词</b> <input type="text" name ="name">
   <input type="submit" value="搜索">   
   </div>
   </form>
   </center>
  
    ${requestScope.aa }<br>
    ${requestScope.value }<br><br>
    ${requestScope.bb }<br>
  
  </body>
</html>
