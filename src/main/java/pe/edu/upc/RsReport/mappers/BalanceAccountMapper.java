package pe.edu.upc.RsReport.mappers;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsReport.models.BalanceAccount;

@Mapper
@Component
public interface BalanceAccountMapper {

    @Select("select user_business_id as userBusinessId, monthly_period as monthlyPeriod, account_id as accountId, amount " +
            "from balance_accounts " +
            "where user_business_id=#{userBusinessId} and monthly_period=#{monthlyPeriod}")
    BalanceAccount getMonthlyBalance(BalanceAccount balanceAccount);

}
