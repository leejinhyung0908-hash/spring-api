package shop.leejinhyung.api.product.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.product.domain.ProductDTO;

@Repository
public class ProductRepository {

    public Messenger save(ProductDTO productDTO) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Product saved successfully");
        return messenger;
    }

    public Messenger saveAll(List<ProductDTO> products) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("All products saved successfully");
        return messenger;
    }

    public Messenger update(ProductDTO product) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Product updated successfully");
        return messenger;
    }

    public Messenger delete(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Product deleted successfully");
        return messenger;
    }

    public Messenger findById(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Product found successfully");
        return messenger;
    }

    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("All products found successfully");
        return messenger;
    }

}
