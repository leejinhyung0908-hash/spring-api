package shop.leejinhyung.api.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.product.domain.ProductDTO;
import shop.leejinhyung.api.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductSerivceImplement implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Messenger save(ProductDTO product) {
        return productRepository.save(product);
    }

    @Override
    public Messenger saveAll(List<ProductDTO> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Messenger update(ProductDTO product) {
        return productRepository.update(product);
    }

    @Override
    public Messenger delete(String id) {
        return productRepository.delete(id);
    }

    @Override
    public Messenger findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Messenger findAll() {
        return productRepository.findAll();
    }

}
