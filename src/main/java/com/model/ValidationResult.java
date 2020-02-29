package com.model;

/**
 * Created by tianjian on 2020/2/29.
 */
public class ValidationResult {

    /**
     * 验证失败
     */
    private String validationMessage;

    /**
     * 失败码
     */
    private String code;

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return validationMessage;
    }

    public static ValidationResult failValidationResult(String code, String validationMessage) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setCode(code);
        validationResult.setValidationMessage(validationMessage);
        return validationResult;
    }
}
