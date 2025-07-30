package org.example.Service;

import org.example.Models.DataModels.Asset;
import org.example.Repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AssetsRepository assetsRepository;

    public void saveAsset(Asset asset) {
        assetsRepository.save(asset);
    }

    public Asset getAsset(String id) {
        return assetsRepository.findById(id).orElse(null);
    }

    public List<Asset> getAllAssets() {
        return assetsRepository.findAll();
    }

    public Asset getAssetByName(String name) {
        return  assetsRepository.findAssetByName(name);
    }
}
