jQuery(function() {
	$("button[type='reset']").on("click", function() {
		$("span[id*='errors']").text("");
		$("div[class*='error']").text("");
		$(this).closest("form").find("input").removeAttr("value");
	});
	const id = $("#inputID");
	const location = $("#inputLocation");
	const status = $("#inputStatus");
	const errorID = $("#errorID");
	const errorLocation = $("#errorLocation");
	const errorStatus = $("#errorStatus");
	const idRegEx = /^MM\d{3}$/;
	$("#inputForm").on("submit", function(e) {
		e.preventDefault();
		if (
			!validateID(id) |
			!validateLocation(location) |
			!validateStatus(status)
		) {
			return;
		}
		this.submit();
	});
	function validateID(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorID.text("Trường không được để trống");
			return false;
		}
		if (!idRegEx.test(value)) {
			errorID.text("Nhập không đúng định dạng (MMxxx)");
			return false;
		}
		errorID.text("");
		return true;
	}

	function validateLocation(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorLocation.text("Trường không được để trống");
			return false;
		}
		errorLocation.text("");
		return true;
	}
	function validateStatus(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorStatus.text("Trường không được để trống");
			return false;
		}
		errorStatus.text("");
		return true;
	}
});