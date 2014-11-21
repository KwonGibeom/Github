$(document).ready(function(){
	$(".innerList").show(); //검색조건이 있는 리스트 div
	$("#searchCondition").show();	
	checkForHash();
	if($("input[name=searchKeyword]").val() != ""){
		innerLayout.sizePane('north', 80); 
		innerLayout.open('north');
		$("#searchBar").show();
	}
	
	//정렬
	$("table.sortable").each(function() {
		
	  var $table = $(this);
		 
	  $("th", $table).each(function(column) {
	    var $header = $(this);
	    if ($header.is(".sorting")) {
	    	$header.hover(function() {
	    		$header.addClass("hover");
	        }, function() {
	        	$header.removeClass("hover");
	      }).click(function() {

	    	  var sortDirection = 1;
	    	  if ($header.is(".sorted-asc")) {
	    		  sortDirection = -1;
	    	  }
						 
	    	  var rows = $table.find("tbody > tr").get();
	    	  rows.sort(function(a, b) {
	    		  var keyA = $(a).children("td").eq(column).text().toUpperCase();
	    		  var keyB = $(b).children("td").eq(column).text().toUpperCase();
	    		  if (keyA < keyB) return -sortDirection;
	    		  if (keyA > keyB) return sortDirection;
	    		  return 0;
	    	  });
	        $.each(rows, function(index, row) {
	        	$table.children("tbody").append(row);
	        });
			
	        $table.find("th").removeClass("sorted-asc").removeClass("sorted-desc");
	        
	        if(sortDirection == 1) $header.addClass("sorted-asc");
	        else $header.addClass("sorted-desc");		   
	      });
	    }
	  });
	});
});

function searchSlide(){
	if($("#searchBar").is(':hidden') == true){
		innerLayout.sizePane('north', 80); 
		innerLayout.open('north');
		$("#searchBar").slideDown();
		$("input[name=searchKeyword]").focus();
	}else{
		$("#searchBar").slideUp();
		innerLayout.sizePane('north', 45);
	}
}

function getSearch(){
	$("form[name=searchForm]").submit();
}

function print1(){
	print();
}