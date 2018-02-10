package codes.angus.marketdata;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;


@Component
public class GDAXWebSocketHandler extends AbstractWebSocketHandler {

    private GDAXConnectionConfiguration configuration;

    public GDAXWebSocketHandler(GDAXConnectionConfiguration configuration) {
        this.configuration = configuration;
    }

//    public static String getConnectionConfiguration(){
//        JsonArray ja = new JsonArray();
//        ja.add("ETH-EUR");
//
//        JsonObject jo = new JsonObject();
//        jo.addProperty("type", "subscribe");
//        jo.add("product_ids", ja);
//        return jo.toString();

//    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(new TextMessage(configuration.getConnectionConfiguration()));
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println(message.getPayload());
    }
}
