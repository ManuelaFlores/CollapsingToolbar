package com.example.manuelaflores.second_collapsingtoolbar

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_scrolling.*
import android.support.design.widget.AppBarLayout



class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)

        var drawable : Drawable

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        app_bar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
             var isShow: Boolean = false
             var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    //collapse map
                    //TODO: change share icon color - set white share icon
                    drawable.colorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP)

                    isShow = true
                } else if (isShow) {
                    //expanded map
                    //TODO: change share icon color - set dark share icon
                    isShow = false
                }
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)

        // set 0 if you have only one item in menu
        //this also will work
        //drawable = menu.findItem(your item id).getIcon();
        //
        menu.getItem(0).icon?.mutate()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> {
                true
            }

            R.id.action_favorite -> {
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}
