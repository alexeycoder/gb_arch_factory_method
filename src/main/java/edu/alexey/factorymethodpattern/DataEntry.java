package edu.alexey.factorymethodpattern;

import java.util.Objects;

public abstract class DataEntry {

	protected Object entryContent;

	public DataEntry(Object entryContent) {
		this.entryContent = Objects.requireNonNull(entryContent);
	}

	public Object getContent() {
		return entryContent;
	}

	/**
	 * Заставляем переопределять toString().
	 */
	public abstract String toString();

}
