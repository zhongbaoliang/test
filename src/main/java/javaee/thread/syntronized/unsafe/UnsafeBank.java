package javaee.thread.syntronized.unsafe;

//不安全的银行
//两个人在银行取钱，账户
//Drawing.run加上synchronized不能解决，因为run的this是Drawing
//而操作的对象是Account

public class UnsafeBank {
    public static void main(String[] args) {
        Account account=new Account(100,"老婆本");
        Drawing boy = new Drawing(account,50,"boy");

        Drawing girl = new Drawing(account,100,"girl");
        //Drawing drawing=new Drawing(account,50,"boy");
        boy.start();
        girl.start();
    }
}

//账户
class Account{
    int money;
    String id;
    public Account(int money,String id) {
        this.money = money;
        this.id=id;
    }
}

//银行 取钱
class Drawing extends Thread{
    Account account;//账户
    int drawingMoney;//取多少钱

    public Drawing(Account account,int drawingMoney,String name) {
        super(name);
        this.account=account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    @Override
    public void run(){
        if(account.money-drawingMoney<0){
            //this.getName()=Thread.currentThread().getName()
            System.out.println(Thread.currentThread().getName()+"取款时余额不足");
            return;
        }

        //sleep()放大问题的发生性
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money=account.money-drawingMoney;
        System.out.println(this.getName() + "取款  "+drawingMoney);
        System.out.println(account.id + "余额为 "+account.money);

    }
}

