package com.jbit.controller;

import com.jbit.entity.SmbmsProvider;
import com.jbit.service.SmbmsProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/9/5.
 */
@Controller
@RequestMapping("provider")
public class ProviderController {
    @Resource
    private SmbmsProviderService smbmsProviderService;
    @RequestMapping(value = "list" ,method = RequestMethod.GET)
    @ResponseBody
    public  List<SmbmsProvider>  providerList(){
      List<SmbmsProvider> providerList= smbmsProviderService.selectProviderList();
        return providerList;
    }
}
