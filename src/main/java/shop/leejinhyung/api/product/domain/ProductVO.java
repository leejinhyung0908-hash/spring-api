package shop.leejinhyung.api.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ProductVO {
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
