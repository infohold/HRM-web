<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 领子 -->
<div class="navbar navbar-default" id="navbar">
	<script type="text/javascript">
		try{ace.settings.check('navbar' , 'fixed')}catch(e){}
	</script>
	
	<div class="navbar-container" id="navbar-container">
		<div class="navbar-header pull-left">
			<a href="#" class="navbar-brand">
				<small>
				</small>
			</a><!-- /.brand -->
		</div><!-- /.navbar-header -->

		<div class="navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li id="task_widget" onclick="clickNavBar(this.id);">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">
						<i></i>
						<span class="badge badge-grey"></span>
					</a>

					<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close" id="task_widget_content"></ul>
				</li>

				<li id="notice_widget" onclick="clickNavBar(this.id);">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">
						<i></i>
						<span class="badge badge-important"></span>
					</a>

					<ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close" id="notice_widget_content"></ul>
				</li>

				<li id="message_widget" onclick="clickNavBar(this.id);">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">
						<i></i>
						<span class="badge badge-success"></span>
					</a>

					<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close" id="message_widget_content"></ul>
				</li>

				<li class="light-blue">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<img class="nav-user-photo"/>
						<span class="user-info">
							<small></small>
						</span>
						<span id="user_id" style="display: none"></span>
						<span id="enterprise_id" style="display: none"></span>
						<i class="icon-caret-down"></i>
					</a>

					<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li class="divider"></li>
						<li class="logout"></li>
					</ul>
				</li>
			</ul><!-- /.ace-nav -->
		</div><!-- /.navbar-header -->
	</div><!-- /.container -->
</div>