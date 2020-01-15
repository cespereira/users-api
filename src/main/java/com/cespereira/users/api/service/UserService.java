package com.cespereira.users.api.service;

import com.cespereira.users.api.dao.UserDao;
import com.cespereira.users.api.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<UserEntity> findAll() {
        return this.userDao.findAll();
    }

    public UserEntity save(final UserEntity user) {
        return this.userDao.saveAndFlush(user);
    }

    public UserEntity find(final Long id) {
        final var found = this.userDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return found;
    }

    public void delete(final Long id) {
        this.userDao.deleteById(id);
    }
}
