package com.shimizu.hutool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用于解析箱Rfid
 *
 * @author shimizu
 * @date 2020年10月13日15:39:47
 */
public class BoxRfidParseUtils {
    /**
     * 解析Rfid省市编号
     *
     * @param equipRfid
     * @return
     */
    public static String parseDistrictNumber(String equipRfid) {
        return equipRfid.substring(0, 4);
    }

    /**
     * 解析Rfid装备参数编号
     *
     * @param equipRfid
     * @return
     */
    public static String parseEquipArgNumber(String equipRfid) {
        return equipRfid.substring(4, 7);
    }

    /**
     * 解析Rfid装备编号
     *
     * @param equipRfid
     * @return
     */
    public static String parseEquipClassificationNumber(String equipRfid) {
        return equipRfid.substring(7, 14);
    }

    /**
     * 解析Rfid写入者编号
     *
     * @param equipRfid
     * @return
     */
    public static String parseWriterNumber(String equipRfid) {
        return equipRfid.substring(14, 15);
    }

    /**
     * 解析Rfid写入者编号
     *
     * @param equipRfid
     * @return
     */
    public static String parseShelfLifeNumber(String equipRfid) {
        return equipRfid.substring(15, 16);
    }

    /**
     * 解析Rfid生产日期
     *
     * @param equipRfid
     * @return
     */
    public static String parseProductDateNumber(String equipRfid) {
        return equipRfid.substring(16, 20);
    }

    /**
     * 解析Rfid装备序号
     *
     * @param equipRfid
     * @return
     */
    public static String parseEquipSerialNumber(String equipRfid) {
        return equipRfid.substring(20, 24);
    }

    /**
     * 解析装备的起止Rfid 包含序号
     */
    public static String parseEquipRfidIncludeSerial(String equipRfid) {
        return equipRfid.substring(0, 24);
    }

    /**
     * 解析装备起止的Rfid 不含序号
     *
     * @param equipRfid
     * @return
     */
    public static String parseEquipRfidNoSerial(String equipRfid) {
        return equipRfid.substring(0, 20);
    }

    /**
     * 解析装备数量
     *
     * @param equipRfid
     * @return
     */
    public static String parseEquipCount(String equipRfid) {
        return equipRfid.substring(24, 27);
    }

    /**
     * 解析箱Rfid 返回所代表的装备Rfid
     *
     * @param boxRfid
     * @return
     */
    public static HashSet<String> parseBoxRfid2EquipRfidSet(String boxRfid) {
        HashSet<String> set = new HashSet();
        String rfidNoSerial = parseEquipRfidNoSerial(boxRfid);
        Long serialNumber = Long.parseLong(parseEquipSerialNumber(boxRfid), 16);
        Long equipCount = Long.parseLong(parseEquipCount(boxRfid), 16);
        for (long l = 0; l < equipCount; l++) {
            set.add(rfidNoSerial + String.format("%04x", serialNumber + l));
        }
        return set;
    }
    /**
     * 解析箱Rfid 返回所带标点装备Rfid List
     *
     * @param boxRfid
     * @return
     */

    /**
     * 单个日期内Rfid的最大数量
     */
    private static final Integer MAX = 65535;
    public static List<String> parseBoxRfid2EquipRfidList(String boxRfid) {
        List<String> list = new ArrayList<>();
        String rfidNoSerial = parseEquipRfidNoSerial(boxRfid);
        Long serialNumber = Long.parseLong(parseEquipSerialNumber(boxRfid), 16);
        Long equipCount = Long.parseLong(parseEquipCount(boxRfid), 16);
        for (long l = 0; l < equipCount; l++) {
            if (serialNumber + l > BoxRfidParseUtils.MAX) {
//                throw new Exception(String.format("生成的散件Rfid数量 超过单日最大值," +
//                        "请重新选择日期生成!剩余该日可生成的数量为[%d]件装备", l - 1));
            }
            list.add(rfidNoSerial + String.format("%04X", serialNumber + l));
        }
        return list;
    }


    public static Set<String> parseBoxList2Set(List<String> rfids) {
        Set<String> parseboxrfids = new HashSet<>();
        rfids.forEach(rfid -> {
            rfid = rfid.toUpperCase();
            if (rfid.length() == 32) {
                List<String> tempList = parseBoxRfid2EquipRfidList(rfid)
                        .stream()
                        .map(String::toLowerCase)
                        .collect(Collectors.toList());
                parseboxrfids.addAll(tempList);
            } else if (rfid.length() == 24) {
                parseboxrfids.add(rfid);
            }
        });
        return parseboxrfids;
    }
}
