<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<h2>Weight Chart Last 30 Days</h2>
<div id="chart"></div>
<script type="text/javascript" >
var chart = c3.generate({
	 size: {
	        height: 540
	        
	    },
    bindto: '#chart',
    data: {
        x: 'x',
        url: 'weight/c3/last30/',
        mimeType: 'json',
    },
	axis: {
    x: {
        type: 'timeseries',
        tick: {
            format: '%Y-%m-%d'
        }
    }
}
});

</script>