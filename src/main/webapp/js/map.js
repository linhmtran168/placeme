/**
 * Map module
 */
define(['jquery', 'leaflet', 'jquery.bootstrap'], function($, L) {
	
	return {
		/**
		 * Init function
		 */
		init: function() {
			var that = this;
			 // Try to get user current location, if not display a default position
			 if (navigator.geolocation) {
				 navigator.geolocation.getCurrentPosition(function success(position) {
					that.showMap(position);
				 }, function error() {
					that.showMap();
				 });
			 }
		},
		
		/**
		 * Display the map
		 * @param Object position position object return from the browser
		 */
		showMap: function(position) {
			 var latlong = position ? [position.coords.latitude, position.coords.longitude] : [51.505, -0.09];
		     var map = L.map('map').setView(latlong, 13);
		     L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
		    	    attribution: 'Map data © OpenStreetMap contributors',
		    	    maxZoom: 18
		    	}).addTo(map);
		}
	};
});