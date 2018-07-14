package pe.edu.upc.RsReport.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.RsReport.exception.ResourceException;
import pe.edu.upc.RsReport.models.OperationSummary;
import pe.edu.upc.RsReport.services.OperationSummaryService;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping(value = "/operations/reports")
public class OperationSummaryController {

    private static final Logger LOGGER = LogManager.getLogger(OperationSummaryController.class);

    @Autowired
    OperationSummaryService operationSummaryService;

    @GetMapping
    public ResponseEntity<List<OperationSummary>> listOperationReportFrom(@RequestParam(value = "user_business_id_fk") Integer userBusinessIdFk,
                                                                          @RequestParam(value = "num_month", required = false) Integer numMonth) {

        LOGGER.info("listOperationFrom(), userBusinessId: {}: , userBusinessIdFk: {}, numMonth: {}", userBusinessIdFk, numMonth);
        List<OperationSummary> operationSummaries;
        OperationSummary operationSummary = new OperationSummary();
        operationSummary.setUserBusinessIdFk(userBusinessIdFk);
        operationSummary.setNumMonth(numMonth);
        try {
            operationSummaries = operationSummaryService.listOrderSummaryFrom(operationSummary);

            LOGGER.info("operationSummaries: " + operationSummaries);
        } catch (ResourceException e) {
            LOGGER.error("error recurso detectado: ", e);
            return ResponseEntity.status(e.getHttpStatus()).body(null);
        } catch (Exception e) {
            LOGGER.error("", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
        if (operationSummaries == null) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok().body(operationSummaries);
    }

}
