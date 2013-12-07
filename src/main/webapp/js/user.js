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
			
			// Handle when user click register
			$(document).on('click', "#register", function() {
				var url = $('#register-form').attr('action');
				var data = {
						username: $('#register-form #username').val(),
						password: $('#register-form #password').val(),
						email: $('#register-form #email').val(),
				};
				

				$.post(url, data, function(res) {
					console.log(res);
				});
			});

			// Handle user sign up popup
			$('#user-signup').click(function() {
				util.loadAjaxPage($(this).data('href'));
			});
		},
		
	};
});