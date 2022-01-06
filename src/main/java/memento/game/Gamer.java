package memento.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;    //所持金币
    private List fruits = new ArrayList(); //获取的水果
    private Random random = new Random();
    private static String[] fruitsName = {
            "苹果" , "葡萄" , "香蕉" , "橘子"
    };

    public Gamer(int money){
        this.money = money;
    }

    public int getMoney(){
        return money;
    }

    public void bet(){
        int dice = random.nextInt(6) + 1;
        if (dice == 1){
            money += 100;
            System.out.println("所持的金币增加了.");
        }else if (dice == 2){
            money /= 2;
            System.out.println("所持金币减半了.");
        }else if (dice == 6){
            String f = getFruit();
            System.out.println("获取了水果(" + f +").");
            fruits.add(f);
        }else {
            System.out.println("什么都没有发生.");
        }
    }

    public Memento createMemento(){
        Memento m = new Memento(money);
        Iterator it = fruits.iterator();
        while (it.hasNext()){
            String f = (String) it.next();
            if (f.startsWith("好吃的")){
                m.addFruit(f);
            }
        }
        return m;
    }

    public void restoreMemento(Memento memento){    //撤销
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits +"]";
    }

    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()){
            prefix = "好吃的";
        }
        return prefix + fruitsName[random.nextInt(fruitsName.length)];
    }
}
