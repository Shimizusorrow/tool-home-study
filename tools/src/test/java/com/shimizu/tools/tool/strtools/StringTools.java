package com.shimizu.tools.tool.strtools;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.*;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-28 14:53
 */
@ExtendWith(SpringExtension.class)
public class StringTools {
    String fileName = "test.txt";
    String path = System.getProperty("user.dir");
    String packagePath = "\\src\\test\\resources\\";
    String file = path + packagePath + fileName;

    @SneakyThrows
    @Test
    void makeFile() {

//        String replace = file.replace('\\', '/');
//        BufferedWriter writer = new BufferedWriter(new FileWriter(replace));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        String content = "a-T1cXvQTFuMI8qJ4SSkUA\n" +
                "35gb6Qd5QCu80R_3vo0oWQ\n" +
                "-dYTdcY5StGqSKL3UH1h_w\n" +
                "yAw5EUtLQPuVHg-8D8P5TA\n" +
                "9slrCaAyRNOPYQKggipcLA\n" +
                "VfYamS4LR5i5Gq1BC2XTTw\n" +
                "i9Rwv0YURAOzmJIQ-ZEiHw\n" +
                "Z05i4zxURo2wV_KAb7hepA\n" +
                "XI1bPOLAS5qSJmHu9q9NWA\n" +
                "r3wgUvkMRee-9Ms7YEUseQ\n" +
                "66X6gKosQvaXwWIXnmxThQ\n" +
                "QmJydgVnTYSETkQgX5Qwhg\n" +
                "XqdTxcBLSVCd6WXPPaXnwg\n" +
                "__iP3s9WQuilBWaWmuolFg\n" +
                "cENAUX92RqmAK13SSg12Kg\n" +
                "9qdVjNt6T46-AWuz4YlN-g\n" +
                "vt3CHU_4QYGrO8JFElORrA\n" +
                "kuUQUSw9TxC3KPJ0daH9SQ\n" +
                "LafHENwGTKO4L-ZiE-ZC0Q\n" +
                "Alox9zTASL6ppIVN4S0pyQ\n" +
                "h2ChmZC_TfS_zdxsovIrCg\n" +
                "mM9Yfw73QZab-fs2KTuV7A\n" +
                "K9ViUxe3RBqwuh6y3zsZtg\n" +
                "jJBPR6C9RSqA22xoSNyi5g\n" +
                "8w2qZsxeRPOz5k3E07RwZA\n" +
                "EsjXVQpDScKKvqfRH7wjvQ\n" +
                "o9lqc1Z8RqWYFwX-N-s1zA\n" +
                "ct4vGPq7QTqQ9Il2u6grDw\n" +
                "gaTXS0FOQOW_yJf38ZUqtQ\n" +
                "a8sZL_wLTCqQHcNbxYCfaQ\n" +
                "riPbwJzTQJWJ7mZ3SS0Ojg\n" +
                "XYHsbwXlSNiUTPgadc5QFA\n" +
                "MZZ-6lJGSWCWb5rTnwATfg\n" +
                "2proIEJ5R0KyKmu_KhemnQ\n" +
                "GvVjWG7fT46HvkZH9snOEQ\n" +
                "ZppOBjTgQ2O1fH0HDGv0RQ\n" +
                "kv5L9EAgQVqkPAsBjF2H6g\n" +
                "8BgDVZysTgGfel9PzcAXQg\n" +
                "cpXL90VlTki8mlm2JtVxYg\n" +
                "uGhQlGTZTGOet_atlBqY2w\n" +
                "YuE9pvwXQqmyK1ZpbYyu2g\n" +
                "frGjnXtBRFiW-9VJvNJy1g\n" +
                "9cqQfuBaTkKDlJetiyNuGg\n" +
                "ovEekk47TnmgNV28Z36qPw\n" +
                "VdSPGbShSeKeOnW9mnorrw\n" +
                "40BVYATpS4mwXioG9_q4rQ\n" +
                "bvw465fPSOW4ivkjkI2g-Q\n" +
                "gpp0K35USpOvasBfl7CdSA\n" +
                "9PABCuzTSfqnrHVgvPbl4A\n" +
                "b4WxdkjsQGK6PAXstmJo5w\n" +
                "ApcaZj_ERkCvt1WKSF6Sgw\n" +
                "HXUtpDReRfeexzG-8xhzew\n" +
                "ycrKWBEsQGmVi9D8UwI-Zg\n" +
                "SlVrT5hkRn2y_GEjmjTGlw\n" +
                "hacVB1MRR3WoyyG7dWXJtw\n" +
                "XsIWPNUXTI6WGsIENJXfCA\n" +
                "FuM2zzcKSLij2iUhcwW-Zw\n" +
                "A8ukzYZ2S72yPKYjYZCrmw\n" +
                "BDoDzQXQQOqhnNiG1Kuy-w\n" +
                "Ag6sksIFSNGYqjoip3arDg\n" +
                "25OazwkaThSbXmaIXvK7qg\n" +
                "sF-UFdjfTLSMoOGltW1FCg\n" +
                "AxtcDjB_Qiu_Ueg1aY7MhA\n" +
                "Lu5kw_3ISjmfa50O9zOYdQ\n" +
                "K12xou6MTyGl5srlsTch5g\n" +
                "-c2OMha8TPSeON48h0ua0g\n" +
                "rJL4QZJ-SIuWChgr861Rtg\n" +
                "PS9CZdT7QGOVJuj1KzPsFA\n" +
                "fNzLupYRSBiDnnW6XCqbhA\n" +
                "2BLc64zkSXywszbNPAAbfQ\n" +
                "NwwTtkgbRAOPcxckBTFEpA\n" +
                "Xwtlwo9ZScemmNkVTwIt7A\n" +
                "_JucDWK0TSyxRL58juEdVA\n" +
                "J6B3abS1T7WtX9EYCQOQBA\n" +
                "f43h9Xl3QKyVMbtMlLopTg\n" +
                "bLc5aSVTQ7GcPvO3UFmpow\n" +
                "ErqjLjYMSpK-uWyWkL3C2Q\n" +
                "Ag4x8XD3SmmvjialNYc9iw\n" +
                "5UxO9Bw0QB6NyLvZFjq9Ew\n" +
                "pegLfVo-TbSIRi78LB0MvQ\n" +
                "dBrCoXZ9RsOZniMvm7Lrvg\n" +
                "DMcZwa6kTMi23Jj9qcWAAQ\n" +
                "YptHcDU5T2-zXJ71t1r1ig\n" +
                "SN0Irud6SJ2aBqoWDsRkuA\n" +
                "TN-cQAIHQoqJ7Rm309FSkg\n" +
                "jyop6PfNS72lIp8h8_eu9Q\n" +
                "lWNsdpXRQn-MWDN7VvkmJA\n" +
                "T0fZfQxsTt2fHH0fOlx1ZA\n" +
                "nR6tfHNBS6KMZ5Mzj4IGIQ\n" +
                "JWO2csSjQ9Oovu5ua7pZtQ\n" +
                "QscRuj0iQZKHFrY0GAfLLQ\n" +
                "8RvT25Z9RuaO4gsK6FF0sA\n" +
                "v_UOLOZQRRiOioLcaqlq7Q\n" +
                "1ricL6gqQ3eBEHkwcYFk7g\n" +
                "E_Q7wbvZSHmtqycy8fx-uA\n" +
                "aaKPOw_KRC6qatmTg0iUEQ\n" +
                "G8imODh6TSax5PBD7glQZw\n" +
                "cIB4zQhCSqaWj3cx0u1sFg\n" +
                "h0GrtZMIQCCidR1-Ki11KA\n" +
                "Kefk3AKURSeBz_hyC6hglQ\n" +
                "41-lUyjpTjeq5L9EULZxng\n" +
                "pOTS3AYbRCqRggR_HQ7Z7A\n" +
                "RzFv-sA4RwK9JeNPjCJqqQ\n" +
                "zrFrk6fWRQOtvdHVyDO7CQ\n" +
                "Ni3bsC4dR2CwStnAUHaDyw\n" +
                "53Wv4yrBR-y5uzy_RfPV8A\n" +
                "PjoAzRNNQiKbhFK6wisxSQ\n" +
                "M6c8FIuXSa62PbuZmMD2ZA\n" +
                "L9UPNZJrS3GMmAPl2xWTAg\n" +
                "Yoku45UYT7KNB1fvNgLp1g\n";
        writer.write(content);
        writer.close();
//        File file = new File(path + packagePath, fileName);


    }

    @SneakyThrows
    @Test
    void readFile() {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        int position = 0;
        String[] bufString = new String[1024];
        while ((line = br.readLine()) != null) {
            bufString[position] = String.format("'%s',", line);
            position++;
        }
        br.close();//关闭文件
//        System.out.println(bufString.toString());
        for (int i = 0; i < position; i++) {
            System.out.println(bufString[i]);
        }
//        OutputStream os = new FileOutputStream(file);
//        PrintWriter pw = new PrintWriter(os);
    }

}
