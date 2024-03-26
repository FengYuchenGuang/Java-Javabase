package CommunicationSystem.Server.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hxz
 * 服务器 管理客户端的线程
 */
public class ManageClientThreads {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    //添加线程对象到 hm 集合
    public static void addClientThread(String uid, ServerConnectClientThread serverConnectClientThread) {
        hm.put(uid, serverConnectClientThread);
    }

    //移除
    public  static void removeClientThread(String uid){
        hm.remove(uid);
    }

    //根据 uid 获取 对应线程
    public static ServerConnectClientThread getServerConnectClientThread(String uid) {
        return hm.get(uid);
    }

    //返回在线用户列表
    public static String getOnlineUser() {
        //遍历集合
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            onlineUserList += iterator.next() + " ";
        }
        return onlineUserList;
    }

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }
}
