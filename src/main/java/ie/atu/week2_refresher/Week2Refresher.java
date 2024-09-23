package ie.atu.week2_refresher;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
public class Week2Refresher {

    @GetMapping("/Hello")
    public String message()
    {
        return "Hello";

    }
    @GetMapping("/Hello/{name}")
    public String myName(@PathVariable String name)
    {
        return "your name is " + name;
    }
    @GetMapping("/search")
    public String search(@RequestParam String search1, @RequestParam () String search2)
    {
        return search1 + " " + search2;
    }
}
