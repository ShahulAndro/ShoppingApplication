package com.shopping.api.request;
import com.shopping.api.dto.CustomerOrderDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Getter
@Setter
public class CustomerOrderRequest {
    @NotNull
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z$",
            message = "Invalid date-time format. Expected format: yyyy-MM-dd'T'HH:mm:ss'Z'")
    private String orderDate;
    @NotNull
    private String orderStatus;
    @NotNull
    private String totalAmount;
    private String paymentStatus;
    private String shippingMethod;
    private String shippingAddress;
    private String paymentMethod;
}
