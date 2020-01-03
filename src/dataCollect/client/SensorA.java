package dataCollect.client;

import dataCollect.server.CollectDataInterface;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SensorA {
    public static void main(String[] args) {

        try {
            CollectDataInterface collectData = (CollectDataInterface) Naming.lookup("//"+"localhost"+":8989/CollectServer");
            Timer t = new Timer();
            //在这个线程里面创建Timer定时器
            TimerTask callback_task = new TimerTask(){
                public void run() {
                    try {
                        long startTime =System.currentTimeMillis();
                        /**
                         * 获取传感器信息（不能忽略获取时间）
                         */
                        int r =new Random().nextInt(100);
                        System.out.println("serverA发信息"+r);

                        long currentTime =System.currentTimeMillis();
                        if (currentTime -startTime <=1000)// 获取时间超过1s的作废
                            collectData.regist("SmartHeadRing",r,startTime);
                    } catch (RemoteException e) {
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
