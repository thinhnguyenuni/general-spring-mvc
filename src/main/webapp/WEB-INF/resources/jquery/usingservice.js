jQuery(function() {
	$("button[type='reset']").on("click", function() {
		$("span[id*='errors']").text("");
		$("div[class*='error']").text("");
		$(this).closest("form").find("input").removeAttr("value");
	});
	$('.select2').select2();
	const date = $("#inputDate");
	const hour = $("#inputHour");
	const quantity = $("#inputQuantity");

	const errorDate = $("#errorDate");
	const errorHour = $("#errorHour");
	const errorQuantity = $("#errorQuantity");
	const quantityRegEx = /^[1-9]\d*$/;;
	$("#inputForm").on("submit", function(e) {
		e.preventDefault();
		if (

			!validateDate(date) |
			!validateHour(hour) |
			!validateQuantity(quantity)
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
	function validateQuantity(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorQuantity.text("Trường không được để trống");
			return false;
		}
		if (!quantityRegEx.test(value)) {
			errorQuantity.text("Số phải lớn hơn 0");
			return false;
		}
		errorQuantity.text("");
		return true;
	}
});