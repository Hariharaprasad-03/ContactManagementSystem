package com.contactManagement.features.callHistory;

import com.contactManagement.features.base.BaseView;

import java.util.ArrayList;
import java.util.List;

public class CallHistoryView extends BaseView {

    private CallHistoryModel model ;
    private List<String> options ;

    public CallHistoryView(){
        this.model = new CallHistoryModel(this);
        options = new ArrayList<>();
    }

    public void init(){
        loadOptions();
        showMenu();
    }

    public void loadOptions() {

        options.add("1 . Call history Details");
        options.add("2 . Search On Call History");
        options.add("3 . Back To Main Menu");
        options.add("4 . Exit App");
    }

    public void showMenu() {

    }
}
