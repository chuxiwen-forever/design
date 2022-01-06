package proxy;

public class PrinterProxy implements Printable{

    private String name;  //名字
    private Printer real; //"本人"

    public PrinterProxy() {
    }

    public PrinterProxy(String name) {
        this.name = name;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if (real != null){
            real.setPrinterName(name);   //同时设置"本人"的名字
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized void realize() {
        if (real == null){
            real = new Printer(name);
        }
    }


}