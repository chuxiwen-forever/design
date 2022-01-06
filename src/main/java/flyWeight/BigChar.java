package flyWeight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BigChar {
    private char charName;
    private String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("big" + charName + ".txt"));
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null){
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontData = buf.toString();
        } catch (Exception e) {
            this.fontData = charName + "?";
        }
    }

    //显示大型字符
    public void print(){
        System.out.println(fontData);
    }
}
