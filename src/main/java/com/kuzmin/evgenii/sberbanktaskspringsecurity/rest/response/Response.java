package com.kuzmin.evgenii.sberbanktaskspringsecurity.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    ErrorResponse errorResponse;
    T result;
}
