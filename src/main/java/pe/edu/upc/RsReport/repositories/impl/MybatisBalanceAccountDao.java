package pe.edu.upc.RsReport.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.upc.RsReport.models.BalanceAccount;
import pe.edu.upc.RsReport.mappers.BalanceAccountMapper;
import pe.edu.upc.RsReport.repositories.BalanceAccountDao;

import java.util.List;

@Repository
public class MybatisBalanceAccountDao implements BalanceAccountDao {

    @Autowired
    BalanceAccountMapper balanceAccountMapper;

    /*@Override
    public List<BalanceAccount> listBalanceAccount(BalanceAccount balanceAccount) throws Exception {
        return balanceAccountMapper.listBalanceAccount(balanceAccount);
    }
*/
    @Override
    public BalanceAccount getMonthlyBalance(BalanceAccount balanceAccount) throws Exception {
        return balanceAccountMapper.getMonthlyBalance(balanceAccount);
    }


}
