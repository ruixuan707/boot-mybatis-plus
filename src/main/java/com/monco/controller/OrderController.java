package com.monco.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monco.common.response.ApiResult;
import com.monco.config.redis.RedisService;
import com.monco.entity.Order;
import com.monco.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author monco
 * @since 2019-11-17
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    @Resource
    private RedisService redisService;

    /**
     * 新增Order方法
     *
     * @param order
     * @return
     */
    @PostMapping
    public ApiResult save(@RequestBody Order order) {
        orderService.save(order);
        return ApiResult.ok();
    }

    /**
     * 修改Order方法
     *
     * @param order
     * @return
     */
    @PutMapping
    public ApiResult update(@RequestBody Order order) {
        orderService.updateById(order);
        return ApiResult.ok();
    }

    /**
     * 查询列表
     *
     * @param order
     * @return
     */
    @GetMapping("list")
    public ApiResult list(Order order) {
        return ApiResult.ok(orderService.getOrderList(order));
    }

    /**
     * 查询分页
     *
     * @param current 当前页
     * @param size    一页多少数据
     * @param order
     * @return
     */
    @GetMapping("page")
    public ApiResult page(@RequestParam(required = false, defaultValue = "0") long current,
                          @RequestParam(required = false, defaultValue = "10") long size, Order order) {
        return ApiResult.ok(orderService.getOrderPage(new Page<Order>().setCurrent(current).setSize(size), order));
    }

    /**
     * 删除方法
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public ApiResult delete(@RequestParam Long id) {
        orderService.removeById(id);
        return ApiResult.ok();
    }

    /**
     * 按照id获取单条记录
     *
     * @param id
     * @return
     */
    public ApiResult getOne(@RequestParam Long id) {
        return ApiResult.ok(orderService.getById(id));
    }

    /**
     * 接口调用重复性校验
     *
     * @param orderId
     * @return
     */
    @PostMapping("repeat")
    public ApiResult repeatCheck(@RequestParam String orderId) {
        redisService.incr(orderId, 1L);
        log.info("当前线程获取的redis 结果" + redisService.get(orderId));
        if (redisService.hasKey(orderId) && "1".equals(redisService.get(orderId))) {
            List<Order> orderList = orderService.getOrderList(new Order().setOrderId(orderId));
            if (CollectionUtils.isNotEmpty(orderList)) {
                Order o = orderList.get(0);
                if ("processing".equals(o.getOrderStatus())) {
                    o.setOrderStatus("success");
                    orderService.updateById(o);
                    log.info("订单号为" + orderId + "的订单发送");
                    redisService.del(orderId);
                }
            }
        } else {
            redisService.del(orderId);
        }
        return ApiResult.ok();
    }

    /**
     * 接口调用不进行重复性校验
     *
     * @param orderId
     * @return
     */
    @PostMapping("no-repeat")
    public ApiResult noRepeatCheck(@RequestParam String orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus("processing");
        orderService.save(order);
        /*List<Order> orderList = orderService.getOrderList(new Order().setOrderId(orderId));
        if (CollectionUtils.isNotEmpty(orderList)) {
            Order o = orderList.get(0);
            if ("processing".equals(o.getOrderStatus())) {
                o.setOrderStatus("success");
                orderService.updateById(o);
                log.info("订单号为" + orderId + "的订单发送");
            }
        }*/
        return ApiResult.ok();
    }

}
