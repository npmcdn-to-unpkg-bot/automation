function intializePage(){
	$( 'table.table-datatable' ).each(function( i, el ){
		$( el ).dataTable();
	});
	
	$( '.dateinput' ).each( function( index, element ){
		$( element ).datepicker( {
			dateFormat : 'yy-mm-dd'
		} );
		if ( $( element ).hasClass( 'default-now' ) && $( element ).val().trim() == '' ) {
			var d = new Date();
			var curr_date = d.getDate();
			var curr_month = d.getMonth() + 1; // months are zero based
			var curr_year = d.getFullYear();
			$( element ).val( curr_year + "-" +( curr_month < 10 ? "0" : "" ) + curr_month + "-" + ( curr_date < 10 ? "0" : "" ) + curr_date );
		}
	} );
}