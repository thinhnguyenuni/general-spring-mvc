package fa.training.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.models.Service;

//Định nghĩa một interface ServiceService để quản lý các hoạt động liên quan đến dịch vụ
public interface ServiceService {

	// Tạo một bản ghi mới cho dịch vụ trong cơ sở dữ liệu
	void create(Service service);

	// Trả về danh sách tất cả các dịch vụ từ cơ sở dữ liệu
	List<Service> findAll();

	// Xóa một bản ghi dịch vụ từ cơ sở dữ liệu dựa trên ID đã cho
	void deleteById(String id);

	// Tìm một dịch vụ trong cơ sở dữ liệu dựa trên ID đã cho
	Service findByID(String id);

	// Trả về một trang dữ liệu dịch vụ từ cơ sở dữ liệu, phân trang bằng đối tượng
	// Pageable
	Page<Service> findAll(Pageable pageable);

	// Tìm kiếm và trả về một trang dữ liệu dịch vụ dựa trên từ khóa tìm kiếm và
	// phân trang bằng đối tượng Pageable
	Page<Service> findAllWithSearch(String searchInput, Pageable pageable);

	// Kiểm tra xem một dịch vụ có tồn tại trong cơ sở dữ liệu dựa trên ID đã cho
	// hay không
	boolean existByID(String id);
}
