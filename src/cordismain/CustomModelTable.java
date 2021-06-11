/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cordismain;
import SQL_Loader.YearData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * To populate Table in Dashboard1, Line Chart
 * @author Michal Dioszegi
 * w1703164
 */
public class CustomModelTable extends AbstractTableModel 
{
    private final String[] columnNames = { "2015 Jan - Dec", "2016 Jan - Dec", "2017 Jan - Dec", "2018 Jan - Dec", "2019 Jan - Dec" };
    private ArrayList<YearData> columnData; 

    public CustomModelTable(ArrayList<YearData> columnData)     //, String[] columnNames 
    {
        this.columnData = columnData;
    }
    
    
    @Override
    public int getRowCount() 
    {
        return 12;
    }

    @Override
    public int getColumnCount() 
    {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        Object temp = null;
        
        if(columnIndex == 0)
        {
            double[] arr = columnData.get(columnIndex).getArray();
            temp = (int)arr[rowIndex] / 1000;
        }
        if(columnIndex == 1)
        {
            double[] arr = columnData.get(columnIndex).getArray();
            temp = (int)arr[rowIndex]  / 1000;
        }
        if(columnIndex == 2)
        {
            double[] arr = columnData.get(columnIndex).getArray();
            temp = (int)arr[rowIndex]  / 1000;
        }
        if(columnIndex == 3)
        {
            double[] arr = columnData.get(columnIndex).getArray();
            temp = (int)arr[rowIndex] / 1000;
        }
        if(columnIndex == 4)
        {
            double[] arr = columnData.get(columnIndex).getArray();
            temp = (int)arr[rowIndex];
        }
        if(columnIndex == 5)
        {
            double[] arr = columnData.get(columnIndex).getArray();
            temp = (int)arr[rowIndex];
        }
        return temp;
    }
    
    public String getColumnName(int col) 
    {
        return columnNames[col];
    }
}
