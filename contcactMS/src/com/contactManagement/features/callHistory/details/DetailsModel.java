package com.contactManagement.features.callHistory.details;

import com.contactManagement.features.base.BaseModel;
import com.contactManagement.repositories.db.ContactDb;
import com.contactManagement.repositories.dto.CallRecord;

import java.util.List;


public class DetailsModel extends BaseModel {

    private DetailsView view ;

    DetailsModel(DetailsView view){
        this.view = view ;
    }

    public void getAllCallLogs() {

        List<CallRecord> lists = ContactDb.getInstance().getAllCallHistory();
        if( lists.size()==0){
            view.showMessage(" No Call Records Found");
        }
        view.displayRecords(lists);
    }

    public void getRecentCalls(){
        List<CallRecord> recentCalls = ContactDb.getInstance().getRecentCalls();

        if( recentCalls.size() == 0) {
            view.showMessage(" No Recent Calls Found");
        }
        view.displayRecords(recentCalls);
    }

}
