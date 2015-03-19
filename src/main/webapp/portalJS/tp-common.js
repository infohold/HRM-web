var WebContext = "/timesoa";
var MpcServer='http://portal.smallpay.com:3000';//nodejs ishenyang.wicp.net 192.168.9.100
var AjaxUrl=window.location.protocol + "//" + window.location.host + WebContext + "/ajaxRequest";
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

function accAdd(arg1,arg2){ 
	var r1,r2,m; 
	try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0} 
	try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0} 
	m=Math.pow(10,Math.max(r1,r2)); 
	return (arg1*m+arg2*m)/m; 
} 

//给Number类型增加一个add方法，调用起来更加方便。 
Number.prototype.add = function (arg){ 
	return accAdd(arg,this); 
};

//(function(){//bind
//	var $topAppWrap=$('.top-app-wrap');
//	//导航处点击事件
//	$(document.body).on('click',function(event){//处理topapp中的下拉
//		var $this=$(event.target);
//		var length=$this.closest('.top-app-a').length||$this.closest('.top-app').length;
//		if(length){
//			
//		}else{
//			$topAppWrap.hide();
//		}
//	});
//	$(document).on('click','.top-app-a',function(){
//		var $this=$(this);
//		$topAppWrap.toggle();
//		if($topAppWrap.is(":visible")){//显示
//			if(!$this.attr('loaded')){//只加载一次
//				$this.attr('loaded','true');
//				$topAppWrap.find('.top-app-cont').html('');
//				$topAppWrap.find('.icon-spinner').show();
//				$.ajax({
//					type: "post",
//					contentType: "application/json;charset=utf-8",
//					url: AjaxUrl,
//					data: JSON.stringify({
//						"method": "tp.kernel.application.get.collar.application",
//						"params": [{
//							"user_id": $("#user_id").text()
//						}],
//						"id": new Date().toLocaleString()
//					}),
//					dataType: "json",
//					success:function(data){
//						var html="<div class='top-app-content clearfix'>"+
//									"<div class='top-app-content-title'>"+
//										"<h3>{title}</h3>"+
//									"</div>"+
//									"{content}"+
//								"</div>";
//						var item='';
//						var content="";
//						var _data=null;
//						$topAppWrap.find('.icon-spinner').hide();
//						if(data.code==-1){//系统错误
//							$topAppWrap.find('.top-app-cont').html("没有应用");
//							$this.removeAttr('loaded');
//						}else{//成功
//							_data=data.data.shortcut_app_widget;
//							if($.isEmptyObject(_data)){
//								$topAppWrap.find('.top-app-cont').html("没有应用");
//								return false;
//							};
//							$.each(_data,function(key,value){
//								var cont='';
//								item=html.replace("{title}",value.application_group_name||'应用名称');
//								$.each(value.application_group_list,function(index,it){
//									cont+="<div class='col-md-4 col-xs-4 col-sm-4'>"+
//											"<a href='"+(it.application_url||'javascript:;')+"'  class='item'>"+
//												"<i style='font-size:50px; ' class='"+it.app_icon_font_name+"'></i>"+
//												"<p>"+it.application_name+"</p>"+
//											"</a>"+
//										"</div>"
//								});
//								item=item.replace("{content}",cont);
//								content+=item;
//							});
//							$topAppWrap.find('.top-app-cont').html(content);
//						}
//					},
//					error:function(){
//						$topAppWrap.find('.icon-spinner').hide();
//						$topAppWrap.find('.top-app-cont').html("加载失败，请重试！");
//						$this.removeAttr('loaded');
//					}
//				});
//			}else{
//				
//			}
//			
//		}else{
//			
//		}
//	});
//	
//})();

function SysConstantsObj(){
    this.title = '企业云门户';
    this.fileSize = 510000;//流程审批中上传文件的最大尺寸
    return this;
}
var sysConstants = new SysConstantsObj();
$('title').text(sysConstants.title);

/**
 * 共通对话框参数对象
 */
function CommonDailogParam(content,confirmOkCallback){
    this.content = content;
    this.confirmOkCallback = confirmOkCallback;
}

/**
 * 共通对话框对象
 */
function CommonDailog(dailogParam){
	$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
		_title : function(title) {
			var $title = this.options.title || '&nbsp;'
			if (("title_html" in this.options)
					&& this.options.title_html == true)
				title.html($title);
			else
				title.text($title);
		}
	}));
	var _title = "<div class='widget-header'><h4 class='smaller red'><i class='icon-check red'></i>提示</h4></div>";
	var _dialog = $("#common-dialog");
	$("#common-dialog-content").text(dailogParam.content);
	//提示类对话框
	this.alert = function(){
		_dialog.removeClass('hide');
		_dialog.dialog({
			resizable : false,
			modal : true,
			title : _title,
			title_html : true,
			buttons : [ {
				html : "<i class='icon-ok bigger-110'></i>&nbsp;&nbsp;确认 &nbsp;&nbsp;",
				"class" : "btn btn-danger btn-xs",
				click : function() {
					$(this).dialog("close");
				}
			} ]
		});
	};
	
	//确认类对话框
	this.confirm = function(){
		_dialog.removeClass('hide');
		_dialog.dialog(
				{
					resizable : false,
					modal : true,
					title : _title,
					title_html : true,
					buttons : [
							{
								html : "<i class='icon-ok bigger-110'></i>&nbsp; 是  &nbsp;",
								"class" : "btn btn-danger btn-xs",
								click : function() {
									if(dailogParam.confirmOkCallback){
										dailogParam.confirmOkCallback();
									}
									$(this).dialog("close");
								}
							},
							{
								html : "<i class='icon-ban-circle bigger-110'></i>&nbsp; 否  &nbsp;",
								"class" : "btn btn-xs btn-info",
								click : function() {
									$(this).dialog("close");
								}
							} ]
				});
	};
	
	
	
	
}

/**
 * wicket弹出的对话框设置样式
 */
function setWicketMessageDialogStyle(){
	$(".ui-dialog-title").text("").append('<div class="widget-header"><h4 class="smaller red">\
	    <i class="icon-check red"></i>提示</h4></div>');
		$(".ui-dialog-titlebar-close")
		.addClass('ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only')
		.append('<span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span>\
		        <span class="ui-button-text">close</span>')
		.attr("role","button")
		.attr("aria-disabled","false")
		.attr("title","close");
	$(".ui-dialog-buttonset button:contains('OK')").text("")
		.addClass('btn btn-danger btn-xs ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only')
		.attr("role","button")
		.attr("aria-disabled","false")
		.append("<span class=\"ui-button-text\"><i class=\"icon-ok bigger-110\"></i>&nbsp;&nbsp;确认 &nbsp;&nbsp;</span>");
	$(".ui-dialog-buttonset button:contains('Yes')").text("")
		.addClass('btn btn-danger btn-xs ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only')
		.attr("role","button")
		.attr("aria-disabled","false")
		.append("<span class=\"ui-button-text\"><i class=\"icon-ok bigger-110\"></i>&nbsp; 是  &nbsp;</span>");
	$(".ui-dialog-buttonset button:contains('No')").text("")
		.addClass('btn btn-xs btn-info ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only')
		.attr("role","button")
		.attr("aria-disabled","false")
		.append("<span class=\"ui-button-text\"><i class=\"icon-ban-circle bigger-110\"></i>&nbsp; 否  &nbsp;</span>");
}


