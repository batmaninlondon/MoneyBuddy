<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">     


<script>

	function convert(str)
  	{
  		var ret = str.replace(/&gt;/g, '>');
  	    ret = ret.replace(/&lt;/g, '<');
  	    ret = ret.replace(/&quot;/g, '"');
  	    ret = ret.replace(/&apos;/g, "'");
  	    ret = ret.replace(/&amp;/g, '&');
  	    return ret;
  	}
  	
  	function openPaymentUrl()  {

		var paymentUrl = convert(document.getElementById("check-id").innerHTML);
		var wnd = window.open("", "_self");
		wnd.document.write(paymentUrl);
		 wnd.document.close(); 
		 
	}
  	
</script>
<title>Insert title here</title>

<script>
    (function(h,o,t,j,a,r){
        h.hj=h.hj||function(){(h.hj.q=h.hj.q||[]).push(arguments)};
        h._hjSettings={hjid:1416665,hjsv:6};
        a=o.getElementsByTagName('head')[0];
        r=o.createElement('script');r.async=1;
        r.src=t+h._hjSettings.hjid+j+h._hjSettings.hjsv;
        a.appendChild(r);
    })(window,document,'https://static.hotjar.com/c/hotjar-','.js?sv=');
</script>


</head>
<body>

		<s:set var="payUrl" value="paymentUrl" />
		<p id="check-id" style="display:none"><s:property value="#payUrl"/></p>
		
		<script type="text/javascript">
		
		
		openPaymentUrl();

		</script>
		
		<script type="text/javascript" src="assets/js/jquery.js"></script>
		<script type="text/javascript" src="assets/js/javaScript.js"></script>
</body>
</html>