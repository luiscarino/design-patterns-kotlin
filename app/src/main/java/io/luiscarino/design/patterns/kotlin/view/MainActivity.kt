package io.luiscarino.design.patterns.kotlin.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import io.luiscarino.design.patterns.kotlin.R
import io.luiscarino.design.patterns.kotlin.view.list.dummy.BehavioralPatterns
import io.luiscarino.design.patterns.kotlin.view.list.dummy.CreationalPatterns
import io.luiscarino.design.patterns.kotlin.view.list.dummy.DummyContent
import io.luiscarino.design.patterns.kotlin.view.list.dummy.StructuralPatterns
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), io.luiscarino.design.patterns.kotlin.view.list.ListFragment.OnListFragmentInteractionListener {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_behavioral -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, io.luiscarino.design.patterns.kotlin.view.list.ListFragment.newInstance(BehavioralPatterns.ITEMS))
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_creational -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, io.luiscarino.design.patterns.kotlin.view.list.ListFragment.newInstance(CreationalPatterns.ITEMS))
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_structural -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, io.luiscarino.design.patterns.kotlin.view.list.ListFragment.newInstance(StructuralPatterns.ITEMS))
                        .commit()
                return@OnNavigationItemSelectedListener true

            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, io.luiscarino.design.patterns.kotlin.view.list.ListFragment.newInstance(BehavioralPatterns.ITEMS))
                .commit()
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }
}
