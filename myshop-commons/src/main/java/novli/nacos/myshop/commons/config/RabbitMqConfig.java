package novli.nacos.myshop.commons.config;

import novli.nacos.myshop.commons.constant.QueueConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author novLi
 * @date 2019年08月02日 10:39
 */
@Configuration
public class RabbitMqConfig {



/*    @Bean
    Queue delayMsgQueue() {
        Map<String, Object> params = new HashMap<>();
        params.put("x-dead-letter-exchange", QueueConstant.EMAIL_EXCHANGE_NAME);
        params.put("x-dead-letter-routing-key", QueueConstant.EMAIL_ROUTING_KEY);
        return new Queue(QueueConstant.DELAY_QUEUE_NAME, true, false, false, params);
    }

    @Bean
    public DirectExchange emailDelayExchange() {
        return new DirectExchange(QueueConstant.DELAY_EXCHANGE_NAME, true , false);
    }

    @Bean
    public Binding dlxBinding() {
        return BindingBuilder.bind(delayMsgQueue()).to(emailDelayExchange()).with(QueueConstant.DELAY_ROUTING_KEY);
    }*/

    @Bean
    public Queue emailQueue() {
        return new Queue(QueueConstant.EMAIL_QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange emailExchange() {
        return new TopicExchange(QueueConstant.EMAIL_EXCHANGE_NAME, true , false);
    }

    @Bean
    public Binding emailBinding() {
        return BindingBuilder.bind(emailQueue()).to(emailExchange()).with(QueueConstant.EMAIL_ROUTING_KEY);
    }



}
