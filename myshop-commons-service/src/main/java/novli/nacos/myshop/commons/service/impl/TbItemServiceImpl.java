package novli.nacos.myshop.commons.service.impl;

import novli.nacos.myshop.commons.domain.TbItem;
import novli.nacos.myshop.commons.mapper.TbItemMapper;
import novli.nacos.myshop.commons.service.TbItemService;
import org.springframework.stereotype.Service;

/**
 * @author novLi
 * @date 2019年08月02日 17:19
 */
@Service
public class TbItemServiceImpl extends BaseCrudServiceImpl<TbItem, TbItemMapper> implements TbItemService {
}
