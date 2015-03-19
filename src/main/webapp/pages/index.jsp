<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>企业云门户</title>

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- 公共样式文件 -->
		<jsp:include page="basePage/loadCss.jsp"></jsp:include>
	</head>

	<body>
		<!-- 领子 -->
		<jsp:include page="basePage/loadCollar.jsp"></jsp:include>
		
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>
				<!-- 菜单 -->
				<jsp:include page="basePage/loadMenuTree.jsp"></jsp:include>
				
				
				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try {
								ace.settings.check('breadcrumbs', 'fixed')
							} catch (e) {
							}
						</script>
				
						<ul class="breadcrumb">
							<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
							<li class="active">人力资源</li>
						</ul>
						<!-- .breadcrumb -->
					</div>
					
					<!-- 页面内容 -->
					<div class="page-content">
						
					</div>
					<!-- /.page-content -->
				</div>
				<!-- /.main-content -->

			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
		<!-- 公共js部分 -->
		<jsp:include page="basePage/loadJs.jsp"></jsp:include>
	</body>
</html>
