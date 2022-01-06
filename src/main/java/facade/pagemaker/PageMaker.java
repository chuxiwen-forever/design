package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {

    }

    public static void makeWelcomePage(String mailaddr,String filename){
        Properties mailprop = Database.getProperties("C:\\Users\\16091\\MyProjects\\design\\src\\main\\java\\facade\\maildata");
        String username = mailprop.getProperty(mailaddr);
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to" + username + "'s page !");
            writer.paragraph(username + "欢迎来到" + username +"的主页");
            writer.paragraph("等着你的邮件！");
            writer.mailto(mailaddr,username);
            writer.close();
            System.out.println(filename + " is created for" + mailaddr + "(" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
