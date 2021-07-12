package com.lht.mahjong.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebsocketManager implements WebSocketHandler {

    private Map<Long, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Long playerId = (Long) session.getAttributes().get("playerId");
        sessionMap.put(playerId, session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        Long playerId = (Long) session.getAttributes().get("playerId");
        //获取消息
        String body = (String) message.getPayload();

        //一系列的处理之后...

        //发送消息
        session.sendMessage(message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        Long playerId = (Long) session.getAttributes().get("playerId");
        sessionMap.remove(playerId);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
