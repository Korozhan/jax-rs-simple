package main.java.com.jax.rs.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by intel on 22.09.2016.
 */
@XmlRootElement(name = "response")
public class GenericResponse {

    private String errorCode;
    private String message;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "GenericResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }

}
