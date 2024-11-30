package archiebaldry.villagernames;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.text.Text;

import java.util.Random;
import java.util.stream.Stream;

public class VillagerNames implements ModInitializer {
	private static final String[] MALE_NAMES = {"Jack","Joshua","Thomas","James","Daniel","Oliver","Samuel","William","Benjamin","Joseph","Harry","Matthew","Lewis","Ethan","Charlie","George","Luke","Mohammed","Callum","Alexander","Adam","Ryan","Jacob","Alfie","Dylan","Jake","Ben","Connor","Liam","Cameron","Nathan","Harvey","Jamie","Max","Tyler","Owen","Louis","Kyle","Michael","Kieran","Aaron","Bradley","Edward","Archie","Brandon","Henry","Alex","Harrison","Charles","Reece","Toby","Muhammad","Sam","Joe","David","Oscar","Leo","Isaac","Robert","Kai","Finlay","John","Christopher","Rhys","Kian","Bailey","Mohammad","Billy","Aidan","Jay","Finley","Noah","Joel","Lucas","Mason","Taylor","Leon","Andrew","Jonathan","Dominic","Sean","Logan","Ellis","Elliot","Morgan","Patrick","Jordan","Riley","Sebastian","Scott","Louie","Jude","Freddie","Declan","Luca","Jayden","Nicholas","Gabriel","Josh","Tom"};

	private static final String[] FEMALE_NAMES = {"Emily","Ellie","Jessica","Sophie","Chloe","Olivia","Lucy","Charlotte","Katie","Grace","Megan","Hannah","Amy","Ella","Mia","Lily","Holly","Emma","Abigail","Amelia","Molly","Millie","Lauren","Leah","Caitlin","Rebecca","Bethany","Georgia","Eleanor","Isabelle","Ruby","Daisy","Freya","Isabella","Elizabeth","Jasmine","Erin","Alice","Evie","Phoebe","Amber","Paige","Poppy","Madison","Abbie","Isabel","Aimee","Anna","Niamh","Courtney","Keira","Isobel","Libby","Shannon","Sarah","Tia","Rosie","Maisie","Zoe","Alicia","Eve","Alisha","Sophia","Nicole","Rachel","Natasha","Imogen","Madeleine","Scarlett","Lydia","Alexandra","Summer","Hollie","Brooke","Morgan","Harriet","Maddison","Louise","Francesca","Laura","Eloise","Faith","Melissa","Mollie","Maya","Jennifer","Chelsea","Kayleigh","Jodie","Georgina","Jade","Kiera","Kate","Zara","Charlie","Katherine","Amelie","Lilly","Lara","Samantha"};

	private static final String[] NATO_NAMES = {"Alfa","Bravo","Charlie","Delta","Echo","Foxtrot","Golf","Hotel","India","Juliett","Kilo","Lima","Mike","November","Oscar","Papa","Quebec","Romeo","Sierra","Tango","Uniform","Victor","Whiskey","Xray","Yankee","Zulu"};

	@Override
	public void onInitialize() {
		Random random = new Random();

		String[] names = Stream.of(
				MALE_NAMES,
				FEMALE_NAMES,
				NATO_NAMES
		).flatMap(Stream::of).toArray(String[]::new);

		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (!(entity instanceof MerchantEntity)) {
				return;
			}

			if (entity.hasCustomName()) {
				return;
			}

			entity.setCustomName(Text.of(names[random.nextInt(names.length)]));
		});
	}
}
