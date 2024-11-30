package archiebaldry.villagernames;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.text.Text;

import java.util.Random;

public class VillagerNames implements ModInitializer {
	private static final String[] NAMES = {"Alfa", "Bravo", "Charlie"};

	@Override
	public void onInitialize() {
		Random random = new Random();

		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (!(entity instanceof MerchantEntity)) {
				return;
			}

			if (entity.hasCustomName()) {
				return;
			}

			entity.setCustomName(Text.of(NAMES[random.nextInt(NAMES.length)]));
		});
	}
}
