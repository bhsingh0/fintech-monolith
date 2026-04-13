package com.bharti.fintech.orderservice.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequest {

    @NotNull(message = "User id can not be null")
    private Long UserId;
}
