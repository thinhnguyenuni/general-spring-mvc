package fa.training.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorController {
	
	// Xử lý các exception chung
	@ExceptionHandler(Exception.class)
	public String showError(Exception e, Model model) {
		// In ra thông điệp lỗi ra console
		System.out.println(e.getMessage());
		// Đưa thông điệp lỗi vào model để hiển thị trên view
		model.addAttribute("errorMessage", e.getMessage() == null ? "Null" : e.getMessage());
		// Đặt đường dẫn của trang lỗi và thêm vào model
		model.addAttribute("urlPage", "/error/error");
		// Chuyển hướng đến trang cơ sở để hiển thị
		return "/base/view";
	}
	
	// Xử lý khi không tìm thấy handler (controller)
	@ExceptionHandler(NoHandlerFoundException.class)
	private String processNotFoundException(Exception e) {
		// In ra thông điệp lỗi ra console
		System.out.println("GlobalExceptionHandling");
		// Chuyển hướng đến trang lỗi 404
		return "/error/404";
	}
}
