package cn.irisicm.dto.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

/**
 * @author hmhu6
 */
@ApiModel(value = "Result<T>", description = "返回给前端的封装器")
public class Result<T> extends BaseMessage {
    /**
     * 返回的结果状态
     */
    @ApiModelProperty(value = "返回的结果状态")
    private boolean flag;

    /**
     * 返回的结果
     */
    @ApiModelProperty(value = "返回的结果")
    private T result;

    /**
     * 默认构造方法
     */
    public Result() {
        super("");
    }

    /**
     * @param flag   flag
     * @param key    key
     * @param result result
     */
    public Result(boolean flag, String key, T result) {
        super(key);
        this.flag = flag;
        this.result = result;
    }

    /**
     * @param flag flag
     * @param key  key
     */
    public Result(boolean flag, String key, String message) {
        super(key);
        this.flag = flag;
        this.setMsg(message);
    }

    /**
     * @param flag flag
     * @param key  key
     */
    public Result(boolean flag, String key) {
        super(key);
        this.flag = flag;
    }

    /**
     * @param key key
     */
    public Result(String key) {
        super(key);
        if (!StringUtils.isEmpty(key)) {
            if (key.startsWith(MsgKey.SUCC_PRFIX)) {
                this.flag = true;
            } else if (key.startsWith(MsgKey.ERROR_PRFIX)) {
                this.flag = false;
            }
        }
    }

    /**
     * @param key    key
     * @param result result
     */
    public Result(String key, T result) {
        super(key);
        this.result = result;
        if (!StringUtils.isEmpty(key)) {
            if (key.startsWith(MsgKey.SUCC_PRFIX)) {
                this.flag = true;
            } else if (key.startsWith(MsgKey.ERROR_PRFIX)) {
                this.flag = false;
            }
        }
    }

    /**
     * @return 返回 flag.
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * @param flag 设置 flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * @return 返回 result.
     */
    public T getResult() {
        return result;
    }

    /**
     * @param result 设置 result
     */
    public void setResult(T result) {
        this.result = result;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Result [flag=" + flag + ", result=" + result + ", getKey()=" + getKey() + ", getMessage()=" + getMsg()
                + "]";
    }
}

