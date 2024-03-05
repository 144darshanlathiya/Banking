package com.example.banking.modal.dto;

import com.example.banking.service.service;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AfterWithdrawBalance {
    private Integer withdraw;
    private Double currentBalance;

    // Private constructor to force usage of the builder
    private AfterWithdrawBalance(Integer withdraw, Double currentBalance) {
        this.withdraw = withdraw;
        this.currentBalance = currentBalance;
    }

    // Getter methods for fields
    public Integer getWithdraw() {
        return withdraw;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    // Builder class
    public static class Builder {
        private Integer withdraw;
        private Double currentBalance;

        // Private constructor to force usage of the builder
        private Builder() {}

        // Setter methods for fields
        public Builder withdraw(Integer withdraw) {
            this.withdraw = withdraw;
            return this;
        }

        public Builder currentBalance(Double currentBalance) {
            this.currentBalance = currentBalance;
            return this;
        }

        // Build method to create the actual AfterWithdrawBalance instance
        public AfterWithdrawBalance build() {
            return new AfterWithdrawBalance(withdraw, currentBalance);
        }
    }

    // Static method to create a new builder instance
    public static Builder builder() {
        return new Builder();
    }
}