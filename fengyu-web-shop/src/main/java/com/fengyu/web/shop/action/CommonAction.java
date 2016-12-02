package com.fengyu.web.shop.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value="/common")
public class CommonAction {

    @RequestMapping(value={"{pageName}.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String common(@PathVariable("pageName") String pageName)
    {
        Map result = new HashMap();

        return "common";
    }
}
