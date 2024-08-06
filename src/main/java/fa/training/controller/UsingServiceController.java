package fa.training.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.training.models.UsingService;
import fa.training.service.CustomerService;
import fa.training.service.ServiceService;
import fa.training.service.UsingServiceService;

@Controller
@RequestMapping(value = "/usingservice")
public class UsingServiceController {


	@Autowired
	private UsingServiceService usingServiceService;

	@Autowired
	private ServiceService serviceService;

	@Autowired
	private CustomerService customerService;
	
	// Xử lý khi truy cập đường dẫn /usingservice/register bằng phương thức GET
	@GetMapping("/register")
	public String getUsingService(Model model) {
		// Tạo một đối tượng UsingService mới và đưa vào model để hiển thị trên view
		model.addAttribute("usingservice", new UsingService());
		// Lấy danh sách khách hàng và dịch vụ từ cơ sở dữ liệu thông qua các service và
		// đưa vào model để hiển thị trên form
		model.addAttribute("customers", customerService.findAll());
		model.addAttribute("services", serviceService.findAll());
		// Đặt đường dẫn của trang và thêm vào model
		model.addAttribute("urlPage", "/usingservice/add-usingservice");
		// Thêm một chuỗi xác định cho mã JavaScript để xử lý sự kiện trên trang
		model.addAttribute("jqPage", "usingservice");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi submit form đăng ký sử dụng dịch vụ
	@PostMapping("/register")
	public String createService(@ModelAttribute("usingservice") @Valid UsingService usingservice, BindingResult result,
			Model model) {
		// Nếu có lỗi xảy ra trong quá trình validate form, hiển thị lại form đăng ký
		// với thông báo lỗi
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/usingservice/add-usingservice");
			model.addAttribute("jqPage", "usingservice");
			return "/base/view";
		}
		// Lưu thông tin đăng ký sử dụng dịch vụ vào cơ sở dữ liệu và chuyển hướng về
		// trang danh sách thông tin tổng hợp
		usingServiceService.create(usingservice);
		return "redirect:/suminfo/list";
	}
}
