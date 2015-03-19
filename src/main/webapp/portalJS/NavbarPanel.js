/**
 * 领子功能的点击事件
 * @param id
 * @returns {Boolean}
 */
function clickNavBar(id) {
	var user_id = $('#user_id').text();
	var method;
	var $id=$('#'+id);
	if($id.data('loading')){//防重复点击 
		return false;
	};
	$id.data({
		'loading':true
	});
	if("task_widget"==id){
		method = "tp.kernel.task.get.user.task";
	}else if("message_widget"==id){
		method = "tp.kernel.message.get.user.message";
	}else if("notice_widget"==id){
		method = "tp.kernel.notice.get.user.notice.collar";
	}
	var params = JSON.stringify({
		"method" : method,
		"params" : [ {
			"user_id" : user_id,
			"operator" : user_id
		} ],
		"id" : 1
	});
	var url = window.location.protocol + "//" + window.location.host + WebContext +"/ajaxRequest";
	//var url = window.location.protocol + "//" + "portal.smallpay.com" + WebContext +"/ajaxRequest";
	//获取ul对象
	var ulObj = $('#' + id).find("ul:eq(0)");
	ulObj.find("li").remove();
	ulObj.append($("<li class='text-center'>加载中...</li>"))
	$.ajax({
		type: "post",
        contentType :"application/json;charset=utf-8",
        url: url,
        data: params,
        dataType: "json",
        success: function(data) {
        	$id.data({
				'loading':false
			});
        	//alert(JSON.stringify(data)); 
			//首先清空ul下的所有li数据
			//ulObj.html('');
	        $('#' + id).find("ul:eq(0) li").remove();
			var count = $('#' + id).find("span:eq(0)").text();
			//返回的下拉菜单数据
			var liList = new Array();
			var liHeader;
			var liText;
			var noDataMessage;
			if("task_widget"==id){
				liList = data.data.task_list;
				liHeader = "<li class='dropdown-header'><i class='icon-ok'></i>您有"+count+"个任务要完成</li>";
				noDataMessage = "没有任务";
			}else if("message_widget"==id){
				liList = data.data.message_list;
				liHeader = "<li class='dropdown-header'><i class='icon-envelope-alt'></i>"+count+"消息</li>";
				noDataMessage = "没有消息";
			}else if("notice_widget"==id){
				liList = data.data.notice_list;
				ulObj.addClass("navbar-pink");
				liHeader = "<li class='dropdown-header'><i class='icon-warning-sign'></i>"+count+"通知</li>";
				noDataMessage = "没有通知";
			}
			ulObj.append(liHeader);
			if(liList.length == 0){
				liText = "<li><a href='#'><div class='clearfix'><span class='pull-left'>"+noDataMessage+"</span></div></a></li>";
				ulObj.append(liText);
			}else{
	             if ("task_widget" == id) {
					for ( var i = 0; i < liList.length; i++) {
						var liObj = liList[i];
						/* var icon_font_name;
						var id;
						var begin_time;
						var end_time;
						var icon_font_value; */
						var content = liObj.content;
						var url = liObj.url;
						var task_url_type = liObj.task_url_type;
						var target = "_self";
	
						//url = "http://www.baidu.com";
	
						if ("1" == task_url_type) {
							target = "_blank"
						}
						liText = "<li><a href='"+url+"' target='"+target+"'><div class='clearfix'><span class='pull-left'>"
								+ content
								+ "</span></div></a></li>";
						ulObj.append(liText);
					}
				}else if("notice_widget"==id){
					for ( var i = 0; i < liList.length; i++) {
						var liObj = liList[i];
						var notice_content = liObj.notice_content;
						var notice_url = liObj.notice_url;
						var notice_id = liObj.notice_id;
						var portal_domain = $("#portal_domain").text();
						liText = "<li><a href='"+ portal_domain + "/" + notice_url+"?noticeId="+notice_id+"'><div class='clearfix'><span class='pull-left'>"
								+ notice_content
								+ "</span></div></a></li>";
						ulObj.append(liText);
					}
				}else if("message_widget"==id){
					for ( var i = 0; i < liList.length; i++) {
						var liObj = liList[i];
						var icon_time = liObj.icon_time;
						var user_img_url_from = liObj.user_img_url_from;
						var update_date = liObj.create_date;
						var message_content = liObj.message_content;
						var user_name_from = liObj.user_name_from;
						var user_id_from = liObj.user_id_from;
						
						var portal_domain = $("#portal_domain").text();
						liText = "<li><a href=\""+portal_domain+"/SentMessage.html?sentId="+user_id_from+"\"><img src='"+user_img_url_from+"' class='msg-photo' alt='Avatar'><span class='msg-body'><span class='msg-title'><span class='blue'>"+user_name_from+":</span>"+message_content+"</span><span class='msg-time'><i class='"+icon_time+"'></i><span>"+update_date+"</span></span></span></a></li>";
						ulObj.append(liText);
					}
				}
			}
			//将“更多”部分插入ul
			var more_label_icon_font_name = data.data.more_label_icon_font_name;
			var count = data.data.count;
			var more_url = data.data.more_url;
			var more_label_icon_font_value = data.data.more_label_icon_font_value;
			var more_label = data.data.more_label;
			var moreText = $("<li><a href='"+more_url+"'><span>"
					+ more_label
					+ "</span><i class='icon-arrow-right'></i></a></li>");
			ulObj.append(moreText);
		},
		error:function(){
			ulObj.html("<li class='text-center'>加载失败，请重试！</li>");
			$id.data({
				'loading':false
			});
		}
	});

};

/**
 * 聊天插件初始化
 */
function initWebChat() {
	var userId = $('#user_id').text();
	var enterprise_id = $('#enterprise_id').text();
	var iframe = document.createElement('iframe');
	var portal_domain = $("#portal_domain").text();
	var chatUrl = window.location.protocol + "//" + window.location.host + WebContext;
	var src = portal_domain + "/webChat/webChat.html?" + "userId=" + userId + "&enterprise_id=" + enterprise_id+"&tmp="+Math.random();
	iframe.src = src;
	iframe.id = 'webchatiframe';
	iframe.style.display = 'none';
	iframe.setAttribute('frameborder', '0');
	document.getElementsByTagName('body')[0].appendChild(iframe);
	try{
		var socket = io.connect(MpcServer);
		socket.on('tp.mpc.channel.chat.all', function(tpdata) {
			WEBCHATAPI_chatall(tpdata);
		});
	}catch(e){

	}
}

/**
 * 领子的数字部分的监听对象
 */
function CollarSocketObj(){
	var _socket = null;
	this.init = function(socket){
		_socket = socket;
		_socket.emit("tp.mc.channel.register", $("#user_id").text());
	};
	this.monitor = function(){
		_socket.on("tp.mpc.channel.message.collar", function (tpdata) {
			$("#message_widget").find("i:eq(0)").removeClass("icon-animated-vertical");
				var fn = function(){
					$("#message_widget").find("i:eq(0)").addClass("icon-animated-vertical");
				};
				setTimeout(fn, 1000);
			$("#message_widget").find("span:eq(0)").text(tpdata.count);
		});

		_socket.on("tp.mpc.channel.task.collar", function (tpdata) {
			$("#task_widget").find("span:eq(0)").text(tpdata.count);
		});		
		
		_socket.on("tp.mpc.channel.notice.collar", function (tpdata) {
			$("#notice_widget").find("i:eq(0)").removeClass("icon-animated-bell");
				var fn = function(){
					$("#notice_widget").find("i:eq(0)").addClass("icon-animated-bell");
				};
				setTimeout(fn, 1000);
			$("#notice_widget").find("span:eq(0)").text(tpdata.count);
		});
	};
}

/**
 * 初始化领子的推送功能
 */
function initCollarPushObj() {
	try{
		var socket = io.connect(MpcServer);
		var collarSocket = new CollarSocketObj();
		collarSocket.init(socket);
		collarSocket.monitor();
	}catch(e){

	}
}

$(function() {
	initCollarPushObj();
	//initWebChat();
});