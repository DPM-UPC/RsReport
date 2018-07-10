package pe.edu.upc.RsReport.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.RsReport.models.BalanceAccount;
import pe.edu.upc.RsReport.repositories.BalanceAccountDao;

@Service
public class BalanceAccountService {

    private static final Logger LOGGER = LogManager.getLogger(BalanceAccountService.class);

    @Autowired
    BalanceAccountDao balanceAccountDao;

    public BalanceAccount getMonthlyBalance (BalanceAccount balanceAccount) throws Exception{
        LOGGER.debug("getMonthlyBalance, balanceAccount: {}", balanceAccount);
        System.out.println("SERVICE!");
        System.out.println("BalanceAccountService . getUserBusinessId: " + balanceAccount.getUserBusinessId());
        System.out.println("BalanceAccountService . getMonthlyPeriod: " + balanceAccount.getMonthlyPeriod());

        BalanceAccount newBalanceAccount = balanceAccountDao.getMonthlyBalance(balanceAccount);

        if (newBalanceAccount == null) {
            System.out.println("se fue nulo T_T");
            return null;
        }
        System.out.println("BalanceAccountService TERMINO");
        System.out.println("monto: " + newBalanceAccount.getAmount());
        System.out.println("monto: " + newBalanceAccount.getAccountId());
        System.out.println("BalanceAccountService TERMINO SALIO");
        return newBalanceAccount;

    }

}
