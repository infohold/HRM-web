<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>企业云门户</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- 页面私有样式 -->
<!-- 公共样式文件 -->
<jsp:include page="../../basePage/loadCss.jsp"></jsp:include>


</head>

<body>
	<!-- 领子 -->
	<jsp:include page="../../basePage/loadCollar.jsp"></jsp:include>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>
			<!-- 菜单 -->
			<jsp:include page="../../basePage/loadMenuTree.jsp"></jsp:include>


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
						<li class="active">部门职务关系管理</li>
					</ul>
					<!-- .breadcrumb -->
				</div>

				<!-- 页面内容 -->
				<div class="page-content">
					<div class="page-header">
						<h1>
							组织机构管理 <small> <i class="icon-double-angle-right"></i>
								部门职务关系维护
							</small>
						</h1>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="sample-table-1"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="center"><label> <input
													type="checkbox" class="ace"> <span class="lbl"></span>
											</label></th>
											<th>Domain</th>
											<th>Price</th>
											<th class="hidden-480">Clicks</th>

											<th><i class="icon-time bigger-110 hidden-480"></i>
												Update</th>
											<th class="hidden-480">Status</th>

											<th></th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td class="center"><label> <input
													type="checkbox" class="ace"> <span class="lbl"></span>
											</label></td>

											<td><a href="#">ace.com</a></td>
											<td>$45</td>
											<td class="hidden-480">3,330</td>
											<td>Feb 12</td>

											<td class="hidden-480"><span
												class="label label-sm label-warning">Expiring</span></td>

											<td>
												<div
													class="visible-md visible-lg hidden-sm hidden-xs btn-group">
													<button class="btn btn-xs btn-success">
														<i class="icon-ok bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-info">
														<i class="icon-edit bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-danger">
														<i class="icon-trash bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-warning">
														<i class="icon-flag bigger-120"></i>
													</button>
												</div>

												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="inline position-relative">
														<button class="btn btn-minier btn-primary dropdown-toggle"
															data-toggle="dropdown">
															<i class="icon-cog icon-only bigger-110"></i>
														</button>

														<ul
															class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
															<li><a href="#" class="tooltip-info"
																data-rel="tooltip" title="" data-original-title="View">
																	<span class="blue"> <i
																		class="icon-zoom-in bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-success"
																data-rel="tooltip" title="" data-original-title="Edit">
																	<span class="green"> <i
																		class="icon-edit bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-error"
																data-rel="tooltip" title="" data-original-title="Delete">
																	<span class="red"> <i
																		class="icon-trash bigger-120"></i>
																</span>
															</a></li>
														</ul>
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<td class="center"><label> <input
													type="checkbox" class="ace"> <span class="lbl"></span>
											</label></td>

											<td><a href="#">base.com</a></td>
											<td>$35</td>
											<td class="hidden-480">2,595</td>
											<td>Feb 18</td>

											<td class="hidden-480"><span
												class="label label-sm label-success">Registered</span></td>

											<td>
												<div
													class="visible-md visible-lg hidden-sm hidden-xs btn-group">
													<button class="btn btn-xs btn-success">
														<i class="icon-ok bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-info">
														<i class="icon-edit bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-danger">
														<i class="icon-trash bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-warning">
														<i class="icon-flag bigger-120"></i>
													</button>
												</div>

												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="inline position-relative">
														<button class="btn btn-minier btn-primary dropdown-toggle"
															data-toggle="dropdown">
															<i class="icon-cog icon-only bigger-110"></i>
														</button>

														<ul
															class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
															<li><a href="#" class="tooltip-info"
																data-rel="tooltip" title="" data-original-title="View">
																	<span class="blue"> <i
																		class="icon-zoom-in bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-success"
																data-rel="tooltip" title="" data-original-title="Edit">
																	<span class="green"> <i
																		class="icon-edit bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-error"
																data-rel="tooltip" title="" data-original-title="Delete">
																	<span class="red"> <i
																		class="icon-trash bigger-120"></i>
																</span>
															</a></li>
														</ul>
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<td class="center"><label> <input
													type="checkbox" class="ace"> <span class="lbl"></span>
											</label></td>

											<td><a href="#">max.com</a></td>
											<td>$60</td>
											<td class="hidden-480">4,400</td>
											<td>Mar 11</td>

											<td class="hidden-480"><span
												class="label label-sm label-warning">Expiring</span></td>

											<td>
												<div
													class="visible-md visible-lg hidden-sm hidden-xs btn-group">
													<button class="btn btn-xs btn-success">
														<i class="icon-ok bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-info">
														<i class="icon-edit bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-danger">
														<i class="icon-trash bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-warning">
														<i class="icon-flag bigger-120"></i>
													</button>
												</div>

												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="inline position-relative">
														<button class="btn btn-minier btn-primary dropdown-toggle"
															data-toggle="dropdown">
															<i class="icon-cog icon-only bigger-110"></i>
														</button>

														<ul
															class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
															<li><a href="#" class="tooltip-info"
																data-rel="tooltip" title="" data-original-title="View">
																	<span class="blue"> <i
																		class="icon-zoom-in bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-success"
																data-rel="tooltip" title="" data-original-title="Edit">
																	<span class="green"> <i
																		class="icon-edit bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-error"
																data-rel="tooltip" title="" data-original-title="Delete">
																	<span class="red"> <i
																		class="icon-trash bigger-120"></i>
																</span>
															</a></li>
														</ul>
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<td class="center"><label> <input
													type="checkbox" class="ace"> <span class="lbl"></span>
											</label></td>

											<td><a href="#">best.com</a></td>
											<td>$75</td>
											<td class="hidden-480">6,500</td>
											<td>Apr 03</td>

											<td class="hidden-480"><span
												class="label label-sm label-inverse arrowed-in">Flagged</span>
											</td>

											<td>
												<div
													class="visible-md visible-lg hidden-sm hidden-xs btn-group">
													<button class="btn btn-xs btn-success">
														<i class="icon-ok bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-info">
														<i class="icon-edit bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-danger">
														<i class="icon-trash bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-warning">
														<i class="icon-flag bigger-120"></i>
													</button>
												</div>

												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="inline position-relative">
														<button class="btn btn-minier btn-primary dropdown-toggle"
															data-toggle="dropdown">
															<i class="icon-cog icon-only bigger-110"></i>
														</button>

														<ul
															class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
															<li><a href="#" class="tooltip-info"
																data-rel="tooltip" title="" data-original-title="View">
																	<span class="blue"> <i
																		class="icon-zoom-in bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-success"
																data-rel="tooltip" title="" data-original-title="Edit">
																	<span class="green"> <i
																		class="icon-edit bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-error"
																data-rel="tooltip" title="" data-original-title="Delete">
																	<span class="red"> <i
																		class="icon-trash bigger-120"></i>
																</span>
															</a></li>
														</ul>
													</div>
												</div>
											</td>
										</tr>

										<tr>
											<td class="center"><label> <input
													type="checkbox" class="ace"> <span class="lbl"></span>
											</label></td>

											<td><a href="#">pro.com</a></td>
											<td>$55</td>
											<td class="hidden-480">4,250</td>
											<td>Jan 21</td>

											<td class="hidden-480"><span
												class="label label-sm label-success">Registered</span></td>

											<td>
												<div
													class="visible-md visible-lg hidden-sm hidden-xs btn-group">
													<button class="btn btn-xs btn-success">
														<i class="icon-ok bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-info">
														<i class="icon-edit bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-danger">
														<i class="icon-trash bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-warning">
														<i class="icon-flag bigger-120"></i>
													</button>
												</div>

												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="inline position-relative">
														<button class="btn btn-minier btn-primary dropdown-toggle"
															data-toggle="dropdown">
															<i class="icon-cog icon-only bigger-110"></i>
														</button>

														<ul
															class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
															<li><a href="#" class="tooltip-info"
																data-rel="tooltip" title="" data-original-title="View">
																	<span class="blue"> <i
																		class="icon-zoom-in bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-success"
																data-rel="tooltip" title="" data-original-title="Edit">
																	<span class="green"> <i
																		class="icon-edit bigger-120"></i>
																</span>
															</a></li>

															<li><a href="#" class="tooltip-error"
																data-rel="tooltip" title="" data-original-title="Delete">
																	<span class="red"> <i
																		class="icon-trash bigger-120"></i>
																</span>
															</a></li>
														</ul>
													</div>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
						</div>

					</div>

				</div>
				<!-- /.main-content -->

			</div>
			<!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up"
				class="btn-scroll-up btn btn-sm btn-inverse"> <i
				class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div>
		<!-- /.main-container -->
		<!-- 公共js部分 -->
		<jsp:include page="../../basePage/loadJs.jsp"></jsp:include>
		<!-- 私有js部分 -->
		<%-- <script src="<%=request.getContextPath() %>/assets/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath() %>/assets/js/jquery.dataTables.bootstrap.js"></script> --%>
		<script src="department.js"></script>
</body>
</html>
