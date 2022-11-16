package unj.cs.student

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import unj.cs.student.databinding.StudentViewBinding

class StudentAdapter(private val onItemClicked: (Student) -> Unit) : ListAdapter<Student, StudentAdapter.StudentViewHolder>(DiffCallback){
//    companion object{
//        var dataset:MutableList<Student> = mutableListOf(
//            Student("1313620026", "Ahmad Bisri")
//        )
//    }
    //private val studentList: MutableList<Student> = viewModel.studentList.value!!

    class StudentViewHolder(private var binding: StudentViewBinding) : RecyclerView.ViewHolder(binding.root) {
//        val idTextView : TextView = view.findViewById(R.id.student_id)
//        val nameTextView : TextView = view.findViewById(R.id.student_name)
//        val studentArea : ConstraintLayout = view.findViewById(R.id.clickable_area)

        fun bind(student: Student){
            binding.apply {
                studentId.text = student.ids
                studentName.text = student.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
//        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.student_view, parent, false)
//        return StudentViewHolder(adapterLayout)
        val viewHolder = StudentViewHolder(
            StudentViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener{
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        // val student: Student = dataset[position]
//        val student: Student = viewModel.studentList.value!![position]
//        holder.idTextView.text = student.ids
//        holder.nameTextView.text = student.name
//        holder.studentArea.setOnClickListener {
//            val action: NavDirections = StudentListFragmentDirections.actionStudentListFragmentToStudentFormFragment(position, "Update Student")
//            holder.view.findNavController().navigate(action)
//        }
        holder.bind(getItem(position))
    }

//    override fun getItemCount(): Int {
//        return viewModel.studentList.value!!.size
//    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Student>() {
            override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean {
                return oldItem == newItem
            }
        }
    }
}