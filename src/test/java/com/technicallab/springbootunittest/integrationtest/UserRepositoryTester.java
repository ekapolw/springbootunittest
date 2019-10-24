package com.technicallab.springbootunittest.integrationtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.annotations.SQLDelete;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTester {

  @Autowired
  private UserRepository userRepository;

  @Test
  @Sql("/createUsers.sql")
  public void listAllUsers() {
    List<User> users = new ArrayList<User>();
    userRepository.findAll().forEach(users::add);
    System.out.println(users.get(1));
    Assert.assertEquals(2, users.size());
  }

  @Test
  @Sql("/createUsers_2.sql")
  public void findUser2() {
    Optional<User> aUser = userRepository.findById(2);
    System.out.println(aUser.get());
    Assert.assertEquals("Tony Wongnapapan", aUser.get().getName());
  }




}
