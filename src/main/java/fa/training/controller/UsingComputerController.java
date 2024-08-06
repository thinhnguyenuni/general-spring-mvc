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

import fa.training.models.UsingComputer;
import fa.training.service.ComputerService;
import fa.training.service.CustomerService;
import fa.training.service.UsingComputerService;

@Controller
@RequestMapping(value = "/usingcomputer")
public class UsingComputerController {

	@Autowired
	private UsingComputerService usingComputerService;

	@Autowired
	private ComputerService computerService;

	@Autowired
	private CustomerService customerService;

	// Xử lý khi truy cập đường dẫn /usingcomputer/register bằng phương thức GET
	@GetMapping("/register")
	public String getUsingComputer(Model model) {
		// Tạo một đối tượng UsingComputer mới và đưa vào model để hiển thị trên view
		model.addAttribute("usingcomputer", new UsingComputer());
		// Lấy danh sách khách hàng và máy tính có sẵn từ cơ sở dữ liệu và đưa vào model
		// để hiển thị trên form
		model.addAttribute("customers", customerService.findAll());
		model.addAttribute("computers", computerService.findAll());
		// Đặt đường dẫn của trang và thêm vào model
		model.addAttribute("urlPage", "/usingcomputer/add-usingcomputer");
		// Thêm một chuỗi xác định cho mã JavaScript để xử lý sự kiện trên trang
		model.addAttribute("jqPage", "usingcomputer");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi submit form đăng ký sử dụng máy tính
	@PostMapping("/register")
	public String createUsingComputer(@ModelAttribute("usingcomputer") @Valid UsingComputer usingcomputer,
			BindingResult result, Model model) {
		// Nếu có lỗi xảy ra trong quá trình validate form, hiển thị lại form đăng ký
		// với thông báo lỗi
		if (result.hasErrors()) {
			// Lấy lại danh sách khách hàng và máy tính có sẵn từ cơ sở dữ liệu và đưa vào
			// model để hiển thị trên form
			model.addAttribute("customers", customerService.findAll());
			model.addAttribute("computers", computerService.findAllAvaiable());
			model.addAttribute("urlPage", "/usingcomputer/add-usingcomputer");
			model.addAttribute("jqPage", "usingcomputer");
			return "/base/view";
		}
		// Lưu thông tin đăng ký sử dụng máy tính vào cơ sở dữ liệu và chuyển hướng về
		// trang danh sách thông tin tổng hợp
		usingComputerService.create(usingcomputer);
		return "redirect:/suminfo/list";
	}
}

//	@GetMapping("/list")
//	public String showAllUsingComputer(Model model, 
//			@RequestParam(name = "pageNumber", required = true, defaultValue = "1") int pageNumber,
//			@RequestParam(name = "pageSize", required = true, defaultValue = "3") int pageSize, 
//			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
//		org.springframework.data.domain.Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, org.springframework.data.domain.Sort.by(Direction.ASC, "id"));
//		Page<UsingComputer> usingComputers = usingComputerService.findAllWithSearch(search.trim(), pageable);
//		model.addAttribute("usingComputers", usingComputers.getContent());
//		model.addAttribute("pageSizes", PageAble.pageSizes);
//		model.addAttribute("pageSize", pageSize);
//		model.addAttribute("pageNumber", pageNumber);
//		model.addAttribute("totalRows", usingComputers.getTotalElements());
//		model.addAttribute("totalPages", usingComputers.getTotalPages());
//		model.addAttribute("search", search);
//		model.addAttribute("urlPage", "/usingcomputer/list-computer");
//		model.addAttribute("jqPage", "list");
//	return "/base/view";
//	}
//	@GetMapping("/update")
//	public String getUpdateComputer(@RequestParam(name="id") String computerId,  Model model) {
//		model.addAttribute("computer", computerService.findByID(computerId));
//		model.addAttribute("urlPage", "/computer/update-computer");
//	return "/base/view";
//		}
//	
//	@PostMapping("/update")
//	public String updateComputer(@ModelAttribute("computer") @Valid Computer computer, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			model.addAttribute("urlPage", "/computer/update-computer");
//			model.addAttribute("jqPage", "computer");
//			return "/base/view";
//		}
//		
//		computerService.create(computer);
//		
//		return "redirect:/computer/list";
//	}
//	@GetMapping("/delete/{id}")
//	public String deleteComputer(@PathVariable(name="id") String computerId,  Model model) {
//		computerService.deleteById(computerId);
//	return "redirect:/computer/list";
//		}
