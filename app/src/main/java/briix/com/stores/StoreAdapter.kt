package briix.com.stores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import briix.com.stores.databinding.ItemStoreBinding

class StoreAdapter(private var stores: MutableList<Store>, private var listner: OnClickListener):
RecyclerView.Adapter<StoreAdapter.ViewHolder>(){

    private lateinit var mContex: Context



    inner class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val binding = ItemStoreBinding.bind(view)
        fun setListener(store: Store){
            binding.root.setOnClickListener { listner.onClick(store) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContex =  parent.context

        val view = LayoutInflater.from(mContex).inflate(R.layout.item_store, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = stores.get(position)
        with(holder){
            setListener(store)
            binding.tvName.text = store.name
        }
    }

    override fun getItemCount(): Int = stores.size
}

class Stores {

    val name: CharSequence?
        get() {
            TODO()
        }
}
