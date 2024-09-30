package ie.atu.week2_refresher;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service-2", url = "http://localhost:8081")
public interface OtherService {

    @GetMapping("/getDetails")
    CustomerDetails getDetails();

    @PostMapping("/submitProduct")
    String sendProductDetails(@RequestBody Product product);


    @PostMapping("/products")
    Product submitProductToService2(@RequestBody Product product);
}
