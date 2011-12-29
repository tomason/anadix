package org.anadix.html;

/**
 * Representation of position of a character in document.
 * It offers two variations: Either the position of a character or
 * as a line, column pair. Please note that both representations at
 * once are not supported.
 * 
 * @author tomason
 * @version $Id: $
 */
public class Position {
	private final int characterNumber;
	private final int lineNumber;
	private final int columnNumber;

	/**
	 * Constructor
	 * 
	 * @param characterNumber number of a character in document
	 */
	public Position(int characterNumber) {
		this(characterNumber, -1, -1);
	}

	/**
	 * Constructor
	 * 
	 * @param lineNumber number of line character is on
	 * @param columnNumber number of column character is on
	 */
	public Position(int lineNumber, int columnNumber) {
		this(-1, lineNumber, columnNumber);
	}

	private Position(int characterNumber, int lineNumber, int columnNumber) {
		this.characterNumber = characterNumber;
		this.lineNumber = lineNumber;
		this.columnNumber = columnNumber;
	}

	/**
	 * Gets the character number from the beginning of the document
	 * 
	 * @return character number or -1 if line, column pair is used
	 */
	public int getCharacterNumber() {
		return characterNumber;
	}

	/**
	 * Gets the line number
	 * 
	 * @return line number or -1 if character number is used
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * Gets the column number
	 * 
	 * @return column number or -1 if character number is used
	 */
	public int getColumnNumber() {
		return columnNumber;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 2011;
		int result = 1;
		result = prime * result + characterNumber;
		result = prime * result + columnNumber;
		result = prime * result + lineNumber;
		return result;
	}

	/** {@inheritDoc} */
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

	/** {@inheritDoc} */
	@Override
	public String toString() {
		if (characterNumber > 0) {
			return Integer.toString(characterNumber);
		} else {
			return String.format("[%s, %s]", lineNumber, columnNumber);
		}
	}
}
