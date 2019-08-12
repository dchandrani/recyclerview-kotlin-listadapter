package com.app.recyclerviewexamplekotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        // Two ways to set click listener
        // 1. Using DSL like below
        val personsAdapter = PersonsAdapter {
            Toast.makeText(this, "${it.name} clicked", Toast.LENGTH_SHORT).show()
        }

        // 2. By calling method like below
        // val personsAdapter = PersonsAdapter(::onClick)

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

    private fun onClick(person: Person) {
        Toast.makeText(this, "${person.name} clicked", Toast.LENGTH_SHORT).show()
    }
}
