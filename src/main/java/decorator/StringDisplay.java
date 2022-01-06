package decorator;

public class StringDisplay extends Display{

    private String string;    //要显示的字符串

    public StringDisplay(String string){
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.getBytes().length;  //字符数
    }

    @Override
    public int getRows() {
        return 1;     //行数是1
    }

    @Override
    public String getRowText(int row) {   //当row为0是返回值
        if (row == 0){
            return string;
        }else {
            return null;
        }
    }
}
