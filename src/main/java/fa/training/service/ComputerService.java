package fa.training.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.models.Computer;

//Định nghĩa một interface ComputerService để quản lý các hoạt động liên quan đến máy tính
public interface ComputerService {

	// Tạo một bản ghi mới cho máy tính trong cơ sở dữ liệu
	void create(Computer computer);

	// Xóa một bản ghi máy tính từ cơ sở dữ liệu dựa trên ID đã cho
	void deleteById(String id);

	// Trả về danh sách tất cả các máy tính từ cơ sở dữ liệu
	List<Computer> findAll();

	// Tìm một máy tính trong cơ sở dữ liệu dựa trên ID đã cho
	Computer findByID(String id);

	// Trả về một trang dữ liệu máy tính từ cơ sở dữ liệu, phân trang bằng đối tượng
	// Pageable
	Page<Computer> findAll(Pageable pageable);

	// Tìm kiếm và trả về một trang dữ liệu máy tính dựa trên từ khóa tìm kiếm và
	// phân trang bằng đối tượng Pageable
	Page<Computer> findAllWithSearch(String searchInput, Pageable pageable);

	// Kiểm tra xem một máy tính có tồn tại trong cơ sở dữ liệu dựa trên ID đã cho
	// hay không
	boolean existByID(String id);

	// Trả về danh sách các máy tính có sẵn để sử dụng, thường là các máy tính có
	// trạng thái "available" hoặc "đang sử dụng"
	List<Computer> findAllAvaiable();
	
}
