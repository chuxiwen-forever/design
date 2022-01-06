package prototype;

public class ProtoTypeMain {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen uPen = new UnderlinePen('~');
        MessageBox mBox = new MessageBox('*');
        MessageBox sBox = new MessageBox('/');
        manager.register("strong message",uPen);
        manager.register("warning box",mBox);
        manager.register("slash box",sBox);

        //生成
        Product p1 = manager.create("strong message");
        p1.use("hello , world");
        Product p2 = manager.create("warning box");
        p2.use("hello , world");
        Product p3 = manager.create("slash box");
        p3.use("hello , world");
    }
}
