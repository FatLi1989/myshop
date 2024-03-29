package novli.nacos.myshop.service.consumer.item.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import novli.nacos.myshop.commons.domain.TbItem;
import novli.nacos.myshop.commons.dto.AbstractBaseResult;
import novli.nacos.myshop.commons.utils.JsonUtil;
import novli.nacos.myshop.commons.web.AbstractBaseController;
import novli.nacos.myshop.service.consumer.item.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author novLi
 * @date 2019年08月02日 18:16
 */
@RestController
@RequestMapping(value = "item")
public class TbItemController extends AbstractBaseController<TbItem> {

    @Autowired
    TbItemService tbItemService;

    @ApiOperation(value = "商品分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "num", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "笔数", required = true, paramType = "path", dataType = "int")
    })
    @GetMapping(value = "page/{num}/{size}")
    public AbstractBaseResult page(@PathVariable int num, @PathVariable  int size) {
        String json = tbItemService.page(num, size);
        try {
            JavaType javaType = JsonUtil.getCollectionType(PageInfo.class, TbItem.class);
            PageInfo<TbItem> pageInfo = JsonUtil.getInstance().readValue(json, javaType);
            return success(request.getRequestURI(), pageInfo.getNextPage(), pageInfo.getPages(), pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
