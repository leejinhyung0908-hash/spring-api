package shop.leejinhyung.api.product.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import shop.leejinhyung.api.common.domain.Messenger;
import shop.leejinhyung.api.product.domain.ProductDTO;
import shop.leejinhyung.api.product.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    public String save(ProductDTO product, Model model) {
        Messenger messenger = productService.save(product);
        model.addAttribute("messenger", messenger);
        return "products/list";
    }

    @PostMapping("/all")
    public String saveAll(Model model) {
        try {
            // CSV 파일 경로
            String csvFilePath = "src/main/resources/static/csv/products.csv";

            // CSV 파일 읽기
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = new CSVParser(reader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader());

            List<ProductDTO> products = new ArrayList<>();

            int count = 0;

            // 처음 5명의 데이터만 읽기
            for (CSVRecord record : parser) {
                if (count >= 5)
                    break;

                ProductDTO product = new ProductDTO();
                product.setProductId(record.get("Index")); // Index를 ProductId로 매핑
                product.setProductName(record.get("Name"));
                product.setProductPrice(record.get("Price"));
                product.setProductQuantity(record.get("Stock"));
                product.setProductCategory(record.get("Category"));
                product.setProductDescription(record.get("Description"));
                product.setProductImage(record.get("Brand")); // Brand를 ProductImage로 임시 매핑
                product.setProductStock(record.get("Stock"));
                product.setProductStatus(record.get("Availability"));

                products.add(product); // products.add(product)에서 (product)는 element라고 생각하면 된다.
                count++;
            }

            parser.close();
            reader.close();

            // 터미널에 상품 정보 출력
            System.out.println("==========================================");
            System.out.println("           모든 상품 정보 출력");
            System.out.println("==========================================");

            for (int i = 0; i < products.size(); i++) {
                ProductDTO product = products.get(i);
                System.out.println("\n--- 상품 " + (i + 1) + " ---");
                System.out.println("상품 ID: " + product.getProductId());
                System.out.println("상품 이름: " + product.getProductName());
                System.out.println("상품 가격: " + product.getProductPrice());
                System.out.println("상품 수량: " + product.getProductQuantity());
                System.out.println("상품 카테고리: " + product.getProductCategory());
                System.out.println("상품 설명: " + product.getProductDescription());
                System.out.println("상품 브랜드: " + product.getProductImage());
                System.out.println("상품 재고: " + product.getProductStock());
                System.out.println("상품 상태: " + product.getProductStatus());
            }

            System.out.println("==========================================");
            System.out.println(" 상품 데이터 로드 완료: " + products.size() + "개 상품이 성공적으로 로드되었습니다.");

            // Messenger 객체로 성공 메시지만 설정
            Messenger messenger = new Messenger();
            messenger.setCode(200);
            messenger.setMessage("Products loaded successfully from CSV");
            model.addAttribute("messenger", messenger);
            model.addAttribute("products", products);
            return "products/list";

        } catch (IOException e) {
            model.addAttribute("products", new ArrayList<ProductDTO>());
            model.addAttribute("message", "CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            return "products/list";
        }

    }

    @PutMapping("/{id}")
    public String update(ProductDTO product, Model model) {
        Messenger messenger = productService.update(product);
        model.addAttribute("messenger", messenger);
        return "products/detail";
    }

    @DeleteMapping("/{id}")
    public String delete(String id, Model model) {
        Messenger messenger = productService.delete(id);
        model.addAttribute("messenger", messenger);
        return "products/detail";
    }

    @GetMapping("/id/{id}")
    public String findById(String id, Model model) {
        Messenger messenger = productService.findById(id);
        model.addAttribute("messenger", messenger);
        return "products/detail";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        Messenger messenger = productService.findAll();
        model.addAttribute("messenger", messenger);
        return "products/detail";
    }
}
