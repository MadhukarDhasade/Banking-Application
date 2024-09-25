package com.spring.bankingApplication.bankController;

import com.spring.bankingApplication.bankService.BankingApplicationService;
import com.spring.bankingApplication.bankService.BankingApplicationServiceImpl;
import com.spring.bankingApplication.exceptionHandling.CustomerNotFound;
import com.spring.bankingApplication.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankApplicationController {
    @Autowired
    BankingApplicationService bankingApplicationService;

    @PostMapping("/Deposit-Current")
    public ResponseEntity<String> depositToCurrent(@RequestBody double amount){
        bankingApplicationService.depositToCurrent(amount);
        return new ResponseEntity<>("Amount Deposited to Current Account Successfully", HttpStatus.ACCEPTED);
    }

    @PostMapping("/Deposit-Saving")
    public ResponseEntity<String> depositToSaving(@RequestBody double amount){
        bankingApplicationService.depositToSaving(amount);
        return new ResponseEntity<>("Amount Deposited to Saving Account Successfully", HttpStatus.ACCEPTED);
    }

    @PostMapping("/Current-Saving")
    public ResponseEntity<String> TransferOthers(@RequestBody double amount){
        bankingApplicationService.TransferToOthers(amount);
        return new ResponseEntity<>("Amount Transferred Successfully", HttpStatus.ACCEPTED);
    }

    @PostMapping("/Saving-Current")
    public ResponseEntity<String> TransferOthers2(@RequestBody double amount){
        bankingApplicationService.TransferFromSaving(amount);
        return new ResponseEntity<>("Amount Transferred Successfully", HttpStatus.ACCEPTED);
    }

}
