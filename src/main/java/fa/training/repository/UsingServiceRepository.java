package fa.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.training.models.UsingService;
import fa.training.models.UsingServicePK;

//Định nghĩa một interface UsingServiceRepository kế thừa từ JpaRepository với đối tượng là UsingService và khóa chính là UsingServicePK
public interface UsingServiceRepository extends JpaRepository<UsingService, UsingServicePK> {

	// Phương thức tìm kiếm tất cả các bản ghi UsingService với điều kiện tìm kiếm
	// theo từ khóa nhập vào và trả về một trang dữ liệu UsingService phân trang
	@Query(value = "select us From UsingService us where us.usingServicePK.customer.id LIKE %?1% OR us.usingServicePK.service.id LIKE %?1%")
	Page<UsingService> findAllWithSearch(String searchInput, Pageable pageable);
	
}
