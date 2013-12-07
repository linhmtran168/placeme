// Main entry point
requirejs.config({
	baseUrl: "./js",
	paths: {
		"jquery": "//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min",
		"jquery.bootstrap": "../lib/bootstrap/js/bootstrap.min",
		"jquery.bootstrap.modalmanager": "../lib/bootstrap-modal/js/bootstrap-modalmanager",
		"jquery.bootstrap.modal": "../lib/bootstrap-modal/js/bootstrap-modal",
		"leaflet": "//cdn.leafletjs.com/leaflet-0.7/leaflet"
	},
	"shim": {
        "jquery.bootstrap": ["jquery"],
        "jquery.bootstrap.modalmanager": ["jquery"],
        "jquery.bootstrap.modal": ["jquery"]
    }
});

require(['jquery', 'jquery.bootstrap', 'map', 'user', 'util'], function($, bootsrap, map, user, util) {
	// Fix modal error
	util.fixModalBs3();
	// Init map
	map.init();
	// Init user module
	user.init();
});