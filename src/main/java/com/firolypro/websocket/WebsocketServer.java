package com.firolypro.websocket;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * com.firolypro.websocket
 * lihaoyang
 * 2018/7/6
 * 下午1:44
 **/

@CrossOrigin
@ServerEndpoint(value = "/websocket/")
@Component
public class WebsocketServer {

    private static int onlineCount = 0;

    private Session session;

    private static Map<String,Session> sessionPool = new HashMap<String,Session>();

    private static Map<String,String> sessionIds = new HashMap<String, String>();



    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        addonlineCount();
        sessionPool.put(session.getId(),session);
        sessionIds.put(session.getId(),session.getId());
        System.out.println("有新链接加入，当前在线人数是："+getOnlineCount());
        System.out.println("Welcome:"+session.getId());
        sendMessage("Welcome:"+session.getId(),session.getId());

    }

    @OnClose
    public void onClose(Session session){
        subonlineCount();
        sessionPool.remove(sessionIds.get(session.getId()));
        sessionIds.remove(session.getId());
        System.out.println("GoodBye："+session.getId());
        System.out.println("有人下线，当前在线人数是："+getOnlineCount()+"下线的是：" +session.getId());

    }

    @OnMessage
    public void onMessage(String message){
        System.out.println("发送人："+sessionIds.get(session.getId())+"发送的内容是："+message);

        JSONObject obj  = new JSONObject(message);
        String userid = obj.getString("userid");
        String messages = obj.getString("message");
        sendMessage(messages,userid);


    }


    @OnError
    public void onError(Session session,Throwable error){
        error.printStackTrace();
    }



    public static void sendMessage(String message,String userId){
        Session s = sessionPool.get(userId);
        if(s!=null){
            try{
                s.getBasicRemote().sendText(message);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static synchronized void addonlineCount(){
        WebsocketServer.onlineCount++;
    }

    private static synchronized void subonlineCount(){
        WebsocketServer.onlineCount--;
    }

    private static synchronized String getOnlineCount(){
        return String.valueOf(onlineCount);
    }
}

