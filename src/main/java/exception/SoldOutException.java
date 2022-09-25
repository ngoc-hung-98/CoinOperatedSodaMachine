package exception;

public class SoldOutException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Máy hết hàng";
    }
}
