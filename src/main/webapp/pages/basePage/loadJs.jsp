<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ace settings handler -->

<script src="<%=request.getContextPath() %>/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
<script src="../assets/js/html5shiv.js"></script>
<script src="../assets/js/respond.min.js"></script>
<![endif]-->

<!-- basic scripts -->

<!--[if !IE]> -->

<script type="text/javascript">
	window.jQuery || document.write("<script src='<%=request.getContextPath() %>/assets/js/jquery-2.0.3.min.js'>" + "<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=request.getContextPath() %>/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
	if ("ontouchend" in document)
		document.write("<script src='<%=request.getContextPath() %>/assets/js/jquery.mobile.custom.min.js'>" + "<"+"/script>");
</script>
<script src="<%=request.getContextPath() %>/assets/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
  <script src="<%=request.getContextPath() %>/assets/js/excanvas.min.js"></script>
<![endif]-->

<script src="<%=request.getContextPath() %>/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/jquery.slimscroll.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/jquery.sparkline.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/flot/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->

<script src="<%=request.getContextPath() %>/assets/js/ace-elements.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script src="<%=request.getContextPath() %>/pages/index.js"></script>
<script src="<%=request.getContextPath() %>/portalJS/tp-common.js"></script>
<script src="<%=request.getContextPath() %>/portalJS/NavbarPanel.js"></script>