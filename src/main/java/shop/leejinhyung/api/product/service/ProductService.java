package shop.leejinhyung.api.product.service;

import java.util.List;

import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.product.domain.ProductDTO;

public interface ProductService {
    Messenger save(ProductDTO product);
    Messenger update(ProductDTO product);
    Messenger delete(String id);
    Messenger findById(String id);
    Messenger findAll();
    Messenger saveAll(List<ProductDTO> products);
}
