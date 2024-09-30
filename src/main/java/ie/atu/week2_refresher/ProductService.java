package ie.atu.week2_refresher;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList.isEmpty() ? List.of() : productList;
    }

    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }
}
