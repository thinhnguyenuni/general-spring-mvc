jQuery(function() {
	$("button[type='reset']").on("click", function() {
		$("span[id*='errors']").text("");
		$("div[class*='error']").text("");
		$(this).closest("form").find("input").removeAttr("value");
	});
	const id = $("#inputID");
	const name = $("#inputName");
	const address = $("#inputAddress");
	const phone = $("#inputPhone");
	const email = $("#inputEmail");
	const errorID = $("#errorID");
	const errorName = $("#errorName");
	const errorAddress = $("#errorAddress");
	const errorPhone = $("#errorPhone");
	const errorEmail = $("#errorEmail");
	const idRegEx = /^KH\d{5}$/;
	const phoneRegEx = /^(090|091|\(84\)\+90|\(84\)\+91)\d{7}$/;
	const emailRegEx = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	$("#inputForm").on("submit", function(e) {
		e.preventDefault();
		if (
			!validateID(id) |
			!validateName(name) |
			!validateAddress(address) |
			!validatePhone(phone) |
			!validateEmail(email)
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
			errorID.text("Nhập không đúng định dạng (KHxxxxx)");
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
	
	function validateAddress(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorAddress.text("Trường không được để trống");
			return false;
		}
		errorAddress.text("");
		return true;
	}
	
	function validatePhone(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorPhone.text("Trường không được để trống");
			return false;
		}
		if (!phoneRegEx.test(value)) {
			errorPhone.text("Nhập không đúng định dạng");
			return false;
		}
		errorPhone.text("");
		return true;
	}
	
	function validateEmail(selector) {
		const value = selector.val().trim();
		if (value == "") {
			errorEmail.text("Trường không được để trống");
			return false;
		}
		if (!emailRegEx.test(value)) {
			errorEmail.text("Nhập không đúng định dạng");
			return false;
		}
		errorEmail.text("");
		return true;
	}
});