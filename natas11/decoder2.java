import java.util.Base64;

public class decoder2 {
    public static void main (String[] args) {
        String str = "HmYkBwozJw4WNyAAFyB1VUcqOE1JZjUIBis7ABdmbU1GIjEJAyIxTRg=";
        String decodede = new String(Base64.getDecoder().decode(str));
        System.out.println(decodede);
    }
}
