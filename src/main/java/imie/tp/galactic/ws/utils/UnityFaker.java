package imie.tp.galactic.ws.utils;

import imie.tp.galactic.ws.model.general.Planet;
import imie.tp.galactic.ws.model.general.Unity;
import imie.tp.galactic.ws.model.unities.ProductionUnity;
import imie.tp.galactic.ws.model.unities.TerrestrialUnity;
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
import imie.tp.galactic.ws.model.unities.terrestrial.StorageShed;
import imie.tp.galactic.ws.model.unities.terrestrial.shed.GoldShed;
import imie.tp.galactic.ws.model.unities.terrestrial.shed.IronShed;
import imie.tp.galactic.ws.model.unities.terrestrial.shed.PlutoniumShed;

import java.lang.reflect.InvocationTargetException;

public class UnityFaker {

    public static final Class<? extends Unity>[] unitiesClasses = new Class[] {
            GoldMine.class, IronMine.class, PlutoniumFactory.class,
            SpatialShipyard.class, WeaponFactory.class,
            MissilesLauncher.class, ShieldUnit.class,
            IronShed.class, GoldShed.class, PlutoniumShed.class,
            Fighter.class, Cruiser.class, Scout.class, Transporter.class
    };

    public static Unity makeUnity(Planet p)
            throws ReflectiveOperationException {
        Class<? extends Unity> randomClass = FakeUtils.randomItem(unitiesClasses);

        return randomClass.getDeclaredConstructor(Planet.class).newInstance(p);
    }
}
