package Key_questions;

public class MutipleThreadOutput {
    static int count = 0;
    /**
     * 两个线程交替打印奇数和偶数
     */
    public static void printJiOuIn2thread() {
        Class clazz = MutipleThreadOutput.class;
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (clazz) {
                    for (int i = 0; i < 100; i++) {
                        if (count % 2 == 0) {
                            System.out.print(Thread.currentThread().getName() + ":" + (++count)+" ");
                            clazz.notify();
                            try {
                                clazz.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }, "打印奇thread").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (clazz) {
                    for (int i = 0; i < 100; i++) {
                        if (count % 2 == 1) {
                            System.out.print(Thread.currentThread().getName() + ":" + (++count)+" ");
                            clazz.notify();
                            try {
                                clazz.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }, "打印偶thread").start();
    }

    /**
     * 两个线程交替打印 0,1
     */
    public static void printOneAndZero2Thread(){
        Class clazz = MutipleThreadOutput.class;
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (clazz){
                    for (int i = 0; i <100 ; i++) {
                        System.out.print(0+" ");
                        clazz.notify();
                        try {
                            clazz.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (clazz){
                    for (int i = 0; i < 100; i++) {
                        System.out.print(1+" ");
                        clazz.notify();
                        try {
                            clazz.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
    public static void main(String[] args) {
        printJiOuIn2thread();
    }
}


