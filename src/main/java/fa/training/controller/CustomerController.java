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

import fa.training.models.Customer;
import fa.training.models.PageAble;
import fa.training.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Xử lý khi truy cập đường dẫn /customer/create bằng phương thức GET
	@GetMapping("/create")
	public String getCustomer(Model model) {
		// Tạo một đối tượng Customer mới và đưa vào model để hiển thị trên view
		model.addAttribute("customer", new Customer());
		// Đặt đường dẫn của trang và thêm vào model
		model.addAttribute("urlPage", "/customer/add-customer");
		// Thêm một chuỗi xác định cho mã JavaScript để xử lý sự kiện trên trang
		model.addAttribute("jqPage", "customer");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi submit form tạo mới khách hàng
	@PostMapping("/create")
	public String createCustomer(@ModelAttribute("customer") @Validated Customer customer, BindingResult result,
			Model model) {
		// Kiểm tra xem mã khách hàng đã tồn tại hay chưa, nếu đã tồn tại, reject giá
		// trị và hiển thị thông báo lỗi
		if (customerService.existByID(customer.getId())) {
			result.rejectValue("id", "idInvalid", "Mã khách hàng đã tồn tại!");
		}
		// Nếu có lỗi xảy ra trong quá trình validate form, hiển thị lại form tạo mới
		// với thông báo lỗi
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/customer/add-customer");
			model.addAttribute("jqPage", "customer");
			return "/base/view";
		}
		// Lưu thông tin khách hàng vào cơ sở dữ liệu và chuyển hướng về trang danh sách
		// khách hàng
		customerService.create(customer);
		return "redirect:/customer/list";
	}

	// Hiển thị danh sách tất cả khách hàng
	@GetMapping("/list")
	public String showAllCustomer(Model model,
			@RequestParam(name = "pageNumber", required = true, defaultValue = "1") int pageNumber,
			@RequestParam(name = "pageSize", required = true, defaultValue = "3") int pageSize,
			@RequestParam(name = "search", required = false, defaultValue = "") String search) {
		// Tạo đối tượng Pageable để phân trang và sắp xếp dữ liệu
		org.springframework.data.domain.Pageable pageable = PageRequest.of(pageNumber - 1, pageSize,
				org.springframework.data.domain.Sort.by(Direction.ASC, "id"));
		// Lấy danh sách khách hàng với điều kiện tìm kiếm và phân trang
		Page<Customer> customers = customerService.findAllWithSearch(search.trim(), pageable);
		// Đưa danh sách khách hàng, thông tin phân trang và tìm kiếm vào model để hiển
		// thị trên view
		model.addAttribute("customers", customers.getContent());
		model.addAttribute("pageSizes", PageAble.pageSizes);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRows", customers.getTotalElements());
		model.addAttribute("totalPages", customers.getTotalPages());
		model.addAttribute("search", search);
		model.addAttribute("urlPage", "/customer/list-customer");
		model.addAttribute("jqPage", "list");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi truy cập đường dẫn /customer/update bằng phương thức GET
	@GetMapping("/update")
	// Annotation này lấy tham số tên là "id" từ yêu cầu và gán giá trị của nó cho biến customerId.
	public String getUpdateComputer(@RequestParam(name = "id") String customerId, Model model) {
		// Tìm kiếm thông tin khách hàng cần cập nhật và đưa vào model để hiển thị trên
		// form
		model.addAttribute("customer", customerService.findByID(customerId));
		model.addAttribute("urlPage", "/customer/update-customer");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}

	// Xử lý khi submit form cập nhật thông tin khách hàng
	@PostMapping("/update")
	public String updateComputer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result,
			Model model) {
		// Nếu có lỗi xảy ra trong quá trình validate form, hiển thị lại form cập nhật
		// với thông báo lỗi
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/customer/update-customer");
			model.addAttribute("jqPage", "customer");
			return "/base/view";
		}
		// Lưu thông tin khách hàng đã cập nhật vào cơ sở dữ liệu và chuyển hướng về
		// trang danh sách khách hàng
		customerService.create(customer);
		return "redirect:/customer/list";
	}

	// Xóa khách hàng dựa trên id
	@GetMapping("/delete/{id}")
	// Sử dụng @PathVariable để lấy tham số 'id' từ URL và gán nó cho biến 'customerId'
	public String deleteComputer(@PathVariable(name = "id") String customerId, Model model) {
		// Xóa khách hàng từ cơ sở dữ liệu và chuyển hướng về trang danh sách khách hàng
		customerService.deleteById(customerId);
		return "redirect:/customer/list";
	}
}
