package novli.nacos.myshop.service.email.service;

import lombok.extern.slf4j.Slf4j;
import novli.nacos.myshop.commons.domain.TbUser;
import novli.nacos.myshop.commons.utils.JsonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author novLi
 * @date 2019年08月02日 11:39
 */
@Slf4j
@Service
public class EmailService {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    JavaMailSender javaMailSender;

    @RabbitListener(queues = {"myShopQueue"})
    public void receiveMsg(String msg) {
        log.info("【线程 {} 准备发送邮件 : {}】",Thread.currentThread().getName(), msg);
        try {
            TbUser tbUser = JsonUtil.json2pojo(msg, TbUser.class);
            sendEmail("欢迎注册", "欢迎 " + tbUser.getUsername() + "使用myShop平台！", tbUser.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 发送普通邮件
     * @param subject
     * @param body
     * @param to
     */
    @Async
    public void sendEmail(String subject, String body, String to) {
        log.info("【线程 {} 发送邮件中 : {}】",Thread.currentThread().getName(), body);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(applicationContext.getEnvironment().getProperty("spring.mail.username"));
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }

}
