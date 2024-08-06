package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.models.Customer;
import fa.training.repository.CustomerRepository;
import fa.training.service.CustomerService;

//Đánh dấu lớp này là một dịch vụ (service) để thực hiện các hoạt động liên quan đến quản lý khách hàng
@Service
public class CustomerServiceImpl implements CustomerService {

	// Tự động liên kết (inject) một đối tượng CustomerRepository vào dịch vụ này để
	// thực hiện các thao tác trên cơ sở dữ liệu
	@Autowired
	private CustomerRepository repository;

	// Phương thức tạo một bản ghi mới cho khách hàng trong cơ sở dữ liệu
	@Override
	public void create(Customer customer) {

		if (customer == null) {
			System.out.println("Không khởi tạo được đối tượng"); // In ra thông báo nếu đối tượng khách hàng không được
																	// khởi tạo
			return;
		}
		repository.save(customer); // Lưu đối tượng khách hàng vào cơ sở dữ liệu
	}

	// Phương thức trả về danh sách tất cả các khách hàng từ cơ sở dữ liệu
	@Override
	public List<Customer> findAll() {

		List<Customer> list = repository.findAll();
		if (list.isEmpty()) {
			System.out.println("Danh sách khách hàng trống"); // In ra thông báo nếu danh sách khách hàng trống
			return null;
		}
		return list;
	}

	// Phương thức tìm một khách hàng trong cơ sở dữ liệu dựa trên ID đã cho
	@Override
	public Customer findByID(String id) {

		return repository.findById(id).orElse(null);
	}

	// Phương thức xóa một bản ghi khách hàng từ cơ sở dữ liệu dựa trên ID đã cho
	@Override
	public void deleteById(String id) {

		repository.deleteById(id);
	}

	// Phương thức trả về một trang dữ liệu khách hàng từ cơ sở dữ liệu, phân trang
	// bằng đối tượng Pageable
	@Override
	public Page<Customer> findAll(Pageable pageable) {

		return repository.findAll(pageable);
	}

	// Phương thức tìm kiếm và trả về một trang dữ liệu khách hàng dựa trên từ khóa
	// tìm kiếm và phân trang bằng đối tượng Pageable
	@Override
	public Page<Customer> findAllWithSearch(String searchInput, Pageable pageable) {

		return repository.findAllWithSearch(searchInput, pageable);
	}

	// Phương thức kiểm tra xem một khách hàng có tồn tại trong cơ sở dữ liệu dựa
	// trên ID đã cho hay không
	@Override
	public boolean existByID(String id) {

		return repository.existsById(id);
	}

}
