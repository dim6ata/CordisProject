/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cordismain;

import SQL_Loader.YearData;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * To populate Table in Dashboard1, Bar Chart
 * @author Michal Dioszegi
 * w1703164
 */
public class CustomTableModelCountries extends AbstractTableModel
{
    private String[] columnName = { "Country", "Number of Projects" };
    private String[] columnNames;
    private Integer[] columnValues;
    int dataSize;

    public CustomTableModelCountries( HashMap<String, Integer> map, int dataSize)     //, String[] columnNames 
    {
        this.columnNames = new String[map.size()];
        this.columnValues = new Integer[map.size()];
        this.dataSize = dataSize;
        initialize(map);
    }
    
    public void initialize(HashMap<String, Integer> map)
    {
        int counter = 0;
        
           for (Map.Entry<String, Integer> entry : map.entrySet()) 
            {
                if(counter < 15)
                {
                    columnNames[counter]  = entry.getKey();
                    columnValues[counter] = entry.getValue();
                    counter++;
                }
            }
//           for(int i = 0; i < columnNames.length; i++)
//           System.out.println("Col: " + columnNames[i]+"\nVal: "+ columnValues[i]);
    }
    
    @Override
    public int getRowCount() 
    {
        return dataSize;
    }

    @Override
    public int getColumnCount() 
    {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        Object temp = null;
        
        if(columnIndex == 0)
        {   
            temp =  columnNames[rowIndex];
        }
        if(columnIndex == 1)
        {   
            temp =  columnValues[rowIndex];
        }

        return temp;
    }
    
    public String getColumnName(int col) 
    {
        return columnName[col];
    }
} 

