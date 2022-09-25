package exception;

public class ProductValidateException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Sản phẩm bạn nhập không hợp lệ do không nằm trong danh sách quy định";
    }
}
