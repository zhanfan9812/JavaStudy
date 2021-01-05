package com.zhanfan.gulimall.member.feign;

import com.zhanfan.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：zhanfan
 * @date ：Created in 2021/1/5 16:54
 */
//告诉spring cloud这个接口是一个远程客户端，要调用coupon服务，再去调用coupon服务/coupon/coupon/member/list对应的方法
//注解的参数为服务向Nacos注册的名字
@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    //注意写全优惠券类上还有映射
    //注意我们这个地方不是控制层，所以这个请求映射请求的不是我们服务器上的东西，而是nacos注册中心的
    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();//得到一个R对象
}
