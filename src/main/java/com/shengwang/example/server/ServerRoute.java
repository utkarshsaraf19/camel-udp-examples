package com.shengwang.example.server;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.Main;

public class ServerRoute extends RouteBuilder {
    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void configure() throws Exception {
        from("netty:udp://100.1.1.1:2090?sync=true&allowDefaultCodec=false&encoder=#stringEncoder&decoder=#stringDecoder")
                .to("bean:echoService");
    }
}