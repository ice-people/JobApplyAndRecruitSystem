// JavaScript Document
$(document).ready(function () {
   //导航
   $('.navItem.other').hover(function(){
		$(this).find("#TopNavMorePopup").stop(true,true).slideDown();
	},function(){
		$(this).find("#TopNavMorePopup").stop(true,true).slideUp();
    });
	
	//侧边栏二级导航
	$('.NavLeftBox.twoNav').click(function(){
	    if($(this).attr("class")=="NavLeftBox twoNav on"){
			$(this).removeClass('on');
		    $(this).find('span.up.down').removeClass('down');
			$(this).next('ul').css('display','block');
		}
		else{
		   $(this).addClass('on');
		   $(this).find('span.up').addClass('down');
		   $(this).next('ul').css('display','none');
		} 
	})
	
	//简历状态  已公开 已隐藏
	$('.statusjl').click(function(){
	   if($(this).attr("class")=="statusjl on"){
	        $(this).removeClass('on');
		}else{
			$(this).addClass('on');
		}
	})
	
	//隐藏姓名
	$('.check1').click(function(){
	   if($(this).attr("class")=="check1 on"){
	      $(this).addClass('on');
		  $(this).removeClass('on');
	   }else
	   {
		  $(this).removeClass('on');
		  $(this).addClass('on');
	   }
	})
	
	//性别
	$('.sex').click(function(){
	   if($(this).attr("class")=="sex on"){
	      $('.sex').addClass('on');
		  $(this).removeClass('on');
	   }else
	   {
		  $('.sex').removeClass('on');
		  $(this).addClass('on');
	   }
	})
	
	//性别
	$('.typeJob').click(function(){
	   if($(this).attr("class")=="typeJob on"){
	      $('.typeJob').addClass('on');
		  $(this).removeClass('on');
	   }else
	   {
		  $('.typeJob').removeClass('on');
		  $(this).addClass('on');
	   }
	})
	
	
	//填写更详细的工作经历
	$('.jobmoreicon').click(function(){
	   if($(this).attr("class")=="jobmoreicon on"){
		  $(this).removeClass('on');
		  $(this).parent().find('.qitaBox').css('display','none');
	   }else
	   {
		  $(this).addClass('on');
		  $(this).parent().find('.qitaBox').css('display','block');
	   }
	})
	
	//技能标签
	$('.jnAdd').click(function(){
	   $(this).css('display','none');
	   $(this).parent().parent().find('.jnBox').css('display','block');
	})
	$('.jnBox .btnBOX a.quxiao').click(function(){
	   $(this).parent().parent().css('display','none');
	   $(this).parent().parent().parent().find('.addcomeon a.jnAdd').css('display','block');
	})
	
	
	//职位搜索搜索条件展开隐藏
  $('.search2 .xzdiv .imgshow').click(function(){
     $(this).css('display','none');
	 $(this).parent().find('.imghidden').css('display','block');
     $(this).parent().parent().find('.xzdivC').css('height','auto');
  })
  $('.search2 .xzdiv .imghidden').click(function(){
     $(this).css('display','none');
	 $(this).parent().find('.imgshow').css('display','block');
     $(this).parent().parent().find('.xzdivC').css('height','33px');
  })
	//职位搜索  更多选项
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
  
  
  
  //个人中心-帮助中心
  $('.quesBox a').click(function(){
     $('.quesBox').removeClass('show');
	 $(this).parent().addClass('show');
  })
  
  
  //申请的职位  选项卡
  var oLihot = document.getElementById("tabsqzw").getElementsByTagName("li");
  var oUlhot = document.getElementById("contentsqzw").getElementsByTagName("ul");	
  for(var i = 0; i < oLihot.length; i++)
  {
		oLihot[i].index = i;
		oLihot[i].onclick = function ()
        {			
           for(var n = 0; n < oLihot.length; n++)
	          oLihot[n].className="";		
			  this.className = "currentsqzw";		
			  for(var n = 0; n < oUlhot.length; n++) 
				 oUlhot[n].style.display = "none";	
				 oUlhot[this.index].style.display = "block";
				 if(oUlhot[this.index].title == ""){			
					 $.parser.parse(oUlhot[this.index]);
					 oUlhot[this.index].title = "parsed";
				 }
	   }	
   }
   
   
   
})