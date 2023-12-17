package crud;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;

import org.apache.poi.xssf.usermodel.XSSFColor;

import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import obj.Initialization;

public class ManageExcel {

	public static void generateReport(ResultSet selectResult) {

		System.out.println("Preparing Excel file");
		String excelFile = "out.xlsx";
		File excel = new File(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("SELECT ALL");

		System.out.println("Preparing Excel sheets");
		XSSFColor colorBlackL1 = new XSSFColor(new java.awt.Color(89,89,89)); // Black (Light) (Content)
		XSSFColor colorBlackL2 = new XSSFColor(new java.awt.Color(64,64,64)); // Black (Dark) (Content)
		XSSFColor colorBlue = new XSSFColor(new java.awt.Color(68,114,199)); // Light Blue (Header)
		XSSFColor colorBlueL1 = new XSSFColor(new java.awt.Color(219,224,243)); // Light Blue (Pivot)
		XSSFColor colorBlueL2 = new XSSFColor(new java.awt.Color(179,198,231)); // Normal Blue (Pivot)
		XSSFColor colorBlueL3 = new XSSFColor(new java.awt.Color(32,55,99)); // Dark Blue (Pivot)
		XSSFColor colorFlesh = new XSSFColor(new java.awt.Color(255,242,204)); // Mild Yellow (Comment)
		XSSFColor colorGreen = new XSSFColor(new java.awt.Color(112,172,72)); // Light Green (Header)
		XSSFColor colorGreenL1 = new XSSFColor(new java.awt.Color(198,239,205)); // Light Green (Good)
		XSSFColor colorGreenL2 = new XSSFColor(new java.awt.Color(0,97,0)); // Light Blue (Good)
		XSSFColor colorRed = new XSSFColor(new java.awt.Color(168,0,0)); // Light Blue (Header)
		XSSFColor colorRedL1 = new XSSFColor(new java.awt.Color(255,200,206)); // Light Blue (Bad)
		XSSFColor colorRedL2 = new XSSFColor(new java.awt.Color(164,0,0)); // Light Blue (Bad)
		XSSFColor colorWhite = new XSSFColor(new java.awt.Color(255,255,254)); // Light Blue (Header)
		XSSFColor colorYellowL1 = new XSSFColor(new java.awt.Color(254,235,156)); // Light Yellow (Neutral)
		XSSFColor colorYellowL2 = new XSSFColor(new java.awt.Color(157,98,0)); // Light Yellow (Neutral)

		System.out.println("Preparing Excel colors");
		XSSFFont fontHeaderWhite = workbook.createFont();
		XSSFFont fontHeaderWhiteBold = workbook.createFont();
		XSSFFont fontContentComment = workbook.createFont();
		XSSFFont fontContentBad = workbook.createFont();
		XSSFFont fontContentGood = workbook.createFont();
		XSSFFont fontContentNeutral = workbook.createFont();
		fontHeaderWhite.setColor(colorWhite);
		fontHeaderWhiteBold.setColor(colorWhite);
		fontHeaderWhiteBold.setBold(true);
		fontContentBad.setColor(colorRedL2);
		fontContentGood.setColor(colorGreenL2);
		fontContentNeutral.setColor(colorYellowL2);
		fontContentComment.setFontHeight((short)(8*20)); // Actual font size is 8, multiplied by 20

		System.out.println("Preparing Excel fonts");
		XSSFCellStyle headerBlue = workbook.createCellStyle();
		XSSFCellStyle headerGreen = workbook.createCellStyle();
		XSSFCellStyle headerRed = workbook.createCellStyle();
		XSSFCellStyle content = workbook.createCellStyle();
		XSSFCellStyle contentDate = workbook.createCellStyle();
		XSSFCellStyle contentDateLong = workbook.createCellStyle();
		XSSFCellStyle contentCenterCenter = workbook.createCellStyle();
		XSSFCellStyle contentComment = workbook.createCellStyle();
		XSSFCellStyle contentBad = workbook.createCellStyle();
		XSSFCellStyle contentGood = workbook.createCellStyle();
		XSSFCellStyle contentNeutral = workbook.createCellStyle();
		XSSFCellStyle contentBlackL1 = workbook.createCellStyle();
		XSSFCellStyle contentBlackL2 = workbook.createCellStyle();
		XSSFCellStyle pivotContent = workbook.createCellStyle();
		XSSFCellStyle pivotHeader1 = workbook.createCellStyle();
		XSSFCellStyle pivotHeader2 = workbook.createCellStyle();

		System.out.println("Preparing Excel width and height");
		XSSFRow headerRow = null;
		XSSFRow rowContent = null;

		System.out.println("Preparing Excel styles");
		headerBlue.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		headerBlue.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		headerGreen.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		headerGreen.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		headerRed.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		headerRed.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		content.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		content.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
		contentDate.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		contentDate.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
		contentDateLong.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		contentDateLong.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
		contentCenterCenter.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		contentCenterCenter.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		contentComment.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		contentComment.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
		contentBad.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		contentBad.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		contentGood.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		contentGood.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		contentNeutral.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		contentNeutral.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		contentBlackL1.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		contentBlackL1.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		contentBlackL2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		contentBlackL2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		pivotContent.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		pivotContent.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		pivotHeader1.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		pivotHeader1.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		pivotHeader2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		pivotHeader2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

		System.out.println("Preparing Excel text wraps to excel styles");
		// content.setWrapText(true);
		contentComment.setWrapText(true);
		// contentBlackL1.setWrapText(true);
		// contentBlackL2.setWrapText(true);
		// headerBlue.setWrapText(true);
		// headerGreen.setWrapText(true);
		// headerRed.setWrapText(true);

		System.out.println("Preparing Excel cell borders to excel styles");
		content.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		content.setBorderTop(XSSFCellStyle.BORDER_THIN);
		content.setBorderRight(XSSFCellStyle.BORDER_THIN);
		content.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		contentDate.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		contentDate.setBorderTop(XSSFCellStyle.BORDER_THIN);
		contentDate.setBorderRight(XSSFCellStyle.BORDER_THIN);
		contentDate.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		contentDateLong.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		contentDateLong.setBorderTop(XSSFCellStyle.BORDER_THIN);
		contentDateLong.setBorderRight(XSSFCellStyle.BORDER_THIN);
		contentDateLong.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		contentCenterCenter.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		contentCenterCenter.setBorderTop(XSSFCellStyle.BORDER_THIN);
		contentCenterCenter.setBorderRight(XSSFCellStyle.BORDER_THIN);
		contentCenterCenter.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		contentComment.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		contentComment.setBorderTop(XSSFCellStyle.BORDER_THIN);
		contentComment.setBorderRight(XSSFCellStyle.BORDER_THIN);
		contentComment.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		contentBad.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		contentBad.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		contentBad.setBorderTop(XSSFCellStyle.BORDER_THIN);
		contentBad.setBorderRight(XSSFCellStyle.BORDER_THIN);
		contentBad.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		contentGood.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		contentGood.setBorderTop(XSSFCellStyle.BORDER_THIN);
		contentGood.setBorderRight(XSSFCellStyle.BORDER_THIN);
		contentGood.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		contentNeutral.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		contentNeutral.setBorderTop(XSSFCellStyle.BORDER_THIN);
		contentNeutral.setBorderRight(XSSFCellStyle.BORDER_THIN);
		contentNeutral.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		contentBlackL1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		contentBlackL1.setBorderTop(XSSFCellStyle.BORDER_THIN);
		contentBlackL1.setBorderRight(XSSFCellStyle.BORDER_THIN);
		contentBlackL1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		contentBlackL2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		contentBlackL2.setBorderTop(XSSFCellStyle.BORDER_THIN);
		contentBlackL2.setBorderRight(XSSFCellStyle.BORDER_THIN);
		contentBlackL2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		headerBlue.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		headerBlue.setBorderTop(XSSFCellStyle.BORDER_THIN);
		headerBlue.setBorderRight(XSSFCellStyle.BORDER_THIN);
		headerBlue.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		headerGreen.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		headerGreen.setBorderTop(XSSFCellStyle.BORDER_THIN);
		headerGreen.setBorderRight(XSSFCellStyle.BORDER_THIN);
		headerGreen.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		headerRed.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		headerRed.setBorderTop(XSSFCellStyle.BORDER_THIN);
		headerRed.setBorderRight(XSSFCellStyle.BORDER_THIN);
		headerRed.setBorderLeft(XSSFCellStyle.BORDER_THIN);

		System.out.println("Preparing excel fill patterns as solid foreground");
		contentComment.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		contentBad.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		contentGood.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		contentNeutral.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		contentBlackL1.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		contentBlackL2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		headerBlue.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		headerGreen.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		headerRed.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		pivotContent.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		pivotHeader1.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		pivotHeader2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

		System.out.println("Preparing excel fill patterns to excel styles");
		contentComment.setFillForegroundColor(colorFlesh);
		contentBad.setFillForegroundColor(colorRedL1);
		contentGood.setFillForegroundColor(colorGreenL1);
		contentNeutral.setFillForegroundColor(colorYellowL1);
		contentBlackL1.setFillForegroundColor(colorBlackL1);
		contentBlackL2.setFillForegroundColor(colorBlackL2);
		headerBlue.setFillForegroundColor(colorBlue);
		headerGreen.setFillForegroundColor(colorGreen);
		headerRed.setFillForegroundColor(colorRed);
		pivotContent.setFillForegroundColor(colorBlueL2);
		pivotHeader1.setFillForegroundColor(colorBlueL3);
		pivotHeader2.setFillForegroundColor(colorBlueL1);

		System.out.println("Applying fonts to excel styles");
		contentComment.setFont(fontContentComment);
		contentBad.setFont(fontContentBad);
		contentGood.setFont(fontContentGood);
		contentNeutral.setFont(fontContentNeutral);
		contentBlackL1.setFont(fontHeaderWhite);
		contentBlackL2.setFont(fontHeaderWhite);
		headerBlue.setFont(fontHeaderWhite);
		headerGreen.setFont(fontHeaderWhite);
		headerRed.setFont(fontHeaderWhite);
		pivotHeader1.setFont(fontHeaderWhiteBold);

		System.out.println("Applying cell data format");
		short dFDate = workbook.createDataFormat().getFormat("dd-mmm-yyyy hh:mm:ss");
		short dFDateOnly= workbook.createDataFormat().getFormat("mmmm dd yyyy, dddd");
		contentDate.setDataFormat(dFDate);
		contentDateLong.setDataFormat(dFDateOnly);

		Integer counter = 0;
		headerRow = sheet1.createRow(counter++);
		XSSFCell cell = headerRow.createCell(0); cell.setCellValue(Initialization._DB_TABLE_COL1_N_ID); cell.setCellStyle(headerBlue);
		cell = headerRow.createCell(1); cell.setCellValue(Initialization._DB_TABLE_COL2_N_CONTENT); cell.setCellStyle(headerBlue);
		cell = headerRow.createCell(2); cell.setCellValue(Initialization._DB_TABLE_COL3_N_NAME); cell.setCellStyle(headerBlue);
		cell = headerRow.createCell(3); cell.setCellValue(Initialization._DB_TABLE_COL4_N_DESC); cell.setCellStyle(headerBlue);
		cell = headerRow.createCell(4); cell.setCellValue(Initialization._DB_TABLE_COL5_N_TYPE); cell.setCellStyle(headerBlue);
		cell = headerRow.createCell(5); cell.setCellValue(Initialization._DB_TABLE_COL6_N_CREATED); cell.setCellStyle(headerBlue);

		XSSFDrawing drawing = sheet1.createDrawingPatriarch();
		XSSFClientAnchor pictureAnchor = new XSSFClientAnchor();

		while (selectResult.next()) {

			rowContent = sheet1.createRow(counter++);
			cell = rowContent.createCell(0);cell.setCellValue(selectResult.getInt(Initialization._DB_TABLE_COL1_N_ID));cell.setCellStyle(content);
			Blob obj_b = selectResult.getBlob(Initialization._DB_TABLE_COL2_N_CONTENT);
			byte[] byte_arr = obj_b.getBytes(1, (int) obj_b.length());
			int inputImagePictureID1 = workbook.addPicture(byte_arr, XSSFWorkbook.PICTURE_TYPE_PNG);
			pictureAnchor.setCol1(2);
			pictureAnchor.setCol2(3);
			pictureAnchor.setRow1(counter);
			pictureAnchor.setRow2(counter+1);
			drawing.createPicture(pictureAnchor, inputImagePictureID1);
			cell = rowContent.createCell(2);cell.setCellValue(selectResult.getString(Initialization._DB_TABLE_COL3_N_NAME));cell.setCellStyle(content);
			cell = rowContent.createCell(3);cell.setCellValue(selectResult.getString(Initialization._DB_TABLE_COL4_N_DESC));cell.setCellStyle(content);
			cell = rowContent.createCell(4);cell.setCellValue(selectResult.getString(Initialization._DB_TABLE_COL5_N_TYPE));cell.setCellStyle(content);
			cell = rowContent.createCell(5);cell.setCellValue((selectResult.getDate(Initialization._DB_TABLE_COL6_N_CREATED)==null)?null:selectResult.getDate(Initialization._DB_TABLE_COL6_N_CREATED));cell.setCellStyle(contentDate);

		}

		sheet1.autoSizeColumn(0);
		sheet1.autoSizeColumn(1);
		sheet1.autoSizeColumn(2);
		sheet1.autoSizeColumn(3);
		sheet1.autoSizeColumn(4);
		sheet1.autoSizeColumn(5);

		try{
			FileOutputStream out = new FileOutputStream(excelFile);
			workbook.write(out);
			out.close();
			System.out.println("excel report complete");
		}catch(FileNotFoundException e){
			System.out.println("excel report failed");
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

	}

}
