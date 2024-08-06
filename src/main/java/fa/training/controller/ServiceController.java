package fa.training.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.models.PageAble;
import fa.training.models.Service;
import fa.training.service.ServiceService;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {

	@Autowired
	private ServiceService serviceService;

	// Xử lý khi truy cập đường dẫn /service/create bằng phương thức GET
	@GetMapping("/create")
	public String getService(Model model) {
		// Tạo một đối tượng Service mới và đưa vào model để hiển thị trên view
		model.addAttribute("service", new Service());
		// Đặt đường dẫn của trang và thêm vào model
		model.addAttribute("urlPage", "/service/add-service");
		// Thêm một chuỗi xác định cho mã JavaScript để xử lý sự kiện trên trang
		model.addAttribute("jqPage", "service");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi submit form tạo mới dịch vụ
	@PostMapping("/create")
	public String createService(@ModelAttribute("service") @Validated Service service, BindingResult result,
			Model model) {
		// Kiểm tra xem mã dịch vụ đã tồn tại hay chưa, nếu đã tồn tại, reject giá trị
		// và hiển thị thông báo lỗi
		if (serviceService.existByID(service.getId())) {
			result.rejectValue("id", "idInvalid", "Mã dịch vụ đã tồn tại!");
		}

		// Nếu có lỗi xảy ra trong quá trình validate form, hiển thị lại form tạo mới
		// với thông báo lỗi
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/service/add-service");
			model.addAttribute("jqPage", "service");
			return "/base/view";
		}
		// Lưu thông tin dịch vụ vào cơ sở dữ liệu và chuyển hướng về trang danh sách
		// dịch vụ
		serviceService.create(service);
		return "redirect:/service/list";
	}

	// Hiển thị danh sách tất cả dịch vụ
	@GetMapping("/list")
	public String showAllService(Model model,
			@RequestParam(name = "pageNumber", required = true, defaultValue = "1") int pageNumber,
			@RequestParam(name = "pageSize", required = true, defaultValue = "3") int pageSize,
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		// Tạo đối tượng Pageable để phân trang và sắp xếp dữ liệu
		org.springframework.data.domain.Pageable pageable = PageRequest.of(pageNumber - 1, pageSize,
				org.springframework.data.domain.Sort.by(Direction.ASC, "id"));
		// Lấy danh sách dịch vụ với điều kiện tìm kiếm và phân trang
		Page<Service> services = serviceService.findAllWithSearch(search.trim(), pageable);
		// Đưa danh sách dịch vụ, thông tin phân trang và tìm kiếm vào model để hiển thị
		// trên view
		model.addAttribute("services", services.getContent());
		model.addAttribute("pageSizes", PageAble.pageSizes);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRows", services.getTotalElements());
		model.addAttribute("totalPages", services.getTotalPages());
		model.addAttribute("search", search);
		model.addAttribute("urlPage", "/service/list-service");
		model.addAttribute("jqPage", "list");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi truy cập đường dẫn /service/update bằng phương thức GET
	@GetMapping("/update")
	public String getUpdateService(@RequestParam(name = "id") String serviceId, Model model) {
		// Tìm kiếm thông tin dịch vụ cần cập nhật và đưa vào model để hiển thị trên
		// form
		model.addAttribute("service", serviceService.findByID(serviceId));
		model.addAttribute("urlPage", "/service/update-service");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi submit form cập nhật thông tin dịch vụ
	@PostMapping("/update")
	public String updateService(@ModelAttribute("service") @Valid Service service, BindingResult result, Model model) {
		// Nếu có lỗi xảy ra trong quá trình validate form, hiển thị lại form cập nhật
		// với thông báo lỗi
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/service/update-service");
			model.addAttribute("jqPage", "service");
			return "/base/view";
		}
		// Lưu thông tin dịch vụ đã cập nhật vào cơ sở dữ liệu và chuyển hướng về trang
		// danh sách dịch vụ
		serviceService.create(service);
		return "redirect:/service/list";
	}

	// Xóa dịch vụ dựa trên id
	@GetMapping("/delete/{id}")
	public String deleteService(@PathVariable(name = "id") String serviceId, Model model) {
		// Xóa dịch vụ từ cơ sở dữ liệu và chuyển hướng về trang danh sách dịch vụ
		serviceService.deleteById(serviceId);
		return "redirect:/service/list";
	}
}
