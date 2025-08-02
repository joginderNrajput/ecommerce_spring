package com.learning.ecommerce_spring.dto.response;

import com.learning.ecommerce_spring.dto.CategoryDTO;
import com.learning.ecommerce_spring.dto.Message;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryResponse extends Message {
    CategoryDTO category;
}
