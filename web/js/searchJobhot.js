// JavaScript Document
$(document).ready(function () {

   //更多选项
  $('.moretypes').click(function(){
	 if($(this).find("span").attr("class")=="down up"){
		   $('.maptypeBox').css('height','125px');
		   $(this).find("span").removeClass('up');
	  }else
	  {
		  $('.maptypeBox').css('height','auto');
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
  
  
  //abc英文字母专业名称搜索 展开合并
  $('.ashow').click(function(){
	if($(this).attr("class")=="ashow adown"){
	    $(this).parent().next('.Aboxr').css('max-height','118px'); 
	    $(this).text('[展开]');
		$(this).removeClass('adown');
	}else
	{ 
	  $(this).parent().next('.Aboxr').css('max-height','100%'); 
	  $(this).text('[收起]');
	  $(this).addClass('adown');	
    }

  })


//职位搜索-热门搜索选项卡
  var oLihot = document.getElementById("tabhot").getElementsByTagName("li");
  var oUlhot = document.getElementById("contenthot").getElementsByTagName("ul");	
  for(var i = 0; i < oLihot.length; i++)
  {
		oLihot[i].index = i;
		oLihot[i].onclick = function ()
        {			
           for(var n = 0; n < oLihot.length; n++)
	          oLihot[n].className="";		
			  this.className = "currenthot";		
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