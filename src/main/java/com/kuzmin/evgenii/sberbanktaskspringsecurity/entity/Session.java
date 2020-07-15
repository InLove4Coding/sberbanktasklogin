package com.kuzmin.evgenii.sberbanktaskspringsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    UUID sessionId;
    Long timestamp;
    Long expire;
    Long userId;
}
