package org.knowm.yank.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class DoubleColumnListHandler extends ColumnListHandler<Double> {

  /** The column number to retrieve. */
  private final int columnIndex;

  /** The column name to retrieve. Either columnName or columnIndex will be used but never both. */
  private final String columnName;

  /**
   * Creates a new instance of ColumnListHandler. The first column of each row will be returned from
   * <code>handle()</code>.
   */
  public DoubleColumnListHandler() {
    this(1, null);
  }

  /**
   * Creates a new instance of ColumnListHandler.
   *
   * @param columnIndex The index of the column to retrieve from the <code>ResultSet</code>.
   */
  public DoubleColumnListHandler(int columnIndex) {
    this(columnIndex, null);
  }

  /**
   * Creates a new instance of ColumnListHandler.
   *
   * @param columnName The name of the column to retrieve from the <code>ResultSet</code>.
   */
  public DoubleColumnListHandler(String columnName) {
    this(1, columnName);
  }

  /**
   * Private Helper
   *
   * @param columnIndex The index of the column to retrieve from the <code>ResultSet</code>.
   * @param columnName The name of the column to retrieve from the <code>ResultSet</code>.
   */
  private DoubleColumnListHandler(int columnIndex, String columnName) {
    super();
    this.columnIndex = columnIndex;
    this.columnName = columnName;
  }

  /**
   * Returns one <code>ResultSet</code> column value as <code>Object</code>.
   *
   * @param rs <code>ResultSet</code> to process.
   * @return <code>Object</code>, never <code>null</code>.
   * @throws SQLException if a database access error occurs
   * @throws ClassCastException if the class datatype does not match the column type
   * @see org.apache.commons.dbutils.handlers.AbstractListHandler#handle(ResultSet)
   */
  @Override
  protected Double handleRow(ResultSet rs) throws SQLException {
    if (this.columnName == null) {
      return rs.getDouble(this.columnIndex);
    }
    return rs.getDouble(this.columnName);
  }
}
