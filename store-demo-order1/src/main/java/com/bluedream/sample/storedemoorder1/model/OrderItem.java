package com.bluedream.sample.storedemoorder1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @NonNull
    private Product product;

    @NonNull
    private Integer quantity;
}
