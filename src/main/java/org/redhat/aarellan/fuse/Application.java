/*
 * Copyright 2005-2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.redhat.aarellan.fuse;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.HttpComponent;
import org.apache.camel.component.netty4.http.NettyHttpComponent;
import org.apache.camel.component.netty4.http.NettyHttpConfiguration;
import org.apache.camel.spring.boot.SpringBootXmlCamelContextConfigurer;
import org.redhat.aarellan.fuse.http.CustomeHttpClientConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class Application extends SpringBootXmlCamelContextConfigurer {
	
	@Autowired
	CamelContext camelContext;
	
	String host = "localhost";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    class RestApi extends RouteBuilder {

        @Override
        public void configure() throws Exception {
        	HttpComponent httpComponent = getContext().getComponent("http", HttpComponent.class);
        	httpComponent.setHttpClientConfigurer(new CustomeHttpClientConfigurer());
        	
        	NettyHttpComponent nettyComponent = getContext().getComponent("netty4-http", NettyHttpComponent.class);
        	NettyHttpConfiguration configuration = nettyComponent.getConfiguration();
        	configuration.setProducerPoolEnabled(false);
        	configuration.setReuseChannel(true);
        	configuration.setReuseAddress(true);
        	configuration.setWorkerCount(1);
        }
    }
}
