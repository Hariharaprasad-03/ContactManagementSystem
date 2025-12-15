package com.contactManagement.features.callHistory.search;

import com.contactManagement.features.base.BaseModel;
import com.contactManagement.repositories.db.ContactDb;
import com.contactManagement.repositories.dto.CallRecord;

import java.util.List;
import java.util.stream.Collectors;

public class SearchModel extends BaseModel {

    private final SearchView view ;

    SearchModel(SearchView view ) {
        this.view = view ;
    }

    public void getContactCallRecords(String name){

        List<CallRecord> records = ContactDb.getInstance().getAllCallHistory()
                .stream()
                .filter(c -> c.getName().equalsIgnoreCase(name)) // Use filter to keep matching records
                .collect(Collectors.toList());

        if ( records.isEmpty()){
            view.showMessage("There is No Call log for this Contact");
            return ;
        }
        view.displayRecords(records);
    }

}
