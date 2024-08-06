package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	// Xử lý khi truy cập vào đường dẫn / hoặc /home bằng phương thức GET
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		// Đặt đường dẫn của trang chính và thêm vào model
		model.addAttribute("urlPage", "/home/home");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}
}
