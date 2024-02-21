package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.TfCigaretteEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-03-22 15:53:31
 */
public interface TfCigaretteService extends IService<TfCigaretteEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

