package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.domain.Goods;
import org.example.domain.Sale;
import org.example.exception.NotEnoughException;
import org.example.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    //添加事务
    //添加事务会把该类变成一个代理类,事务的机制是AOP环绕（Around）spring内部有around注解的方法
//    @Transactional(
//            propagation = Propagation.REQUIRED,
//            isolation = Isolation.DEFAULT,
//            readOnly = false,
//            //默认抛出运行时异常回滚事务
//            rollbackFor = {
//                    //指定的异常即使不是运行异常依然会回滚
//                    NullPointerException.class,NotEnoughException.class
//            }
//    )
    @Override
    public void buy(Integer gid, Integer nums) {
        //向销售表添加记录
        Sale sale=new Sale();
        sale.setGid(gid);
        sale.setNums(nums);
        saleDao.insertSale(sale);
        //更新库存
        Goods goods=goodsDao.selectGoods(gid);
        if(goods==null){
            throw new NullPointerException("编号是："+gid+"商品不存在");
        }else if(goods.getAmount()<nums){
            throw new NotEnoughException("编号是："+gid+"商品库存不足");
        }
        goods.setAmount(nums);
        goodsDao.updateGoods(goods);
    }
}
