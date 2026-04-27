package org.example.Service;

import org.example.Models.DataModels.Asset;
import org.example.Repository.AssetsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssetServiceTest {

    @Mock
    private AssetsRepository assetsRepository;

    @InjectMocks
    private AssetService assetService;

    @Test
    void saveAsset_shouldCallRepository() {
        Asset asset = new Asset("Gold", "Resource");

        assetService.saveAsset(asset);

        verify(assetsRepository, times(1)).save(asset);
    }

    @Test
    void getAsset_shouldReturnAsset_whenExists() {
        Asset asset = new Asset("Gold", "Resource");
        when(assetsRepository.findById("1")).thenReturn(Optional.of(asset));

        Optional<Asset> result = assetService.getAsset("1");

        assertTrue(result.isPresent());
        assertEquals("Gold", result.get().getAssetName());
    }

    @Test
    void getAsset_shouldReturnEmpty_whenNotExists() {
        when(assetsRepository.findById("99")).thenReturn(Optional.empty());

        Optional<Asset> result = assetService.getAsset("99");

        assertFalse(result.isPresent());
    }

    @Test
    void getAllAssets_shouldReturnAllAssets() {
        List<Asset> assets = List.of(
                new Asset("Gold", "Resource"),
                new Asset("Bitcoin", "digital")
        );
        when(assetsRepository.findAll()).thenReturn(assets);

        List<Asset> result = assetService.getAllAssets();

        assertEquals(2, result.size());
    }

    @Test
    void getAssetByName_shouldReturnAsset_whenExists() {
        Asset asset = new Asset("Gold", "Resource");
        when(assetsRepository.findAssetByName("Gold")).thenReturn(asset);

        Asset result = assetService.getAssetByName("Gold");

        assertNotNull(result);
        assertEquals("Gold", result.getAssetName());
    }
}