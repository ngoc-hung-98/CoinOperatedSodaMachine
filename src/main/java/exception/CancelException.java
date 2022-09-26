package exception;

public class CancelException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Đã hủy yêu cầu mua hàng";
    }
}
