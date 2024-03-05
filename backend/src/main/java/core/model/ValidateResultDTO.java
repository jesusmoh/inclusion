package core.model;

public class ValidateResultDTO {
    private boolean valid;
    private String result;

    public ValidateResultDTO(boolean valid, String result) {
        this.result = result;
        this.valid = valid;
    }

    public ValidateResultDTO() {
    }

    public boolean isValid() {
        return valid;

    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
