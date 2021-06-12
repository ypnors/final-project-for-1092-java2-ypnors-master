package finaltest;

import java.util.*;
interface player {
    final static String[][] cname={{"梅花","方塊","紅心","黑桃"},
            {"Club","Diamond","Hearts","Spades"},
            {"花","塊","心","桃"},
            {"C","D","H","S"}};
    /**** method 用來show出第幾張牌 ******/
    abstract public String show(int id);
    abstract public int card_num();
    /**** 發牌的方法設定為abstract ******/
    abstract public void set_card(int x);
    /****** 要不要再發牌的方法設定為 abstract *******/

    abstract public boolean isgo(); //決定要不要再要牌
    abstract public int get_card_value(); //不寫在這裡會發生錯誤
}