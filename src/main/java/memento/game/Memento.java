package memento.game;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    int money;   //所持金币
    ArrayList fruits;   //获取的水果

    public int getMoney(){
        return money;
    }

    Memento(int money){
        this.money = money;
        this.fruits = new ArrayList();
    }

    void addFruit(String fruit){
        fruits.add(fruit);
    }

    List getFruits(){
        return (List) fruits.clone();   //获取当前所持所有的水果
    }

}
