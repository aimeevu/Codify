package codify.aimee.com.codify;

/**
 * Created by aimeevu on 3/26/2016.
 */
public class play_info {
    int id;
    int level;
    String code;
    String language;
    int points;

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public play_info() {}

    public void setId(int input){
        id=input;
    }
    public void setLevel(int input){
        level=input;
    }
}
