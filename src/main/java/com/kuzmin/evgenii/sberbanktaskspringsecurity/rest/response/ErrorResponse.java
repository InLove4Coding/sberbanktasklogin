package com.kuzmin.evgenii.sberbanktaskspringsecurity.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    Integer statusCode;
    String statusDescription;
    String exception;
}
