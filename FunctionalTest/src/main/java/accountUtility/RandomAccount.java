package accountUtility;

import java.util.Random;

public class RandomAccount {

	private RandomAccount() {
	}

	public static String subtstanceName() {
		String[] substanceName = { "DHEA", "kaaapn", "Cobalt" };
		String substanceNames = (substanceName[new Random().nextInt(substanceName.length)]);
		return substanceNames;
	}

	public static String regimeName() {
		String[] RegimeName = { "zscexRajeshs", "ceaser" };
		String RegimeNames = (RegimeName[new Random().nextInt(RegimeName.length)]);
		return RegimeNames;
	}

	public static String regimeFilterName() {
		String[] RegimeName = { "testz", "0A Regime B" };
		String RegimeNames = (RegimeName[new Random().nextInt(RegimeName.length)]);
		return RegimeNames;
	}

	public static String countryCode() {
		String[] CountryCode = { "Afghanistan (+93)", "Brazil (+55)", "Russia (+7)", "Kenya (+254)" };
		String CountryCodeName = (CountryCode[new Random().nextInt(CountryCode.length)]);
		return CountryCodeName;
	}

	public static String entitiesSearch() {
		String[] entitiesSearchText = { "DTS", "Entity", "Test" };
		String entitiesSearch = (entitiesSearchText[new Random().nextInt(entitiesSearchText.length)]);
		return entitiesSearch;
	}

	public static String entities() {
		String[] entitiesSearchText = { "Jenson", "Angeline" };
		String entitiesSearch = (entitiesSearchText[new Random().nextInt(entitiesSearchText.length)]);
		return entitiesSearch;
	}

	public static String resultSearch() {
		String[] resultSearchText = { "XYZ104", "311Absent" };
		String resultSearch = (resultSearchText[new Random().nextInt(resultSearchText.length)]);
		return resultSearch;
	}
}
