package com.spring.bankingApplication.bankController;

import com.spring.bankingApplication.bankService.BankingApplicationService;
import com.spring.bankingApplication.bankService.BankingApplicationServiceImpl;
import com.spring.bankingApplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    BankingApplicationService bankingApplicationService;
    //BankingApplicationServiceImpl bankingApplicationServiceImpl = new BankingApplicationServiceImpl();

    @PostMapping("/New-Account")
    public ResponseEntity<String> createMethod(@RequestBody String name){
        bankingApplicationService.createCustomer(name);
        return new ResponseEntity<>("Account Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/Show-Customers")
    public List<Customer> showCustomers(){
        return bankingApplicationService.showCustomers();
    }
}
