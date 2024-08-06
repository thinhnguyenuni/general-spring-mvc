package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.models.UsingService;
import fa.training.repository.UsingServiceRepository;
import fa.training.service.UsingServiceService;

//Đánh dấu lớp này là một dịch vụ (service) để thực hiện các hoạt động liên quan đến việc sử dụng dịch vụ
@Service
public class UsingServiceServiceImpl implements UsingServiceService {

	// Tự động liên kết (inject) một đối tượng UsingServiceRepository vào dịch vụ
	// này để thực hiện các thao tác trên cơ sở dữ liệu với các sự kiện sử dụng dịch
	// vụ
	@Autowired
	private UsingServiceRepository repository;

	// Phương thức tạo một sự kiện mới của việc sử dụng dịch vụ
	@Override
	public void create(UsingService usingService) {
		if (usingService == null) {
			System.out.println("Không khởi tạo được đối tượng"); // In ra thông báo nếu đối tượng sự kiện sử dụng dịch
																	// vụ không được khởi tạo
			return;
		}
		repository.save(usingService); // Lưu sự kiện sử dụng dịch vụ vào cơ sở dữ liệu
	}

	// Phương thức trả về danh sách tất cả các sự kiện sử dụng dịch vụ từ cơ sở dữ
	// liệu
	@Override
	public List<UsingService> findAll() {
		List<UsingService> list = repository.findAll();
		if (list.isEmpty()) {
			System.out.println("Danh sách sử dụng dịch vụ trống"); // In ra thông báo nếu danh sách sự kiện sử dụng dịch
																	// vụ trống
		}
		return list;
	}

	// Phương thức xóa một sự kiện sử dụng dịch vụ từ cơ sở dữ liệu
	@Override
	public void delete(UsingService usingService) {
		repository.delete(usingService);
	}

	// Phương thức trả về một trang dữ liệu sự kiện sử dụng dịch vụ từ cơ sở dữ
	// liệu, phân trang bằng đối tượng Pageable
	@Override
	public Page<UsingService> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	// Phương thức tìm kiếm và trả về một trang dữ liệu sự kiện sử dụng dịch vụ dựa
	// trên từ khóa tìm kiếm và phân trang bằng đối tượng Pageable
	@Override
	public Page<UsingService> findAllWithSearch(String searchInput, Pageable pageable) {
		return repository.findAllWithSearch(searchInput, pageable);
	}

}
