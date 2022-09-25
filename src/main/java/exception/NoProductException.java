package exception;

public class NoProductException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Vui lòng thêm sản phẩm vào máy";
    }
}
