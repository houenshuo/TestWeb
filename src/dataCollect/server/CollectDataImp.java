package dataCollect.server;

import dataCollect.server.config.SensorName;
import dataCollect.server.domain.Data;
import dataCollect.server.domain.imp.SensorB;
import dataCollect.server.domain.imp.SensorC;
import dataCollect.server.domain.imp.SmartHeadRing;
import dataCollect.client.CallBackInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CollectDataImp extends UnicastRemoteObject implements CollectDataInterface {
    private Queue<Data> queue =new ArrayDeque();
    private long startTime =0;
    protected CollectDataImp() throws RemoteException {
    }
    // 设置内部对象锁
    // 前提 回调的方法必须是1s
    @Override
    public synchronized void  regist( String serverName, int random,long time) throws RemoteException {
        long currentTime =time;
        if (startTime ==0)// 开始存第一个数据
            startTime =currentTime;
        // 解析json

        //封装
        Data putData =null;
        if ("SmartHeadRing".equals(serverName)){
            SmartHeadRing smartHeadRing =new SmartHeadRing();
            smartHeadRing.setTime(time);
            smartHeadRing.setServerName(serverName);
            smartHeadRing.setRandom(random);
            putData =smartHeadRing;
        }else if ("serverB".equals(serverName)){
            SensorB sensorB =new SensorB();
            sensorB.setTime(time);
            sensorB.setServerName(serverName);
            sensorB.setRandom(random);
            putData =sensorB;
        }else if ("serverC".equals(serverName)){
            SensorC sensorC =new SensorC();
            sensorC.setTime(time);
            sensorC.setServerName(serverName);
            sensorC.setRandom(random);
            putData =sensorC;
        }
        if (currentTime -startTime>=1000){// 获取1秒内的数据
            // 从队列中取数据
            if (!queue.isEmpty()){
                StringBuffer joinData = new StringBuffer();
                long sum =0;
                List<String> currentSensors =new ArrayList();

                while (!queue.isEmpty()){
                    Data data =queue.poll();
                    if (data.getTime()-startTime<=1000){
                        if ("SmartHeadRing".equals(data.getServerName())){
                            // 做连接运算
                            joinData.append(data.getServerName()+data.getTime()+" "+((SmartHeadRing)data).getRandom());
                            joinData.append("\n");
                            sum+=((SmartHeadRing)data).getRandom();
                        }else if ("serverB".equals(data.getServerName())){
                            // 做连接运算
                            joinData.append(data.getServerName()+data.getTime()+" "+((SensorB)data).getRandom());
                            joinData.append("\n");
                            sum+=((SensorB)data).getRandom();
                        }else if ("serverC".equals(data.getServerName())){
                            // 做连接运算
                            joinData.append(data.getServerName()+data.getTime()+" "+((SensorC)data).getRandom());
                            joinData.append("\n");
                            sum+=((SensorC)data).getRandom();
                        }
                        currentSensors.add(data.getServerName());// 获取传感器的设备名称
                    }else {// 时间不在1s内，先缓存在队列中
                        break;
                    }
                }
                startTime =currentTime;
                // 检查未启动的设备
                if (!currentSensors.isEmpty()){
                    for (String sensorName: SensorName.sensorNames){
                       int i =0;
                       for (;i<currentSensors.size();i++){
                           if (sensorName.equals(currentSensors.get(i)))
                               break;
                       }
                       if (i==currentSensors.size())
                            // 没有找到 则输出
                            joinData.append(sensorName+"未连接"+"\n");
                    }
                }
                joinData.append("传感器信息总和"+sum+"\n");
                System.out.println(joinData.toString());
            }
        }
        if (putData!=null)
            queue.add(putData);
    }
}
