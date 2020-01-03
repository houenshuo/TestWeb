package dataCollect.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallBackInterface extends Remote {
    //提供给Server端调用的回调接口
    public String disp_Time(long time,String serverName) throws RemoteException;
}
