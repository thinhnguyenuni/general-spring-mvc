package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.repository.ServiceRepository;
import fa.training.service.ServiceService;

//Đánh dấu lớp này là một dịch vụ (service) để thực hiện các hoạt động liên quan đến quản lý dịch vụ
@Service
public class ServiceServiceImpl implements ServiceService {

	// Tự động liên kết (inject) một đối tượng ServiceRepository vào dịch vụ này để
	// thực hiện các thao tác trên cơ sở dữ liệu
	@Autowired
	private ServiceRepository repository;

	// Phương thức tạo một bản ghi mới cho dịch vụ trong cơ sở dữ liệu
	@Override
	public void create(fa.training.models.Service service) {

		if (service == null) {
			System.out.println("Không khởi tạo được đối tượng"); // In ra thông báo nếu đối tượng dịch vụ không được
																	// khởi tạo
			return;
		}
		repository.save(service); // Lưu đối tượng dịch vụ vào cơ sở dữ liệu
	}

	// Phương thức trả về danh sách tất cả các dịch vụ từ cơ sở dữ liệu
	@Override
	public List<fa.training.models.Service> findAll() {

		List<fa.training.models.Service> list = repository.findAll();
		if (list.isEmpty()) {
			System.out.println("Danh sách dịch vụ trống"); // In ra thông báo nếu danh sách dịch vụ trống
		}
		return list;
	}

	// Phương thức xóa một bản ghi dịch vụ từ cơ sở dữ liệu dựa trên ID đã cho
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}

	// Phương thức tìm một dịch vụ trong cơ sở dữ liệu dựa trên ID đã cho
	@Override
	public fa.training.models.Service findByID(String id) {

		return repository.findById(id).orElse(null);
	}

	// Phương thức trả về một trang dữ liệu dịch vụ từ cơ sở dữ liệu, phân trang
	// bằng đối tượng Pageable
	@Override
	public Page<fa.training.models.Service> findAll(Pageable pageable) {

		return repository.findAll(pageable);
	}

	// Phương thức tìm kiếm và trả về một trang dữ liệu dịch vụ dựa trên từ khóa tìm
	// kiếm và phân trang bằng đối tượng Pageable
	@Override
	public Page<fa.training.models.Service> findAllWithSearch(String searchInput, Pageable pageable) {

		System.out.println("SearchInput" + searchInput); // In ra thông báo về từ khóa tìm kiếm
		return repository.findAllWithSearch(searchInput, pageable);
	}

	// Phương thức kiểm tra xem một dịch vụ có tồn tại trong cơ sở dữ liệu dựa trên
	// ID đã cho hay không
	@Override
	public boolean existByID(String id) {

		return repository.existsById(id);
	}

}
