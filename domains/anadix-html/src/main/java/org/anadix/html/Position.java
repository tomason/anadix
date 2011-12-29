package org.anadix.html;

public class Position {
	private final int characterNumber;
	private final int lineNumber;
	private final int columnNumber;

	public Position(int characterNumber) {
		this(characterNumber, -1, -1);
	}

	public Position(int lineNumber, int columnNumber) {
		this(-1, lineNumber, columnNumber);
	}

	private Position(int characterNumber, int lineNumber, int columnNumber) {
		this.characterNumber = characterNumber;
		this.lineNumber = lineNumber;
		this.columnNumber = columnNumber;
	}

	public int getCharacterNumber() {
		return characterNumber;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public int getColumnNumber() {
		return columnNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 2011;
		int result = 1;
		result = prime * result + characterNumber;
		result = prime * result + columnNumber;
		result = prime * result + lineNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (characterNumber != other.characterNumber)
			return false;
		if (columnNumber != other.columnNumber)
			return false;
		if (lineNumber != other.lineNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (characterNumber > 0) {
			return Integer.toString(characterNumber);
		} else {
			return String.format("[%s, %s]", lineNumber, columnNumber);
		}
	}
}
