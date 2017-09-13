package imie.tp.galactic.ws.model.general;

public class UnityType {
    
    private int size;
    
    private Long productionDelay;
    
    private int goldCost;
    
    private int ironCost;
    
    private int plutoniumCost;
    
    private String name;

    public UnityType(Unity unity) {
        this.size = unity.getSize();
        this.productionDelay = unity.getProductionDelay();
        this.goldCost = unity.getGoldCost();
        this.ironCost = unity.getIronCost();
        this.plutoniumCost = unity.getPlutoniumCost();
        this.name = unity.getName();
    }

    public int getSize() {
        return size;
    }

    public Long getProductionDelay() {
        return productionDelay;
    }

    public int getGoldCost() {
        return goldCost;
    }

    public int getIronCost() {
        return ironCost;
    }

    public int getPlutoniumCost() {
        return plutoniumCost;
    }

    public String getName() {
        return name;
    }
}
