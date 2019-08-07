package com.app.recyclerviewexamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val mRecyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create list of persons
        val persons = ArrayList<Person>()
        persons.add(Person(name = "Dhruv Chandrani"))
        persons.add(Person(name = "John Doe"))
        persons.add(Person(name = "Abc Xyz"))

        // Create adapter object
        val personsAdapter = PersonsAdapter()

        // Configure recyclerview
        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            itemAnimator = DefaultItemAnimator()
            adapter = personsAdapter
        }

        // Post data using submitList method
        personsAdapter.submitList(persons)
    }
}
