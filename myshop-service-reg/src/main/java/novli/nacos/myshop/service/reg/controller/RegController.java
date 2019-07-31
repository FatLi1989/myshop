package novli.nacos.myshop.service.reg.controller;

import novli.nacos.myshop.commons.domain.TbUser;
import novli.nacos.myshop.commons.dto.AbstractBaseResult;
import novli.nacos.myshop.commons.service.TbUserService;
import novli.nacos.myshop.commons.web.AbstractBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author novLi
 * @date 2019年07月31日 10:24
 */
@RestController
@RequestMapping(value = "reg")
public class RegController extends AbstractBaseController<TbUser> {


    @Autowired
    private TbUserService tbUserService;

    /**
     * 用户注册
     *
     * @return
     */
    @PostMapping("")
    public AbstractBaseResult reg(@RequestBody @Valid TbUser tbUser, BindingResult result) {
        if (result.hasErrors()) {
            return error(result.getFieldError().getDefaultMessage(), null);
        }
        // 验证用户名是否重复
        if (!tbUserService.unique("username", tbUser.getUsername())) {
            return error("用户名重复，请重试", null);
        }
        // 验证邮箱是否重复
        if (!tbUserService.unique("email", tbUser.getEmail())) {
            return error("邮箱重复，请重试", null);
        }
        // 注册用户
        tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
        TbUser user = tbUserService.save(tbUser);
        if (user != null) {
            response.setStatus(HttpStatus.CREATED.value());
            return success(request.getRequestURI(), user);
        }
        // 注册失败
        return error("注册失败，请重试", null);
    }
}
