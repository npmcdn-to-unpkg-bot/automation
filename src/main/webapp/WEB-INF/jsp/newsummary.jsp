<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<h3>Weight and Activity</h3>
<div id="summary"></div>

<script type="text/javascript" >

var size = 350;

var vitals = c3.generate({
	 size: {
	        height: size
	        
	    },
   bindto: '#summary',
   data: {
       x: 'monthYear',
       url: 'summarytable/',
       mimeType: 'json',
       
       axes: {
    	   avgActivity: 'y2',
    	   minActivity: 'y2',
    	   maxActivity: 'y2',
    	   avgWeight: 'y',
    	   minWeight: 'y',
    	   maxWeight: 'y'
       },
       keys: {
         x: 'monthYear', // it's possible to specify 'x' when category axis
         value: [
				'maxActivity',
                'avgActivity',
                'minActivity',
                 
                'maxWeight',
                'avgWeight',
                'minWeight'
               ],
     }
 },

	axis: {
		y2: {
	        show: true
	    },
	    x: {
	        type: 'category',
	        tick: {
	            format: '%Y-%m'
	       }
	   	
	    }
	}
});

</script>