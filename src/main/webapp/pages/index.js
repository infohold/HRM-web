//启动预加载
jQuery(function($) {
	loadMenuTree();
	loadCollar();
});

//加载菜单树
function loadMenuTree(){
	$.ajax({
		url : "loadMenuTree.action",
		// 数据发送方式
		type : "post",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		// data : params,
		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
			if(data != null && data.length > 0){
				renderMenuTree(data);
			}
		}
	});
}

//加载领子信息
function loadCollar(){
	$.ajax({
		url : "loadCollar.action",
		// 数据发送方式
		type : "post",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		// data : params,
		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
			if(data != null && data.length > 0){
				renderCollar(data);
			}
		}
	});
}

//渲染菜单树
function renderMenuTree(data){
	data = eval(data);
	var menuUl = $("ul.nav-list");
	loopBuildMenuTree(menuUl,data)
}
//迭代创建树
function loopBuildMenuTree(rootDom,data){
	for(var i=0;i<data.length;i++){
		var menuLi = $("<li></li>");
		rootDom.append(menuLi);
		var menuA = $("<a></a>");
		menuLi.append(menuA);
		var menuI = $("<i></i>");
		menuA.append(menuI);
		//图标
		if(data[i]["menu_icon_font_name"] != null){
			menuI.attr("class",data[i].menu_icon_font_name);
		}else{
			menuI.attr("class","");
		}
		
		if(data[i]["menu_level"] != null && data[i]["menu_level"] == 2){
			menuI.attr("class","icon-double-angle-right");
		}
		
		//
		if(data[i].menu_url_type == 1){
			menuA.attr("target","_blank");
		}
		
		var menuSpan = $("<span class=\"menu-text\"></span>");
		menuSpan.append(data[i].menu_title);
		menuA.append(menuSpan);
		var menuB = $("<b></b>");
		menuA.append(menuB);
		//判断是否有子菜单
		if(data[i].sub_menu_items == null){
			//否
			menuA.attr("href",data[i].menu_skip_url);
		}else{
			//是
			menuA.attr({
				href:"javascript:;",
				target:"_blank",
				class:"dropdown-toggle"
			});
			menuB.attr("class","arrow icon-angle-down");
			var subMenuUl = $("<ul class=\"submenu\"></ul>");
			menuLi.append(subMenuUl);
			loopBuildMenuTree(subMenuUl,data[i].sub_menu_items);
		}
	}
}
//渲染领子
function renderCollar(data){
	data = eval(data);
	data = data[0];
	console.log(data)
	var collarDiv = $("div.navbar-container");
	//系统名称
	collarDiv.find("a.navbar-brand small").text(data.portal_sub_system_name);
	//职务
	collarDiv.find("span.user-info small").text(data.userinfo_widget.user_position);
	//用户名
	collarDiv.find("span.user-info small").after(data.userinfo_widget.user_name);
	//头像
	collarDiv.find("img.nav-user-photo").attr("src",data.userinfo_widget.user_avatar_url);
	//用户id
	collarDiv.find("#user_id").text(data.user_id);
	//域
	collarDiv.find("#enterprise_id").text(data.enterprise_id);
	//应用列表
	var appUl = collarDiv.find("ul.user-menu");
	var appList = data.userinfo_widget.application_list;
	for(var i=0;i<appList.length;i++){
		if("退出" != appList[i].label){
			var appLi = $("<li></li>");
			var appA = $("<a></a>");
			appLi.append(appA);
			appA.attr("href",appList[i].url);
			var appI = $("<i></i>");
			appA.append(appI);
			appI.attr("class","icon-user");
			appI.after(appList[i].label);
			
			appUl.find("li.divider").before(appLi);
		}else{
			var appA = $("<a></a>");
			appA.attr("href",appList[i].url);
			var appI = $("<i></i>");
			appA.append(appI);
			appI.attr("class","icon-off");
			appI.after(appList[i].label);
			
			appUl.find("li.logout").append(appA);
		}
	}
	//task_widget
	var taskLi = $("#task_widget");
	taskLi.find("a.dropdown-toggle i").attr("class",data.task_widget.icon_font_name);
	taskLi.find("a.dropdown-toggle span").text(data.task_widget.count);
	taskLi.attr("class",data.task_widget.bgcolor);
	//notice_widget
	var noticLi = $("#notice_widget");
	noticLi.find("a.dropdown-toggle i").attr("class",data.notice_widget.icon_font_name);
	noticLi.find("a.dropdown-toggle span").text(data.notice_widget.count);
	noticLi.attr("class",data.notice_widget.bgcolor);
	//notice_widget
	var messageLi = $("#message_widget");
	messageLi.find("a.dropdown-toggle i").attr("class",data.message_widget.icon_font_name);
	messageLi.find("a.dropdown-toggle span").text(data.message_widget.count);
	messageLi.attr("class",data.message_widget.bgcolor);
}
//点击Bar
function clickNavBar(id) {
	var user_id = $('#user_id').text();
	var method;
	var $id=$('#'+id);
	if($id.data('loading')){//防重复点击 
		return false;
	};
}