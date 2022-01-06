package observer;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {

    private ArrayList observers = new ArrayList(); //保存Observer们

    public void addObserver(Observer observer){
        observers.add(observer);                    //注册observer
    }

    public void deleteObserver(Observer observer){
        observers.remove(observer);                  //移除observer
    }

    public void notifyObservers(){
        Iterator it = observers.iterator();
        while (it.hasNext()){
            Observer o = (Observer) it.next();
            o.update(this);
        }
    }

    public abstract int getNumber();   //获取数值

    public abstract void execute();   //生成数值
}
