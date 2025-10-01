package org.example.Controller;

import org.example.Exception.ResourceNotFoundException;
import org.example.Models.DataModels.Investment;
import org.example.Service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/investments")
public class InvestmentController {
    @Autowired
    private InvestmentService investmentService;
    @Autowired
//    private AssetService assetService;


    @GetMapping
    public List<Investment> getAllInvestments () {
        // mocking data
//        Asset asset = assetService.getAssetByName("Bitcoin");
//        Investment investment = new Investment(asset, 2.00, new Date());
//        System.out.println(investment);
//        investmentService.saveInvestment(investment);

        return investmentService.getAllInvestments();
    }

    @GetMapping("/{id}")
    public Investment getInvestmentById (@PathVariable String id) {
        return investmentService.getInvestmentById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Investment not found for this id : " + id)
                );
    }
}
