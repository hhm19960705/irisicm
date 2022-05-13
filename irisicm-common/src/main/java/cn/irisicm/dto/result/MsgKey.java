package cn.irisicm.dto.result;

/**
 * @author hmhu6
 */
public final class MsgKey {
    /**
     * 成功前缀
     */
    protected static final String SUCC_PRFIX = "success.";
    /**
     * 失败前缀
     */
    protected static final String ERROR_PRFIX = "error.";

    /**
     * 操作成功
     */
    public static final String SUCCESS_OPERATION = SUCC_PRFIX + "operation";

    /**
     * 操作失败
     */
    public static final String ERROR_OPERATION = ERROR_PRFIX + "operation";

    /**
     * 非法参数
     */
    public static final String ERROR_ILLEGAL_PARAM = ERROR_PRFIX + "illegal.param";

    /**
     * 网络异常
     */
    public static final String ERROR_NET_EXCEPTION = ERROR_PRFIX + "net.exception";

    /**
     * 服务异常
     */
    public static final String ERROR_SERVER_EXCEPTION = ERROR_PRFIX + "server.exception";

    /**
     * 用户名或密码错误
     */
    public static final String ERROR_PSW_OR_ACCOUNT = ERROR_PRFIX + "passwd.or.account";

    /**
     * 您输入的账户或密码信息不完整
     */
    public static final String ERROR_INCOMPLETE_LOGIN_INFO = ERROR_PRFIX + "incomplete.login.info";

}
