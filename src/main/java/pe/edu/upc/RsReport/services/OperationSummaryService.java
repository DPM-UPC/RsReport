package pe.edu.upc.RsReport.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.RsReport.models.OperationSummary;
import pe.edu.upc.RsReport.repositories.OperationSummaryDao;

import java.util.List;

@Service
public class OperationSummaryService {

    private static final Logger LOGGER = LogManager.getLogger(OperationSummaryService.class);

    @Autowired
    OperationSummaryDao operationSummaryDao;

    public List<OperationSummary> listOrderSummaryFrom(OperationSummary operationSummary) {
        LOGGER.info("listOrderSummaryFrom: operationSummary: {}", operationSummary);
        return operationSummaryDao.listOrderSummaryFrom(operationSummary);
    }

}
