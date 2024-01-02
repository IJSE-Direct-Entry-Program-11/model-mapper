package lk.ijse.dep11;

import lk.ijse.dep11.entity.Customer;
import lk.ijse.dep11.to.CustomerTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

@Slf4j
public class Transformer {

    public static void main(String[] args) {
        ModelMapper mapper = new ModelMapper();

        // This is how we handle type mismatches
        mapper.typeMap(CustomerTO.class, Customer.class)
               .addMapping(CustomerTO::getTelephone, Customer::setCustomerContact);
        mapper.typeMap(Customer.class, CustomerTO.class)
                .addMapping(Customer::getCustomerContact, CustomerTO::setTelephone);

        CustomerTO customerTo = new CustomerTO(1, "Kasun Sampath", "Panadura", "077-1234567");
        Customer customer = mapper.map(customerTo, Customer.class);
//        Customer customer = new Customer(customerTo.getId() + "",
//                customerTo.getName(),
//                customerTo.getAddress());
        log.debug("{}", customer);

        Customer c003 = new Customer("3", "Nuwan Ramindu", "Galle", "011-1234567");
        CustomerTO c003To = mapper.map(c003, CustomerTO.class);
//        CustomerTO c003To = new CustomerTO(Integer.valueOf(c003.getCustomerId()),
//                c003.getCustomerName(), c003.getCustomerAddress());
        log.debug("{}", c003To);
    }
}
