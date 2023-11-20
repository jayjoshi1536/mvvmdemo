package com.example.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.repository.UserRepository
import com.varitas.gokulpos.tablet.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val showProgress: MutableLiveData<Boolean> = MutableLiveData()

    private val _fullName = MutableLiveData<String>()
    val fullName: LiveData<String>
        get() = _fullName

    fun searchUser(username: String) {
        userRepository.getUser(username, { user -> _fullName.value = user.name }, { t -> Log.e("MainActivity", "onFailure: ", t) })
    }

    private val _movieList = MutableLiveData<List<Movie>>()

    val movieList: LiveData<List<Movie>>
        get() = _movieList

    fun setMovies() {
        userRepository.getAllMovies({ user -> _movieList.value = user }, { t -> Log.e("MainActivity", "onFailure: ", t) })
    }

    /*
     //region To fetch Auto Complete
    fun fetchAutoCompleteItems(msg : String) : MutableLiveData<List<FavouriteItems>> {
        val list = MutableLiveData<List<FavouriteItems>>()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                productsRepository.fetchAutoCompleteItems(msg, storeId!!, { response ->
                    if (response.status == Default.SUCCESS_API) list.postValue(response.data)
                    else list.postValue(ArrayList())
                }, { t ->
                    Log.e("Auto Complete", "onFailure: ", t)
                })
            } catch(ex : Exception) {
                Utils.printAndWriteException(ex)
                showProgress.postValue(false)
            }
        }
        return list
    } //endregion
    */
}