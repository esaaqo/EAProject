<!DOCTYPE html>
    <html> 
    <head> 
       <meta http-equiv="content-type" content="text/html; charset=UTF-8"/> 
       <title>Car Rental</title> 
       <script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyDSIncL9vyNi3EcOfB3nl8pR8OW1gHkzkc&sensor=false&libraries=places"></script>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
       <script src="resources/js/reserve.js"></script>
       <style>			
       		.column{
       			float:left
       		}
       		.column>span{
       			display:block
       			
       		}
       		.column span{
       			margin-right: 4px;
       			margin-top: 4px;
       			
       		}
       		span{
       			margin-left: 10px
       		}
       		.row{
       			clear:left;       			
       		}
       		#map{
       			clear:left;  
       			margin-top:4px     			
       		}
       </style>
       <script>

       </script>
    </head> 
    <body style="font-family: Arial; font-size: 12px;"> 
    	<div class="searchContainer">
       		<div class="row">
       			<div class="column"><span>From</span><span><input id="from-input" class="controls" type="text"  placeholder="Enter a location"></span></div>
       			<div class="column"><span>Date</span><span><input type="date" id="from-date"  placeholder="from date" min= "2005-01-01" max="2017-11-01" ></span></div>
       		</div>
       		<div class="row">
       			<div class="column"><span>To</span><span><input id="to-input" class="controls" type="text"  placeholder="Enter a location"></span></div>
       			<div class="column"><span>Date</span><span><input type="date"  id="to-date" placeholder="to date" min= "2005-01-01" max="2017-11-01" ></span></div>
       		</div>
       		<div class="row">
       			<input type="button" value="Search" id="search">
       			<input type="button" value="Reserve" id="reserve">
       		</div>
       		<div style="width: 600px;">
         		<div id="map" style="width: 280px; height: 400px; float: left;"></div> 
       		</div>
       		<div id="searchResults"></div>
       	</div>
       
       <script type="text/javascript"> 
         var input = (document.getElementById('from-input'));
         var input2 = (document.getElementById('to-input'));
         
         var autocomplete = new google.maps.places.Autocomplete(input);
         var autocomplete = new google.maps.places.Autocomplete(input2);
         
         var directionsService = new google.maps.DirectionsService();
         var directionsDisplay = new google.maps.DirectionsRenderer();
    
         var map = new google.maps.Map(document.getElementById('map'), {
           zoom:7,
           mapTypeId: google.maps.MapTypeId.ROADMAP
         });
   
         directionsDisplay.setMap(map);
         autocomplete.bindTo('bounds', map);
         var from=0;
         var to=0;
         function drawRoute(){
        	 console.log(from + "  " + to)
        	 if(from!=0 && to!=0){
             	var request = {
                     origin: from, 
                     destination: to,
                     travelMode: google.maps.DirectionsTravelMode.DRIVING
                   };              
                   directionsService.route(request, function(response, status) {
                     if (status == google.maps.DirectionsStatus.OK) {
                       directionsDisplay.setDirections(response);
                     }
                   });
        	 }
         }

         $(document).ready(
        		 function(){
  			    
        		 }
    			    
         );
         
       </script> 
    </body> 
    </html>