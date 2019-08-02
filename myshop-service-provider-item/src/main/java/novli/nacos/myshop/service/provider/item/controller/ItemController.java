package novli.nacos.myshop.service.provider.item.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import novli.nacos.myshop.commons.domain.TbItem;
import novli.nacos.myshop.commons.service.TbItemService;
import novli.nacos.myshop.commons.web.AbstractBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author novLi
 * @date 2019年08月02日 17:15
 */
@RestController
@RequestMapping(value = "item")
public class ItemController extends AbstractBaseController<TbItem> {

    @Autowired
    private TbItemService tbItemService;

    @ApiOperation(value = "商品分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "笔数", required = true, paramType = "path", dataType = "int")
    })
    @GetMapping(value = "page/{num}/{size}")
    public PageInfo<TbItem> page(@PathVariable int num, @PathVariable int size) {
        return tbItemService.page(null, num, size);
    }
}
