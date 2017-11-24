package com.anywell.dao;

import com.anywell.domain.User;

public interface UserDao {

	User findUser(String code);
}
