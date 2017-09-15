package imie.tp.galactic.ws.views;

public interface Views {
    interface Public {}
    interface Planet extends Public {}
    interface ShowAllPlanets extends Planet {}
    interface ShowOnePlanet extends Planet {}
    interface Resources {}
    interface Player extends Public {}
    interface UnityType extends Public {}
    interface Unity extends Public {}
    interface ShowOneUnity extends Unity {}
}
