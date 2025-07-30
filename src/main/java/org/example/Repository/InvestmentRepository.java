package org.example.Repository;

import org.example.Models.DataModels.Investment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvestmentRepository extends MongoRepository<Investment, String> {}
