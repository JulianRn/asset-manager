db = db.getSiblingDB("financeAssets");

db.assets.insertMany([
    {
        assetName: "Silber",
        type: "resource"
    },
    {
            assetName: "Öl",
            type: "resource"
    },
    {
            assetName: "Ethereum",
            type: "digital"
    },
    {
            assetName: "Bitcoin",
            type: "digital"
    },
    {
            assetName: "Aktien",
            type: "stock"
    }
]);