package CommunicationSystem.Client.Service;

import CommunicationSystem.QQCommon.Message;
import CommunicationSystem.QQCommon.MessageType;

import java.io.*;

/**
 * @author hxz
 * 该类/对象完成 文件传输服务
 */
public class FileClientService {

    /**
     * @param senderUid 发送者 Uid
     * @param getterUid 接收者 Uid
     * @param src       源文件
     * @param dest      把该文件传输到对方的哪个目录
     */
    public void sendFileToOne(String senderUid, String getterUid, String src, String dest) {
        //读取 src 文件 --> message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_SEND_FILE);
        message.setSender(senderUid);
        message.setGetter(getterUid);
        message.setSrc(src);
        message.setDest(dest);
        System.out.println(senderUid + " 给 " + getterUid + " 发送文件：从 " + src + " 到对方 " + dest);

        //需要将文件读取
        FileInputStream fileInputStream = null;
        int len = (int)new File(src).length();
        message.setFileLen(len);
        byte[] fileBytes = new byte[len];

        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes); //将src文件读入到程序的字节数组
            //将文件对应的字节数组设置 message
            message.setFileBytes(fileBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //发送
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderUid).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
