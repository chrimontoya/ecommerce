package cl.grupopi.ecommerce.entities.dto;
public class ResponseDTO<T> {
    private Integer status;
    private String message;
    private T data;

    public ResponseDTO() {
        this.status = 0;
        this.message = "";
        this.data = null;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
