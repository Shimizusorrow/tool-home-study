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
        String content =
                "06156dab-8c5e-478f-8516-c70dae1f911e\n" +
                        "10e7592a-fa37-4801-8ffe-3e4ba6b9de96\n" +
                        "11cfc2e5-05f4-47fb-802e-de859d4eabcf\n" +
                        "20723b4f-10ef-44d1-a56a-8c4d663d3c28\n" +
                        "2532cb53-c459-48b4-8eee-00528e3f9625\n" +
                        "25b92255-47aa-4bf8-8935-e0a1008ed3b1\n" +
                        "36d42196-4ffb-42c8-8a5b-73c1bd5f5bb8\n" +
                        "4cfd4fe0-f8e9-4134-b2bc-acfae5f10db1\n" +
                        "4db797cb-63b1-4ff7-9349-8ccd2f4cb24d\n" +
                        "4f05e6dd-452e-4766-9eb4-f9b99ecdaa80\n" +
                        "5091855e-aa9c-4796-b916-f406a1e285f1\n" +
                        "54fd047d-1809-4ff8-9f41-10bf9ac4f487\n" +
                        "744ff47c-6f3f-437d-b922-cc5fb804cad3\n" +
                        "81fc1b66-18af-4ba2-84cb-f332c8a5701a\n" +
                        "98f6f9f5-6fc7-4eb7-b7fc-451c5c00957a\n" +
                        "9923c485-390f-4dae-bd9c-daffd911cf8b\n" +
                        "aca8aa0c-585e-4e0c-ba46-701dbb34daec\n" +
                        "afQkEUpdE9yVDKg9OrnQ50Equ\n" +
                        "AGlKFdJ9ENSoku84MbyB_3Equ\n" +
                        "b3cb631b-c48d-475d-be80-ee793f07c585\n" +
                        "b55c4fad-e49d-4803-888c-158f434ade30\n" +
                        "b5QEbRCXGWm2zeEIg2SBT0Equ\n" +
                        "b6BMYOzlFzOKH_V4Ej0yk1Equ\n" +
                        "b7bCjFvtHMegOXDS1Kh1O2Equ\n" +
                        "bDqD5oJ6FVquOzU7a8GYx2Equ\n" +
                        "Bj0AwysKFnuqL4kQ115qE0Equ\n" +
                        "BOgEZUICEuOKpV0HRjbZc2Equ\n" +
                        "brrOYoVGH2KLn3KnyRe4F2Equ\n" +
                        "bSh2Xm61E2eRARy3pudCi2Equ\n" +
                        "bU_hnWmMGcmMx3KJm1t902Equ\n" +
                        "CcJe5zniGN2Arp3TUOcaN3Equ\n" +
                        "cdb52c30-0517-4ffe-93ce-6e0c4f06d63d\n" +
                        "CqT5Sp0_GHq9Y2Tdc2X0X0Equ\n" +
                        "CuFGupfQFK2GXckK9SwO63Equ\n" +
                        "d96448f8-eae0-4c68-bd6f-605b144ae89f\n" +
                        "df71bdd4-e92c-4d92-87d9-82116499d827\n" +
                        "diwkqFyjHC_AvfImx5Y9K1Equ\n" +
                        "dl4ziBgyGv_dej0rzIy3a1Equ\n" +
                        "e3c41e43-fd71-477f-a7e0-d34648902701\n" +
                        "EolSdcwdG3_pGjUj70dnK1Equ\n" +
                        "exX8tw1lHradp4DS7si000Equ\n" +
                        "ezJejsbXHayycdQ6ufI9T3Equ\n" +
                        "f63049bb-97f2-46f6-a23e-3b7c037bd0bf\n" +
                        "f7ba303e-f430-4b67-bd8c-4760ce11c326\n" +
                        "fbcNczlfGH_UYOvv08uTI2Equ\n" +
                        "fff2d54b-17a6-4581-b501-54d510ea7c49\n" +
                        "FTo_puotFTOuA4ddmANXz1Equ\n" +
                        "fTpGfq0kFaGO939du9Py72Equ\n" +
                        "FucjF5BLFwm5bWZlJ29I51Equ\n" +
                        "GcIaFDRmEBa3iKaB48XN_0Equ\n" +
                        "GMp7OeWdHlGDp037Lzk_j2Equ\n" +
                        "h0bQpSbVFCm1uNigB5HOs0Equ\n" +
                        "HdJHfvRaF7G2QHSS1uIyE0Equ\n" +
                        "hdTzPK1ZG7qTExsepe1mA0Equ\n" +
                        "hF3B790JGLCROhBAvtxsx3Equ\n" +
                        "HiZf31u4G7KuHhM89A2NO3Equ\n" +
                        "huSrJ_wrFn6WCvQtRB3n03Equ\n" +
                        "HZ1ttrS7Gwany1_Hg3ZSD3Equ\n" +
                        "I3TKR1o4Gj_VTaUrVmH1M1Equ\n" +
                        "i7AP86NhFsKUNshQijcjU3Equ\n" +
                        "I7B4WCNdEW_od8L0pEWbs1Equ\n" +
                        "ID9BD_YLFDihHqSEvAziL0Equ\n" +
                        "IIs7RWpfFR6Ji91xeCuV83Equ\n" +
                        "IN2fSbxWHCevb_JfZyRCP0Equ\n" +
                        "IUKzrV_iHE_1xzJelcpWy3Equ\n" +
                        "j0bRiA8gFVSowraSAxrLP0Equ\n" +
                        "jjkXnz4PE6W0MD3RS9t6k3Equ\n" +
                        "JSwgZuV5Fku6EMqOXBTNS1Equ\n" +
                        "JtfQBVONGKinUyHTW3eNu0Equ\n" +
                        "jWptlnkQHPCRpAA1ChshN2Equ\n" +
                        "JY4RuX8CEDSlawl5fc0F52Equ\n" +
                        "j_SjMus5FEamSUUHXrlv31Equ\n" +
                        "K1aCwarXHCi84grkfJu4N0Equ\n" +
                        "KCKwXlHREFegGbE7FAwwf2Equ\n" +
                        "Kl_u8KyhEV_6TGtiME20A2Equ\n" +
                        "KMcLDpr1ESqZVn759hMvh0Equ\n" +
                        "kobJFYbeHw2kkiMLdNVS01Equ\n" +
                        "kw995BNcGKmnaJBY9u2Ej0Equ\n" +
                        "LAAgQcJZESKDZ4V9EAkan1Equ\n" +
                        "lBX2rIAtF3mJLEQ8eRu5R2Equ\n" +
                        "lFoFetysE8a0PHJDRLVBD0Equ\n" +
                        "LGUiK9ioEbKBcVr1X9QIB3Equ\n" +
                        "lgurtyCnExa36BfkuMrt90Equ\n" +
                        "LRzosv64ELaQ_TMhN6Na23Equ\n" +
                        "L_vxW3AiFHaWGK6MDm6kt1Equ\n" +
                        "mKkSNCeIGOCuo0YX5ar2u0Equ\n" +
                        "mnwTUaLxHmylPcimeITdK3Equ\n" +
                        "MVyDShezGwWw26tpkr2gq0Equ\n" +
                        "NmbqCCxVEs2NyHwDd8jQu2Equ\n" +
                        "Np4vM8jDFZOETLID8_8ws1Equ\n" +
                        "nS3Yoo3NFqSDvCyODIOqF0Equ\n" +
                        "N_MTFojUHUuujfwDdTdZd0Equ\n" +
                        "O1tk421BEUWY5oIq1pVHd3Equ\n" +
                        "OlQLSfjzEnupsAhsxwWel0Equ\n" +
                        "OQnpL9VpFDOlSkel_BpsO0Equ\n" +
                        "OQsvh1UgEEONnNMImlbUw2Equ\n" +
                        "pAsWsRooH_O25lKvVXdQh2Equ\n" +
                        "pIpDItFVFGuVBIcyGpl6j1Equ\n" +
                        "pjJE0XmzHsu_btgdJ89mg3Equ\n" +
                        "pJZR8IEqEnS4cyr6M8clQ3Equ\n" +
                        "puVOAbpQGqGYdchVrSRVd1Equ\n" +
                        "Q7o7vIk9GdSY9BVYZEpJK2Equ\n" +
                        "qAPWHPwdF_eBlx3RGPVHR3Equ\n" +
                        "qbUAA6P3G4avJlH7fSusU3Equ\n" +
                        "QCo3KCjREW_2TL170tYoI0Equ\n" +
                        "qhjiHKNLFJ2RXkix4LpMS1Equ\n" +
                        "qLpNsEN9GSedYrH9JI_PW0Equ\n" +
                        "qVY5feAGF2W_NfLZPBSrp3Equ\n" +
                        "QxmQU7bNEWClzjHsc6WFk1Equ\n" +
                        "r1_p2XvJFUmPXXSwBXfT43Equ\n" +
                        "r2vF7oZnGHO67Fhe6l3M83Equ\n" +
                        "RkM6Tud4FlWh5h4BzW2Zf2Equ\n" +
                        "rKwdGGX6H4WkJp3wj8O351Equ\n" +
                        "Rl4OGE3rGqenWY3vaGGIF1Equ\n" +
                        "rqa3zi9qER_IeCQ7Kd7p80Equ\n" +
                        "sB85RECCFxOXCZRSuQyd03Equ\n" +
                        "SrUg2llVHqW0C2vC4fsSo3Equ\n" +
                        "SuB3J1KbEwehcQ73mnwuW1Equ\n" +
                        "SxSzFMylGTSwOSUPLRYV73Equ\n" +
                        "sz5wJZ85FLCoVC3B5LzOL2Equ\n" +
                        "tgkwuHy4GVa4q9zvylcKQ3Equ\n" +
                        "TkwsJBauGzCLF8KFm_zPG1Equ\n" +
                        "u3_tnsqyFUKqVwVOYC7qw3Equ\n" +
                        "UKTFnmiQHaq3SZ7mwpLs01Equ\n" +
                        "UljzWkY1FBGTUmKOTkwuB0Equ\n" +
                        "UMxeSvObF822pUMbMxhlr1Equ\n" +
                        "UqFCikwUHsGIJzWM5tXbX2Equ\n" +
                        "utpZ49vHGXOqNbvgX67rU1Equ\n" +
                        "UVIQRMhwH8u6WF4tRBvCi1Equ\n" +
                        "V8GpqfFRG4mGt6E_O9BzD3Equ\n" +
                        "vDLusKHdGgm2msLWX_o_B0Equ\n" +
                        "wNsEllcHFECjTy2dim6bk2Equ\n" +
                        "WoWFbiE3FAqKoZBUJ8dzH2Equ\n" +
                        "wUtz16ZAE1muIgBUyYK4m1Equ\n" +
                        "X7SuXSINEp2MQj93FSzqJ3Equ\n" +
                        "XeRUP4WCGPSvjOaRztr_m3Equ\n" +
                        "XTZtCBEgHie_1AG6s2GgD1Equ\n" +
                        "xvpFtA2VG3KzxsrfwyAyv1Equ\n" +
                        "y9br4RSdFu21i4akzp1MQ3Equ\n" +
                        "yMueRQ9IFFujAJCQaJ98S0Equ\n" +
                        "ZBaO6A5NG6_wXuiciKpTa0Equ\n" +
                        "zccpgEm0GCK_p0xpH3s5L1Equ\n" +
                        "ZGrVg45gER6dIAh8YHbh92Equ\n" +
                        "zGyDqpsdGg64F8US5yOxt3Equ\n" +
                        "_KfWlkhvGtaTTEdDu5Dw00Equ\n";
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
