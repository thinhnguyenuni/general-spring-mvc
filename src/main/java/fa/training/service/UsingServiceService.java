package fa.training.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.models.UsingService;

//Định nghĩa một interface UsingServiceService để quản lý các hoạt động liên quan đến việc sử dụng dịch vụ
public interface UsingServiceService {

	// Tạo một bản ghi mới cho việc sử dụng dịch vụ trong cơ sở dữ liệu
	void create(UsingService usingService);

	// Trả về danh sách tất cả các bản ghi về việc sử dụng dịch vụ từ cơ sở dữ liệu
	List<UsingService> findAll();

	// Xóa một bản ghi về việc sử dụng dịch vụ từ cơ sở dữ liệu
	void delete(UsingService usingService);

	// Trả về một trang dữ liệu về việc sử dụng dịch vụ từ cơ sở dữ liệu, phân trang
	// bằng đối tượng Pageable
	Page<UsingService> findAll(Pageable pageable);

	// Tìm kiếm và trả về một trang dữ liệu về việc sử dụng dịch vụ dựa trên từ khóa
	// tìm kiếm và phân trang bằng đối tượng Pageable
	Page<UsingService> findAllWithSearch(String searchInput, Pageable pageable);

}
