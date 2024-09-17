package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CafeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val TAB_CONTENT = "TAB_CONTENT"

class CafeDetailFragment : Fragment() {

    private var titleResId: Int? = null
    private var descriptionResId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            titleResId = it.getInt(ARG_TITLE)
            descriptionResId = it.getInt(ARG_DESCRIPTION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Assuming you have TextViews in fragment_cafe_detail for title and description
        val titleTextView = view.findViewById<TextView>(R.id.title_text_view)
        val descriptionTextView = view.findViewById<TextView>(R.id.description_text_view)

        titleTextView.text = titleResId?.let { getString(it) }
        descriptionTextView.text = descriptionResId?.let { getString(it) }
    }

    companion object {
        private const val ARG_TITLE = "title"
        private const val ARG_DESCRIPTION = "description"

        // Use this method to pass data to the fragment
        @JvmStatic
        fun newInstance(titleResId: Int, descriptionResId: Int) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TITLE, titleResId)
                    putInt(ARG_DESCRIPTION, descriptionResId)
                }
            }
    }
}