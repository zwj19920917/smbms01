package com.jbit.controller;

import com.jbit.entity.SmbmsBill;
import com.jbit.entity.SmbmsProvider;
import com.jbit.service.SmbmsBillService;
import com.jbit.service.SmbmsProviderService;
import com.jbit.utils.PaggingUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/9/5.
 */
@Controller
@RequestMapping("bill")
public class BillController {
    @Resource
    private SmbmsProviderService smbmsProviderService;
    @Resource
    private SmbmsBillService smbmsBillService;
    //订单管理
    @RequestMapping(value = "list")
    public String billlist(Model model,@RequestParam(required = false) Integer queryProviderId,
                           @RequestParam(required = false)String queryProductName,
                           @RequestParam(required = false)Integer queryIsPayment ,
                           @RequestParam(required = false) Integer pageIndex){
        PaggingUtils utils = new PaggingUtils();
        if (pageIndex != null) {
            utils.setCurrentPageNo(pageIndex);
        }
        List<SmbmsBill> billList =smbmsBillService.selsctBillList(queryProviderId,queryProductName,queryIsPayment,utils);
        model.addAttribute("billList",billList);
        List<SmbmsProvider> providerList= smbmsProviderService.selectProviderList();
        model.addAttribute("providerList" ,providerList);
        model.addAttribute("queryProviderId",queryProviderId);
        model.addAttribute("queryProductName",queryProductName);
        model.addAttribute("queryIsPayment",queryIsPayment);
        model.addAttribute("pagging", utils);
        return "jsp/billlist";
    }
    //填加订单
    @RequestMapping(value = "add")
    public String addbill(SmbmsBill bill,Model model){
        int res=smbmsBillService.insertbill(bill);
        if(res!=0){
            return "redirect:/bill/list";
        }
        model.addAttribute("error","添加失败");
        return "jsp/billadd";
    }
    //删除订单
    @RequestMapping("del")
    @ResponseBody
    public String delbill(Long id){
        if(id==null){
            return "notexist";
        }
        int res=smbmsBillService.delbill(id);
        if(res!=0){
            return "true";
        }

        return "false";
    }
}
