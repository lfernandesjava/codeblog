package com.spring.codeblog.util;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CodeBlogRepository codeBlogRepository;

    @PostConstruct
    public void savePosts(){

        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Leandro Fernandes");
        post1.setData(LocalDate.now());
        post1.setTitulo("Docker");
        post1.setTexto("Docker é um conjunto de produtos de plataforma como serviço que usam virtualização de nível de sistema operacional para entregar software em pacotes chamados contêineres");

        Post post2 = new Post();
        post2.setAutor("Lee");
        post2.setData(LocalDate.now());
        post2.setTitulo("Kubernate");
        post2.setTexto("Docker é um conjunto de produtos de plataforma como serviço que usam virtualização de nível de sistema operacional para entregar software em pacotes chamados contêineres");

        postList.add(post1);
        postList.add(post2);

        for (Post post: postList){
            Post postSaved = codeBlogRepository.save(post);
            System.out.println(postSaved.getId());
        }

    }
}
