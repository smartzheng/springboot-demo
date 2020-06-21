package com.smartzheng.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by smartzheng
 * 2020-06-21
 */
@RestController
public class LuckymoneyController {
    private final LuckymoneyRespository mRespository;

    @Autowired
    public LuckymoneyController(LuckymoneyRespository mRespository, LuckymoneyService mService) {
        this.mRespository = mRespository;
        this.mService = mService;
    }

    private final LuckymoneyService mService;

    @GetMapping("/luckymoneys")
    public List<Luckymoney> getAllLuckmoneys() {
        return mRespository.findAll();
    }

    @GetMapping("/luckymoney/{id}")
    public Luckymoney getLuckmoneyById(@PathVariable Integer id) {
        return mRespository.findById(id).orElse(null);
    }

    @PostMapping("/luckymoney")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money") BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setMoney(money);
        luckymoney.setProducer(producer);
        return mRespository.save(luckymoney);
    }

    @PutMapping("/luckymoney/{id}")
    public Luckymoney update(@PathVariable Integer id,
                             @RequestParam("customer") String customer) {
        Optional<Luckymoney> optional = mRespository.findById(id);
        if (optional.isPresent()) {
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(customer);
            return mRespository.save(luckymoney);
        }
        return null;
    }

    @PostMapping("/createTwo")
    public boolean createTwo() {
        return mService.createTow();
    }
}
