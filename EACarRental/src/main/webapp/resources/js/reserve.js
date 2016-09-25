$(document).ready(
	function(){       				
        function search(){
            $.ajax("search",{
                    "type":"GET",
                "dataType":"json",
                    "data":{
                    	"fromLocation":$("#from-input").val(),
                    	"toLocation":$("#to-input").val(),
                    	"fromDate":$("#from-date").val(),
                    	"toDate":$("#to-date").val()       		                    	
                    }
            }).done(function(data){
                        $("#searchResults").empty();
                        console.log("data is: " + data)
                        if(data.length==0)
                        	$("#searchResults").append("<p>Sorry we can not find a car for you now</p>")
                        else
		                    for(var i=0;i<data.length;i++){
		                    	var car = $("#searchResults").append("<div></div>");
		                    	car.append(	"<div>"+
		                    				"<input type='radio' name='carId' value='"+data[i].id+"'>"+
		                    				"<span>name: " + data[i].name + "</span>" +
		                    				"<span>price: " + data[i].price + "</span>" +
		                    				"<span>seats: " + data[i].seats + "</span></div>");
		                    	car.append("<div><img src='resources/images/" + data[i].imageLink+"' width='100px'></img></div>")
	                        } 
                    }
            )
        }
        function reserve(){
            $.ajax("reserveRequest",{
                    "type":"GET",
                    "data":{
                    	"fromLocation":$("#from-input").val(),
                    	"toLocation":$("#to-input").val(),
                    	"fromDate":$("#from-date").val(),
                    	"toDate":$("#to-date").val(),
                    	"carId":$("input[name='carId']:checked").val()
                    }
            }).done(function(data){
                        console.log(data)
                        $("#searchResults").empty();
                    }
            )
        }
        
        $("#reserve").click(reserve);
        $("#search").click(search);
	    $("#from-input,#to-input").keypress(function (e) {
	        if (e.which == 13) {
	        	var firstResult
	        	if(e.target.id=="from-input")
	        		firstResult = $(".from-container .from-item:first").text();
	        	else
	        		firstResult = $(".to-container .to-item:first").text();

	            var geocoder = new google.maps.Geocoder();
	            geocoder.geocode({"address":firstResult }, function(results, status) {
	                if (status == google.maps.GeocoderStatus.OK) {
	                	if(e.target.id=="from-input")
	                    	from = results[0].address_components[0].long_name;
	                	else
	                		to = results[0].address_components[0].long_name;
	                	setTimeout(drawRoute,100)
						
	                }
	            });
	        } else {
	            $(".pac-container").css("visibility","visible");
	        }
	    }) 
	}       		
)
