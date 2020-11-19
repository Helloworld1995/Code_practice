package JUC;

/**
 *生产者消费者模式
 */
public class MyConsumerAndProducer {
    public static void main(String[] args) {
        Shop shop=new Shop();
        Thread t=new Thread(new Producer(shop));
        t.start();
        Thread t2=new Thread(new Consumer(shop));
        t2.start();
    }
}
class Shop{
    Good[] goods=new Good[10];
    int count=0;
    public synchronized void push(Good good){
      while(count==goods.length){
          try {
              this.wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
      goods[count]=good;
      count++;
      this.notify();
    }
    public synchronized Good pop(){
        while(count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        count--;
        return goods[count];
    }
}
class Good{
    int k;
    public Good(int k){
        this.k=k;
    }
}
class Producer implements Runnable{
    Shop shop;
    public Producer(Shop shop){
        this.shop=shop;
    }
    @Override
    public void run() {
        for (int i = 0; i <24 ; i++) {
            System.out.println("生产第"+i+"个商品");
            shop.push(new Good(i));
        }
    }
}
class Consumer implements Runnable{
    Shop shop;
    public Consumer(Shop shop){
        this.shop=shop;
    }
    @Override
    public void run() {
        for (int i = 0; i <24 ; i++) {
            System.out.println("消费第"+shop.pop().k+"商品");
        }
    }
}