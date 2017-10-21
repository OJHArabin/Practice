
package sbean;

import entity.Goods;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class GoodsBean {
  
    @PersistenceContext(unitName = "siwaPU")
   private EntityManager em;
    
    public void add(Goods goods)throws EntityExistsException
    {
        em.persist(goods);
    }
   public Goods find(Integer goodsID)
   {
       return em.find(Goods.class, goodsID);
   }
   public List<Goods> viewAll()
   {
       List<Goods> goodsList=(List<Goods>) em.createNamedQuery("Goods.findAll").getResultList();
       //return em.createNamedQuery("Goods.findAll", Goods.class).getResultList();
       return goodsList;
   }
   public void delete(Integer goodsID)throws IllegalArgumentException
   {
       em.remove(find(goodsID));
   }
   public void update(Goods goods)
   {
       
       em.merge(goods);
   }
   public void update(Goods newGoods,Integer goodsID)
   {
       Goods searchGoods=find(goodsID);
       searchGoods.setGoodsId(newGoods.getGoodsId());
       searchGoods.setGoodsName(newGoods.getGoodsName());
       searchGoods.setGoodsPrice(newGoods.getGoodsPrice());
   }
   public List<Goods> getGoodWithPriceMoreThan(Float price)
   {
      return em.createNamedQuery("Goods.findByPrice", Goods.class).setParameter("goodsPrice", price).getResultList();
   }
}
