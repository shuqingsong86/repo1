package cn.itcast.dao.impl;

import cn.itcast.dao.poemDao;
import cn.itcast.domain.Poem;
import cn.itcast.util.JDBCUtils;
import cn.itcast.util.JdbcTemplateUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class poemDaoImpl implements poemDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Poem> findAll(String cate) {
        List<Poem> list = null;
        try {
            String sql = "select * from poem where category = ?";
            list = template.query(sql, new BeanPropertyRowMapper<>(Poem.class),cate);
        } catch (DataAccessException e) {
        }
        return list;
    }

    @Override
    public Poem findOneById(int id) {
        Poem poem = null;
        try {
            String sql = "select * from poem where id = ?";
           poem = template.queryForObject(sql, new BeanPropertyRowMapper<Poem>(Poem.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return poem;
    }
}
