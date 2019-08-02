package novli.nacos.myshop.service.reg.service;

import novli.nacos.myshop.commons.domain.TbUser;

public interface RegService {

    String sendEmail(TbUser user) throws Exception;
}
