package pe.edu.upc.RsReport.mappers;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import pe.edu.upc.RsReport.models.OperationSummary;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface OperationSummaryMapper {

    @Select("select 1 as 'order', m.num_mes as numMonth,IFNULL(i.total_ingresos, 0) as totalIncome, IFNULL(g.total_gastos, 0) as totalExpense, #{operationSummary.userBusinessIdFk} as userBusinessIdFk from " +
            "(select #{numMonthsMap.order1} as num_mes from dual) m, " +
            "(select sum(IFNULL(i.amount, 0)) as total_ingresos from operations i where MONTH(i.operation_date)=#{numMonthsMap.order1} and i.user_business_id_fk=#{operationSummary.userBusinessIdFk} and i.account_id_fk=1) i, " +
            "(select sum(IFNULL(g.amount, 0)) as total_gastos from operations g where MONTH(g.operation_date)=#{numMonthsMap.order1} and g.user_business_id_fk=#{operationSummary.userBusinessIdFk} and g.account_id_fk=2) g " +
            "union " +
            "select 2 as 'order', m.num_mes as numMonth,IFNULL(i.total_ingresos, 0) as totalIncome, IFNULL(g.total_gastos, 0) as totalExpense, #{operationSummary.userBusinessIdFk} as userBusinessIdFk from " +
            "(select #{numMonthsMap.order2} as num_mes from dual) m, " +
            "(select sum(IFNULL(i.amount, 0)) as total_ingresos from operations i where  MONTH(i.operation_date)=#{numMonthsMap.order2} and i.user_business_id_fk=#{operationSummary.userBusinessIdFk} and i.account_id_fk=1) i, " +
            "(select sum(IFNULL(g.amount, 0)) as total_gastos from operations g where  MONTH(g.operation_date)=#{numMonthsMap.order2} and g.user_business_id_fk=#{operationSummary.userBusinessIdFk} and g.account_id_fk=2) g " +
            "union " +
            "select 3 as 'order', m.num_mes as numMonth,IFNULL(i.total_ingresos, 0) as totalIncome, IFNULL(g.total_gastos, 0) as totalExpense, #{operationSummary.userBusinessIdFk} as userBusinessIdFk from " +
            "(select #{numMonthsMap.order3} as num_mes from dual) m, " +
            "(select sum(IFNULL(i.amount, 0)) as total_ingresos from operations i where MONTH(i.operation_date)=#{numMonthsMap.order3} and i.user_business_id_fk=#{operationSummary.userBusinessIdFk} and i.account_id_fk=1) i, " +
            "(select sum(IFNULL(g.amount, 0)) as total_gastos from operations g where MONTH(g.operation_date)=#{numMonthsMap.order3} and g.user_business_id_fk=#{operationSummary.userBusinessIdFk} and g.account_id_fk=2) g;")
    List<OperationSummary> listOrderSummaryFrom(@Param("operationSummary") OperationSummary operationSummary, @Param("numMonthsMap") Map<String, Integer> numMonthsMap);

}
