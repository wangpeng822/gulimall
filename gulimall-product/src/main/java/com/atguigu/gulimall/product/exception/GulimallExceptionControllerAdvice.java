package com.atguigu.gulimall.product.exception;

import com.atguigu.common.exception.BizCodeEnume;
import com.atguigu.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 集中处理异常
 * @ControllerAdvice统一处理异常
 * basePackages = "com/atguigu/gulimall/product/controller"处理哪里的异常
 * @ResponseBody返回json字符串
 */
@Slf4j
//@ResponseBody
//@ControllerAdvice(basePackages = "com/atguigu/gulimall/product/controller")
@RestControllerAdvice(basePackages = "com/atguigu/gulimall/product/controller")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题{},异常类型{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> errMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            errMap.put(field,defaultMessage);
        });
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(), BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data",errMap);
    }

    @ExceptionHandler(value =  Throwable.class)
    public R handleException(Throwable throwable){

        return R.error();
    }
}
