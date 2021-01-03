// JavaScript Document

$(document).ready(function () {
  //导航下划线
  $('.menuDiv ul li').mouseover(function(){
     $('.menuDiv ul li').css('border-bottom','0');
	 $(this).css('border-bottom','3px solid #AF4C01');
  })
  $('.menuDiv ul li').mouseout(function(){
	  $('.menuDiv ul li.onmenu').css('border-bottom','3px solid #AF4C01');
  })
  
  //职位搜索搜索条件展开隐藏
  $('.searchDiv .xzdiv .imgshow').click(function(){
     $(this).css('display','none');
	 $(this).parent().find('.imghidden').css('display','block');
     $(this).parent().parent().find('.xzdivC').css('height','auto');
  })
  $('.searchDiv .xzdiv .imghidden').click(function(){
     $(this).css('display','none');
	 $(this).parent().find('.imgshow').css('display','block');
     $(this).parent().parent().find('.xzdivC').css('height','33px');
  })
  
  //更多选项
  $('.search3').click(function(){
     $('.xzdiv.hidden').toggle();
	 if($(this).find("span").attr("class")=="down up"){
		   $(this).find("span").removeClass('up');
	  }else
	  {
		  $(this).find("span").addClass('up');
	  }
  })
  
  //列表摘要
  $('.seachlist .tj1 span.list').click(function(){
      $('.seachlist .tj1').removeClass('on');
	  $(this).addClass('on');
	  $('.seachlist .tj1 span.zhaoyao').removeClass('on');
	  $('table.listtab tr.xxdetail').addClass('none')
  })
  $('.seachlist .tj1 span.zhaoyao').click(function(){
      $('.seachlist .tj1').addClass('on');
	  $(this).addClass('on');
	  $('.seachlist .tj1 span.list').removeClass('on');
	  $('table.listtab tr.xxdetail').removeClass('none');
  })
  
  
  
  //招聘会搜索条件展开隐藏
  $('.meetingDiv .meetsx .imgshow').click(function(){
     $(this).css('display','none');
	 $(this).parent().find('.imghidden').css('display','block');
	 $(this).parent().parent().css('height','auto');
     $(this).parent().parent().find('.meetcon').css('height','auto');
  })
  $('.meetingDiv .meetsx .imghidden').click(function(){
     $(this).css('display','none');
	 $(this).parent().find('.imgshow').css('display','block');
	 $(this).parent().parent().css('height','40px');
     $(this).parent().parent().find('.meetcon').css('height','20px');
  })
  
  //招聘会往期近期招聘会选项卡
  var oLi = document.getElementById("tabmeet").getElementsByTagName("li");
  var oUl = document.getElementById("contentmeet").getElementsByTagName("ul");	
  for(var i = 0; i < oLi.length; i++)
  {
		oLi[i].index = i;
		oLi[i].onclick = function ()
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

