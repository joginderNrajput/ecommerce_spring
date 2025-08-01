package com.learning.ecommerce_spring.gateway;

import com.learning.ecommerce_spring.dto.CategoryDTO;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public interface FakeStoreCategoryGateway {
    List<CategoryDTO> getAllCategories() throws IOException;
}
