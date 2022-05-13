package cn.irisicm.util;

import cn.irisicm.entity.User;
import cn.irisicm.exception.MyException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang.StringUtils;

import java.util.Calendar;

/**
 * @author hmhu6
 */
public class JWTUtils {

    /**
     * 签名密钥
     */
    private static final String SECRET = "!DAR$";

    /**
     * 生成token
     *
     * @param u user
     * @return token字符串
     */
    public static String getToken(User u) {
        // 指定token过期时间为7天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);

        JWTCreator.Builder builder = JWT.create();
        // 构建payload
        builder.withClaim("userId", u.getId())
                .withClaim("username", u.getUsername());
        // 指定过期时间和签名算法
        return builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 解析token
     *
     * @param token token字符串
     * @return 解析后的token
     */
    public static DecodedJWT verify(String token) throws MyException {
        if (StringUtils.isEmpty(token)) {
            throw new MyException("token不能为空");
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        return jwtVerifier.verify(token);
    }
}

