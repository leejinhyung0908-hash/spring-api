package shop.leejinhyung.api.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO {
    private String ProductId;
    private String ProductName;
    private String ProductPrice;
    private String ProductQuantity;
    private String ProductCategory;
    private String ProductDescription;
    private String ProductImage;
    private String ProductStock;
    private String ProductStatus;
}
