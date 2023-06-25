package com.Blood_Donation_System.Blood_Donation_System.service;

import com.Blood_Donation_System.Blood_Donation_System.model.LastOperationsModel;
import com.Blood_Donation_System.Blood_Donation_System.repository.Last_OperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Last_OperationsService {
    @Autowired
    Last_OperationsRepository lastopRepository;

    public List<LastOperationsModel> findAll(){
        return lastopRepository.findAllByOrderByIdDesc();
    }

    public LastOperationsModel createLOG(String user, String message, Date datetime){
        LastOperationsModel log=new LastOperationsModel();
        log.setUsername(user);
        log.setDate(datetime);
        log.setMessage(message);
        return lastopRepository.save(log);
    }

}
