package edu.alexey.factorymethodpattern;

import java.util.concurrent.ThreadLocalRandom;

import edu.alexey.factorymethodpattern.concrete.ByTenBytesReader;
import edu.alexey.factorymethodpattern.concrete.ConcreteReaderCreator;

public class App {

	public static void main(String[] args) {

		ReaderCreator readerCreator = new ConcreteReaderCreator();

		test1(readerCreator);

		test2(readerCreator);

		test3(readerCreator);
	}

	static void test1(ReaderCreator readerCreator) {

		Reader textReader = readerCreator.createPreparedReader(DataType.TEXT, "test.txt");
		textReader.setPosition(3);

		for (var entry : textReader.readEntries()) {
			System.out.println(entry.toString());
		}
		System.out.println("-".repeat(40));
	}

	static void test2(ReaderCreator readerCreator) {

		String data = """
				У лукоморья дуб зелёный;
				Златая цепь на дубе том:
				И днём и ночью кот учёный
				Всё ходит по цепи кругом;
				Идёт направо — песнь заводит,
				Налево — сказку говорит.""";

		Reader poemReader = readerCreator.createPreparedReader(DataType.POEM, data);
		poemReader.setPosition(3);

		for (var entry : poemReader.readEntries()) {
			System.out.println(entry.toString());
		}
		System.out.println("-".repeat(40));
	}

	static void test3(ReaderCreator readerCreator) {

		byte[] data = new byte[ByTenBytesReader.N * 10 + 5];
		ThreadLocalRandom.current().nextBytes(data);

		Reader byTenBytesReader = readerCreator.createPreparedReader(DataType.BINARY, data);
		byTenBytesReader.setPosition(5);

		for (var entry : byTenBytesReader.readEntries()) {
			System.out.println(entry.toString());
		}
		System.out.println("-".repeat(40));
	}

}
