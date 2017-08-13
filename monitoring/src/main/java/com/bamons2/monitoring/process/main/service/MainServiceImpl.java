package com.bamons2.monitoring.process.main.service;

import com.bamons2.monitoring.process.main.dao.MainDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by david100gom on 2017. 8. 14.
 *
 * Github : https://github.com/david100gom
 */
@Service
public class MainServiceImpl implements MainService{

    @Autowired
    private MainDAO mainDAO;


    @Override
    public String today() {
        return mainDAO.today();
    }
}
