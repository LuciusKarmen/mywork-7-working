package org.example.redis_start.service;

import org.example.redis_start.dao.UserSessionDao;
import org.example.redis_start.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserSessionService {
    private UserSessionDao userSessionDao;

    public UserSessionService(UserSessionDao userSessionDao) {
        this.userSessionDao = userSessionDao;
    }

    public void saveSession(String userId, String token) {
        userSessionDao.saveSession(userId, token);
    }

    public String getSession(String userId) {
        return userSessionDao.getSession(userId);
    }

    public void deleteSession(String userId) {
        userSessionDao.deleteSession(userId);
    }
    public void saveUser(User user) {
        userSessionDao.saveUser(user);
    }
    public User getUser(String userId) {
        return userSessionDao.getUser(userId);
    }
    public void deleteUser(String userId) {
        userSessionDao.deleteUser(userId);
    }


}
