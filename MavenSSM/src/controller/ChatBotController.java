package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ChatBotService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ChatBotController {

    private ChatBotService chatBotService;

//    {"result":0,"content":"现在时间是23点19分"}
    @RequestMapping(value = "/chat.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getChatResponse(String chatMsg){

        chatBotService = new ChatBotService();

        try {
            return chatBotService.getResponse(chatMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "服务端请求 API 服务器出错";
    }
}
