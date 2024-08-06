package fa.training.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.models.Customer;
import fa.training.models.UsingComputer;
import fa.training.models.dto.SumInfoDTO;

//Định nghĩa một interface UsingComputerService để quản lý các hoạt động liên quan đến việc sử dụng máy tính
public interface UsingComputerService {

	// Tạo một bản ghi mới cho việc sử dụng máy tính trong cơ sở dữ liệu
	void create(UsingComputer usingComputer);

	// Xóa một bản ghi về việc sử dụng máy tính từ cơ sở dữ liệu
	void delete(UsingComputer usingComputer);

	// Trả về danh sách tất cả các bản ghi về việc sử dụng máy tính từ cơ sở dữ liệu
	List<UsingComputer> findAll();

	// Trả về danh sách tất cả các khách hàng liên quan đến việc sử dụng máy tính từ
	// cơ sở dữ liệu
	List<Customer> findAllCustomer();

	// Trả về một trang dữ liệu về việc sử dụng máy tính từ cơ sở dữ liệu, phân
	// trang bằng đối tượng Pageable
	Page<UsingComputer> findAll(Pageable pageable);

	// Tìm kiếm và trả về một trang dữ liệu về việc sử dụng máy tính dựa trên từ
	// khóa tìm kiếm và phân trang bằng đối tượng Pageable
	Page<UsingComputer> findAllWithSearch(String searchInput, Pageable pageable);

	// Trả về một trang dữ liệu về thông tin tổng hợp của việc sử dụng máy tính, bao
	// gồm thông tin về khách hàng, máy tính và dịch vụ sử dụng, phân trang bằng đối
	// tượng Pageable
	Page<SumInfoDTO> getAllSumInfo(String search, Pageable pageable);

}
