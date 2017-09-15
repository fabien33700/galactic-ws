package imie.tp.galactic.ws.model.constants;

public class GameConstants {

	public static final int INIT_LEVEL = 1;

	public static final long REFRESH_DELAY = 1000L;

	static final long SECONDS = 1L;
	static final long MINUTES = 60 * SECONDS;
	static final long HOURS = 60 * MINUTES;
	static final long DAYS = 24 * HOURS;

	public static class Planet {
		public static final int INIT_GOLD_STORAGE = 2000;
		public static final int INIT_IRON_STORAGE = 3000;
		public static final int INIT_PLUT_STORAGE = 1500;
	}
	
	public static class IronMine {

		public static final int SIZE = 2;
		public static final int HEALTH = 500;
		public static final Long PRODUCT_DELAY = 10 * MINUTES;
		public static final int IRON_COST = 350;
		public static final int PLUTONIUM_COST = 100;
		public static final int GOLD_COST = 250;
		public static final float INIT_CAPACITY = 500f;
		
	}
	
	public static class PlutoniumFactory {

		public static final int SIZE = 3;
		public static final int HEALTH = 500;
		public static final Long PRODUCT_DELAY = 20 * MINUTES;
		public static final int IRON_COST = 450;
		public static final int PLUTONIUM_COST = 100;
		public static final int GOLD_COST = 400;
		public static final float INIT_CAPACITY = 200f;
		
	}
	
	public static class GoldMine {

		public static final int SIZE = 2;
		public static final int HEALTH = 350;
		public static final Long PRODUCT_DELAY = 10 * MINUTES;
		public static final int IRON_COST = 450;
		public static final int PLUTONIUM_COST = 100;
		public static final int GOLD_COST = 250;
		public static final float INIT_CAPACITY = 300f;
		
	}
	
	public static class GoldShed {

		public static final int SIZE = 2;
		public static final int HEALTH = 900;
		public static final Long PRODUCT_DELAY = 5 * MINUTES;
		public static final int IRON_COST = 250;
		public static final int PLUTONIUM_COST = 50;
		public static final int GOLD_COST = 250;
		public static final int INIT_CAPACITY = 1000;
		
	}
	
	public static class IronShed {

		public static final int SIZE = 2;
		public static final int HEALTH = 900;
		public static final Long PRODUCT_DELAY = 5 * MINUTES;
		public static final int IRON_COST = 250;
		public static final int PLUTONIUM_COST = 50;
		public static final int GOLD_COST = 250;
		public static final int INIT_CAPACITY = 1000;
		
	}
	
	public static class PlutoniumShed {

		public static final int SIZE = 3;
		public static final int HEALTH = 750;
		public static final Long PRODUCT_DELAY = 7 * MINUTES + 30 * SECONDS;
		public static final int IRON_COST = 350;
		public static final int PLUTONIUM_COST = 100;
		public static final int GOLD_COST = 250;
		public static final int INIT_CAPACITY = 500;
		
	}

	public static class MissilesLauncher {

		public static final int SIZE = 1;
		public static final int HEALTH = 250;
		public static final Long PRODUCT_DELAY = 2 * MINUTES;
		public static final int IRON_COST = 250;
		public static final int PLUTONIUM_COST = 150;
		public static final int GOLD_COST = 250;
		public static final int BASE_ATTACK = 40;
	}

	public static class ShieldUnit {

		public static final int SIZE = 1;
		public static final int HEALTH = 1000;
		public static final Long PRODUCT_DELAY = 2 * MINUTES;
		public static final int IRON_COST = 150;
		public static final int PLUTONIUM_COST = 250;
		public static final int GOLD_COST = 250;
	}

	public static class SpatialShipyard {

		public static final int SIZE = 4;
		public static final int HEALTH = 500;
		public static final Long PRODUCT_DELAY = 1 * HOURS;
		public static final int IRON_COST = 1000;
		public static final int PLUTONIUM_COST = 850;
		public static final int GOLD_COST = 850;
	}

	public static class WeaponFactory {

		public static final int SIZE = 3;
		public static final int HEALTH = 500;
		public static final Long PRODUCT_DELAY = 1 * HOURS;
		public static final int IRON_COST = 1200;
		public static final int PLUTONIUM_COST = 1000;
		public static final int GOLD_COST = 650;
	}

	public static class Cruiser {

		public static final int SIZE = 5;
		public static final int HEALTH = 1000;
		public static final Long PRODUCT_DELAY = 1 * DAYS;
		public static final int IRON_COST = 3000;
		public static final int PLUTONIUM_COST = 1500;
		public static final int GOLD_COST = 2500;
		public static final int BASE_ATTACK = 50;
		public static final int BASE_SPEED = 15;
	}

	public static class Fighter {

		public static final int SIZE = 2;
		public static final int HEALTH = 200;
		public static final Long PRODUCT_DELAY = 1 * HOURS;
		public static final int IRON_COST = 350;
		public static final int PLUTONIUM_COST = 250;
		public static final int GOLD_COST = 250;
		public static final int BASE_ATTACK = 10;
		public static final int BASE_SPEED = 25;
	}

	public static class Scout {

		public static final int SIZE = 1;
		public static final int HEALTH = 100;
		public static final Long PRODUCT_DELAY = 20 * MINUTES;
		public static final int IRON_COST = 150;
		public static final int PLUTONIUM_COST = 100;
		public static final int GOLD_COST = 100;
		public static final int BASE_SPEED = 75;
	}

	public static class Transporter {

		public static final int SIZE = 5;
		public static final int HEALTH = 500;
		public static final Long PRODUCT_DELAY = 6 * HOURS;
		public static final int IRON_COST = 550;
		public static final int PLUTONIUM_COST = 250;
		public static final int GOLD_COST = 750;
		public static final int BASE_SPEED = 10;
		public static final int GOLD_VOLUME = 1500;
		public static final int PLUT_VOLUME = 1500;
		public static final int IRON_VOLUME = 1500;
	}


}
