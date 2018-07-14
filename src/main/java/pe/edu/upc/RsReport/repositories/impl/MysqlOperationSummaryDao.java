package pe.edu.upc.RsReport.repositories.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.upc.RsReport.mappers.OperationSummaryMapper;
import pe.edu.upc.RsReport.models.OperationSummary;
import pe.edu.upc.RsReport.repositories.OperationSummaryDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MysqlOperationSummaryDao implements OperationSummaryDao {

    private static final Logger LOGGER = LogManager.getLogger(MysqlOperationSummaryDao.class);

    @Autowired
    OperationSummaryMapper summaryMapper;

    @Override
    public List<OperationSummary> listOrderSummaryFrom(OperationSummary operationSummary) {

        Map<String, Integer> numMonthsMap = new HashMap<>();
        int intMonth = operationSummary.getNumMonth();
        numMonthsMap.put("order3", intMonth);
        numMonthsMap.put("order2", (intMonth == 1) ? 0 : --intMonth);
        numMonthsMap.put("order1", (intMonth == 1) ? 0 : --intMonth);

        return summaryMapper.listOrderSummaryFrom(operationSummary, numMonthsMap);
    }
}
