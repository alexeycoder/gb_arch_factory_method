package edu.alexey.factorymethodpattern;

public class App {

	public static void main(String[] args) {

		ReaderCreator readerCreator = new ConcreteReaderCreator();

		Reader textReader = readerCreator.createPreparedReader(DataType.TEXT, "test.txt");

		textReader.setPosition(3);

		for (var entry : textReader.readEntries()) {
			System.out.println(entry.toString());
		}
	}
}
