package cn.itcast.dao;

import cn.itcast.domain.Poem;

import java.util.List;

public interface poemDao {
    List<Poem> findAll(String cate);

    Poem findOneById(int i);
}
