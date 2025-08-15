package com.quyennv.spring_ai_demo.dto.response;

public record ExpenseInfo(
    String category,
    String itemName,
    Double amount
) {
    
}
