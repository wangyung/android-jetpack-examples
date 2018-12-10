package idv.freddiew.jetpackexamples.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import idv.freddiew.jetpackexamples.R
import java.lang.IllegalStateException

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var simpleText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(R.layout.main_fragment, container, false).also {
            simpleText = it.findViewById(R.id.simpleText)
        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw IllegalStateException("No view model")

        viewModel.displayText.value = "In onActivityCreated"
        viewModel.displayText.observe(this, Observer<String> { text ->
            simpleText.text = text
        })
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}
