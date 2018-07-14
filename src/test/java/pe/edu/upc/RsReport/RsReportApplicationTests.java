package pe.edu.upc.RsReport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.upc.RsReport.mappers.OperationSummaryMapper;
import pe.edu.upc.RsReport.models.OperationSummary;
import pe.edu.upc.RsReport.services.OperationSummaryService;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RsReportApplicationTests {

    private static final Logger LOGGER = LogManager.getLogger(RsReportApplicationTests.class);

    @Autowired
    OperationSummaryMapper summaryMapper;

    @Autowired
    OperationSummaryService operationSummaryService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void listMapperOperationSummary() {
        OperationSummary operationSummary = new OperationSummary();
        operationSummary.setUserBusinessIdFk(1);
        Map<String, Integer> numMonthsMap = new HashMap<>();
        numMonthsMap.put("order1", 0);
        numMonthsMap.put("order2", 0);
        numMonthsMap.put("order3", 7);
        LOGGER.info(summaryMapper.listOrderSummaryFrom(operationSummary, numMonthsMap));
    }

    @Test
    public void listServiceOperationSummary() {
        OperationSummary operationSummary = new OperationSummary();
        operationSummary.setUserBusinessIdFk(1);
        operationSummary.setNumMonth(7);
        LOGGER.info(operationSummaryService.listOrderSummaryFrom(operationSummary));
    }

}
