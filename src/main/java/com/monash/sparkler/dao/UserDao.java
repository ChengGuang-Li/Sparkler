package com.monash.sparkler.dao;

import com.monash.sparkler.entity.User;
import com.monash.sparkler.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userDao")
public class UserDao {

  //note: we can add some specific CRUD methods

}
