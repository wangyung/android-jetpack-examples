package idv.freddiew.jetpackexamples.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val displayText: MutableLiveData<String> = MutableLiveData()

    init {
        displayText.value = "Freddie's greeting"
    }
}
