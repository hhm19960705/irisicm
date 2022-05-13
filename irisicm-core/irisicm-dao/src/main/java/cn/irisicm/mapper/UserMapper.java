package cn.irisicm.mapper;

import cn.irisicm.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hmhu6
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 获取所有用户信息
     *
     * @return 用户信息
     */
    public List<User> findAllUser();
}
