package ie.atu.week2_refresher;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final OtherService otherService;

    @Autowired
    public ProductController(ProductService productService, OtherService otherService) {
        this.productService = productService;
        this.otherService = otherService;
    }

    @PostMapping("/confirm")
    public ResponseEntity<String> confirmDetails() {
        CustomerDetails details = otherService.getDetails();
        String message = "Name: " + details.getName() + ", Email: " + details.getEmail();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProductList() {
        List<Product> products = productService.getProductList();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }
}
