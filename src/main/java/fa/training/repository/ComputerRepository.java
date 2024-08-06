package fa.training.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.training.models.Computer;

//Định nghĩa một interface ComputerRepository kế thừa từ JpaRepository với đối tượng là Computer và kiểu dữ liệu của khóa chính là String
public interface ComputerRepository extends JpaRepository<Computer, String> {

	// Phương thức tìm kiếm tất cả các máy tính với điều kiện tìm kiếm theo từ khóa
	// nhập vào và trả về một trang dữ liệu máy tính phân trang
	@Query(value = "select c From Computer c where c.id LIKE %?1% OR c.location LIKE %?1% OR c.status LIKE %?1%")
	Page<Computer> findAllWithSearch(String searchInput, Pageable pageable);

	// Phương thức tìm kiếm tất cả các máy tính có trạng thái "available" hoặc "đang
	// sử dụng" và trả về danh sách các máy tính
	@Query(value = "select c From Computer c where c.status LIKE ?1")
	List<Computer> findAllAvaiable(String status);

}
