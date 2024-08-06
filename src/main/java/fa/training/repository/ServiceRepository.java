package fa.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.training.models.Service;

//Định nghĩa một interface ServiceRepository kế thừa từ JpaRepository với đối tượng là Service và kiểu dữ liệu của khóa chính là String
public interface ServiceRepository extends JpaRepository<Service, String> {

	// Phương thức tìm kiếm tất cả các dịch vụ với điều kiện tìm kiếm theo từ khóa
	// nhập vào và trả về một trang dữ liệu dịch vụ phân trang
	@Query(value = "select s From Service s where s.id LIKE %?1% OR s.name LIKE %?1% OR s.unit LIKE %?1% OR CAST( s.price AS string ) LIKE %?1%")
	Page<Service> findAllWithSearch(String searchInput, Pageable pageable);
	
}
