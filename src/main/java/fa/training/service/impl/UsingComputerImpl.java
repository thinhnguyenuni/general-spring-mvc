package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.models.Computer;
import fa.training.models.Customer;
import fa.training.models.UsingComputer;
import fa.training.models.dto.SumInfoDTO;
import fa.training.repository.ComputerRepository;
import fa.training.repository.UsingComputerRepository;
import fa.training.service.UsingComputerService;

//Đánh dấu lớp này là một dịch vụ (service) để thực hiện các hoạt động liên quan đến việc sử dụng máy tính
@Service
public class UsingComputerImpl implements UsingComputerService {

	// Tự động liên kết (inject) một đối tượng UsingComputerRepository vào dịch vụ
	// này để thực hiện các thao tác trên cơ sở dữ liệu với các sự kiện sử dụng máy
	// tính
	@Autowired
	private UsingComputerRepository repository;

	// Tự động liên kết (inject) một đối tượng ComputerRepository để thực hiện các
	// thao tác trên cơ sở dữ liệu với các máy tính
	@Autowired
	private ComputerRepository computerRepository;

	// Phương thức tạo một sự kiện mới của việc sử dụng máy tính và cập nhật trạng
	// thái của máy tính tương ứng
	@Override
	public void create(UsingComputer usingComputer) {

		if (usingComputer == null) {
			System.out.println("Không khởi tạo được đối tượng"); // In ra thông báo nếu đối tượng sự kiện sử dụng máy
																	// tính không được khởi tạo
			return;
		}
		Computer computer = computerRepository.findById(usingComputer.getUsingComputerPK().getComputer().getId())
				.orElse(null); // Tìm kiếm máy tính tương ứng với sự kiện sử dụng máy tính
		if (computer != null) {
			computer.setStatus("Đang sử dụng"); // Cập nhật trạng thái của máy tính thành 'Đang sử dụng'
			computerRepository.save(computer); // Lưu trạng thái cập nhật vào cơ sở dữ liệu
		}
		repository.save(usingComputer); // Lưu sự kiện sử dụng máy tính vào cơ sở dữ liệu
	}

	// Phương thức trả về danh sách tất cả các sự kiện sử dụng máy tính từ cơ sở dữ
	// liệu
	@Override
	public List<UsingComputer> findAll() {

		List<UsingComputer> list = repository.findAll();
		if (list.isEmpty()) {
			System.out.println("Danh sách sử dụng máy trống"); // In ra thông báo nếu danh sách sự kiện sử dụng máy tính
																// trống
		}

		return list;
	}

	// Phương thức trả về danh sách tất cả các khách hàng đang sử dụng máy tính từ
	// cơ sở dữ liệu
	@Override
	public List<Customer> findAllCustomer() {

		List<Customer> list = repository.findAllCustomer("Đang sử dụng"); // Truy vấn tất cả các khách hàng đang sử dụng
																			// máy tính
		return list;
	}

	// Phương thức xóa một sự kiện sử dụng máy tính từ cơ sở dữ liệu
	@Override
	public void delete(UsingComputer usingComputer) {

		repository.delete(usingComputer);
	}

	// Phương thức trả về một trang dữ liệu sự kiện sử dụng máy tính từ cơ sở dữ
	// liệu, phân trang bằng đối tượng Pageable
	@Override
	public Page<UsingComputer> findAll(Pageable pageable) {

		return repository.findAll(pageable);
	}

	// Phương thức tìm kiếm và trả về một trang dữ liệu sự kiện sử dụng máy tính dựa
	// trên từ khóa tìm kiếm và phân trang bằng đối tượng Pageable
	@Override
	public Page<UsingComputer> findAllWithSearch(String searchInput, Pageable pageable) {
		return repository.findAllWithSearch(searchInput, pageable);
	}

	// Phương thức trả về một trang dữ liệu tổng hợp thông tin sử dụng máy tính từ
	// cơ sở dữ liệu, phân trang bằng đối tượng Pageable
	@Override
	public Page<SumInfoDTO> getAllSumInfo(String search, Pageable pageable) {

		// Truy vấn và lấy dữ liệu tổng hợp thông tin sử dụng máy tính từ cơ sở dữ liệu
		Page<SumInfoDTO> sumInfos = repository.getAllSumInfo("Đang sử dụng", search, pageable);
		if (sumInfos.getContent().isEmpty()) {
			return sumInfos;
		}
		// Tính toán và cập nhật tổng chi phí cho mỗi sự kiện sử dụng máy tính
		sumInfos = sumInfos.map(sumInfo -> {
			if (sumInfo.getPrice() != null && sumInfo.getQuantity() != null) {
				sumInfo.setTotalCost(sumInfo.getPrice() * sumInfo.getQuantity());
			} else {
				sumInfo.setTotalCost(0);
			}
			return sumInfo;
		});
		return sumInfos;
	}

}
