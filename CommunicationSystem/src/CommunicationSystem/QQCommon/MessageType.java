package CommunicationSystem.QQCommon;

/**
 * @author hxz
 */
public interface MessageType {
    //在接口中定义一些常量，表示一些 基础的常见的消息类型。
    //不同常量，表示不同值
    String MESSAGE_LOGIN_SUCCEED = "1";//表示登录成功
    String MESSAGE_LOGIN_FAIL = "2";//表示登录失败
    String MESSAGE_COMM_MES = "3";//普通信息包
    String MESSAGE_GET_ONLINE_FRIEND = "4";//要求返回在线用户列表
    String MESSAGE_RET_ONLINE_FRIEND = "5";//返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6";//客户端请求退出
    String MESSAGE_TO_ALL_MES = "7";//群发消息
    String MESSAGE_SEND_FILE = "8";//发送文件
    String MESSAGE_NEWS_TO_ALL = "9";//服务器推送消息
    String MESSAGE_OFFLINE_CONTENT  = "10";//询问是否有离线消息


}
