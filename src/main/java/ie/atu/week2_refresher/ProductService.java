package ie.atu.week2_refresher;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> productist = new ArrayList<>();
    @GetMapping
    public List<Product> getProductList() {
        return productist;
    }
    @PostMapping("/products")
    public Product addProduct(Product product) {
        productist.add(product);
        return product;
    }

    public Product updateProduct(Long id, Product product) {
        Optional<Product> existingProductOpt = productist.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            return existingProduct;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with ID: " + id);
        }
    }

    public void deleteProduct(Long id) {
        boolean removed = productist.removeIf(p -> p.getId().equals(id));
        if (!removed) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with ID: " + id);
        }
    }
}
