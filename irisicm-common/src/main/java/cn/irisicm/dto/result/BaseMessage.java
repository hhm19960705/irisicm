package cn.irisicm.dto.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author hmhu6
 */
@Slf4j
@ApiModel(value = "BaseMessage", description = "返回给前端的封装器")
public abstract class BaseMessage {

    /**
     * key
     */
    @ApiModelProperty(value = "错误码")
    private String key;

    /**
     * msg
     */
    @ApiModelProperty(value = "提示内容")
    private String msg;

    /**
     * 配置信息
     */
    private static PropertiesConfiguration msgProperties = null;

    /**
     * @param key key
     */
    public BaseMessage(String key) {
        super();
        this.key = key;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the message
     */
    public String getMsg() {
        if (StringUtils.isNotBlank(this.msg)) {
            return this.msg;
        }
        PropertiesConfiguration configuration = getMsgProperties();
        if (null == configuration) {
            return StringUtils.EMPTY;
        }
        String msg = configuration.getString(key);
        if (msg != null) {
            this.msg = msg;
        } else {
            try {
                this.msg = new String("提示信息未定义".getBytes(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                log.error("提示信息未定义编码类型转换错误", e);
            }
        }
        return this.msg;
    }

    /**
     * @param message the message to set
     */
    public void setMsg(String message) {
        this.msg = message;
    }

    /**
     * <p>
     * <code>getMsgProperties</code>获取配置信息
     * </p>
     *
     * @return PropertiesConfiguration
     */
    private static PropertiesConfiguration getMsgProperties() {
        if (null == msgProperties) {
            init();
        }
        return msgProperties;
    }

    /**
     * <p>
     * <code>init</code>配置初始化
     * </p>
     */
    private static void init() {
        try {
            msgProperties = new PropertiesConfiguration("config/message.properties");
        } catch (ConfigurationException e) {
            log.error("初始化提示信息未成功，文件不存在或路径不正确{}", "", e);
        }
    }

}
