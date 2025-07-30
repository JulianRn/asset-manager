package org.example.Models.DataModels;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "assets")
public class Asset {

    @Id
    private String id;
    private String assetName;
    private String type;

    //Constructor
    public Asset(String assetName, String type) {
        this.assetName = assetName;
        this.type = type;
    }

    //Getter
    public String getAssetId() {
        return id;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getType() {
        return type;
    }

    //Setter
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setType(String type) {
        this.type = type;
    }
}
