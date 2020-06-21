package com.smartzheng.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

/**
 * Created by smartzheng
 * 2020-06-21
 */
@Service
class LuckymoneyService {
    private final LuckymoneyRespository mRespository;

    @Autowired
    public LuckymoneyService(LuckymoneyRespository mRespository) {
        this.mRespository = mRespository;
    }

    @Transactional
    public boolean createTow() {
        try {
            Luckymoney luckymoney1 = new Luckymoney();
            luckymoney1.setConsumer("smartzheng");
            luckymoney1.setProducer("smartzheng");
            luckymoney1.setMoney(new BigDecimal("100"));
            mRespository.save(luckymoney1);
            Luckymoney luckymoney2 = new Luckymoney();
            luckymoney2.setConsumer("smartzheng");
            luckymoney2.setProducer("smartzheng");
            luckymoney2.setMoney(new BigDecimal("120000"));
            mRespository.save(luckymoney2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
