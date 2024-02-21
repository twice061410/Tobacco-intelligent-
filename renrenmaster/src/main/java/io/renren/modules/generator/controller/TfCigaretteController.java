package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.TfCigaretteEntity;
import io.renren.modules.generator.service.TfCigaretteService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 *
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-03-22 15:53:31
 */
@RestController
@RequestMapping("generator/tfcigarette")
public class TfCigaretteController {
    @Autowired
    private TfCigaretteService tfCigaretteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:tfcigarette:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tfCigaretteService.queryPage(params);

         return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:tfcigarette:info")
    public R info(@PathVariable("id") Integer id){
		TfCigaretteEntity tfCigarette = tfCigaretteService.getById(id);

        return R.ok().put("tfCigarette", tfCigarette);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:tfcigarette:save")
    public R save(@RequestBody TfCigaretteEntity tfCigarette){
		tfCigaretteService.save(tfCigarette);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:tfcigarette:update")
    public R update(@RequestBody TfCigaretteEntity tfCigarette){
		tfCigaretteService.updateById(tfCigarette);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:tfcigarette:delete")
    public R delete(@RequestBody Integer[] ids){
		tfCigaretteService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
