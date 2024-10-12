package com.DevCraftLab.QuickMail.api;

import lombok.*;
import org.springframework.http.HttpStatus;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailResponse {
    private String message;
    private HttpStatus status;
    private boolean success;
}
