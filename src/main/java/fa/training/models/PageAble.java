package fa.training.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageAble {
	
	// Khai báo biến riêng tư để lưu trữ số trang và kích thước của mỗi trang
	private int page;
	private int size;

	// Định nghĩa một danh sách các kích thước trang được định trước
	public static List<Integer> pageSizes = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 10));

	// Constructor mặc định không có tham số
	public PageAble() {

	}

	// Constructor với tham số để thiết lập số trang và kích thước
	public PageAble(int page, int size) {
		this.page = page;
		this.size = size;
	}

	// Phương thức tính toán vị trí bắt đầu của dữ liệu trên trang hiện tại
	public int getOffset() {
		return (page - 1) * size;
	}

	// Phương thức getter để lấy số trang hiện tại
	public int getPage() {
		return page;
	}

	// Phương thức setter để thiết lập số trang hiện tại
	public void setPage(int page) {
		this.page = page;
	}

	// Phương thức getter để lấy kích thước của mỗi trang
	public int getSize() {
		return size;
	}

	// Phương thức setter để thiết lập kích thước của mỗi trang
	public void setSize(int size) {
		this.size = size;
	}
}
