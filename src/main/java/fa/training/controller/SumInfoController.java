package fa.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.models.PageAble;
import fa.training.models.dto.SumInfoDTO;
import fa.training.service.UsingComputerService;

@Controller
@RequestMapping(value = "/suminfo")
public class SumInfoController {

	@Autowired
	private UsingComputerService usingComputerService;

	// Xử lý khi truy cập đường dẫn /suminfo/list bằng phương thức GET
	@GetMapping("/list")
	public String showAllInfo(Model model,
			@RequestParam(name = "pageNumber", required = true, defaultValue = "1") int pageNumber,
			@RequestParam(name = "pageSize", required = true, defaultValue = "10") int pageSize,
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		// Tạo đối tượng Pageable để phân trang dữ liệu
		org.springframework.data.domain.Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		// Lấy danh sách thông tin tổng hợp từ việc sử dụng máy tính với điều kiện tìm
		// kiếm và phân trang
		Page<SumInfoDTO> sumInfos = usingComputerService.getAllSumInfo(search, pageable);
		// Đưa danh sách thông tin tổng hợp, thông tin phân trang và tìm kiếm vào model
		// để hiển thị trên view
		model.addAttribute("sumInfos", sumInfos.getContent());
		model.addAttribute("pageSizes", PageAble.pageSizes);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRows", sumInfos.getTotalElements());
		model.addAttribute("totalPages", sumInfos.getTotalPages());
		model.addAttribute("search", search);
		model.addAttribute("urlPage", "/suminfo/list-suminfo");
		model.addAttribute("jqPage", "list");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi truy cập đường dẫn /suminfo/pay bằng phương thức GET và truyền tham
	// số id
	@GetMapping("/pay")
	public String paymentMay(@RequestParam("id") String computerID) {
		// Chuyển hướng đến trang home
		return "redirect:/home";
	}
}
