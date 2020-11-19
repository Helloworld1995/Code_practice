package Key_questions;

/**
 * 生产者消费模式
 */
public class MyProducterAndConsumerModel {
    public static void main(String[] args) {
        Container container=new Container();
        Productor productor=new Productor(container);
        Consumer consumer=new Consumer(container);
        new Thread(productor,"生产者").start();
        new Thread(consumer,"消费者").start();
    }
}
class Container{
    int capactity=0;
}
class Productor implements Runnable {
    Container container;

    public Productor(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        synchronized (container) {
            if (container.capactity == 0) {
                    for (int i = 0; i < 100; i++) {
                    container.capactity++;
                    System.out.println(Thread.currentThread().getName() + "生产了第" + container.capactity);
                    container.notify();
                }
            }
            try {
                container.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable {
    Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        synchronized (container) {
                if (container.capactity > 0) {
                    for (int i = 0; i < 100; i++) {
                        System.out.println(Thread.currentThread().getName() + "消费了第" + container.capactity);
                        container.capactity--;
                    }

                }
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                }
           }
        }
    }



