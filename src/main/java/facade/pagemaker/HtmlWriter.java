package facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {

    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws IOException{
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>");
    }

    public void paragraph(String msg) throws IOException{  //输出段落
        writer.write("<p>" + msg + "</p>");
    }

    public void link(String href,String caption) throws IOException{ //输出超链接
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }

    public void mailto(String mailaddr , String username) throws IOException{
        link("mailto:" + mailaddr ,username);   //输出邮件地址
    }

    public void close() throws IOException{
        writer.write("</body>");   // 结束输出HTML
        writer.write("</html>\n");
        writer.close();
    }
}
