package com.learning.fake_store.gateway;

import com.learning.fake_store.dto.CategoryDTO;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public interface FakeStoreCategoryGateway {
    List<CategoryDTO> getAllCategories() throws IOException;
}
