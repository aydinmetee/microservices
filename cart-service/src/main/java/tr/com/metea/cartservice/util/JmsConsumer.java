package tr.com.metea.cartservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import tr.com.metea.cartservice.domain.Product;
import tr.com.metea.cartservice.repository.ProductRepository;

/**
 * @author Mete Aydin
 * @since 1.06.2022
 */
@Component
public class JmsConsumer {

    @Autowired
    ProductRepository productRepository;

    @JmsListener(destination = "${product.jms.destination}")
    public void consumeMessage(String data) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            //Json data to Product object
            Product product = mapper.readValue(data, Product.class);
            productRepository.save(product);

        } catch (JsonProcessingException e) {
            e.getStackTrace();
        }
    }
}
