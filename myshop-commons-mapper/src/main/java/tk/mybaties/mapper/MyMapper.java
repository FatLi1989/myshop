package tk.mybaties.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author novLi
 * @date 2019年07月31日 09:26
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
