package lk.ijse.dep11.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderTO {
    private Integer orderId;
    private LocalDate orderDate;
    private String customerId;
    private List<OrderDetailTO> orderDetailTOList;
}
