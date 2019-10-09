package com.booleanull.featurecontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.booleanull.core.data.Contact
import kotlinx.android.synthetic.main.view_contact.view.*

class ContactsAdapter(private val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactsAdapter.ContactsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContactsHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_contact,
                parent,
                false
            )
        )

    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: ContactsHolder, position: Int) =
        holder.bind(contacts[holder.adapterPosition])

    inner class ContactsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(contact: Contact) {
            with(itemView) {
                tv_name.text = contact.name
                tv_email.text = contact.email
            }
        }
    }
}