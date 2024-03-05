package com.example.banking.modal.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReceiverDetails {

    private SenderDetails senderDetails;
    private ReceiverDetails receiverDetails;
    private double transferMoney;

    public ReceiverDetails(SenderDetails senderDetails, ReceiverDetails receiverDetails, double transferMoney) {
        this.senderDetails = senderDetails;
        this.receiverDetails = receiverDetails;
        this.transferMoney = transferMoney;
    }

    public SenderDetails getSenderDetails() {
        return senderDetails;
    }

    public ReceiverDetails getReceiverDetails() {
        return receiverDetails;
    }

    public double getTransferMoney() {
        return transferMoney;
    }
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
        public ReceiverDetails build() {
            return new ReceiverDetails(senderDetails, receiverDetails, transferMoney);
        }
    }

    // Static method to create a new builder instance
    public static Builder builder() {
        return new Builder();
    }
}

