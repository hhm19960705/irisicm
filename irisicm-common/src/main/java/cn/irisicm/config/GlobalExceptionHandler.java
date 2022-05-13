package cn.irisicm.config;

import cn.irisicm.exception.MyException;
import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理器
 * * @author hmhu6
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     */
    @ExceptionHandler(value = MyException.class)
    public <T> R<T> bizExceptionHandler(MyException e) {
        log.error("发生业务异常！ msg: -> ", e);
        return R.failed(e.getMessage());
    }

    /**
     * 处理空指针的异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public R<String> exceptionHandler(NullPointerException e) {
        log.error("发生空指针异常！ msg: -> ", e);
        return R.failed("发生空指针异常!");
    }

    /**
     * 服务器异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R<String> exception(Exception e) {
        log.error("服务器异常！ msg: -> ", e);
        return R.failed("服务器异常!");
    }
}

