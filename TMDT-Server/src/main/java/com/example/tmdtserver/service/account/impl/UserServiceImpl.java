package com.example.tmdtserver.service.account.impl;

import com.example.tmdtserver.model.Users;
import com.example.tmdtserver.repository.IUserRepository;
import com.example.tmdtserver.service.account.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<Users> listAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Users users) {
        iUserRepository.save(users);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public String randomCode(String email) {
        return null;
    }

    @Override
    public Users findByEmail(String email) {
        return iUserRepository.findByEmail(email);
    }

    @Override
    public Map login(Users users) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String text = "";
        Users users1 = findByEmail(users.getEmail());
        if (users1 != null) {
            if (users1.getPassword().equals(users.getPassword())) {
                text = "Đăng Nhập Thành Công";
                hashMap.put("text", text);
                hashMap.put("user", users1);
            } else {
                text = "Mật Khẩu Không Chính Xác";
                hashMap.put("text", text);
            }
        } else {
            text = "Email Không Tồn Tại";
            hashMap.put("text", text);
        }

        return hashMap;
    }
}