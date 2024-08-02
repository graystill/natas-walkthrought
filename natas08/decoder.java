/* последовательность: переревод из hex в bin -> реверс строки -> декод base64 
 * пишу эту хуйню чист по приколу, ну и ради экспириенса
 * исходник:
 * <? php
 * $secret="3d3d516343746d4d6d6c315669563362";
 * echo base64_encode(strrev(hex2bin($secret)));
 * ?>
*/

import java.util.Base64;

public class decoder {
    public static void main (String[] args) {
        String hex = "3d3d516343746d4d6d6c315669563362";
        String binary = hex2bin(hex);
        System.out.println("Бинарное представление: " + binary); // на выходе - ==QcCtmMml1ViV3b

        var reversed = new StringBuilder(binary) // перевёртыш - b3ViV1lmMmtCcQ==
        .reverse().toString(); 
        System.out.println(reversed);

        String decodedString=new String(Base64.getDecoder().decode(reversed)); // декодим base64, на выходе - oubWYf2kBq
        System.out.println(decodedString);

    }

    /* это перевод из шестнадцатиричного в бинарное представление, спизженно со steckoverflov
     * @param - String, тип данных
     * @param - hex, то, что хотим декодировать hex -> bin
     */
    public static String hex2bin (String hex) {
        StringBuilder bin = new StringBuilder("");

        for (int i=0; i<hex.length(); i+=2) { 
            String str = hex.substring(i, i+2); 
            bin.append((char) Integer.parseInt(str, 16)); 
        }

        return bin.toString();
    } 
}