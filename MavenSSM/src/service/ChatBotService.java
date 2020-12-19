package service;

import util.QingYunKeRobot;

public class ChatBotService {
    private static final String url = "http://api.qingyunke.com/api.php";

    private static final String key = "free";

    public  String getResponse(String msg) throws Exception {
        return QingYunKeRobot.getQingYunKe(url, key,msg);
    }

    public ChatBotService() {
    }
}