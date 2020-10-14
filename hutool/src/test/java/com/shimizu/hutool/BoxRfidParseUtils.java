package com.shimizu.hutool;

/**
 * 用于解析装备Rfid
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
     * 解析Rfid供应商编号
     *
     * @param equipRfid
     * @return
     */
    public static String parseSupplierNumber(String equipRfid) {
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
}
