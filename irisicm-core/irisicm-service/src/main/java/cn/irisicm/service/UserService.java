package cn.irisicm.service;

import cn.irisicm.dto.result.PageInfo;
import cn.irisicm.dto.search.UserSearch;
import cn.irisicm.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hmhu6
 */
public interface UserService extends IService<User> {
    /**
     * 获取所有用户信息
     *
     * @return 用户信息
     */
    public List<User> findAllUser();

    /**
     * 分页获取所有用户信息
     * @param userSearch 查询条件
     * @return 用户信息
     */
    PageInfo<User> getUserInfo(UserSearch userSearch);

    /**
     * 用户登录
     * @param username 姓名
     * @param password 密码
     * @return token
     */
    String login(String username,String password);

}
