package io.getarrays.securecapita.report;

import io.getarrays.securecapita.domain.Stock;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class StoctReport {

    public static final String DATE_FORMATTER = "yyyy-MM-dd hh:mm:ss";
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Stock> stock;

    public StoctReport(List<Stock> stock) {
        this.stock = stock;
    }
//
//    private void setHeaders(){
//        Row headerRow = sheet.createRow(0);
//        CellStyle style = workbook.createCellStyle();
//        XSSFFont font = workbook.createFont();
//        font.setBold(true);
//        font.setFontHeight(14);
//        style.setFont(font);
//        range(0, HEADERS.length).forEach(index -> {
//            Cell cell = headerRow.createCell(index);
//            cell.setCellValue(HEADERS[index]);
//            cell.setCellStyle(style);
//        });
//
//    }
//
//    public InputStreamResource export() {
//        return generateReport();
//    }
//
//
//
//    private InputStreamResource generateReport() {
//        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
//            CellStyle style = workbook.createCellStyle();
//            XSSFFont font = workbook.createFont();
//            font.setFontHeight(10);
//            style.setFont(font);
//            int rowIndex = 1;
//            for(Stock stock: stock) {
//                Row row = sheet.createRow(rowIndex++);
//                row.createCell(0).setCellValue(purchaseRequests.getId());
//                row.createCell(1).setCellValue(purchaseRequests.getProductName());
//                row.createCell(2).setCellValue(purchaseRequests.getDate());
//                row.createCell(3).setCellValue(purchaseRequests.getProductCode());
//                row.createCell(4).setCellValue(purchaseRequests.getReceiverEmail());
//
//
//            }
//            workbook.write(out);
//            return new InputStreamResource(new ByteArrayInputStream(out.toByteArray()));
//        } catch (Exception exception) {
//            log.error(exception.getMessage());
//            throw new ApiException("Unable to export report file");
//        }
//    }


}
