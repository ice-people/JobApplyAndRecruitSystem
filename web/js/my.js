// JavaScript Document

//首页小广告图轮换
$(function () {
        var left = $("#left");
        var right = $("#right");
        var obj = $(".adBox0 ul");
        var w = obj.find("li").innerWidth();

        left.click(function () {
            obj.find("li:last").prependTo(obj);
            obj.css("margin-left", -w);
            obj.animate({ "margin-left": 0 });
        });

        right.click(function () {
            obj.animate({ "margin-left": -w }, function () {
                obj.find("li:first").appendTo(obj);
                obj.css("margin-left", "0");
            });
        });
        var moving = setInterval(function () { right.click() }, 5000);
        obj.hover(function () {
            clearInterval(moving);
        }, function () {
            moving = setInterval(function () { right.click() }, 5000);
        })
 });
 
 

$(document).ready(function () {
  //首页右侧登录方式
  $('.loginA').click(function(){
     $('.smlogin').css('display','block');
	 $('.loginB').removeClass('select');
	 $(this).addClass('select');
	 $('.ContentA').css('display','block');
	 $('.ContentB').css('display','none')
  })
  $('.loginB').click(function(){
	 $('.smlogin').css('display','none');
     $('.loginA').removeClass('select');
	 $(this).addClass('select');
	 $('.ContentB').css('display','block');
	 $('.ContentA').css('display','none')
  })
  //首页右侧登录方式接受用户协议
  $('.chebox').click(function(){
	  if($(this).attr("class")=="chebox yes"){
		   $(this).removeClass('yes');
	  }else
	  {
		  $(this).addClass('yes');
	  }
  })
  //二维码登录
  $('.smlogin').click(function(){
     $('.erweima').css('display','block');
  })
  $('.erweima .close').click(function(){
     $('.erweima').css('display','none');
  })
  
  
  //选项卡
  var oLi = document.getElementById("tab").getElementsByTagName("li");
  var oUl = document.getElementById("content").getElementsByTagName("ul");	
  for(var i = 0; i < oLi.length; i++)
  {
		oLi[i].index = i;
		oLi[i].onmouseover = function ()
  {			
  for(var n = 0; n < oLi.length; n++)
	  oLi[n].className="";		
	  this.className = "current";		
	  for(var n = 0; n < oUl.length; n++) 
		 oUl[n].style.display = "none";	
		 oUl[this.index].style.display = "block";
		 if(oUl[this.index].title == ""){			
			 $.parser.parse(oUl[this.index]);
			 oUl[this.index].title = "parsed";
		 }
	 }	
  }
  
  
  
  
  
  
  
  
})

