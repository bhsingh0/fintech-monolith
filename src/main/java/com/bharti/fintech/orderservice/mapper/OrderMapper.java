package com.bharti.fintech.orderservice.mapper;

import com.bharti.fintech.orderservice.model.Order;
import com.bharti.fintech.orderservice.request.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderId", ignore = true)
    @Mapping(target = "status", constant = "CREATED")
    Order toEntity(OrderRequest request);
}
