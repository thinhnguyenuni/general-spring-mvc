jQuery(function() {
	$('.select2').select2();
	$("button[type='reset']").on("click", function() {
		$("span[id*='errors']").text("");
		$("div[class*='error']").text("");
		$(this).closest("form").find("input").removeAttr("value");
	});

	const date = $("#inputDate");
	const hour = $("#inputHour");
	const duration = $("#inputDuration");
	const errorDate = $("#errorDate");
	const errorHour = $("#errorHour");
	const errorDuration = $("#errorDuration");
	const durationRegEx = /^(?!0\d)\d+(\.\d+)?$/;
	$("#inputForm").on("submit", function(e) {
		e.preventDefault();
		if (
			!validateDate(date) |
			!validateHour(hour) |
			!validateDuration(duration)
		) {
			return;
		}
		this.submit();
	});
	function validateDate(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorDate.text("Trường không được để trống");
			return false;
		}
		const inputDate = new Date(selector.val().trim());
		const currentDate = new Date();
		currentDate.setHours(7, 0, 0, 0);
		if (currentDate < inputDate) {
			errorDate.text("Ngày không được lớn hơn ngày hiện tại");
			return false;
		}
		errorDate.text("");
		return true;
	}
	function validateHour(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorHour.text("Trường không được để trống");
			return false;
		}
		errorHour.text("");
		return true;
	}
	function validateDuration(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorDuration.text("Trường không được để trống");
			return false;
		}
		if (!durationRegEx.test(value)) {
			errorDuration.text("Số phải lớn hơn 0");
			return false;
		}
		errorDuration.text("");
		return true;
	}
});