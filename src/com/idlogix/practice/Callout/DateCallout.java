package com.idlogix.practice.Callout;

import java.util.Properties;
import java.sql.Timestamp;
import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.MOrder;
import org.compiere.model.GridTab;
import org.compiere.util.CLogger;

public class DateCallout implements IColumnCallout {

    CLogger log = CLogger.getCLogger(DateCallout.class);

    @Override
    public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
    	
    	
//    	int a = 3;
//    	int b = 3;
    	String dateStr = mTab.get_ValueAsString("DateOrdered");
    	Timestamp dateTs = Timestamp.valueOf(dateStr);
    	
    
            Timestamp orderDate = (Timestamp) dateTs;
            Timestamp minimumAllowedDate = Timestamp.valueOf("2024-01-01 00:00:00");

            
            if (orderDate.before(minimumAllowedDate)) {
                log.warning("Order date cannot be before January 1, 2024! Setting to minimum allowed date.");
                mTab.setValue(MOrder.COLUMNNAME_DateOrdered, minimumAllowedDate);
            }
       
        return null;
    }
}
