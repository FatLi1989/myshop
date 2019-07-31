package novli.nacos.myshop.commons.service.impl;

import novli.nacos.myshop.commons.domain.TbUser;
import novli.nacos.myshop.commons.mapper.TbUserMapper;
import novli.nacos.myshop.commons.service.TbUserService;
import org.springframework.stereotype.Service;

/**
 * @author novLi
 * @date 2019年07月31日 16:54
 */
@Service
public class TbUserServiceImpl extends BaseCrudServiceImpl<TbUser, TbUserMapper> implements TbUserService {
}
