package flyWeight;

import java.util.HashMap;

public class BigCharFactory {
    //管理已经生成的BigChar的实例
    private HashMap pool = new HashMap();
    //单例模式
    private static BigCharFactory singleton = new BigCharFactory();
    private BigCharFactory(){

    }
    public static BigCharFactory getInstance(){
        return singleton;
    }

    //生成（共享） BigChar 类的实例
    public synchronized BigChar getBigChar(char charName){
        BigChar bc = (BigChar) pool.get("" + charName);
        if (bc == null){
            bc = new BigChar(charName);  //生成BigChar的实例
            pool.put("" + charName , bc);
        }
        return bc;
    }
}
