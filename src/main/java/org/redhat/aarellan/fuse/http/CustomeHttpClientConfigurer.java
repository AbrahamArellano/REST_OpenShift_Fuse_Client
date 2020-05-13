package org.redhat.aarellan.fuse.http;

import org.apache.camel.component.http.HttpClientConfigurer;
import org.apache.commons.httpclient.HttpClient;

public class CustomeHttpClientConfigurer implements HttpClientConfigurer {

	@Override
	public void configureHttpClient(HttpClient client) {
		client.getHostConfiguration().setHost("localhost", 8081);;
	}

}
