jQuery(function () {
   $("#pageSizeSelect").on("change", function () {
    let pageSize = $(this).val();
    let search = $("input[name='search']").val();
    // Thực hiện submit lại form với giá trị mới khi select thay đổi
    window.location.href = "list?pageSize=" + pageSize +"&search=" + search;
  });
});