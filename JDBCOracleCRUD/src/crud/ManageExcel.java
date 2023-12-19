package crud;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
//import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import obj.Initialization;

public class ManageExcel {

	public static void generateReport(ResultSet selectResult) {

		System.out.println("12e");

		String excelFile = "out.xlsx";
		File excel = new File(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook();


		System.out.println("Preparing Excel file");
		XSSFSheet sheet1 = workbook.createSheet("SELECT ALL");

		System.out.println("Preparing Excel sheets");
//		IndexedColorMap colorMap = workbook.getStylesSource().getIndexedColors();
//		XSSFColor colorBlackL1 = new XSSFColor(new byte[]{(byte) 89, (byte) 89, (byte) 89}, colorMap); // Black (Light) (Content)
//		XSSFColor colorBlackL2 = new XSSFColor(new byte[]{(byte) 64, (byte) 64, (byte) 64}, colorMap); // Black (Dark) (Content)
//		XSSFColor colorBlue = new XSSFColor(new byte[]{(byte) 68, (byte) 114, (byte) 199}, colorMap); // Light Blue (Header)
//		XSSFColor colorBlueL1 = new XSSFColor(new byte[]{(byte) 219, (byte) 224, (byte) 243}, colorMap); // Light Blue (Pivot)
//		XSSFColor colorBlueL2 = new XSSFColor(new byte[]{(byte) 179,(byte) 198,(byte) 231}, colorMap); // Normal Blue (Pivot)
//		XSSFColor colorBlueL3 = new XSSFColor(new byte[]{32,55,99}, colorMap); // Dark Blue (Pivot)
//		XSSFColor colorFlesh = new XSSFColor(new byte[]{(byte) 255,(byte) 242,(byte) 204}, colorMap); // Mild Yellow (Comment)
//		XSSFColor colorGreen = new XSSFColor(new byte[]{112,(byte) 172,72}, colorMap); // Light Green (Header)
//		XSSFColor colorGreenL1 = new XSSFColor(new byte[]{(byte) 198,(byte) 239,(byte) 205}, colorMap); // Light Green (Good)
//		XSSFColor colorGreenL2 = new XSSFColor(new byte[]{0,97,0}, colorMap); // Light Blue (Good)
//		XSSFColor colorRed = new XSSFColor(new byte[]{(byte) 168,0,0}, colorMap); // Light Blue (Header)
//		XSSFColor colorRedL1 = new XSSFColor(new byte[]{(byte) 255,(byte) 200,(byte) 206}, colorMap); // Light Blue (Bad)
//		XSSFColor colorRedL2 = new XSSFColor(new byte[]{(byte) 164,0,0}, colorMap); // Light Blue (Bad)
//		XSSFColor colorWhite = new XSSFColor(new byte[]{(byte) 255,(byte) 255,(byte) 254}, colorMap); // Light Blue (Header)
//		XSSFColor colorYellowL1 = new XSSFColor(new byte[]{(byte) 254,(byte) 235,(byte) 156}, colorMap); // Light Yellow (Neutral)
//		XSSFColor colorYellowL2 = new XSSFColor(new byte[]{(byte) 157,98,0}, colorMap); // Light Yellow (Neutral)

		System.out.println("Preparing Excel colors");
		XSSFFont fontHeaderWhite = workbook.createFont();
		XSSFFont fontHeaderWhiteBold = workbook.createFont();
		XSSFFont fontContentComment = workbook.createFont();
		XSSFFont fontContentBad = workbook.createFont();
		XSSFFont fontContentGood = workbook.createFont();
		XSSFFont fontContentNeutral = workbook.createFont();
//		fontHeaderWhite.setColor(colorWhite);
//		fontHeaderWhiteBold.setColor(colorWhite);
//		fontHeaderWhiteBold.setBold(true);
//		fontContentBad.setColor(colorRedL2);
//		fontContentGood.setColor(colorGreenL2);
//		fontContentNeutral.setColor(colorYellowL2);
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
		headerBlue.setAlignment(HorizontalAlignment.CENTER);
		headerBlue.setVerticalAlignment(VerticalAlignment.CENTER);
		headerGreen.setAlignment(HorizontalAlignment.CENTER);
		headerGreen.setVerticalAlignment(VerticalAlignment.CENTER);
		headerRed.setAlignment(HorizontalAlignment.CENTER);
		headerRed.setVerticalAlignment(VerticalAlignment.CENTER);
		content.setAlignment(HorizontalAlignment.LEFT);
		content.setVerticalAlignment(VerticalAlignment.TOP);
		contentDate.setAlignment(HorizontalAlignment.LEFT);
		contentDate.setVerticalAlignment(VerticalAlignment.TOP);
		contentDateLong.setAlignment(HorizontalAlignment.LEFT);
		contentDateLong.setVerticalAlignment(VerticalAlignment.TOP);
		contentCenterCenter.setAlignment(HorizontalAlignment.CENTER);
		contentCenterCenter.setVerticalAlignment(VerticalAlignment.CENTER);
		contentComment.setAlignment(HorizontalAlignment.LEFT);
		contentComment.setVerticalAlignment(VerticalAlignment.TOP);
		contentBad.setAlignment(HorizontalAlignment.CENTER);
		contentBad.setVerticalAlignment(VerticalAlignment.CENTER);
		contentGood.setAlignment(HorizontalAlignment.CENTER);
		contentGood.setVerticalAlignment(VerticalAlignment.CENTER);
		contentNeutral.setAlignment(HorizontalAlignment.CENTER);
		contentNeutral.setVerticalAlignment(VerticalAlignment.CENTER);
		contentBlackL1.setAlignment(HorizontalAlignment.CENTER);
		contentBlackL1.setVerticalAlignment(VerticalAlignment.CENTER);
		contentBlackL2.setAlignment(HorizontalAlignment.CENTER);
		contentBlackL2.setVerticalAlignment(VerticalAlignment.CENTER);
		pivotContent.setAlignment(HorizontalAlignment.CENTER);
		pivotContent.setVerticalAlignment(VerticalAlignment.CENTER);
		pivotHeader1.setAlignment(HorizontalAlignment.CENTER);
		pivotHeader1.setVerticalAlignment(VerticalAlignment.CENTER);
		pivotHeader2.setAlignment(HorizontalAlignment.CENTER);
		pivotHeader2.setVerticalAlignment(VerticalAlignment.CENTER);

		System.out.println("Preparing Excel text wraps to excel styles");
		// content.setWrapText(true);
		contentComment.setWrapText(true);
		// contentBlackL1.setWrapText(true);
		// contentBlackL2.setWrapText(true);
		// headerBlue.setWrapText(true);
		// headerGreen.setWrapText(true);
		// headerRed.setWrapText(true);

		System.out.println("Preparing Excel cell borders to excel styles");
		content.setBorderBottom(BorderStyle.THIN);
		content.setBorderTop(BorderStyle.THIN);
		content.setBorderRight(BorderStyle.THIN);
		content.setBorderLeft(BorderStyle.THIN);
		contentDate.setBorderBottom(BorderStyle.THIN);
		contentDate.setBorderTop(BorderStyle.THIN);
		contentDate.setBorderRight(BorderStyle.THIN);
		contentDate.setBorderLeft(BorderStyle.THIN);
		contentDateLong.setBorderBottom(BorderStyle.THIN);
		contentDateLong.setBorderTop(BorderStyle.THIN);
		contentDateLong.setBorderRight(BorderStyle.THIN);
		contentDateLong.setBorderLeft(BorderStyle.THIN);
		contentCenterCenter.setBorderBottom(BorderStyle.THIN);
		contentCenterCenter.setBorderTop(BorderStyle.THIN);
		contentCenterCenter.setBorderRight(BorderStyle.THIN);
		contentCenterCenter.setBorderLeft(BorderStyle.THIN);
		contentComment.setBorderBottom(BorderStyle.THIN);
		contentComment.setBorderTop(BorderStyle.THIN);
		contentComment.setBorderRight(BorderStyle.THIN);
		contentComment.setBorderLeft(BorderStyle.THIN);
		contentBad.setBorderBottom(BorderStyle.THIN);
		contentBad.setBorderBottom(BorderStyle.THIN);
		contentBad.setBorderTop(BorderStyle.THIN);
		contentBad.setBorderRight(BorderStyle.THIN);
		contentBad.setBorderLeft(BorderStyle.THIN);
		contentGood.setBorderBottom(BorderStyle.THIN);
		contentGood.setBorderTop(BorderStyle.THIN);
		contentGood.setBorderRight(BorderStyle.THIN);
		contentGood.setBorderLeft(BorderStyle.THIN);
		contentNeutral.setBorderBottom(BorderStyle.THIN);
		contentNeutral.setBorderTop(BorderStyle.THIN);
		contentNeutral.setBorderRight(BorderStyle.THIN);
		contentNeutral.setBorderLeft(BorderStyle.THIN);
		contentBlackL1.setBorderBottom(BorderStyle.THIN);
		contentBlackL1.setBorderTop(BorderStyle.THIN);
		contentBlackL1.setBorderRight(BorderStyle.THIN);
		contentBlackL1.setBorderLeft(BorderStyle.THIN);
		contentBlackL2.setBorderBottom(BorderStyle.THIN);
		contentBlackL2.setBorderTop(BorderStyle.THIN);
		contentBlackL2.setBorderRight(BorderStyle.THIN);
		contentBlackL2.setBorderLeft(BorderStyle.THIN);
		headerBlue.setBorderBottom(BorderStyle.THIN);
		headerBlue.setBorderTop(BorderStyle.THIN);
		headerBlue.setBorderRight(BorderStyle.THIN);
		headerBlue.setBorderLeft(BorderStyle.THIN);
		headerGreen.setBorderBottom(BorderStyle.THIN);
		headerGreen.setBorderTop(BorderStyle.THIN);
		headerGreen.setBorderRight(BorderStyle.THIN);
		headerGreen.setBorderLeft(BorderStyle.THIN);
		headerRed.setBorderBottom(BorderStyle.THIN);
		headerRed.setBorderTop(BorderStyle.THIN);
		headerRed.setBorderRight(BorderStyle.THIN);
		headerRed.setBorderLeft(BorderStyle.THIN);

		System.out.println("Preparing excel fill patterns as solid foreground");
		contentComment.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		contentBad.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		contentGood.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		contentNeutral.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		contentBlackL1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		contentBlackL2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerBlue.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		headerRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		pivotContent.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		pivotHeader1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		pivotHeader2.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		System.out.println("Preparing excel fill patterns to excel styles");
//		contentComment.setFillForegroundColor(colorFlesh);
//		contentBad.setFillForegroundColor(colorRedL1);
//		contentGood.setFillForegroundColor(colorGreenL1);
//		contentNeutral.setFillForegroundColor(colorYellowL1);
//		contentBlackL1.setFillForegroundColor(colorBlackL1);
//		contentBlackL2.setFillForegroundColor(colorBlackL2);
//		headerBlue.setFillForegroundColor(colorBlue);
//		headerGreen.setFillForegroundColor(colorGreen);
//		headerRed.setFillForegroundColor(colorRed);
//		pivotContent.setFillForegroundColor(colorBlueL2);
//		pivotHeader1.setFillForegroundColor(colorBlueL3);
//		pivotHeader2.setFillForegroundColor(colorBlueL1);

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

		try {
			while (selectResult.next()) {

				rowContent = sheet1.createRow(counter++);
				cell = rowContent.createCell(0);cell.setCellValue(selectResult.getInt(Initialization._DB_TABLE_COL1_N_ID));cell.setCellStyle(content);
				Blob obj_b = selectResult.getBlob(Initialization._DB_TABLE_COL2_N_CONTENT);
				byte[] byte_arr = obj_b.getBytes(1, (int) obj_b.length());
				int inputImagePictureID1 = workbook.addPicture(byte_arr, Workbook.PICTURE_TYPE_PNG);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("asd");

		sheet1.autoSizeColumn(0);
		sheet1.autoSizeColumn(1);
		sheet1.autoSizeColumn(2);
		sheet1.autoSizeColumn(3);
		sheet1.autoSizeColumn(4);
		sheet1.autoSizeColumn(5);


		try{
			FileOutputStream out = new FileOutputStream(excel);
			workbook.write(out);
			out.close();
			workbook.close();
			System.out.println("excel report complete");
		}catch(FileNotFoundException e){
			System.out.println("excel report failed");
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

	}

}
