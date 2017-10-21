package com.neiron.neiron.service;

import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.repos.RequestLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class RequestLineService {
    @Autowired
    RequestLineRepo repo;
   public ArrayList<RequestLine> getRequestLines(Long requestId){
       return repo.findByRequestId(requestId);
   }
} 