package machinelearningdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import machinelearningdemo.dao.MongoDao;
import machinelearningdemo.service.HeatmapService;
import machinelearningdemo.service.Testservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.Test;
import test.test2;

/**
 * Created by cdz on 2017/6/8.
 */
@Controller
@ComponentScan("machinelearningdemo.service")
@ComponentScan("test")
public class Hello {
    @Autowired
    Testservice testservice;

    @Autowired
    HeatmapService heatmapService;

    @Autowired
    private MongoDao mongoDao;

    @Value("${test}")
    private String haha;

    @Autowired
    private Test test;

    @Autowired
    private test2 test2;

    @RequestMapping(value = "/lssb", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        System.out.println(testservice.getHahaha());
//        test.test();
//        test2 test2 = new test2();
//        test2.generateTrainData();
        test2.test();
        return testservice.getHahaha();
    }

    @PostMapping(value = "/heatmap")
    @ResponseBody
    public String getHeatMap(){
        SerializerFeature feature = SerializerFeature.DisableCircularReferenceDetect;
        return JSON.toJSONString(heatmapService.getHeatmapData(),feature);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        return "index";
    }

}
