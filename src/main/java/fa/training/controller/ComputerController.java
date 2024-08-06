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

import fa.training.models.Computer;
import fa.training.models.PageAble;
import fa.training.service.ComputerService;

@Controller
@RequestMapping(value = "/computer")
public class ComputerController {

	@Autowired
	private ComputerService computerService;

	// Xử lý khi truy cập đường dẫn /computer/create bằng phương thức GET
	@GetMapping("/create")
	// Model model là một đối tượng được Spring MVC cung cấp, cho phép bạn thêm dữ
	// liệu vào model để truyền cho view.
	public String getComputer(Model model) {
		// Tạo một đối tượng Computer mới và đưa vào model để hiển thị trên view
		model.addAttribute("computer", new Computer());
		// Đặt đường dẫn của trang và thêm vào model
		model.addAttribute("urlPage", "/computer/add-computer-new");
		// Thêm một chuỗi xác định cho mã JavaScript để xử lý sự kiện trên trang
		model.addAttribute("jqPage", "computer");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi submit form tạo mới máy tính
	@PostMapping("/create")
//	Chú thích @ModelAttribute được sử dụng để ràng buộc tham số phương thức với một thuộc tính mô hình (model attribute).
//	"computer" là tên của thuộc tính mô hình mà chúng ta đang ràng buộc.
//	Trong trường hợp này, nó ràng buộc đối tượng Computer từ dữ liệu yêu cầu HTTP
	public String createComputer(@ModelAttribute("computer") @Validated Computer computer, BindingResult result,
			Model model) {
		// Kiểm tra xem mã máy tính đã tồn tại hay chưa, nếu đã tồn tại, reject giá trị
		// và hiển thị thông báo lỗi
		if (computerService.existByID(computer.getId())) {
			result.rejectValue("id", "idInvalid", "Mã máy tính đã tồn tại!");
		}

		// Nếu có lỗi xảy ra trong quá trình validate form, hiển thị lại form tạo mới
		// với thông báo lỗi
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/computer/add-computer-new");
			model.addAttribute("jqPage", "computer");
			return "/base/view";
		}
		// Lưu thông tin máy tính vào cơ sở dữ liệu và chuyển hướng về trang danh sách
		// máy tính
		computerService.create(computer);
		return "redirect:/computer/list";
	}

	// Hiển thị danh sách tất cả máy tính
	@GetMapping("/list")
	public String showAllComputer(Model model,
			@RequestParam(name = "pageNumber", required = true, defaultValue = "1") int pageNumber,
			@RequestParam(name = "pageSize", required = true, defaultValue = "3") int pageSize,
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		// Tạo đối tượng Pageable để phân trang và sắp xếp dữ liệu
		org.springframework.data.domain.Pageable pageable = PageRequest.of(pageNumber - 1, pageSize,
				org.springframework.data.domain.Sort.by(Direction.ASC, "id"));
		// Lấy danh sách máy tính với điều kiện tìm kiếm và phân trang
		Page<Computer> computers = computerService.findAllWithSearch(search.trim(), pageable);
		// Đưa danh sách máy tính, thông tin phân trang và tìm kiếm vào model để hiển
		// thị trên view
		model.addAttribute("computers", computers.getContent());
		model.addAttribute("pageSizes", PageAble.pageSizes);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRows", computers.getTotalElements());
		model.addAttribute("totalPages", computers.getTotalPages());
		model.addAttribute("search", search);
		model.addAttribute("urlPage", "/computer/list-computer");
		model.addAttribute("jqPage", "list");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi truy cập đường dẫn /computer/update bằng phương thức GET
	@GetMapping("/update")
	public String getUpdateComputer(@RequestParam(name = "id") String computerId, Model model) {
		// Tìm kiếm thông tin máy tính cần cập nhật và đưa vào model để hiển thị trên
		// form
		model.addAttribute("computer", computerService.findByID(computerId));
		model.addAttribute("urlPage", "/computer/update-computer");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi submit form cập nhật thông tin máy tính
	@PostMapping("/update")
	public String updateComputer(@ModelAttribute("computer") @Valid Computer computer, BindingResult result,
			Model model) {
		// Nếu có lỗi xảy ra trong quá trình validate form, hiển thị lại form cập nhật
		// với thông báo lỗi
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/computer/update-computer");
			model.addAttribute("jqPage", "computer");
			return "/base/view";
		}

		// Lưu thông tin máy tính đã cập nhật vào cơ sở dữ liệu và chuyển hướng về trang
		// danh sách máy tính
		computerService.create(computer);
		return "redirect:/computer/list";
	}

	// Xóa máy tính dựa trên id
	@GetMapping("/delete/{id}")
	public String deleteComputer(@PathVariable(name = "id") String computerId, Model model) {
		// @PathVariable: Lấy giá trị của biến {id} từ URL và gán cho biến computerId
		// name = "id" chỉ ra rằng giá trị từ đường dẫn (URL) sẽ được gán vào biến
		// computerId
		// Model: Đối tượng dùng để thêm các thuộc tính cần truyền tới view nếu cần
		// (không sử dụng trong trường hợp này)

		// Gọi phương thức deleteById của computerService để xóa máy tính từ cơ sở dữ
		// liệu dựa trên ID
		computerService.deleteById(computerId);

		// Chuyển hướng về trang danh sách máy tính sau khi xóa
		return "redirect:/computer/list";
	}
}
