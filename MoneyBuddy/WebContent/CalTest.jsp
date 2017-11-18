<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>DatePicker</title>
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
	<link type="text/css" rel="stylesheet" href="assets/bootstrap/css/datepicker.css"/>
	<script type="text/javascript"  src="assets/js/jquery.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>
	<style type="text/css">
		#datepicker{
			width: 180px; margin: 0 20px 20px 20px;
		}
		#datepicker > span:hover {
			cursor: pointer;;
		}
	</style>
</head>
<body>
	<h1 align="center">Create DatePicker </h1>
	<div  class="input-group ">
		<input type="text" id="datepicker">
		<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
	</div>

<script type="text/javascript">
	$(function() {
		
		$("#datepicker").datepicker({
			autoclose:true,
			todayhighlight:true
		}).datepicker('update',new Date());
	} )
</script>
</body>
</html>