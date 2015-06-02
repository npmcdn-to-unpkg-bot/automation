<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<noscript>
	<div class="alert alert-danger">Please enable javascript, it is required for this application to function properly.</div>
</noscript>

<div class="panel panel-default"   ng-controller="SummaryTableCtrl">
	<div class="panel-heading">
		<h1 class="panel-title">Welcome to automation</h1>
	</div>
	  <div  id="grid1"  ui-grid="{ data: data }" class="grid"></div>
	

</div>