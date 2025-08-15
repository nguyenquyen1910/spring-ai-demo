package com.quyennv.spring_ai_demo.dto.response;

public record BillItem(
    String itemName,
    String unit,
    Integer quantity,
    Double price,
    Double total
) {
    
}
