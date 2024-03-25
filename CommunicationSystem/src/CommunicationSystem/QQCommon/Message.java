package CommunicationSystem.QQCommon;

import java.io.Serializable;

/**
 * @author hxz
 * 表示 客户端与服务器端 通信的一个消息对象
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    //发送者、接收者、发送时间、信息类型、信息内容
    private String sender;
    private String getter;
    private String sendTime;
    private String mesType;//消息类型可以在 接口 定义
    private String content;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
