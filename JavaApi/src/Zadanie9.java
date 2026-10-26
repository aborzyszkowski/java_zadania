import org.json.JSONArray;
import org.json.JSONObject;

public class Zadanie9 {
    public static void main(String[] args) throws Exception {
        JSONObject dane = Api.pobierz("https://store.steampowered.com/api/featuredcategories/?cc=pl&l=polish");
        JSONArray gry = dane.getJSONObject("specials").getJSONArray("items");
        
        int minimalnyRabat = 50;
        for (int i = 0; i < gry.length(); i++) {
            JSONObject gra = gry.getJSONObject(i);
            if (gra.getInt("discount_percent") <= minimalnyRabat) {
                System.out.print(gra.getString("name") + ", rabat: ");
                System.out.println(gra.getInt("discount_percent") + "%");
                
            }
        }

    }
}