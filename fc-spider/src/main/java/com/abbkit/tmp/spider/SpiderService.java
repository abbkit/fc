package com.abbkit.tmp.spider;

import com.abbkit.tmp.spider.mapper.TDiseaseMapper;
import com.abbkit.tmp.spider.po.TDiseaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpiderService {


    @Value("${spider.url:https://www.chinacdc.cn/jkzt/crb/}")
    private String url;

    @Autowired
    private TDiseaseMapper diseaseMapper;

    public void insertData() throws Exception{

        List<TDiseaseEntity> entities = Spider.run(url);
        //先全删除了 ，再入库
        diseaseMapper.deleteAll();
        for (TDiseaseEntity diseaseEntity : entities) {
            diseaseMapper.insert(diseaseEntity);
        }


    }


}
