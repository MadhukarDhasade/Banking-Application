package com.spring.bankingApplication.exceptionHandling;

import java.util.Date;


public class ErrorDetails {
        private Date timestamp;
        private String message;
        private String description;

        public ErrorDetails(Date timestamp, String message, String description) {
            this.timestamp = timestamp;
            this.message = message;
            this.description = description;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public String getMessage() {
            return message;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
