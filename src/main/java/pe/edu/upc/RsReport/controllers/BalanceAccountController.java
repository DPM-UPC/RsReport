package pe.edu.upc.RsReport.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.RsReport.models.BalanceAccount;
import pe.edu.upc.RsReport.services.BalanceAccountService;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping(value = "/reports")
public class BalanceAccountController {

    private static final Logger LOGGER = LogManager.getLogger(BalanceAccountController.class);

    @Autowired
    BalanceAccountService balanceAccountService;

    @GetMapping
    public ResponseEntity<BalanceAccount> getMonthlyBalance(@RequestParam(value = "userBusinessId", required = false) Integer userBusinessId,
                                                            @RequestParam(value = "monthlyPeriod", required = false) Integer monthlyPeriod){
        System.out.println("BalanceAccountController");
        LOGGER.info("getMonthlyBalance(), balanceAccount: {}: ", userBusinessId);
        LOGGER.info("getMonthlyBalance(), balanceAccount: {}: ", monthlyPeriod);

        BalanceAccount balanceAccountResult;
        BalanceAccount balanceAccountReq = new BalanceAccount();

        balanceAccountReq.setUserBusinessId(userBusinessId);
        balanceAccountReq.setMonthlyPeriod(monthlyPeriod);

        System.out.println("userBusinessId: " + userBusinessId);
        System.out.println("monthlyPeriod: " + monthlyPeriod);

        try {
            System.out.println("BalanceAccountController11");
            balanceAccountResult = balanceAccountService.getMonthlyBalance(balanceAccountReq);
            System.out.println("BalanceAccountController12");

            LOGGER.info("balanceAccountResult: " + balanceAccountResult);
        } catch (Exception e){
            System.out.println("BalanceAccountController2");

            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        if (balanceAccountResult == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok().body(balanceAccountResult);
    }

}
