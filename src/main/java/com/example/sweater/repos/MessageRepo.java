package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> { // CRUD-репозиторий

    //можно получить полный список полей findByAll()
    List<Message> findByTag(String tag); //а можно по идентификатору (тегу)

}
