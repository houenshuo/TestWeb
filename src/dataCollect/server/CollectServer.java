package dataCollect.server;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CollectServer {
    //private static Map<String,RemoteInterface> concurrentHashMap =new ConcurrentHashMap();
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        //创建接受对8989端口的远程调用的注册表
        LocateRegistry.createRegistry(8989);
        //创建远程对象的实例(向客户端提供的服务)
        final CollectDataInterface collectDataImp = new CollectDataImp();
        //将远程对象绑定到地址(IP,Port),这样其他机器才能找到此服务
        try {
            Naming.bind("//localhost:8989/CollectServer", collectDataImp);
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

//        CallBackByString callBackByString =new CallBackByString();
//        //客户端获取服务端的远程代理对象（Stub对象）（是一个RegistryImpl的Stub对象，他与服务端的RegistryImpl的Skeleton对象之间是通过Socket通信的）
//        RemoteInterface sensorA = (RemoteInterface) Naming.lookup("//"+"localhost"+":8989/SensorA");
//        RemoteInterface sensorB = (RemoteInterface) Naming.lookup("//"+"localhost"+":8990/SensorB");
//        RemoteInterface sensorC = (RemoteInterface) Naming.lookup("//"+"localhost"+":8991/SensorC");
//        concurrentHashMap.put("鼠标传感器",sensorA);
//        concurrentHashMap.put("智能头环",sensorB);
//        concurrentHashMap.put("座椅传感器",sensorC);
//
//        for (Map.Entry<String,RemoteInterface> entry:concurrentHashMap.entrySet()){
//            Runnable r =()->{
//                RemoteInterface sensor =entry.getValue();
//                try {
//                    // 相当于sensor端的代码在这里执行
//                    sensor.regist( callBackByString,"接收来自"+entry.getKey()+"的信息",1);
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
//                System.out.printf("传感器："+entry.getKey()+"启动...\n");
//            };
//            Thread t = new Thread(r);
//            t.start();
//        }

    }
}
