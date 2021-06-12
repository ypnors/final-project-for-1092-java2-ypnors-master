package finaltest;

class p21b implements player{
    private int[] card=new int[13];//記錄手上的牌
    private int card_cnt=0;
    private int card_pt=0;//記錄選定哪一組牌名
    private int card_value;
    private int status;//0:繼續收牌 1:停止發牌
    public p21b()
    {
        this(0);
    }
    public p21b(int cpt)
    {
        int i;
        card_pt=cpt;//可以設定選用不同牌名
        card_cnt=0;//預設選用中文全名
        for (i=0;i<13;i=i+1)  this.card[i]=-2;//用-2代表空牌
        card_value=0;//清理牌計數
        status=0;//設定收牌
    }
    public String show(int id)
    {
        int A,B;
        if (card[id]==-2) return ("沒有這張牌");
        else
        {
            A=card[id]%4;
            B=card[id]/4;
            B=B+2;
            if (B==14)
                return (cname[card_pt][A]+"A");
            else if (B==13)
                return (cname[card_pt][A]+"K");
            else if (B==12)
                return (cname[card_pt][A]+"Q");
            else if (B==11)
                return (cname[card_pt][A]+"J");
            else
                return (cname[card_pt][A]+B);
        }
    } //SHOW
    public int card_num() //傳回現在的牌數目
    {
        return card_cnt;
    }
    public boolean isgo() //決定要不要再要牌
    {
        if (status==1) return false;
        //以下改用發牌就算好的card_value
        if (card_value<18) return true; //大於18點才不要牌了
        return false;
    }
    public int get_card_value() //傳回現在的點數
    {
        return card_value;
    }
    public void set_card(int x)//overriding palyer的method，順便計算點數
    {
        int i,flag;
        int A,B;
        if (x>52 || x<0)
        {
            System.out.println("錯誤  x="+x);
            return;
        }
        //flag用來看看有沒有發到牌
        flag=0;
        A=0;
        for (i=0;i<13;i=i+1)
        {
            if (card[i]==-2) //那個位置沒有牌，發牌順便算牌
            {
                card[i]=x;
                flag=1;
                card_cnt=card_cnt+1;
                B=x/4+2;
                if (B>10 && B<14) B=10;//JKQ都算10
                if (B==14) A=A+1;//算有幾張A
                else card_value=card_value+B;
                break; //發完牌就可以跳出去了
            }//if card
        }//for
        card_value=card_value+A;//先把A算1
        while (card_value<21 && A>0)  //把A算成11試試看
        {
            card_value=card_value+10;
            if (card_value<=21) //如果不爆就算11
                A=A-1;
            else //如果會爆就算回A
            {
                card_value=card_value-10;
                break;
            }
        }
        if (flag==0) System.out.println("錯誤!本家發超過13張牌"+x);
    }

}