/**
 * User module
 */
define(['jquery', 'util', 'jquery.bootstrap', 'bootbox'], function($, util) {
	
	return {
		/**
		 * Init function
		 */
		init: function() {
			this.handleRegister();
			this.handleSignin();
		},
		
		/**
		 * Handle Register
		 */
		handleRegister: function() {
			
			// Handle user sign up popup
			$('#user-signup').click(function() {
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
				
				// Send request to server
				$.post(url, data, function(res) {
					util.closeModal();
					// Success
					if (res.status === 1) {
						bootbox.alert("Registration is successful, please login");
					} else { // Error
						bootbox.alert("Registration failed. Please try again");
					}
				});
			});

		},
		
		/**
		 * Handle Signin
		 */
		handleSignin: function() {
			// Handle user sign in popup
			$('#user-signin').click(function() {
				util.loadAjaxPage($(this).data('href'));
			});
			
		}
		
	};
});