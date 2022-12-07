package com.eyyuperdogan.room.adapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eyyuperdogan.room.R
import com.eyyuperdogan.room.databinding.ItemBinding
import com.eyyuperdogan.room.model.Car

class CarAdapter(private val actionListener: ItemOnClickListenner) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {
    var carList: MutableList<Car> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    inner class CarViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(car: Car) = binding.apply {
            textView2.text = car.title
            carItemText.text = car.price

            itemView.setOnClickListener {
                actionListener.showCustomAlertDialog(position = adapterPosition,car=car)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val binding = ItemBinding.bind(view)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    fun addNewCar(car: Car) {
        carList.add(0, car)
        notifyItemInserted(0)
    }

    fun updateCar(position: Int, newCar: Car) {
        carList[position] = newCar
        notifyItemChanged(position)

    }

    fun deleteCar(position: Int) {
        carList.removeAt(position)
        notifyItemRemoved(position)
    }


    override fun getItemCount(): Int = carList.size
}

interface ItemOnClickListenner {
    fun showCustomAlertDialog(position: Int, car: Car)
}