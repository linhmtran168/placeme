/**
 * Helper functions
 */
define(['jquery', 'jquery.bootstrap', 'jquery.bootstrap.modalmanager', 'jquery.bootstrap.modal'], function($) {
	var _modalId = '#ajax-modal';

	return {
		/**
		 * Function to load a modal through ajax
		 * @param String url the remote url
		 * @param String modalId the dom Id of the modal
		 */
		loadAjaxPage: function(url, modalId) {

			var $modal = modalId ? $(modalId) : $(_modalId);
			
			$('body').modalmanager('loading');

			$modal.load(url, '', function() {
				$modal.modal();
			});
		},
		
		/**
		 * Function to destroy a modal
		 */
		closeModal: function(modalId) {
			var $modal = modalId ? $(modalId) : $(_modalId);
			$modal.modal('destroy');
			$('.modal-scrollable').remove();
		},
		
		/**
		 * Fix bootstrap modal for bootstrap 3
		 */
		fixModalBs3: function() {
			$.fn.modal.defaults.spinner = $.fn.modalmanager.defaults.spinner = 
			    '<div class="loading-spinner" style="width: 200px; margin-left: -100px;">' +
			        '<div class="progress progress-striped active">' +
			            '<div class="progress-bar" style="width: 100%;"></div>' +
			        '</div>' +
			    '</div>';
		}


	};
});