package com.example.banking.modal.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class SenderDetails {
    private SenderDetails senderDetails;
    private ReceiverDetails receiverDetails;
    private double transferMoney;

    private SenderDetails(SenderDetails senderDetails, ReceiverDetails receiverDetails, double transferMoney) {
        this.senderDetails = senderDetails;
        this.receiverDetails = receiverDetails;
        this.transferMoney = transferMoney;
    }

    // Getter methods for fields
    public SenderDetails getSenderDetails() {
        return senderDetails;
    }

    public ReceiverDetails getReceiverDetails() {
        return receiverDetails;
    }

    public double getTransferMoney() {
        return transferMoney;
    }

    // Builder class
    public static class Builder {
        private SenderDetails senderDetails;
        private ReceiverDetails receiverDetails;
        private double transferMoney;

        // Private constructor to force usage of the builder
        private Builder() {}

        // Setter methods for fields
        public Builder senderDetails(SenderDetails senderDetails) {
            this.senderDetails = senderDetails;
            return this;
        }

        public Builder receiverDetails(ReceiverDetails receiverDetails) {
            this.receiverDetails = receiverDetails;
            return this;
        }

        public Builder transferMoney(double transferMoney) {
            this.transferMoney = transferMoney;
            return this;
        }

        // Build method to create the actual TransferMoney instance
        public SenderDetails build() {
            return new SenderDetails(senderDetails, receiverDetails, transferMoney);
        }



    }

    // Static method to create a new builder instance
    public static Builder builder() {
        return new Builder();
    }
}
