import net.sourceforge.jFuzzyLogic.FIS;


/*

 * Тестовый парсер FCL-файла
 * компилируем командой "javac -cp ./jFuzzyLogic_v2.1a.jar SmartHouse.java"
 * далее кладем файл SmartHouse.class в каталог SmartHouse
 * и запускаем командой "java -cp ./jFuzzyLogic_v2.1a.jar;SmartHouse SmartHouse"

 */


// Входные переменные:
// Время суток: TimeOfDay
// Время года: Season
// Температура на улице: OutdoorTemperature
// Климатические условия: ClimaticConditions

// Выходные переменные:
// Уровень освещенности в помещениях: IndoorLightingLevel
// Уровень температуры в помещениях: RoomTemperature



// Умный дом
public class SmartHouse {

	public static void main(String[] args) throws Exception {

		FIS fis = FIS.load("SmartHouse.fcl", true);

		if (fis == null) {
			System.err.println("Error loading file with name 'SmartHouse.fcl'");
			return;
		}

		// Показываем.
		fis.chart();

		// Задаем значения входных переменных.
		fis.setVariable("TimeOfDay", 6);
		fis.setVariable("Season", 11);
		fis.setVariable("OutdoorTemperature", 65);
		fis.setVariable("ClimaticConditions", 55);

		// Вычисляем.
		fis.evaluate();

		// Печатаем информацию о выходной перменной.
		System.out.println(fis.getVariable("IndoorLightingLevel").toString());
		System.out.println(fis.getVariable("RoomTemperature").toString());

		// Печатаем вещественное значение последней дефаззификации выходной переменной.
		System.out.println(fis.getVariable("IndoorLightingLevel").getValue());
		System.out.println(fis.getVariable("RoomTemperature").getValue());

		// Показываем график выходной переменной.
		fis.getVariable("IndoorLightingLevel").chartDefuzzifier(true);
		fis.getVariable("RoomTemperature").chartDefuzzifier(true);

	}

}