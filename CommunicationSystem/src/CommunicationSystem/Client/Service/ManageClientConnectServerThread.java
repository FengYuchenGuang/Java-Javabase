package CommunicationSystem.Client.Service;

import java.util.HashMap;

/**
 * @author hxz
 * 管理客户端连接到服务器端的线程的类
 */
public class ManageClientConnectServerThread {
    //把多个线程放入到 HashMap 集合中，
    //key 为 用户id  vaule 就是线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    public static void addClientConnectServerThread(String uid,ClientConnectServerThread ccst){
        hm.put(uid,ccst);
    }

    //通过 userId 得到对应线程
    public static ClientConnectServerThread getClientConnectServerThread(String uid){
        return hm.get(uid);
    }
}
