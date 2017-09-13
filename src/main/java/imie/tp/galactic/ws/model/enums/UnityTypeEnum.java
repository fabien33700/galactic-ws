package imie.tp.galactic.ws.model.enums;

import imie.tp.galactic.ws.model.general.Unity;
import imie.tp.galactic.ws.model.unities.gather.GoldMine;
import imie.tp.galactic.ws.model.unities.gather.IronMine;
import imie.tp.galactic.ws.model.unities.gather.PlutoniumFactory;
import imie.tp.galactic.ws.model.unities.production.SpatialShipyard;
import imie.tp.galactic.ws.model.unities.production.WeaponFactory;
import imie.tp.galactic.ws.model.unities.terrestrial.MissilesLauncher;
import imie.tp.galactic.ws.model.unities.terrestrial.ShieldUnit;
import imie.tp.galactic.ws.model.unities.terrestrial.shed.GoldShed;
import imie.tp.galactic.ws.model.unities.terrestrial.shed.IronShed;
import imie.tp.galactic.ws.model.unities.terrestrial.shed.PlutoniumShed;

public enum UnityTypeEnum {
    GOLD_MINE (GoldMine.class),
    IRON_MINE (IronMine.class),
    PLUTONIUM_FACTORY (PlutoniumFactory.class),
    GOLD_SHED (GoldShed.class),
    IRON_SHED (IronShed.class),
    PLUTONIUM_SHED (PlutoniumShed.class),
    SPATIAL_SHIPYARD (SpatialShipyard.class),
    WEAPON_FACTORY (WeaponFactory.class),
    MISSILES_LAUNCHER (MissilesLauncher.class),
    SHIELD_UNIT (ShieldUnit.class);

    private Class<? extends Unity> clazz;
    
    UnityTypeEnum(Class<? extends Unity> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Unity> getClazz() {
        return clazz;
    }
}
