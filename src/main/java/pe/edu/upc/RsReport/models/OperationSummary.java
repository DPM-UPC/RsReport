package pe.edu.upc.RsReport.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import pe.edu.upc.RsReport.utils.DateFormatter;

import java.math.BigDecimal;

public class OperationSummary {
    private Integer order;
    @JsonProperty(value = "total_income")
    private BigDecimal totalIncome;
    @JsonProperty(value = "num_month")
    private Integer numMonth;
    @JsonProperty(value = "total_expense")
    private BigDecimal totalExpense;
    @JsonProperty(value = "month_description")
    private String monthDescription;
    @JsonProperty(value = "user_business_id_fk")
    private Integer userBusinessIdFk;

    public OperationSummary() {
    }

    public OperationSummary(Integer order, BigDecimal totalIncome, Integer numMonth, BigDecimal totalExpense, String monthDescription, Integer userBusinessIdFk) {
        this.order = order;
        this.totalIncome = totalIncome;
        this.numMonth = numMonth;
        this.totalExpense = totalExpense;
        this.monthDescription = monthDescription;
        this.userBusinessIdFk = userBusinessIdFk;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Integer getNumMonth() {
        return numMonth;
    }

    public void setNumMonth(Integer numMonth) {
        this.numMonth = numMonth;
    }

    public BigDecimal getTotalExpense() {
        return totalExpense.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public void setTotalExpense(BigDecimal totalExpense) {
        this.totalExpense = totalExpense;
    }

    public String getMonthDescription() {
        monthDescription = DateFormatter.getMonthDesc(numMonth);
        return monthDescription;
    }

    public void setMonthDescription(String monthDescription) {
        this.monthDescription = monthDescription;
    }

    public Integer getUserBusinessIdFk() {
        return userBusinessIdFk;
    }

    public void setUserBusinessIdFk(Integer userBusinessIdFk) {
        this.userBusinessIdFk = userBusinessIdFk;
    }

    @Override
    public String toString() {
        return "OperationSummary{" +
                "order=" + order +
                ", totalIncome=" + totalIncome +
                ", numMonth=" + numMonth +
                ", totalExpense=" + totalExpense +
                ", monthDescription='" + monthDescription + '\'' +
                ", userBusinessIdFk=" + userBusinessIdFk +
                '}';
    }
}
