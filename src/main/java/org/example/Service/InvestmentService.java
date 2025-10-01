package org.example.Service;

import org.example.Models.DataModels.Investment;
import org.example.Repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    public void saveInvestment(Investment investment) {
        investmentRepository.save(investment);
    }

    public Optional<Investment> getInvestmentById (String id) {
        return investmentRepository.findById(id);
    }

    public List<Investment> getAllInvestments () {
        return  investmentRepository.findAll();
    }
}
