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
        .reverse().toString(); //здесь перереворачиваем и переводим полученные данные в тиип String
        System.out.println(reversed);

        String decodedString=new String(Base64.getDecoder().decode(reversed)); // декодим base64, на выходе - oubWYf2kBq
        System.out.println(decodedString);

    }
    /* нераборчий код от чатажпт
    // public static String hexToBinary (String hex) {
    //     StringBuilder binary = new StringBuilder();
        
    //     for (char c : hex.toCharArray()) { // Преобразуем каждый шестнадцатеричный символ в бинарное представление
    //         String bin = Integer.toBinaryString(Integer.parseInt(String.valueOf(c),16));
            
    //         while (bin.length() > 4) { //Добавляем ведущие нули для представления 4-х бит
    //             bin="0" + bin;
    //         }
            
    //         binary.append(bin);
    //     }
        
    //     return binary.toString();
    // }
    */

    /* это перевод из шестнадцатиричного в бинарное представление, спизженно со steckoverflov
     * @param - String, тип данных
     * @param - hex, то, что хотим декодировать hex -> bin
     */
    public static String hex2bin (String hex) {
        StringBuilder bin = new StringBuilder(""); // инициализация StringBuilder

        for (int i=0; i<hex.length(); i+=2) { //цикл, каждая итерация которого обрабатывает по 2 символа в 16-ричной строке
            String str = hex.substring(i, i+2); //берётся подстрока str, состоящая из 2 символов, начиная с позиции i и заканчивая i+2
            bin.append((char) Integer.parseInt(str, 16)); //преобразует подстроку в десятичное значение и приводится в даненые char
        }

        return bin.toString(); //возвращаем результат как тип данных Строка
    } 
}