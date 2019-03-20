//package com.manooz.myjobs.View;
//
//import android.app.Application;
//
//import com.manooz.myjobs.Repository.WebsitesRepository;
//import com.manooz.myjobs.data.WebsiteModelRoom;
//
//import java.util.List;
//
//import androidx.annotation.NonNull;
//import androidx.lifecycle.AndroidViewModel;
//import androidx.lifecycle.LiveData;
//
//public class WebsitesViewModel extends AndroidViewModel {
//
//
//    private WebsitesRepository repository;
//    private LiveData<List<WebsiteModelRoom>> listLiveData;
//
//    public WebsitesViewModel(@NonNull Application application) {
//        super(application);
//        repository = new WebsitesRepository(application);
//        listLiveData = repository.listLiveData();
//    }
//
//    public void insert(WebsiteModelRoom websiteModelRoom) {
//        repository.insert(websiteModelRoom);
//    }
//
//    public void update(WebsiteModelRoom websiteModelRoom) {
//        repository.update(websiteModelRoom);
//    }
//
//    public void delete(WebsiteModelRoom note) {
//        repository.delete(note);
//    }
//
//    public void deleteAllNotes() {
//        repository.deleteAllNotes();
//    }
//
//    public LiveData<List<WebsiteModelRoom>> listLiveData() {
//        return listLiveData;
//    }
//}
