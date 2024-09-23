package ie.atu.week2_refresher;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productist = new ArrayList<Product>();
    @GetMapping
    public List<Product> getProductList()
    {
        return productist;

    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product)
    {
        productist.add(product);
        return product;
    }
}
