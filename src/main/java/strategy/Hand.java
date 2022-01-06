package strategy;

public class Hand {
    public static final int HANDVALUE_GUU = 0;  //石头
    public static final int HANDVALUE_CHO = 1; //剪刀
    public static final int HANDVALUE_PAA = 2; // 布

    public static final Hand[] hand = {  //3种手势的实例
            new Hand(HANDVALUE_GUU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA),
    };
    private static final String[] name = {  //猜拳手势对应的字符串
            "石头","剪刀","布"
    };
    private int handValue;   //手势的值

    private Hand(int handValue){
        this.handValue = handValue;
    }

    public static Hand getHand(int handValue){   //根据手势的值获取齐对应的实例
        return hand[handValue];
    }

    public boolean isStrongerThan(Hand h){   //如果this胜利了h返回true
        return fight(h) == 1;
    }

    public boolean isWeakerThan(Hand h){  //如果this输给了h返回true
        return fight(h) == -1;
    }

    private int fight(Hand h) {    //计分：平0 胜1  负-1
        if (this == h){
            return 0;
        }else if ((this.handValue + 1) % 3 == h.handValue){
            return 1;
        }else {
            return -1;
        }
    }

    public String toString(){
        return name[handValue];    //转换为手势值所对应的字符串
    }

}
