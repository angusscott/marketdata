package codes.angus.marketdata;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/*
 * WebSocket client application. Performs client side setup and sends
 * messages.
 *
 * @Author Jay Sridhar
 */
public class Application {

	@Autowired
	public static void setConfiguration(GDAXConnectionConfiguration configuration) {
		Application.configuration = configuration;
	}

	private static GDAXConnectionConfiguration configuration;

	public static void main(String args[]) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		BeanFactory factory = context;
		GDAXConnectionConfiguration test = (GDAXConnectionConfiguration) factory.getBean("GDAXConnectionConfiguration");
		WebSocketClient webSocketClient = new StandardWebSocketClient();
//		Application.configuration = new GDAXConnectionConfiguration();
		String url = "wss://ws-feed.gdax.com";
		AbstractWebSocketHandler webSocketHandler = new GDAXWebSocketHandler(Application.configuration);

		webSocketClient.doHandshake(webSocketHandler, url);
		System.in.read();
	}
}
