package cn.irisicm.config;

import cn.irisicm.exception.MyException;
import cn.irisicm.util.JWTUtils;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hmhu6
 */
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new MyException("token不能为空");
        }
        try {
            JWTUtils.verify(token);
        } catch (SignatureVerificationException e) {
            throw new MyException("无效签名！");
        } catch (TokenExpiredException e) {
            throw new MyException("token过期！");
        } catch (AlgorithmMismatchException e) {
            throw new MyException("token算法不一致！");
        } catch (Exception e) {
            throw new MyException("token无效！");
        }
        return true;
    }
}
