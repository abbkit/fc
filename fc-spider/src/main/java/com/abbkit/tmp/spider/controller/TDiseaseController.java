package com.abbkit.tmp.spider.controller;

import com.abbkit.tmp.spider.SpiderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author J
 * @since 2023-02-12
 */
@Slf4j
@Controller
@RequestMapping("/tDiseaseEntity")
public class TDiseaseController {


    @Autowired
    private SpiderService spiderService;

    @ResponseBody
    @GetMapping(path = "insert")
    public boolean insert(HttpServletRequest request) throws Exception {
        spiderService.insertData();
        return true;
    }

}
