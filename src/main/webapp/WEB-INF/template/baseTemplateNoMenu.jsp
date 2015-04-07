<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/include.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
	<head>
		<tiles:insertAttribute name="head" />
	</head>
	<body>
		<tiles:insertAttribute name="nav" />
		<div class="container-fluid" id="container">
			<div class="row" id="body">
				<div class="col-md-12">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
			<div id="footer" >
					<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</body>
</html>