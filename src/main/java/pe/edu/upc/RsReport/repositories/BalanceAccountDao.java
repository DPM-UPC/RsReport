package pe.edu.upc.RsReport.repositories;

import pe.edu.upc.RsReport.models.BalanceAccount;

import java.util.List;

public interface BalanceAccountDao {

    //List<BalanceAccount> listBalanceAccount(BalanceAccount balanceAccount) throws Exception;

    //List<BalanceAccount> getQuarterlyBalance(BalanceAccount balanceAccount) throws Exception;

    BalanceAccount getMonthlyBalance(BalanceAccount balanceAccount) throws Exception;
}
