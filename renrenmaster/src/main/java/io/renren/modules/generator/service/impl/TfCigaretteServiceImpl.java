package io.renren.modules.generator.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.TfCigaretteDao;
import io.renren.modules.generator.entity.TfCigaretteEntity;
import io.renren.modules.generator.service.TfCigaretteService;


@Service("tfCigaretteService")
public class TfCigaretteServiceImpl extends ServiceImpl<TfCigaretteDao, TfCigaretteEntity> implements TfCigaretteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<TfCigaretteEntity> wrapper = new QueryWrapper<TfCigaretteEntity>().orderByAsc("id");

        if (!StringUtils.isEmpty(key)) {
            wrapper.and((obj) -> {
                obj.like("tab", key).or().like("content", key);
            });
        }

        IPage<TfCigaretteEntity> page = this.page(
                new Query<TfCigaretteEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

}
