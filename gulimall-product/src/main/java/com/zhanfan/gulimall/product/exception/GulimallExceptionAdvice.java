package com.zhanfan.gulimall.product.exception;

import com.zhanfan.common.exception.BizCodeEnum;
import com.zhanfan.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：zhanfan
 * @date ：Created in 2021/1/11 21:27
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.zhanfan.gulimall.product.controller")
public class GulimallExceptionAdvice {

    //处理/product/brand/save的后端校验不匹配异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException exception){
        Map<String,String> map=new HashMap<>();
        BindingResult bindingResult = exception.getBindingResult();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        });

        log.error("数据校验出现问题{},异常类型{}",exception.getMessage(),exception.getClass());
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(),BizCodeEnum.VALID_EXCEPTION.getMsg()).put("data",map);
    }

    //
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        log.error("未知异常{},异常类型{}",throwable.getMessage(),throwable.getClass());
        return R.error(BizCodeEnum.UNKNOW_EXEPTION.getCode(),BizCodeEnum.UNKNOW_EXEPTION.getMsg());
    }


}