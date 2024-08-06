package fa.training.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.models.Customer;

//Định nghĩa một interface CustomerService để quản lý các hoạt động liên quan đến khách hàng
public interface CustomerService {

	// Tạo một bản ghi mới cho khách hàng trong cơ sở dữ liệu
	void create(Customer customer);

	// Trả về danh sách tất cả các khách hàng từ cơ sở dữ liệu
	List<Customer> findAll();

	// Tìm một khách hàng trong cơ sở dữ liệu dựa trên ID đã cho
	Customer findByID(String id);

	// Xóa một bản ghi khách hàng từ cơ sở dữ liệu dựa trên ID đã cho
	void deleteById(String id);

	// Trả về một trang dữ liệu khách hàng từ cơ sở dữ liệu, phân trang bằng đối
	// tượng Pageable
	Page<Customer> findAll(Pageable pageable);

	// Tìm kiếm và trả về một trang dữ liệu khách hàng dựa trên từ khóa tìm kiếm và
	// phân trang bằng đối tượng Pageable
	Page<Customer> findAllWithSearch(String searchInput, Pageable pageable);

	// Kiểm tra xem một khách hàng có tồn tại trong cơ sở dữ liệu dựa trên ID đã cho
	// hay không
	boolean existByID(String id);
}
