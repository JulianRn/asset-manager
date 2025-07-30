package org.example.Repository;

import org.example.Models.DataModels.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AssetsRepository extends MongoRepository<Asset, String> {

    @Query("{assetName:'?0'}")
    Asset findAssetByName(String name);
}
