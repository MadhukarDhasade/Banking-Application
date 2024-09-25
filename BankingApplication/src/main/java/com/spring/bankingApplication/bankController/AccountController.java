package com.spring.bankingApplication.bankController;

import com.spring.bankingApplication.bankService.BankingApplicationService;
import com.spring.bankingApplication.exceptionHandling.CustomerNotFound;
import com.spring.bankingApplication.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    BankingApplicationService bankingApplicationService;

    @GetMapping("/Show-SavingAccount-Transaction")
    public ResponseEntity<List<Transaction>> showSavingsTransact(@RequestBody String name) throws CustomerNotFound {
        return new ResponseEntity<>(bankingApplicationService.showSavingTrans(name), HttpStatus.OK);
    }

    @GetMapping("/Show-CurrentAccount-Transaction")
    public ResponseEntity<List<Transaction>> showCurrentTransact(@RequestBody String name) throws CustomerNotFound {
        return new ResponseEntity<>(bankingApplicationService.showCurrentTrans(name),HttpStatus.OK);
    }
}
