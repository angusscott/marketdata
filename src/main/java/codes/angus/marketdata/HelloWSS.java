package codes.angus.marketdata;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketFactory;

/**
 * Mendekotasunak:  (maven bidez instalatu)
 * 		gson-2.8.2
 *      nv-websocket-client-2.3
 *
 * @author juanan
 *
 */
public class HelloWSS
{
    public static void main(String[] args) throws Exception
    {

        JsonArray ja = new JsonArray();
        ja.add("BTC-EUR");
        ja.add("ETH-EUR");

        JsonObject jo = new JsonObject();
        jo.addProperty("type", "subscribe");
        jo.add("product_ids", ja);



        System.out.println(jo.toString());

/*    initialMessage = {
    			  "type": "subscribe",
    	          "product_ids": [ "BTC-EUR", "ETH-EUR"]
    	          }

*/


        // Connect to "wss://" and send your message to it.
        // When a response from the WebSocket server is received, print it
        // Don't forget to close the WebSocket connection
        new WebSocketFactory()
                .createSocket("wss://ws-feed.gdax.com")
                .addListener(new WebSocketAdapter() {
                    @Override
                    public void onTextMessage(WebSocket ws, String message) {
                        // Received a response. Print the received message.
                        System.out.println(message);

                        // Close the WebSocket connection.
                        // ws.disconnect();
                    }
                })
                .connect()
                .sendText(jo.toString());
    }
}
