package com.idlogix.practice.factories;

import java.util.ArrayList;
import java.util.List;
import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.compiere.model.MOrder;
import com.idlogix.practice.Callout.DateCallout;
import com.idlogix.practice.Callout.MyCallout;
import com.idlogix.practice.Callout.PracCallout;

public class MyCalloutFactory implements IColumnCalloutFactory {

    @Override
    public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {
        
        List<IColumnCallout> list = new ArrayList<>();

 
            if (tableName.equalsIgnoreCase(MOrder.Table_Name) && columnName.equalsIgnoreCase(MOrder.COLUMNNAME_Description)) {
                list.add(new MyCallout());
            }
            else if(tableName.equalsIgnoreCase(MOrder.Table_Name) && columnName.equalsIgnoreCase(MOrder.COLUMNNAME_DateOrdered)) {
				list.add(new DateCallout());
			}

           
        return list.toArray(new IColumnCallout[0]);
    }
}
