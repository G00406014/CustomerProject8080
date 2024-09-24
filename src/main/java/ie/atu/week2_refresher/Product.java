package ie.atu.week2_refresher;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;

    @NotBlank(message = "fill in name")
    private String name;

    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price must be higher than 0")
    private double price;
}
