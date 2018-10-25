package animationlib.codebox.com

import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import animationlib.codebox.com.magent_navgation.R
import com.magenta.navigation.model.ItemsModel
import com.magenta.navigation.onClick.OnNavItemClicked
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnNavItemClicked {

    override fun onMagentaNavItemClicked(id: Int, position: Int) {
        when (id) {
            R.id.home -> {
                magentaNav.navColor = colour(R.color.colorAccent)
                toast("Home")
            }
            R.id.account -> {
                magentaNav.navColor = colour(R.color.red)
                toast("Account")
            }
            R.id.friends -> {
                magentaNav.navColor = colour(R.color.amber)
                toast("Friends")
            }
            R.id.about -> {
                magentaNav.navColor = colour(R.color.indigo)
                toast("About")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
          In order to set items to navigation bar programmatically.
          prepareNavItems()
         */

        magentaNav.callOnClickNavigation(0)
    }

    //Navigation
    fun prepareNavItems() {
        //create mutableList then pass it createNav() to create new items
        val itemsList = mutableListOf<ItemsModel>()
        itemsList.add(ItemsModel("Home", getImage(R.drawable.home_img), 123))
        itemsList.add(ItemsModel("Account", getImage(R.drawable.account), 456))
        itemsList.add(ItemsModel("about", getImage(R.drawable.about_info), 789))
        magentaNav.createNav(itemsList)
    }

    private fun colour(@ColorRes color: Int) = ContextCompat.getColor(this, color)
    private fun toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    private fun getImage(@DrawableRes @ColorRes res: Int) = ContextCompat.getDrawable(this, res)!!
}
