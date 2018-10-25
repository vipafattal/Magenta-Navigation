<p align="center"><img src="https://github.com/vipafattal/Magent-Navgation/blob/master/readme/magent-icon.png" width=20%></p>
<br>

# Magent-Navgation
[![](https://jitpack.io/v/vipafattal/Magent-Navigation.svg)](https://jitpack.io/#vipafattal/Magent-Navigation)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
### A stylish material navigation written in Kotlin
<img src="https://github.com/vipafattal/Magent-Navgation/blob/master/readme/magentaNav.gif" width=25%>

# Usage

#### Step 1
add in your root build.gradle at the end of repositories
```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
#### Step 2
```groovy
implementation 'com.github.vipafattal:Magent-Navigation:v0.1'
```
then use it as you use any other view...
note this project built using Kotlin `1.2.71` 

### How To Create Navigation Menu
you can create nav menu programmatically by buliding list items then pass it or by passing xml menu to createNavBar() function 
#### note you shouldn't put more then 4 element in the navigation.

### What Can I Do
| Tag                        | Usage                                                                 | default value |
| -------------------------- | --------------------------------------------------------------------- | ------------- |
| menuRes                    | used for passing menu to create nav items                             | _             |
| navColor                   | the main color for the nav items when pressed or active               | Magenta       |
| defaultColorState          | the main color for the nav items when not pressed or not active       | White         |
| accentActiveColor          | the secondary color for the nav items when pressed or active          | White         |
| accentDefault              | the secondary color for the nav items when not pressed or not active  | Gray          |
| navRadius                  | the raduis for every nav element                                      | 8dp           |
| navElevation               | the elevation for every nav element                                   | 4dp           |
| onClickItemElevation       | the elevation for element when clicked                                | 6dp           |
| text_size                  | the text size, default 22sp, note this tag takes float values         | 22sp          |
| textSingleLine             | only one line are allowed for text                                    | false         |
| boldFont                   | bold type face for text                                               | true          |
| itemHeight                 | specify height for items in the nav                                   | wrap_content  |
| itemWidth                  | specify width for items in the nav                                    | match_parent  |
 



#### Example :
```xml
  <com.magenta.navigation.MagentaNav
        app:onClickItemElevation="14dp"
        android:id="@+id/magentaNav"
        app:scaleImg="1.5"
        app:textSize="15"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        app:menuRes="@menu/main_menu"
        app:navElevation="10dp"
        app:navRadius="10dp"
        />
```
##### to handle clicks on items you have to options, one by implement OnNavItemClicked listener

```kotlin
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
            R.id.friends->{
                magentaNav.navColor = colour(R.color.amber)
                toast("Friends")
            }
            R.id.about -> {
                magentaNav.navColor = colour(R.color.indigo)
                toast("About")
            }
        }
    }
    ...
}
```

##### or by creating an anonymous object and implement OnNavItemClicked

```kotlin
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        magentaNav.doOnItemClick(object : OnNavItemClicked {
            override fun onMagentaNavItemClicked(id: Int, position: Int) {
                onNavClick(id)
            }
        })
    }
    
  fun onNavClick(id: Int) {
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
```

##### also you can create items programatically by calling createNav() function on MagentaNav view and passing mutableList of ItemsModel

```kotlin
//create mutableList then pass it createNav() to create new items
val itemsList = mutableListOf<ItemsModel>()
itemsList.add(ItemsModel("Home", getImage(R.drawable.home_img), 123))
itemsList.add(ItemsModel("Account",getImage(R.drawable.account),456))
itemsList.add(ItemsModel("about",getImage(R.drawable.about_info),789))
magentaNav.createNav(itemsList)
```
    
##### you may want to set the defualt nav item, you can do that by giving default position to callOnClickNavigation() function

```kotlin
  magentaNav.callOnClickNavigation(0)
```
##### you're free to make pull request and contribute, happy coding!
