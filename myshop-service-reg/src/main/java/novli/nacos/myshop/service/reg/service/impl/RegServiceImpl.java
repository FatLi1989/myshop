package novli.nacos.myshop.service.reg.service.impl;

import lombok.extern.slf4j.Slf4j;
import novli.nacos.myshop.commons.constant.QueueConstant;
import novli.nacos.myshop.commons.domain.TbUser;
import novli.nacos.myshop.commons.utils.JsonUtil;
import novli.nacos.myshop.service.reg.service.RegService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author novLi
 * @date 2019年08月02日 09:41
 */
@Slf4j
@Service
public class RegServiceImpl implements RegService {


    @Autowired
    AmqpTemplate amqpTemplate;

    @Async
    @Override
    public String sendEmail(TbUser user) throws Exception {
        log.info("【线程 {} 执行注册】",Thread.currentThread().getName());
        amqpTemplate.convertAndSend(QueueConstant.EMAIL_EXCHANGE_NAME, QueueConstant.EMAIL_ROUTING_KEY, JsonUtil.obj2json(user));
        return "注册邮件已经发送";
    }
}
