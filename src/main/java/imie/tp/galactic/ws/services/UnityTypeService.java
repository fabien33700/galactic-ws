package imie.tp.galactic.ws.services;

import imie.tp.galactic.ws.model.general.UnityType;
import imie.tp.galactic.ws.model.unities.gather.GoldMine;
import imie.tp.galactic.ws.model.unities.gather.IronMine;
import imie.tp.galactic.ws.model.unities.gather.PlutoniumFactory;
import imie.tp.galactic.ws.model.unities.orbital.Cruiser;
import imie.tp.galactic.ws.model.unities.orbital.Fighter;
import imie.tp.galactic.ws.model.unities.orbital.Scout;
import imie.tp.galactic.ws.model.unities.orbital.Transporter;
import imie.tp.galactic.ws.model.unities.production.SpatialShipyard;
import imie.tp.galactic.ws.model.unities.production.WeaponFactory;
import imie.tp.galactic.ws.model.unities.terrestrial.MissilesLauncher;
import imie.tp.galactic.ws.model.unities.terrestrial.ShieldUnit;
import imie.tp.galactic.ws.model.unities.terrestrial.shed.GoldShed;
import imie.tp.galactic.ws.model.unities.terrestrial.shed.IronShed;
import imie.tp.galactic.ws.model.unities.terrestrial.shed.PlutoniumShed;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UnityTypeService {

    private Set<UnityType> unityTypes = new HashSet<>();

    public UnityTypeService() {
        unityTypes.add(new UnityType(new GoldMine(null)));
        unityTypes.add(new UnityType(new IronMine(null)));
        unityTypes.add(new UnityType(new PlutoniumFactory(null)));
        unityTypes.add(new UnityType(new SpatialShipyard(null)));
        unityTypes.add(new UnityType(new WeaponFactory(null)));
        unityTypes.add(new UnityType(new ShieldUnit(null)));
        unityTypes.add(new UnityType(new MissilesLauncher(null)));
        unityTypes.add(new UnityType(new GoldShed(null)));
        unityTypes.add(new UnityType(new IronShed(null)));
        unityTypes.add(new UnityType(new PlutoniumShed(null)));
        unityTypes.add(new UnityType(new Scout(null)));
        unityTypes.add(new UnityType(new Fighter(null)));
        unityTypes.add(new UnityType(new Cruiser(null)));
        unityTypes.add(new UnityType(new Transporter(null)));
    }

    public Set<UnityType> getUnityTypes() {
        return unityTypes;
    }
}
