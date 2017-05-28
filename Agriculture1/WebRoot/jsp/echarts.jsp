<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta charset="UTF-8">

</head>
<body>
	</div>
    <div id="main" style="width: 1000px; height: 750px"></div>
    
   <div class = "message" style="margin-left: 80%; margin-top: -40%; width: 200px; height: 300px;border:1px solid #F00;background-color:white;display:none"  >
	<!-- <a id="close">x</a>    -->
	叙词名为：<span id="span1">原文</span>
	 <br>
	<!-- <span id="span3">原文</span>  -->
	英文名为：<span id="span2">原文</span><br>
	拉丁文为：<span id="span3">原文</span>
	</div>
    <script src="js/jquery-1.4.3.min.js"></script>
 <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
    
    
      require.config({
            paths : {
                echarts : 'http://echarts.baidu.com/build/dist'
            }
        });
        require([ "echarts", "echarts/chart/force"], function(ec) {
        	var i;
        	var myData =${requestScope.aa };
        	if(myData.length>100)
        	i = myData.length/100;
        	else
        	 i = 1.1;
        	// var x=${resquestScope.value};
        	//var myLink =${requestScope.aa };
            var myChart = ec.init(document.getElementById('main'), 'macarons');
            var option = {
                tooltip : {
                    show : false
                },
				tooltip : {
        trigger: 'item',
        formatter: '{a} : {b}'
    },
    toolbox: {
        show : true,
        feature : {
            restore : {show: true},
            magicType: {show: true, type: ['force', 'chord']},
            saveAsImage : {show: true}
        }
    },
               series : [
        {
            type:'force',
           		//edgeLength: 10, //默认距离
              //  repulsion: 10, //斥力
            ribbonType: true,
            categories : [
                
            ],
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        textStyle: {
                            color: '#333'
                        }
                    },
                    nodeStyle : {
                        brushType : 'both',
                        borderColor : 'rgba(255,215,0,0.4)',
                        borderWidth : 1
                    },
                    linkStyle: {
                        type: 'curve'
                    }
                },
                emphasis: {
                    label: {
                        show: false
                        // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
                    },
                    nodeStyle : {
                        //r: 30
                    },
                    linkStyle : {
					
					}
                }
            },			
            useWorker: false,
            minRadius : 15,
            maxRadius : 25,
            gravity: 1.1,
            scaling: i,
            roam: 'move',
                     nodes :${requestScope.aa},
                    links :${requestScope.bb}
                } ]
            };
            myChart.setOption(option);
            var ecConfig = require('echarts/config');
            function openOrFold(param) {
                var option = myChart.getOption();//获取已生成图形的option
                var nodesOption = option.series[0].nodes;//获得所有节点数组
                var linksOption = option.series[0].links;//获得所有连接的数组
                var data = param.data;//表示当前选择的某一节点
                var linksNodes = [];//中间变量
				//var value=${requestScope.value };
                var categoryLength = option.series[0].categories.length;//获取类别数组的大小
				/*
				该段代码判断当前节点的category是否为最终子节点，
				如果是，则弹出该节点的label
				*/  
                if (data.category == (0)) {
						//window.open =function () {
    
	//}
				}
				//添加点击事件
				 if (typeof param.seriesIndex == 'undefined') {    
				        return;    
			      }  
			  
				    if (param.type == 'click') {    
				    	 
				    	 $.ajax({ 
							url:"findename", //服务器的地址 
							data:{"name":param.name}, //参数 
							dataType:"text", //返回数据类型 
							type:"POST", //请求类型 
							success:function(data){ 
							var result = eval(data);
              					$("#span1").text(param.name);	
								$("#span2").html(result[0]);	
							},
							error:function(data){
							alert(shibai);
							}
							});	
							
							$.ajax({ 
							url:"findelname", //服务器的地址 
							data:{"name":param.name}, //参数 
							dataType:"text", //返回数据类型 
							type:"POST", //请求类型 
							success:function(data){ 
							var result = eval(data);
              					$("#span1").text(param.name);	
								$("#span3").html(result[0]);	
							},
							error:function(data){
						//	alert('shibai');
							}
							});	
							$(".message").fadeIn();
 				 		    $(".message").fadeIn("slow");
  						    $(".message").fadeIn(3000);	 	    	   	  
				    	  //$("#span2").text(param.name); 	
				    }    
					//判断是否选择到了连接线上
                if (data != null && data != undefined) {
					/*
					判断所选节点的flag
					如果为真，则表示要展开数据,
					如果为假，则表示要折叠数据
					*/
                    if (data.flag) {
					//遍历关系数组，最终获得所选节点的一层子节点
                        for ( var m in linksOption) {
							//父节点为当前节点
                            if (linksOption[m].target == data.id) {
							
                                linksNodes.push(linksOption[m].source);//获得子节点数据
                            }
                        }
						//遍历子节点数组，设置对应的option属性
                        if (linksNodes != null && linksNodes != undefined) {
                            for ( var p in linksNodes) {
                                nodesOption[linksNodes[p]].ignore = false;//设置展示该节点
                                nodesOption[linksNodes[p]].flag = true;
                            }
                        }
                        nodesOption[data.id].flag = false;//设置该节点的flag为false，下次点击折叠子孙节点
                        myChart.setOption(option);//重新绘制
                    } else {

                        for ( var m in linksOption) {
								/* 
								遍历连接关系数组，最终获得所选择节点的所有子节点
								*/
                            if (linksOption[m].target == data.id) {//父节点为当前节点
                                linksNodes.push(linksOption[m].source);//找到当前节点的第一层子节点
                            }
                            if (linksNodes != null && linksNodes != undefined) {
                                for ( var n in linksNodes) {
								//第一层子节点作为父节点，找到所有子孙节点
                                    if (linksOption[m].target == linksNodes[n]) {
                                        linksNodes.push(linksOption[m].source);
                                    }
                                }
                            }
                        }
						//遍历最终生成的连接关系数组
                        if (linksNodes != null && linksNodes != undefined) {
                            for ( var p in linksNodes) {
                                nodesOption[linksNodes[p]].ignore = true;//设置折叠该节点
                                nodesOption[linksNodes[p]].flag = true;
                                 $(".message").hide();
                            }
                        }
                        nodesOption[data.id].flag = true;//设置该节点的flag为true，下次点击展开子节点
                        myChart.setOption(option);//重绘
                    }
                }
            }
            myChart.on(ecConfig.EVENT.CLICK, openOrFold);
        });
    </script>

</body>
</html>