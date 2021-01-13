package com.zhanfan.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：zhanfan
 * @date ：Created in 2021/1/12 10:26
 */
//ListValue注解的自定义校验器
public class ListValueConstraintValidator implements ConstraintValidator<ListValue,Integer> {
    private Set<Integer> set=new HashSet<>();
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals=constraintAnnotation.vals(); //获取BrandEntity上注解预定义的值({0，1})
        for (int val : vals) {
            set.add(val);
        }
    }

    /**
     * 判断是否校验成功函数
     * @param integer 接受到的待校验数据
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return set.contains(integer);
    }
}
