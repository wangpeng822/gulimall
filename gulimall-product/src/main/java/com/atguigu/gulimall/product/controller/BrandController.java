package com.atguigu.gulimall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 品牌
 *
 * @author zhouxingxing
 * @email zhouxingxing822@gmail.com
 * @date 2025-11-15 23:35:05
 */
@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     * @Valid表示这个字段需要校验
     * BindingResult result 封装校验结果
     */
    @RequestMapping("/save")
    public R save(@Valid @RequestBody BrandEntity brand /*,BindingResult result*/){
        //result.hasErrors()是否有错
//        if(result.hasErrors()){
//            Map<String,String> map = new HashMap<>();
//            //1.获取校验的错误结果
//            result.getFieldErrors().forEach((item)->{
//                //fieldError 获取到错误
//                String defaultMessage = item.getDefaultMessage();
//                //获取校验错误字段名
//                String field = item.getField();
//                map.put(field,defaultMessage);
//            });
//            return R.error(400,"提交数据不合法").put("data",map);
//        }else{
//            brandService.save(brand);
//        }
        brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
