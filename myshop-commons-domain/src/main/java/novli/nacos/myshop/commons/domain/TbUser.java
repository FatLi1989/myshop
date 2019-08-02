package novli.nacos.myshop.commons.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import novli.nacos.myshop.commons.dto.AbstractBaseDomain;
import novli.nacos.myshop.commons.utils.RegexpUtils;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Table(name = "tb_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TbUser extends AbstractBaseDomain {

    /**
     * 用户名
     */
    @Setter
    @Getter
    @NotNull(message = "用户名不可为空")
    @Length(min = 5, max = 20, message = "用户名长度必须介于 5 和 20 之间")
    private String username;

    /**
     * 密码，加密存储
     */
    @Setter
    @Getter
    private String password;

    /**
     * 注册手机号
     */
    @Setter
    @Getter
    private String phone;

    /**
     * 注册邮箱
     */
    @Setter
    @Getter
    @NotNull(message = "邮箱不可为空")
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;


}
