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
       return addSumPrice(repo.findByRequestId(requestId));
   }

    private ArrayList<RequestLine> addSumPrice(ArrayList<RequestLine> lines) {
       long sum = 0l;
       for (RequestLine line : lines) {
            if (line.getAssortmentId() != null&&line.getAssortmentId().getPrice()!=null&&line.getAmmount()!=null) {
                line.setPrice(line.getAssortmentId().getPrice());
                line.setSum(line.getAssortmentId().getPrice()*line.getAmmount());
                sum+=line.getAssortmentId().getPrice()*line.getAmmount();
            }

        }
        RequestLine itogo = new RequestLine();
        itogo.setSum(sum);
        itogo.setUnparsedLine("ИТОГО:");
        itogo.setAmmount(0);
        itogo.setParsedLine("включая НДС");
        lines.add(itogo);
        return  lines;
    }
} 