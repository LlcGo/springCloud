package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author Lc
 * @Date 2023/6/7
 * @Description
 */
@Component
@EnableBinding(Sink.class)
public class ConsummerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void geMessaage(Message<String> message){
        System.out.println("消费者2号------>接收到的消息:  "+message.getPayload() + "\t" + serverPort);
    }
}
