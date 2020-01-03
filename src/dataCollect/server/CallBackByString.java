package dataCollect.server;

import dataCollect.client.CallBackInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class CallBackByString extends UnicastRemoteObject implements CallBackInterface {
    private Map<String,Long> bufferMap =new HashMap<>();
    private long startTime =0;

    protected CallBackByString() throws RemoteException {
    }

    // 设置内部对象锁
    // 前提 回调的方法必须是1s
    @Override
    public synchronized String disp_Time(long time,String serverName) throws RemoteException {
       return null;
    }

}
