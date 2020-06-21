package com.smartzheng.luckymoney;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by smartzheng
 * 2020-06-21
 */

interface LuckymoneyRespository extends JpaRepository<Luckymoney, Integer> {
}
