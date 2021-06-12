package finaltest;

public class Tester {

    public  static  void  main(String[] args)
        {
            int i,j,x;
            int[] dcard=new int[52];	//用來記錄該位牌是否已被發出
            int num=5;
            int A,B;
            Random randomG=new Random();
            player p[];
            p=new player[4];//定義四家玩家,配置空間給陣列
            p[0]=new p21a(); //為每個元素配置物件
            p[1]=new p21b(); //為每個元素配置物件
            p[2]=new p21a(); //為每個元素配置物件
            p[3]=new p21b(); //為每個元素配置物件
//---------------起始值設定------
            for (i=0;i<=51;i=i+1)
                dcard[i]=0;

//-------------由電腦亂數發牌------
            for (j=0;j<num;j=j+1)  //最多發5張就可以過5關了
                for (i=0;i<4;i=i+1) //發給一家
                {
                    x=randomG.nextInt(52);
                    while (dcard[x]!=0) x=randomG.nextInt(52);
                    if (p[i].isgo())
                    {
                        p[i].set_card(x);
                        dcard[x]=1;
                        System.out.print("第 "+(i+1)+" 家要牌得到：");
                        System.out.println(p[i].show(j)+"  目前"+p[i].get_card_value()+"點");
                    }
                    else System.out.println("第 "+(i+1)+" 家不要牌了");
                }
//秀出最後結果
            System.out.println("========================最後的結果====================");
            for (i=0;i<4;i=i+1)
            {
                num=p[i].card_num();//取得真正的牌數
                System.out.print("第 "+(i+1)+" 家的牌：");
                for (j=0;j<num;j=j+1)
                {
                    System.out.print(p[i].show(j)+"  ");
                }
                if (p[i].get_card_value() > 21)
                    System.out.println("積點是"+p[i].get_card_value()+"點!爆了！");
                else
                {
                    if (num>=5) System.out.print("喔！過五關囉！ ");
                    System.out.println("積點是"+p[i].get_card_value()+"點");
                }
            }
        }
    }

