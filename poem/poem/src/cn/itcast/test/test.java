package cn.itcast.test;

import cn.itcast.domain.Poem;
import cn.itcast.service.impl.poemServiceImpl;
import cn.itcast.service.poemService;
import org.junit.Test;

import java.lang.annotation.Target;
import java.util.List;

public class test {
    private poemService service = new poemServiceImpl();
    @Test
    public void testFindAll(){
        String s = "唐诗三百首";

        List<Poem> list = service.findAll(s);
        System.out.println(list);
    }
    @Test
    public void testFindOneById(){
        String id = "1";
        Poem one = service.findOne(id);
        System.out.println(one);
    }
}
