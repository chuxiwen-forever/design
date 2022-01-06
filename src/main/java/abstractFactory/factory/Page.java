package abstractFactory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Page {

    protected String title;  // 页面标题
    protected String author;  //页面作者
    protected ArrayList content = new ArrayList();

    public Page(String title , String author){
        this.title = title;
        this.author = author;
    }

    public void add(Item item){
        content.add(item);
    }

    public void output(){
        String filename = title + ".html";
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(this.makeHTML());
            fileWriter.close();
            System.out.println(filename + "编写完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract String makeHTML();
}
