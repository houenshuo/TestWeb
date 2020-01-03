package dataCollect.server;

import dataCollect.client.CallBackInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 客户端远程调用接口
 */
public interface CollectDataInterface extends Remote {
    //提供给客户端远程调用的方法
    // 注册
    public  void regist( String serverName, int random,long time) throws RemoteException;

}
