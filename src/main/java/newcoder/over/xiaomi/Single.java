package newcoder.over.xiaomi;

class Single1 {
    private static Single1 instance;

    static {
        try {
            instance = new Single1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Single1() throws Exception {
        Object o = new Object();
        o.wait();
        o.notify();
        o.notifyAll();
        if(instance!=null)
            throw new Exception();
    }

    public static Single1 getInstance(){
        return instance;
    }
}

class Single2{
    private static Single2 instance;
    private Single2() throws Exception {
        if(instance!=null)
            throw new Exception();
    }
    public static Single2 getInstance() throws Exception {
        if(instance==null){
            synchronized (Single2.class){
                if(instance==null)
                    instance = new Single2();
            }
        }
        return instance;
    }
}
