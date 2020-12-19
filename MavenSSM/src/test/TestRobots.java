package test;

import service.ChatBotService;

public class TestRobots {
    public static void main(String[] args) throws Exception {

        String response = new ChatBotService().getResponse("现在几点");

        System.out.println(response);

//        {"result":0,"content":"现在时间是23点19分"}
    }
}
