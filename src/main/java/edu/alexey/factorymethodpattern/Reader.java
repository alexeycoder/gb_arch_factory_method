package edu.alexey.factorymethodpattern;

public interface Reader {

	/**
	 * Sets data source.
	 * 
	 * @param dataSource
	 */
	void setDataSource(Object dataSource);

	/**
	 * Sets zero-based position.
	 * 
	 * @param pos -- zero-based position.
	 */
	void setPosition(int pos);

	/**
	 * Gets zero-based position.
	 * 
	 * @return Zero-based position.
	 */
	int getPosition();

	/**
	 * Reads all entries starting from position.
	 * 
	 * @return Data entries.
	 */
	Iterable<? extends DataEntry> readEntries();

}
