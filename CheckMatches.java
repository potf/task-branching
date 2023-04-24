package dedietrich;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckMatches {

    public static String check(String s) {

        String newString = null;
        String s2 = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader("/product_properties.csv");
            br = new BufferedReader(fr);

            while ((s2 = br.readLine()) != null) {
                String [] arr = s2.split(";");

                if (s.equalsIgnoreCase(arr[0].replace("\"", ""))){

                    newString = arr[1];
                    break;
                } else newString = s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return newString;
    }
}
