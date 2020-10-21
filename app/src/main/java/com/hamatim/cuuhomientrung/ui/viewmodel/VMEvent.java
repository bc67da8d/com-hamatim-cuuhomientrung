package com.hamatim.cuuhomientrung.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hamatim.cuuhomientrung.model.Event;
import com.hamatim.cuuhomientrung.model.HoDan;
import com.hamatim.cuuhomientrung.provider.ProviderSingleton;
import com.hamatim.cuuhomientrung.repository.RepoHoDan;
import com.hamatim.cuuhomientrung.util.HelperFormat;
import com.hamatim.cuuhomientrung.util.TimeComparator;

import java.util.List;

public class VMEvent extends ViewModel {

    private MutableLiveData<Event> eventLiveData;

    public VMEvent() {
        this.eventLiveData = new MutableLiveData<>();
    }

    public LiveData<Event> watchEvent(){
        return eventLiveData;
    }

    public void eventProcessed() {
        eventLiveData.postValue(new Event());
    }

    public void postEvent(Event event) {
        eventLiveData.postValue(event);
    }
}
