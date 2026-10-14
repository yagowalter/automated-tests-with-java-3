package br.com.yago.mockito.constructor;

import java.math.BigDecimal;

public class PaymentProcessorTest {

    private boolean allowForeignCurrencies;
    private String fallbackOption;
    private BigDecimal taxRate;

    public PaymentProcessorTest() {
        this(false, "DEBIT", new BigDecimal("19.00"));
    }

    public PaymentProcessorTest(String fallbackOption, BigDecimal taxRate) {
        this(false, fallbackOption, taxRate);
    }

    public PaymentProcessorTest(boolean allowForeignCurrencies, String fallbackOption, BigDecimal taxRate) {
        this.allowForeignCurrencies = allowForeignCurrencies;
        this.fallbackOption = fallbackOption;
        this.taxRate = taxRate;
    }

    public BigDecimal chargeCustomer(String customerId, BigDecimal netPrice) {
        
        // Any arbitrary implementation
        System.out.println("About to charge customer: " + customerId);
        return BigDecimal.ZERO;
    }
}
