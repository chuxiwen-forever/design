package decorator;

public class FullBorder extends Border{

    public FullBorder(Display display){
        super(display);
    }

    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {             //指定的那一行的字符串
        if (row == 0){
            return "+" + makeLine('-',display.getColumns()) + "+";   //下边框
        }else if (row == display.getRows() + 1){
            return "+" + makeLine('-',display.getColumns()) + "+";   //上边框
        }else {
            return "|" + display.getRowText(row - 1) + "|";   //其他边框
        }
    }

    private String makeLine(char ch, int count) {    //生成一个重复count次字符ch的字符串
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
