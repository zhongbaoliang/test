package javaee.thread.syntronized.unsafe;

public class DeadLock {


    public static void main(String[] args) {
        Makeup makeup1=new Makeup(0,"girl1");
        Makeup makeup2=new Makeup(1,"girl2");
        makeup1.start();
        makeup2.start();
    }
}


class Lipstick{ }

class Mirror{ }

class Makeup extends Thread{
    //static 保证只有一份资源
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();

    int choice;
    String name;

    public Makeup(int choice,String name) {
        this.choice = choice;
        this.name=name;
    }

    @Override
    public void run(){
        makeup2();
        System.out.println(this.name+"正常结束");
    }

    //会死锁
    private void makeup1(){
        if(choice==0){
            synchronized (lipstick){
                System.out.println(this.name + "获得了口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(this.name + "获得了镜子的锁");
                }

            }
        }
        else {
            synchronized (mirror){
                System.out.println(this.name + "获得了镜子的锁");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick){
                    System.out.println(this.name + "获得了口红的锁");
                }

            }
        }
    }


    //用完后释放锁
    private void makeup2(){
        if(choice==0){
            synchronized (lipstick){
                System.out.println(this.name + "获得了口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (mirror){
                System.out.println(this.name + "获得了镜子的锁");
            }
        }
        else {
            synchronized (mirror){
                System.out.println(this.name + "获得了镜子的锁");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lipstick){
                System.out.println(this.name + "获得了口红的锁");
            }
        }
    }

}