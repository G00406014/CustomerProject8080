package ie.atu.week2_refresher;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "external - Service" ,url = "http://loclahost:8081")
public interface OtherService {

    @GetMapping("/getDetails")
    public String externalDetails();
}
