/**
 * 
 */
$(document).ready(function() {

	$('.table .eBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		$.get(href, function(app, status) {
			$('.myForm #iddestination').val(destination.iddestination);
			//$(".myForm #iddestination").prop("readonly", true);
			$('.myForm #name').val(destination.description);
			$('.myForm #description').val(destination.description);
		});
		$('.myForm #exampleModal').modal();

	});

	$('.nBtn').on('click', function(event) {
		event.preventDefault();
		$('.mySecondForm #name').val('');
		$('.myForm #description').val('');
		$('.mySecondForm #exampleModal').modal();

	});
	$('.table .delBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href', href);
		$('#myModal').modal();
	});
});