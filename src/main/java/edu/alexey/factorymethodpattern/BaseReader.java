package edu.alexey.factorymethodpattern;

public abstract class BaseReader implements Reader {

	protected int position;

	/**
	 * Zero-based!
	 */
	@Override
	public void setPosition(int pos) {
		if (pos < 0) {
			throw new IllegalArgumentException();
		}
		this.position = pos;
	}

	/**
	 * Zero-based!
	 */
	@Override
	public int getPosition() {
		return this.position;
	}
}
