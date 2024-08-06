jQuery(function() {
	$("button[type='reset']").on("click", function() {
		$("span[id*='errors']").text("");
		$("div[class*='error']").text("");
		$(this).closest("form").find("input").removeAttr("value");
	});
	const id = $("#inputID");
	const name = $("#inputName");
	const unit = $("#inputUnit");
	const price = $("#inputPrice");
	const errorID = $("#errorID");
	const errorName = $("#errorName");
	const errorUnit = $("#errorUnit");
	const errorPrice = $("#errorPrice");
	const idRegEx = /^DV\d{3}$/;
	const priceRegEx = /^[1-9]\d*$/;
	$("#inputForm").on("submit", function(e) {
		e.preventDefault();
		if (
			!validateID(id) |
			!validateName(name) |
			!validateUnit(unit) |
			!validatePrice(price)
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
			errorID.text("Nhập không đúng định dạng (DVxxx)");
			return false;
		}
		errorID.text("");
		return true;
	}

	function validateName(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorName.text("Trường không được để trống");
			return false;
		}
		errorName.text("");
		return true;
	}
	function validateUnit(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorUnit.text("Trường không được để trống");
			return false;
		}
		errorUnit.text("");
		return true;
	}
	function validatePrice(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorPrice.text("Trường không được để trống");
			return false;
		}
		if (!priceRegEx.test(value)) {
			errorPrice.text("Số phải lớn hơn 0");
			return false;
		}
		errorPrice.text("");
		return true;
	}
});