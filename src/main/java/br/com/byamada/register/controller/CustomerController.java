package br.com.byamada.register.controller;

import br.com.byamada.register.model.dto.CustomerDTO;
import br.com.byamada.register.queue.config.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> postTaxpayer(@RequestBody CustomerDTO customer){

        customerService.send(customer);

        return ResponseEntity.ok(customer);
    }



}
