package CommunicationSystem.Server.Service;

import java.util.HashMap;

/**
 * @author hxz
 * 服务器 管理客户端的线程
 */
public class ManageClientThreads {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    //添加线程对象到 hm 集合
    public static void addClientThread(String uid, ServerConnectClientThread serverConnectClientThread){
        hm.put(uid, serverConnectClientThread);
    }

    //根据 uid 获取 对应线程
    public static ServerConnectClientThread getServerConnectClientThread(String uid){
        return hm.get(uid);
    }
}
