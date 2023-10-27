package io.getarrays.securecapita.report;

import io.getarrays.securecapita.domain.StockItemRequisition;
import io.getarrays.securecapita.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamResource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

@Slf4j
public class StockItemRequisitionReport {

    public static final String DATE_FORMATTER = "yyyy-MM-dd hh:mm:ss";
    private XSSFWorkbook workbook;
    private Sheet sheet;
    private List<StockItemRequisition> stockItemRequisitions;
    private static String[] HEADERS = {"Requesting Department", "Date", "Department Code", "Purpose of Issue",
            "Item Description", "Date of Previous Issue", "Previous Issue Quantity", "Quantity", "Initiated By",
            "Signature", "Receiver Email"};

    public StockItemRequisitionReport(List<StockItemRequisition> stockItemRequisitions) {
        this.stockItemRequisitions = stockItemRequisitions;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("StockItemRequisitions");
        setHeaders();
    }

    private void setHeaders() {
        Row headerRow = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(14);
        style.setFont(font);
        for (int index = 0; index < HEADERS.length; index++) {
            Cell cell = headerRow.createCell(index);
            cell.setCellValue(HEADERS[index]);
            cell.setCellStyle(style);
        }
    }

    public InputStreamResource export() {
        return generateReport();
    }

    private InputStreamResource generateReport() {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            CellStyle style = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setFontHeight(10);
            style.setFont(font);
            int rowIndex = 1;
            for (StockItemRequisition stockItemRequisition : stockItemRequisitions) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(stockItemRequisition.getPreviousIssueQuantity());
                row.createCell(1).setCellValue(stockItemRequisition.getDate());
                row.createCell(2).setCellValue(stockItemRequisition.getDepartmentCode());
                row.createCell(3).setCellValue(stockItemRequisition.getPurposeOfIssue());
                row.createCell(4).setCellValue(stockItemRequisition.getItemDescription());
                row.createCell(5).setCellValue(stockItemRequisition.getDateOfPreviousIssue());
                row.createCell(6).setCellValue(stockItemRequisition.getPreviousIssueQuantity());
                row.createCell(7).setCellValue(stockItemRequisition.getQuantity());
                row.createCell(8).setCellValue(stockItemRequisition.getInitiatedBy());
                row.createCell(9).setCellValue(stockItemRequisition.getSignature());
                row.createCell(10).setCellValue(stockItemRequisition.getReceiverEmail());
            }
            workbook.write(out);
            return new InputStreamResource(new ByteArrayInputStream(out.toByteArray()));
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("Unable to export report file");
        }
    }

}