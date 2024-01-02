package lk.ijse.dep11;

import lk.ijse.dep11.entity.Order;
import lk.ijse.dep11.entity.OrderDetail;
import lk.ijse.dep11.to.OrderDetailTO;
import lk.ijse.dep11.to.OrderTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLData;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class Transformer2 {

    public static void main(String[] args) {
        OrderDetailTO i001 = new OrderDetailTO("I001", 5, new BigDecimal(500));
        OrderDetailTO i002 = new OrderDetailTO("I002", 2, new BigDecimal(100));
        OrderDetailTO i003 = new OrderDetailTO("I003", 6, new BigDecimal(300));
        OrderTO orderTO = new OrderTO(1,
                LocalDate.now(),
                "C001",
                List.of(i001, i002, i003));

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);

        // Handle mismatches of data types
        mapper.typeMap(LocalDate.class, Date.class)
                        .setConverter(ctx -> Date.valueOf(ctx.getSource()));

        // Handle mismatches of property names
        mapper.typeMap(OrderTO.class,  Order.class)
                .addMapping(OrderTO::getOrderId, Order::setId)
                .addMapping(OrderTO::getOrderDate, Order::setDate);

        mapper.typeMap(OrderDetailTO.class, OrderDetail.class)
                .addMapping(OrderDetailTO::getCode, OrderDetail::setItemCode)
                .addMapping(OrderDetailTO::getPrice, OrderDetail::setUnitPrice);

        Order order = mapper.map(orderTO, Order.class);
        order.getOrderDetailList().forEach(od -> od.setOrderId(order.getId()));

        System.out.println(order);
        order.getOrderDetailList().forEach(System.out::println);
    }
}
