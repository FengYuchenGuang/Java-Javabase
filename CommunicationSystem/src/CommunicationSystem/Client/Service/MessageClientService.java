package CommunicationSystem.Client.Service;

import CommunicationSystem.QQCommon.Message;
import CommunicationSystem.QQCommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author hxz
 * 该类/对象，提供和消息相关的服务对象
 */
public class MessageClientService {

    public void sendMessageToAll(String senderUid,String content){
        //构建Message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
        message.setSender(senderUid);
        message.setContent(content);
        message.setSendTime(getCurrentTime());//发送时间设置到 message 对象
        System.out.println(senderUid + " 对大家说 " + content);

        //发送给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderUid).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param senderUid 发送用户 id
     * @param getterUid 接收用户 id
     * @param content   内容
     */
    public void sendMessageToOne(String senderUid, String getterUid, String content) {
        //构建Message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(senderUid);
        message.setGetter(getterUid);
        message.setContent(content);
        message.setSendTime(getCurrentTime());//发送时间设置到 message 对象
        System.out.println(senderUid + " 对 " + getterUid + " 说 " + content);

        //发送给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderUid).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return 返回发送时间
     */
    public String getCurrentTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateTimeFormatter.format(localDateTime);
        return currentTime;
    }
}
