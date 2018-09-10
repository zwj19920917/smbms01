package com.jbit.service.impl;

import com.jbit.dao.SmbmsBillDao;
import com.jbit.entity.SmbmsBill;
import com.jbit.service.SmbmsBillService;
import com.jbit.utils.PaggingUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/9/5.
 */
@Service("smbmsBillService")
public class SmbmsBillServiceImpl implements SmbmsBillService {
    @Resource
    private SmbmsBillDao smbmsBillDao;
    @Override
    public List<SmbmsBill> selsctBillList(Integer queryProviderId, String queryProductName, Integer queryIsPayment,PaggingUtils pagging) {
        pagging.initPagging(smbmsBillDao.selecttotalCount(queryProviderId,queryProductName,queryIsPayment));
        return smbmsBillDao.selsctBillList(queryProviderId,queryProductName,queryIsPayment,pagging.startPage(),pagging.endPage());
    }

    @Override
    public int insertbill(SmbmsBill bill) {
        return smbmsBillDao.insertbill(bill);
    }

    @Override
    public int delbill(Long id) {
        return smbmsBillDao.delbill(id);
    }

    @Override
    public SmbmsBill selectByPrimaryKey(Long id) {
        return smbmsBillDao.selectByPrimaryKey(id);
    }

    @Override
    public int updatebill(SmbmsBill bill) {
        return smbmsBillDao.updatebill(bill);
    }
}
