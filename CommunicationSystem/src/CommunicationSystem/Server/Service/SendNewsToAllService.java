package CommunicationSystem.Server.Service;

import CommunicationSystem.QQCommon.Message;
import CommunicationSystem.QQCommon.MessageType;
import CommunicationSystem.Utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author hxz
 */
public class SendNewsToAllService implements Runnable {
    private Scanner scanner = new Scanner(System.in);


    @Override
    public void run() {
        //为了可以推送多次新闻，使用循环
        while (true){
            System.out.println("请输入服务器要推送的新闻/消息[输入 exit 退出推送服务]：");
            String news = Utility.readString(100);
            if ("exit".equals(news)){
                break;
            }
            //构建一个 Message
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_NEWS_TO_ALL);
            message.setSender("服务器");
            message.setContent(news);
            message.setSendTime(getCurrentTime());

            System.out.println("服务器推送消息给所有人(在线)，说：" + news);

            //遍历当前所有的通信线程，得到对应 socket，并发送 Message
            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String onlineUserUid =  iterator.next();
                try {
                    ObjectOutputStream oos =
                            new ObjectOutputStream(hm.get(onlineUserUid).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @return 返回发送时间
     */
    private String getCurrentTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateTimeFormatter.format(localDateTime);
        return currentTime;
    }
}
