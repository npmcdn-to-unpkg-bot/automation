<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<div class="span2 well">
     <h3>Latest Weight: <span id="current_weight">loading</span></h3>
</div>
<h3>Weight Chart Last 18 Months</h3>

<div id="chart"></div>
<h3>BP and Pulse</h3>
<div id="vitals"></div>

<script type="text/javascript" >

var size = 250;


var vitals = c3.generate({
	 size: {
	        height: size
	        
	    },
   bindto: '#vitals',
   data: {
       x: 'monthYear',
       url: 'vitals/summary/',
       mimeType: 'json',
       axes: {
   		avgSystolic: 'y',
        minSystolic: 'y',
        maxSystolic: 'y',
		avgPulse: 'y2',
        minPulse: 'y2',
        maxPulse: 'y2',
         
        avgDiatolic: 'y',
        minDiatolic: 'y',
        maxDiatoli: 'y',
       },
       keys: {
         x: 'monthYear', // it's possible to specify 'x' when category axis
         value: [
				'avgSystolic',
                'minSystolic',
                'maxSystolic',
				'avgPulse',
                'minPulse',
                'maxPulse',
                 
                'avgDiatolic',
                'minDiatolic',
                'maxDiatolic'
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



var weight = c3.generate({
	 size: {
	        height: size
	        
	    },
   bindto: '#chart',
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



function update() {
	  console.log("running update");
	  var url = './weight/latest/';
	  $.ajax({
	    type: 'GET',
	    url: url,
	    dataType: "json",
	    
	  
	  }).done(function ( data ) {
	    console.log("got data");
	    console.log(data);
	    var weight = data[0].value;
	    console.log(weight);
	    $("#current_weight").html(weight +"lbs @ " + data[0].date );
	  });


	}
	
update();
</script>