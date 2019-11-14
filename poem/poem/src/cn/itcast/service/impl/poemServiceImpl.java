package cn.itcast.service.impl;

import cn.itcast.dao.impl.poemDaoImpl;
import cn.itcast.dao.poemDao;
import cn.itcast.domain.Poem;
import cn.itcast.service.poemService;

import java.util.List;

public class poemServiceImpl implements poemService {

    private poemDao dao = new poemDaoImpl();
    @Override
    public List<Poem> findAll(String cate) {

            List<Poem> list = dao.findAll(cate);
            return list;

    }

    @Override
    public Poem findOne(String id) {
        Poem poem = dao.findOneById(Integer.parseInt(id));
        return poem;
    }
}
