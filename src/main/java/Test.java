import com.tools.cipher.DESCipher;
import com.tools.cipher.StdPayAESUtil;
import org.apache.commons.lang.StringUtils;
import sun.security.util.AuthResources_it;

import java.io.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Test {

    public static void main(String[] args) throws Exception {
//        System.out.println(CipherUtil.decryptData("7292a1b24e4ff7f630db629f030a99b56f3f4d7d3d2a72de", "GXlJzbo0"));
//        desDecrypt("GXlJzbo0", "D:\\data\\taxPay\\DBC0000000815_22.txt", "D:\\data\\taxPay\\DBC0000000815_22_result.txt");
//        stdAESDecrypt("ttQLEg4MuvQq8Mb6", "D:\\data\\taxPay\\DBC0000000815_11.txt", "D:\\data\\taxPay\\DBC0000000815_11_result.txt");

//        String str = "2020-07-23 20:00:17.747079";
//        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
//        DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
//        Date date = sf.parse(str);
//        DateFormat sf2 = new SimpleDateFormat("yyyyMMdd");
////        System.out.println(sf2.format(date));
//        System.out.println((new SimpleDateFormat("yyyyMMdd")).format(timestamp));

        System.out.println(Thread.currentThread().getContextClassLoader().getResource("."));





    }

    public static void stdAESDecrypt(String aesKey, String inFile, String outFile) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(inFile));
        br.readLine();
        StringBuilder sb = new StringBuilder();
        String str = "";
        while((str = StringUtils.trim(br.readLine())) != null) {
            sb.append(str).append("|");
            String[] arr = str.split("\\|", -1);
//            sb.append(arr[0]).append("|")
//                    .append(arr[1]).append("|")
//                    .append(arr[2]).append("|")
//                    .append(arr[3]).append("|")
//                    .append(arr[4]).append("|")
//                    .append(arr[5]).append("|");
            if(StringUtils.isNotEmpty(arr[6])) {
                sb.append(StringUtils.trim(StdPayAESUtil.decrypt(StringUtils.trim(arr[6]), aesKey))).append("\n");
            }else {
                sb.append("").append("\n");
            }
        }

        PrintWriter pw = new PrintWriter(new FileOutputStream(new File(outFile)));
        pw.write(sb.toString());
        pw.flush();;


        br.close();
        pw.close();

        System.out.println("StdPayAES文件解密结束");
    }

    public static void desDecrypt(String desKey, String inFile, String outFile) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(inFile));
        br.readLine();
        StringBuilder sb = new StringBuilder();
        String str = "";
        while((str = br.readLine()) != null) {
            sb.append(StringUtils.trim(str)).append("|");

            String[] arr = str.split("\\|", -1);
            DESCipher desCipher = new DESCipher(desKey);
            if(StringUtils.isNotEmpty(arr[16])) {
                sb.append(desCipher.decrypt(StringUtils.trim(arr[16]))).append("\n");
            }else {
                sb.append("").append("\n");
            }
        }

        PrintWriter pw = new PrintWriter(new FileOutputStream(new File(outFile)));
        pw.write(sb.toString());
        pw.flush();;


        br.close();
        pw.close();

        System.out.println("DES文件解密结束");
    }
}
