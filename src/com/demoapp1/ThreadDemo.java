package com.demoapp1;
class Q
{
    int num;
    boolean valueSet = false;
    public synchronized void setQ(int num)
    {
        while(valueSet)
        {
            try{
                wait();
            }catch(Exception e){}
        }
        System.out.println("Set : "+num);
        this.num = num;
        valueSet=true;
        notify();
    }

    public synchronized void getQ()
    {
        while(!valueSet)
        {
            try{
                wait();
            }catch(Exception e){}
        }
        System.out.println("Get : "+num);
        valueSet=false;
        notify();
    }

}

class Producer
{
    Q q;
    Producer(Q q)
    {
        this.q = q;
        Thread p = new Thread( producer,"producer");
        p.start();

    }
    Thread producer = new Thread(new Runnable() {
        @Override
        public void run() {
            int i =0;
            while(true)
            {
                q.setQ(i++);
                try{
                    Thread.sleep(1000);
                }catch(Exception e){}
            }

        }
    });
}

class Consumer
{
    Q q;
    Consumer(Q q)
    {
        this.q = q;
        Thread c = new Thread(consumer,"consumer");
        c.start();
    }
    Thread consumer = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true)
            {
                q.getQ();
                try{
                    Thread.sleep(5000);
                }catch(Exception e){}
            }
        }
    });
}

public class ThreadDemo {

    public static void main(String[] args)
    {
         Q q = new Q();
         new Producer(q);
         new Consumer(q);
    }
}
