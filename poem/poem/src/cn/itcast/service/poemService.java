package cn.itcast.service;

import cn.itcast.dao.impl.poemDaoImpl;
import cn.itcast.dao.poemDao;
import cn.itcast.domain.Poem;

import java.util.List;

public interface poemService {
    public List<Poem> findAll(String cate);

    Poem findOne(String id);
}
