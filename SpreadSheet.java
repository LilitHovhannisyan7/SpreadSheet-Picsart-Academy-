class WrongInputException extends RuntimeException
{
        public WrongInputException(String message)
        {
            System.out.println(message);
        }
}

class SpreadSheet
{
    private Cell [][] cells;
    private int column;
    private int row;


    public SpreadSheet(Cell [][] cells)
    {
        this.cells = cells;
    }

    public SpreadSheet(int row, int column)
    {
        this.column = column;
        this.row = row;
        this.cells = new Cell[row][column];

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                this.cells[i][j] = new Cell();
            }
        }
    }

    public void addColumn(int columnPosition)
    {
        if (columnPosition < 0 || columnPosition >= this.cells[0].length)
        {
            throw new WrongInputException("Wrong column position");
        }
        Cell [][] newCells = new Cell[this.cells.length][this.cells[0].length + 1];

        int i = 0;
        int j = 0;
        for(i = 0; i < this.cells.length; ++i)
        {
            for(j = 0; j <= columnPosition; ++j)
            {
                newCells[i][j] = cells[i][j];
            }

            newCells[i][j] = new Cell();

            for(j = j + 1; j < this.cells[0].length; ++j)
            {
                newCells[i][j] = cells[i][j];
            }
        }
        cells = newCells;
    }


    public void addRow(int rowPosition)
    {

        if (rowPosition < 0 || rowPosition >= this.cells.length)
        {
            throw new WrongInputException("Wrong row position");
        }

        Cell [][] newCells = new Cell[this.cells.length + 1][this.cells[0].length];
        int i = 0;
        int j = 0;
        for(i = 0; i <= rowPosition; ++i)
        {
            for (j = 0; j < this.cells[0].length; ++j)
            {
                newCells[i][j] = cells[i][j];
            }
        }
        for(j = 0; j < this.cells[0].length; ++j)
        {
            newCells[i][j] = new Cell();
        }
        for(; i < this.cells.length; ++i)
        {
            for (j = 0; j < this.cells[0].length; ++j)
            {
                newCells[i][j] = cells[i][j];
            }
        }
        cells = newCells;
    }



    public void setValueAt(int row, int column, Object value)
    {
        if (row < 0 || row >= this.row)
        {
            throw new WrongInputException("Wrong row");
        }
        if(column < 0 || column >= this.column)
        {
            throw new WrongInputException("Wrong column");
        }

        this.cells[row][column].setValue(value);
    }


    public Object getValueAt(int row, int column)
    {
        if (row < 0 || row >= this.cells.length)
        {
            throw new WrongInputException("Wrong row");
        }
        if(column < 0 || column >= this.cells[0].length)
        {
            throw new WrongInputException("Wrong column");
        }
        return this.cells[row][column].getValue();
    }


    public void setColorAt(int row, int column, Color color)
    {
        if (row < 0 || row >= this.cells.length)
        {
            throw new WrongInputException("Wrong row");
        }
        if(column < 0 || column >= this.cells[0].length)
        {
            throw new WrongInputException("Wrong column");
        }
        this.cells[row][column].setColor(color);
    }


    public Color getColorAt(int row, int column)
    {
        if (row < 0 || row >= this.cells.length)
        {
            throw new WrongInputException("Wrong row");
        }
        if(column < 0 || column >= this.cells[0].length)
        {
            throw new WrongInputException("Wrong column");
        }
        return this.cells[row][column].getColor();
    }


    public void reset()
    {
        for(int i = 0; i < cells.length; ++i)
        {
            for(int j = 0; j < cells[0].length; ++j)
            {
                this.cells[i][j].reset();
            }
        }
    }


    public void resetCellAt(int row, int column)
    {
        if (row < 0 || row >= this.cells.length)
        {
            throw new WrongInputException("Wrong row");
        }
        if(column < 0 || column >= this.cells[0].length)
        {
            throw new WrongInputException("Wrong column");
        }
        this.cells[row][column].reset();
    }


    public double getColumnSum(int column) {

        if (column < 0 || column >= this.cells[0].length)
        {
            throw new WrongInputException("Wrong column");
        }
        double sum = 0;
        for (int i = 0; i < this.cells.length; ++i) {
            if (this.cells[i][column] != null) {
                sum = sum + this.cells[i][column].toDouble();
            } else {
                throw new ValueIsNullException("Value is null");
            }

        }

            return sum;
        }



    public double getRowSum(int row)
    {
        if (row < 0 || row >= this.cells.length)
        {
            throw new WrongInputException("Wrong row");
        }
        double sum = 0;
        for(int j = 0; j < this.cells[0].length; ++j)
        {
            if (this.cells[row][j] != null) {
                sum = sum + this.cells[row][j].toDouble();
            } else {
                throw new ValueIsNullException("Value is null");
            }

        }
        return sum;
    }


    public double getAreaSum(int row1, int column1, int row2, int column2)
    {
        if (row1 < 0 || row1 >= this.cells.length || row2 < 0 || row2 >= this.cells.length)
        {
            throw new WrongInputException("Wrong row");
        }
        if(column1 < 0 || column1 >= this.cells[0].length || column2 < 0 || column2 >= this.cells[0].length)
        {
            throw new WrongInputException("Wrong column");
        }
        int maxRow = (row1 < row2) ? row2 : row1;
        int maxColumn = (column1 < column2) ? column2 : column1;
        int minRow = (row1 > row2) ? row2 : row1;
        int minColumn = (column1 > column2) ? column2 : column1;
        double areaSum = 0;
        for(int i = minRow; i <= maxRow; ++i)
        {
            for(int j = minColumn; j <= maxColumn; ++j)
            {
                if (this.cells[i][j] != null)
                {
                    areaSum = areaSum + this.cells[i][j].toDouble();
                }
                else
                {
                    throw new ValueIsNullException("Value is null");
                }


            }
        }
        return areaSum;
    }


    public double getColumnAverage(int column)
    {
        if (column < 0 || column >= this.cells[0].length)
        {
            throw new WrongInputException("Wrong row");
        }
        return this.getColumnSum(column) / this.cells.length;
    }


    public double getRowAverage(int row)
    {
        if (row < 0 || row >= this.cells.length)
        {
            throw new WrongInputException("Wrong row");
        }
        return this.getRowSum(row) / this.cells[0].length;
    }


    public double getAreaAverage(int row1, int column1, int row2, int column2)
    {
        if (row1 < 0 || row1 >= this.cells.length || row2 < 0 || row2 >= this.cells.length)
        {
            throw new WrongInputException("Wrong row");
        }
        if(column1 < 0 || column1 >= this.cells[0].length || column2 < 0 || column2 >= this.cells[0].length)
        {
            throw new WrongInputException("Wrong column");
        }
        int maxRow = (row1 < row2) ? row2 : row1;
        int maxColumn = (column1 < column2) ? column2 : column1;
        int minRow = (row1 > row2) ? row2 : row1;
        int minColumn = (column1 > column2) ? column2 : column1;
        double areaSum = 0;
        int count = 0;
        for(int i = minRow; i < maxRow; ++i)
        {
            for(int j = minColumn; j < maxColumn; ++j)
            {
                if (this.cells[i][j] != null)
                {
                    areaSum = areaSum + this.cells[i][j].toDouble();
                    ++count;
                }
                else
                {
                    throw new ValueIsNullException("Value is null");
                }

            }
        }
        return areaSum / count;
    }


}