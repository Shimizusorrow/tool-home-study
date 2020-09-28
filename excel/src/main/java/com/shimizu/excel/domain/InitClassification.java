package com.shimizu.excel.domain;

import com.shimizu.excel.domain.level.FirstClassification;
import com.shimizu.excel.domain.level.FourthClassification;
import com.shimizu.excel.domain.level.SecondClassification;
import com.shimizu.excel.domain.level.ThirdClassification;
import com.shimizu.excel.repo.EquipClassificationRepo;
import com.shimizu.excel.utils.ExcelUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/21 14:47
 */
@RestController
@RequestMapping("/init")
@AllArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class InitClassification {
    private EquipClassificationRepo equipClassificationRepo;
    private Environment environment;

    @Value("classpath:zbInf.xlsx")
    private Resource resource;

    @GetMapping("/classification")
    public void initClassification(@RequestParam String fileName) throws Exception {
        String dir = System.getProperty("user.dir");
        log.info(System.getProperty("user.dir"));
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        Workbook wb;
        Sheet sheet;
        final String filePath = dir + "\\" + fileName;
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
                            list.add(ExcelUtils.getCellValue(cell));
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

//        data.forEach(its
//                -> its.forEach(it -> {
//            System.out.println(it);
//            System.out.println("-------");
//        }));

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

        List<EquipClassification> list = data.stream().map(its -> {
            return new EquipClassification(
                    String.valueOf(new Random().nextInt()),
                    new FirstClassification(its.get(1), its.get(2)),
                    new SecondClassification(its.get(3), its.get(4)),
                    new ThirdClassification(its.get(5), its.get(6)),
                    new FourthClassification(its.get(7), its.get(8))
            );
        }).collect(Collectors.toList());

        equipClassificationRepo.saveAll(list);
    }

    private String getFilePath() {
        return System.getProperty("user.dir");
    }
}
