package com.booleanull.featureperson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booleanull.core.data.ContactEntity
import com.booleanull.core.data.convertToContact
import kotlinx.android.synthetic.main.fragment_person.*

class PersonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contact = (arguments?.get("item") as ContactEntity).convertToContact()

        textView.text = contact.name
    }
}