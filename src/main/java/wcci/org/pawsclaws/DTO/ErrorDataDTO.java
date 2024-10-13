package wcci.org.pawsclaws.DTO;

/**
 * Data Transfer Object (DTO) for encapsulating error information.
 */
public class ErrorDataDTO {
    
    private String errorMessage; // Message describing the error
    private int errorCode = 0;   // Code representing the type of error (default is 0)

    /**
     * Gets the error message.
     * 
     * @return The error message as a String.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the error message.
     * 
     * @param errorMessage The message to be set for the error.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Gets the error code.
     * 
     * @return The error code as an integer.
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the error code.
     * 
     * @param errorCode The error code to be set.
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
