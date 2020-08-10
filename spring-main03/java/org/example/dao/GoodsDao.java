package org.example.dao;

import org.example.domain.Goods;

public interface GoodsDao {
    //提供商品编号和数量
    int updateGoods(Goods goods);
    Goods selectGoods(Integer id);
}
