package pe.edu.upc.RsReport.repositories;

import pe.edu.upc.RsReport.models.OperationSummary;

import java.util.List;

public interface OperationSummaryDao {
    List<OperationSummary> listOrderSummaryFrom(OperationSummary operationSummary);
}
