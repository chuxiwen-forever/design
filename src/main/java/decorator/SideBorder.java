package decorator;

public class SideBorder extends Border{

    private char borderChar;    //表示装饰边框的字符

    public SideBorder(Display display,char ch){
        super(display);            //指定Display和装饰边框字符
        this.borderChar = ch;
    }
    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;  //字符数为字符数加上两边边框的字符数
    }

    @Override
    public int getRows() {
        return display.getRows();   //行数即被装饰物的行数
    }

    @Override
    public String getRowText(int row) {   //指定字符串加上两侧边框的字符
        return borderChar + display.getRowText(row) + borderChar;
    }
}
