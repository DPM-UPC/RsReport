package pe.edu.upc.RsReport.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceAccount {

    private Integer userBusinessId;

    private Integer monthlyPeriod;

    private Integer accountId;

    private Double amount;

    public BalanceAccount(){}

    public Integer getUserBusinessId() {
        return userBusinessId;
    }

    public void setUserBusinessId(Integer userBusinessId) {
        this.userBusinessId = userBusinessId;
    }

    public Integer getMonthlyPeriod() {
        return monthlyPeriod;
    }

    public void setMonthlyPeriod(Integer monthlyPeriod) {
        this.monthlyPeriod = monthlyPeriod;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
