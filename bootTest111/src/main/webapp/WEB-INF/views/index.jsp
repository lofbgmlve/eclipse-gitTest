<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/insaFormCheck.js"></script>
<link type="text/css" href="resources/css/insa.css" rel="stylesheet" />
</head>

<body>
	<main>
		<%@ include file="templates/header.jsp" %>
		<jsp:include page="${ param.body }" />
		<%@ include file="template/footer.jsp" %> 
	</main>
</body>
</html>