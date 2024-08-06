package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.models.Computer;
import fa.training.repository.ComputerRepository;
import fa.training.service.ComputerService;

//Đánh dấu đây là một dịch vụ (service) để thực hiện các hoạt động liên quan đến quản lý máy tính
@Service
public class ComputerServiceImpl implements ComputerService {

	// Tự động liên kết (inject) một đối tượng ComputerRepository vào dịch vụ này để
	// thực hiện các thao tác trên cơ sở dữ liệu
	@Autowired
	private ComputerRepository repository;

	// Phương thức tạo một bản ghi mới cho máy tính trong cơ sở dữ liệu
	@Override
	public void create(Computer computer) {

		if (computer == null) {
			System.out.println("Không khởi tạo được đối tượng");
			// In ra thông báo nếu đối tượng máy tính không được khởi tạo
			return;
		}
		// Lưu đối tượng máy tính vào cơ sở dữ liệu
		repository.save(computer);
	}

	// Phương thức trả về danh sách tất cả các máy tính từ cơ sở dữ liệu
	@Override
	public List<Computer> findAll() {

		List<Computer> list = repository.findAll();
		if (list.isEmpty()) {
			// In ra thông báo nếu danh sách máy tính trống
			System.out.println("Danh sách máy tính trống"); 
			return null;
		}
		return list;
	}

	// Phương thức tìm một máy tính trong cơ sở dữ liệu dựa trên ID đã cho
	@Override
	public Computer findByID(String id) {

		return repository.findById(id).orElse(null);
	}

	// Phương thức xóa một bản ghi máy tính từ cơ sở dữ liệu dựa trên ID đã cho
	@Override
	public void deleteById(String id) {

		repository.deleteById(id);
	}

	// Phương thức trả về một trang dữ liệu máy tính từ cơ sở dữ liệu, phân trang
	// bằng đối tượng Pageable
	@Override
	public Page<Computer> findAll(Pageable pageable) {

		return repository.findAll(pageable);
	}

	// Phương thức tìm kiếm và trả về một trang dữ liệu máy tính dựa trên từ khóa
	// tìm kiếm và phân trang bằng đối tượng Pageable
	@Override
	public Page<Computer> findAllWithSearch(String searchInput, Pageable pageable) {

		return repository.findAllWithSearch(searchInput, pageable);
	}

	// Phương thức kiểm tra xem một máy tính có tồn tại trong cơ sở dữ liệu dựa trên
	// ID đã cho hay không
	@Override
	public boolean existByID(String id) {

		return repository.existsById(id);
	}

	// Phương thức trả về danh sách các máy tính có sẵn để sử dụng, thường là các
	// máy tính có trạng thái "Trống"
	@Override
	public List<Computer> findAllAvaiable() {

		return repository.findAllAvaiable("Trống");
	}

}
