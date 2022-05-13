package cn.irisicm.service.impl;

import cn.irisicm.dto.result.PageInfo;
import cn.irisicm.dto.search.UserSearch;
import cn.irisicm.entity.User;
import cn.irisicm.mapper.UserMapper;
import cn.irisicm.service.UserService;
import cn.irisicm.util.JWTUtils;
import cn.irisicm.util.MD5Utils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hmhu6
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public PageInfo<User> getUserInfo(UserSearch userSearch) {
        Page<User> userPage = new Page<>(userSearch.getCurrentPageNo(), userSearch.getPageSize());
        PageInfo<User> pageInfo = new PageInfo<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(userSearch.getUsername()), "username", userSearch.getUsername());
        pageInfo.setPageInfo(baseMapper.selectPage(userPage, queryWrapper));
        return pageInfo;
    }

    @Override
    public String login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", MD5Utils.string2MD5(password));
        User user = baseMapper.selectOne(queryWrapper);
        if (null != user) {
            return JWTUtils.getToken(user);
        } else {
            return "";
        }
    }
}
