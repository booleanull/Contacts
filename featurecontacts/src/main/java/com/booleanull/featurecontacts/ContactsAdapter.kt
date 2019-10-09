package com.booleanull.featurecontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.booleanull.core.data.Contact
import kotlinx.android.synthetic.main.view_contact.view.*


class ContactsAdapter :
    RecyclerView.Adapter<ContactsAdapter.ContactsHolder>() {

    var contacts = listOf<Contact>()

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

    class ContactDiffUtilCallback(
        private val oldList: List<Contact>,
        private val newList: List<Contact>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldProduct = oldList[oldItemPosition]
            val newProduct = newList[newItemPosition]
            return oldProduct.id == newProduct.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldProduct = oldList[oldItemPosition]
            val newProduct = newList[newItemPosition]
            return oldProduct.name == newProduct.name
        }
    }
}