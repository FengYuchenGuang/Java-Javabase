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

    //文件传输 扩展
    private byte[] fileBytes;
    private int fileLen = 0;
    private String dest;//文件传输到哪里
    private String src;//源文件路径

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

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
