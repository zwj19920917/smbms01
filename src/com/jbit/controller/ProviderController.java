package com.jbit.controller;

import com.jbit.entity.SmbmsProvider;
import com.jbit.service.SmbmsProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    //供应商管理
    @RequestMapping(value = "lists" )
    public  String  providerList(String queryProCode, String queryProName, Model model){
      List<SmbmsProvider> providerList= smbmsProviderService.selectProviderLists(queryProCode,queryProName);
        model.addAttribute("providerList",providerList);
        model.addAttribute("queryProCode",queryProCode);
        model.addAttribute("queryProName",queryProName);
        return "jsp/providerlist";
    }
    //查全部供应商
    @RequestMapping(value = "list" ,method = RequestMethod.GET)
    @ResponseBody
    public  List<SmbmsProvider>  providerList(){
        List<SmbmsProvider> providerList= smbmsProviderService.selectProviderList();
        return providerList;
    }

    //查看供应商 或修改跳转
    @RequestMapping(value = "view")
    public String view(Long id,String method,Model model) {
        SmbmsProvider provider=smbmsProviderService.selectByPrimaryKey(id);
        model.addAttribute("provider",provider);
        if(method.equals("view")){
            return "jsp/providerview";
        }
        return "jsp/providermodify";
    }

    //修改供应商
    @RequestMapping(value = "modify")
    public String modify(SmbmsProvider provider){
        int res=smbmsProviderService.updateProvider(provider);
        if(res!=0){
            return "redirect:/provider/lists";
        }
        return "redirect:/provider/view?method=modify&id="+provider.getId();
    }
}
