package edu.alexey.templatemethodpattern;

public class App {

	public static final String DATA = """
			У лукоморья дуб зклёный;
			Златая цепь на дубе том:
			И днём и ночью кот учёный
			Всё ходит по цепи кругом;
			Идёт направо — песнь заводит,
			Налево — сказку говорит.""";

	public static void main(String[] args) {

		LogReader logReader = new PoemLogReader(DATA);
		logReader.setCurrentPosition(3);

		for (LogEntry logEntry : logReader.readLogEntries()) {
			System.out.println(logEntry.text());
		}
	}
}
