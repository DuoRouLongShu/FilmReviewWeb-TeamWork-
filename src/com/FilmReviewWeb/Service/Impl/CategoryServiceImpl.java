package com.FilmReviewWeb.Service.Impl;

import com.FilmReviewWeb.Dao.CategoryDao;
import com.FilmReviewWeb.Model.Category;
import com.FilmReviewWeb.Service.CategoryService;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDao();
    @Override
    public List<Category> findAll() throws SQLException {
//        //从redis中查询
//        Jedis jedis = JedisPoolUtils.getJedis();
//        //使用sortedset排序查询
//        Set<String> categorys = jedis.zrange("category",0,-1);
//        List<Category> cs = null;
//        //判断查询的集合是否为空
//        if(categorys==null||categorys.size()==0){
//            System.out.println("从数据库查询....");
//            //如果为空，需要从数据库查询，将数据存入redis
//            //从数据库查询
//            cs=categoryDao.findAll();
//            //将集合数据存储到redis中的category的key
//            for(int i=0; i<cs.size(); i++){
//                jedis.zadd("category",cs.get(i).getCid(),cs.get(i).getCname());
//            }
//
//
//        }else{
//            System.out.println("从redis中查询....");
//            //如果不为空，将set的数据存入list
//            cs= new ArrayList<Category>();
//            for(String name : categorys) {
//                Category category = new Category();
//                category.setCname(name);
//                cs.add(category);
//
//            }
//        }

        return categoryDao.findAll();
    }
}
