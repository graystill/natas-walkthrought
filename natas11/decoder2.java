package natas11;
import org.json.JSONObject;

import java.util.HashMap;



public class decoder2 {
    public static void main (String[] args) {
        HashMap <String, String> map = new HashMap<>();
        map.put("showpassword", "no");
        map.put("bgcolor", "#ffffff");

        System.out.println(map);

        JSONObject json = new JSONObject(map);
        System.out.println(json);
    }
}
