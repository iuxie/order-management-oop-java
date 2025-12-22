package br.com.iurexavier.ordermanagement.domain.shipping;

public class ShippingResult {
    private final boolean success;
    private final String message;

    public ShippingResult(boolean success, String message) {
        validateFields(message);
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    private void validateFields(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("A mensagem é obrigatória!");
        }
    }
}
