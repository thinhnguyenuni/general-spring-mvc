package fa.training.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.training.models.Customer;
import fa.training.models.UsingComputer;
import fa.training.models.UsingComputerPK;
import fa.training.models.dto.SumInfoDTO;

//Định nghĩa một interface UsingComputerRepository kế thừa từ JpaRepository với đối tượng là UsingComputer và khóa chính là UsingComputerPK
public interface UsingComputerRepository extends JpaRepository<UsingComputer, UsingComputerPK> {

	// Phương thức tìm kiếm tất cả các khách hàng đang sử dụng máy tính với trạng
	// thái máy tính như input truyền vào
	@Query(value = "select distinct uc.usingComputerPK.customer from UsingComputer uc where uc.usingComputerPK.computer.status LIKE ?1")
	List<Customer> findAllCustomer(String input);

	// Phương thức tìm kiếm tất cả các bản ghi UsingComputer với điều kiện tìm kiếm
	// theo từ khóa nhập vào và trả về một trang dữ liệu UsingComputer phân trang
	@Query(value = "select uc From UsingComputer uc where uc.usingComputerPK.customer.id LIKE %?1% OR uc.usingComputerPK.computer.id LIKE %?1%")
	Page<UsingComputer> findAllWithSearch(String searchInput, Pageable pageable);

	// Phương thức này trả về một trang dữ liệu SumInfoDTO với thông tin tổng hợp về
	// việc sử dụng máy tính, dịch vụ, và khách hàng
	@Query("select new fa.training.models.dto.SumInfoDTO "
			+ "(cus.id, cus.name, com.id, com.location, com.status, uc.usingComputerPK.date, "
			+ "uc.usingComputerPK.time, uc.duration, sv.id, us.usingServicePK.date, "
			+ "us.usingServicePK.time, us.quantity, sv.price) " 
			+ "from UsingComputer uc "
			+ "left join uc.usingComputerPK.customer cus " 
			+ "left join uc.usingComputerPK.computer com "
			+ "left join cus.usingServices us "
			+ "left join us.usingServicePK.service sv where uc.usingComputerPK.computer.status LIKE ?1 and (cus.id LIKE %?2% or cus.name LIKE %?2%)")
	Page<SumInfoDTO> getAllSumInfo(String status, String search, Pageable pageable);
	
}
