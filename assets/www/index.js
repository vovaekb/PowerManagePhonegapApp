	function turn_on(){
		//TODO enable screen sleep
		//alert("Turn in");
		cordova.exec( function(data){ 
			document.getElementById("status").innerHTML = data;
			}, 
			function( e ){
				document.getElementById("status").innerHTML = "Error: " + e;
			}, 'WakeLock', 'turn_on', []);
	}
	
	function turn_off(){
		//alert("Turn off");
		
		cordova.exec( function(data){ 
			document.getElementById("status").innerHTML = data;
			}, 
			function( e ){
				document.getElementById("status").innerHTML = "Error: " + e;
			}, 'WakeLock', 'turn_off', []);
	}
	