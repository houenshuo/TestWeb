package dataCollect.client;

import dataCollect.server.CollectDataInterface;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SensorB {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        try {
            CollectDataInterface collectData = (CollectDataInterface) Naming.lookup("//"+"localhost"+":8989/CollectServer");
            Timer t = new Timer();
            //在这个线程里面创建Timer定时器
            TimerTask callback_task = new TimerTask(){
                public void run() {
                    try {
                        long startTime =System.currentTimeMillis();

                        int r =new Random().nextInt(100);
                        System.out.println("serverB发信息"+r);

                        long currentTime =System.currentTimeMillis();
                        if (currentTime -startTime <=1000)// 超过1s舍弃
                            collectData.regist("serverB",r,startTime);// currentTime 不确定 statTime总会间隔查过1s的 这样就不会在1s出现多个数据
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            //每隔seconds秒(客户端注册时指定)回调一次客户端接口
            t.schedule(callback_task,0,1*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
