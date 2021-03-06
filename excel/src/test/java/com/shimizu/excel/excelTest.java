package com.shimizu.excel;


import com.shimizu.excel.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/21 11:42
 */
@ExtendWith(SpringExtension.class)
@Slf4j
public class excelTest {

    final String excelPath = "C:\\Users\\Shimizu\\Desktop\\装备信息模板.xlsx";
    private final String ExcelName = "";
    private final String SHEET_NAME = "";

    @Test
    void useGetData() throws Exception {
//        getData(ExcelName, SHEET_NAME);
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    void test() {
        Workbook wb = null;
        File excel = new File(excelPath);
        try {
            String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
//            System.out.println(split[1]);
            if ("xls".equals(split[1])) {
                FileInputStream fis = new FileInputStream(excel);   //文件流对象
                wb = new HSSFWorkbook(fis);
            } else if ("xlsx".equals(split[1])) {
                wb = new XSSFWorkbook(excel);
            } else {
                System.out.println("文件类型错误!");
            }

            //开始解析
            wb.getNumberOfSheets();
            Sheet sheet = wb.getSheetAt(1);     //读取sheet 0

            int firstRowIndex = sheet.getFirstRowNum() + 1;   //第一行是列名，所以不读
            int lastRowIndex = sheet.getLastRowNum();
            System.out.println("firstRowIndex: " + firstRowIndex);
            System.out.println("lastRowIndex: " + lastRowIndex);

            for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {
                System.out.println("rIndex: " + rIndex);
                Row row = sheet.getRow(rIndex);
                if (row != null) {
                    int firstCellIndex = row.getFirstCellNum();
                    int lastCellIndex = row.getLastCellNum();
                    System.out.println("firstCellIndex: " + firstCellIndex);
                    System.out.println("lastCellIndex: " + lastCellIndex);
                    for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                        Cell cell = row.getCell(cIndex);
                        String s = ExcelUtils.isCombineCell(ExcelUtils.getCombineCell(sheet), cell, sheet);
                        if (!s.isEmpty()) {
                            System.out.println(s);
                        } else {
                            String cellValue = ExcelUtils.getCellValue(cell);
                            if (cell == null || cellValue.equals("")) {
                                break;
                            }
                            System.out.println(cellValue);
                        }
                    }
                }
            }

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2() throws Exception {
        String dir = System.getProperty("user.dir");
        log.info(System.getProperty("user.dir"));
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        Workbook wb;
        Sheet sheet;
        final String filePath = dir + "\\" + "zbInf.xlsx";
        File excel = new File(filePath);
        if (!excel.exists()) {
            throw new Exception("文件不存在,清检查路径文件" + filePath);
        }
        try {
            wb = new XSSFWorkbook(excel);
            sheet = wb.getSheet("装备基础类别信息表");
            //合并单元格的 列表
            List<CellRangeAddress> combineCell = ExcelUtils.getCombineCell(sheet);
            //第一行是列名，所以不读
            int firstRowIndex = sheet.getFirstRowNum() + 1;
            int lastRowIndex = sheet.getLastRowNum();

            for (int rIndex = firstRowIndex; rIndex < lastRowIndex; rIndex++) {
                Row row = sheet.getRow(rIndex);
                if (row != null) {
                    ArrayList<String> list = new ArrayList<>();
                    int firstCellIndex = row.getFirstCellNum();
                    int lastCellIndex = row.getLastCellNum();
                    for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {
                        Cell cell = row.getCell(cIndex);
                        String cellValue = ExcelUtils.isCombineCell(combineCell, cell, sheet);
                        if (cellValue == null) {
                            if (ExcelUtils.getCellValue(cell) == null) {
                                list.add(null);
                            } else {
                                list.add(ExcelUtils.getCellValue(cell));
                            }
                        } else {
                            list.add(cellValue);
                        }
                    }
                    data.add(list);
                }
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        data.forEach(its
                        -> {
                    System.out.println(its.get(1));
                    System.out.println(its.get(2));
                    System.out.println(its.get(3));
                    System.out.println(its.get(4));
                    System.out.println(its.get(5));
                    System.out.println(its.get(6));
                    System.out.println(its.get(7));
                    System.out.println(its.get(8));
                    System.out.println("-------");
                }
        );

        System.out.println(data.size());

    }

    /**
     * 将Excel中的数据导出 以二维数组的形式
     *
     * @param fileName  Excel的名字 XXX.xlsx
     * @param sheetName 表单的名字 sheet1
     * @return
     * @throws Exception
     */
    private List<ArrayList<String>> getData(String fileName, String sheetName) throws Exception {
        String dir = System.getProperty("user.dir");
//        String dir = "D:\\work_save\\corporate\\warehouse_system";
        List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        Workbook wb;
        Sheet sheet;
        final String filePath = dir + "\\" + fileName;
        File excel = new File(filePath);
        if (!excel.exists()) {
            throw new Exception("文件不存在,请检查路径文件!" + filePath);
        }
        if (sheetName == null || sheetName.isEmpty()) {
            throw new Exception("表单名字不可为空!");
        }
        try {
            wb = new XSSFWorkbook(excel);
            sheet = wb.getSheet(sheetName);
            //校验表单是否存在
            if (sheet == null) {
                throw new Exception(String.format("表单不存在!请校验表单名字: %s 是否填写正确", fileName));
            }
            //合并单元格的 列表
            List<CellRangeAddress> combineCell = ExcelUtils.getCombineCell(sheet);
            //第一行是列名，所以不读
            int firstRowIndex = sheet.getFirstRowNum() + 1;
            int lastRowIndex = sheet.getLastRowNum();

            for (int rIndex = firstRowIndex; rIndex < lastRowIndex; rIndex++) {
                Row row = sheet.getRow(rIndex);
                if (row != null) {
                    ArrayList<String> list = new ArrayList<>();
                    int firstCellIndex = row.getFirstCellNum();
                    int lastCellIndex = row.getLastCellNum();
                    for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {
                        Cell cell = row.getCell(cIndex);
                        if (cell != null) {
                            //判断是否是合并的单元格 如果是则返回合并单元格的值
                            String cellValue = ExcelUtils.isCombineCell(combineCell, cell, sheet);
                            if (cellValue != null) {
                                list.add(cellValue);
                            } else {
                                list.add(ExcelUtils.getCellValue(cell));
                            }
                        } else {
                            list.add("");
                        }
                    }
                    //添加 这一行的数据
                    data.add(list);
                }
            }
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
        /**
         * 导入过滤
         */
        return data.stream()
                .filter(it -> !it.isEmpty())
                .filter(it -> !"".equals(it.get(0)))
                .collect(Collectors.toList());
    }
}
