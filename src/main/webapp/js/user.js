/**
 * User module
 */
define(['jquery', 'jquery.bootstrap', 'util'], function($, bootstrap, util) {
	
	
	return {
		/**
		 * Init function
		 */
		init: function() {
			// Handle user sign in popup
			$('#user-signin').click(function() {
				util.loadAjaxPage($(this).data('href'));
			});

			// Handle user sign up popup
			$('#user-signup').click(function() {
				util.loadAjaxPage($(this).data('href'));
			});
		},
		
	};
});