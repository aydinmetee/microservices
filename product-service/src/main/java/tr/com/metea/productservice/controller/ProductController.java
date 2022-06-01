package tr.com.metea.productservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import tr.com.metea.productservice.domain.Product;
import tr.com.metea.productservice.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Mete Aydin
 * @since 1.06.2022
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    private final JmsTemplate jmsTemplate;
    @Value("${product.jms.destination}")
    private String jmsQueue;

    @PostMapping()
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/sendToCart/{id}")
    public ResponseEntity<Product> sendToCart(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {

            ObjectMapper mapper = new ObjectMapper();
            //Convert the object to String
            String jsonInString = mapper.writeValueAsString(product.get());
            //Send the data to the message queue
            jmsTemplate.convertAndSend(jmsQueue, jsonInString);
            return new ResponseEntity<>(product.get(), HttpStatus.OK);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
