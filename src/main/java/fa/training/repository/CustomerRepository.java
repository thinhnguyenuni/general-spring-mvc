package fa.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.training.models.Customer;

//Định nghĩa một interface CustomerRepository kế thừa từ JpaRepository với đối tượng là Customer và kiểu dữ liệu của khóa chính là String
public interface CustomerRepository extends JpaRepository<Customer, String> {

	// Phương thức tìm kiếm tất cả các khách hàng với điều kiện tìm kiếm theo từ
	// khóa nhập vào và trả về một trang dữ liệu khách hàng phân trang
	@Query(value = "select c From Customer c where c.id LIKE %?1% OR c.name LIKE %?1% OR c.address LIKE %?1% OR c.phone LIKE %?1% OR c.email LIKE %?1%")
	Page<Customer> findAllWithSearch(String searchInput, Pageable pageable);
	
}
