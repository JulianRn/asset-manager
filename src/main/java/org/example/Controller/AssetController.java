package org.example.Controller;

import jakarta.validation.Valid;
import org.example.Models.DataModels.Asset;
import org.example.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    /**
     * @param name will be specified in url e.g. localhost:8080/assets?name=Silver
     */
    @GetMapping
    public List<Asset> getAllAssets(@RequestParam (required = false) String name) {
        if (name != null) {
            return List.of(assetService.getAssetByName(name));
        }
        return assetService.getAllAssets();
    }
    @GetMapping("/{id}")
    public Asset getAssetById(@PathVariable String id) {
        return assetService.getAsset(id);
    }

    @PostMapping
    public ResponseEntity<Asset> createAsset(@Valid @RequestBody Asset asset) {
        assetService.saveAsset(asset);
        return  ResponseEntity.status(HttpStatus.CREATED).body(asset);
    }
    
}
