package com.example.banking.modal.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AfterDepositBalance {

    private Integer depositBalance;
    private double currentBalance;

    private AfterDepositBalance(Integer depositBalance, Double currentBalance) {
        this.depositBalance = depositBalance;
        this.currentBalance = currentBalance;
    }

    public Integer getDepositBalance() {
        return depositBalance;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public static class Builder {
        private Integer depositBalance;
        private Double currentBalance;

        private Builder() {}

        public Builder depositBalance(Integer depositBalance) {
            this.depositBalance = depositBalance;
            return this;
        }

        public Builder currentBalance(Double currentBalance) {
            this.currentBalance = currentBalance;
            return this;
        }

        public AfterDepositBalance build() {
            return new AfterDepositBalance(depositBalance, currentBalance);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}


