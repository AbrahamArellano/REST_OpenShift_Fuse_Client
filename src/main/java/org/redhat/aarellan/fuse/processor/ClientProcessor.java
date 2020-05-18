package org.redhat.aarellan.fuse.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.netty4.http.NettyHttpComponent;
import org.apache.camel.component.netty4.http.NettyHttpConfiguration;
import org.apache.camel.component.netty4.http.NettyHttpMessage;

public class ClientProcessor implements Processor {
	
	private static String cookie;

	@Override
	public void process(Exchange exchange) throws Exception {
		if (exchange.getIn().getClass().equals(NettyHttpMessage.class)) {
			NettyHttpMessage message = (NettyHttpMessage) exchange.getIn();
			if (cookie == null && message.getHeader("Set-Cookie") != null)
				setCookie(message.getHeader("Set-Cookie", String.class));
		}
		NettyHttpComponent nettyHttpComponent = exchange.getContext().getComponent("netty4-http", NettyHttpComponent.class);
		NettyHttpConfiguration configuration = nettyHttpComponent.getConfiguration();
		int port = configuration.getPort();

//		System.out.println("\n***********************************");
//		System.out.println("Response: " + exchange.getIn().);
//		System.out.println("***********************************\n");
	}

	public static String getCookie() {
		if (cookie == null)
			return "";
		return cookie;
	}

	public static void setCookie(String cookie) {
		ClientProcessor.cookie = cookie;
	}
	
	

}
