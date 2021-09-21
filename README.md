
<br>

# Magent-Navigation
[![](https://jitpack.io/v/vipafattal/Magent-Navigation.svg)](https://jitpack.io/#vipafattal/Magent-Navigation)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
### A stylish material navigation in Magenta© style
<img src="https://github.com/vipafattal/Magent-Navgation/blob/master/readme/magentaNav0.gif" width=25%>

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
add the dependency
```groovy
implementation 'com.github.vipafattal:Magent-Navigation:v0.1.2'
```
### How To Create Navigation Menu
you can create nav menu programmatically by buliding list items then pass it or by passing xml menu to createNavBar() function 

### What Can I Do
| Tag                        | Usage                                                                 | default value |
| -------------------------- | --------------------------------------------------------------------- | ------------- |
| menuRes                    | used for passing xml menu to create nav items                         | _             |
| navColor                   | the main color for the nav items when pressed or active               | Magenta       |
| defaultColorState          | the main color for the nav items when not pressed or not active       | White         |
| accentActiveColor          | the secondary color for the nav items when pressed or active          | White         |
| accentDefault              | the secondary color for the nav items when not pressed or not active  | Gray          |
| navRadius                  | the raduis for every nav element                                      | 8dp           |
| navElevation               | the elevation for every nav element                                   | 4dp           |
| marginBetweenItems         | the margin between every items                                        | 4dp           |
| onClickItemElevation       | the elevation for element when clicked                                | 6dp           |
| text_size                  | the text size in every item                                           | 21sp          |
| textSingleLine             | only one line are allowed for text                                    | false         |
| boldFont                   | bold type face for text                                               | true          |
| itemHeight                 | specify the height for items in the nav                               | wrap_content  |
| itemWidth                  | specify the width for items in the nav                                | match_parent  |
| itemMarginTop              | specify the margin top for items in the nav                           | 10dp          |
| itemMarginBottom           | specify the margin bottom for items in the nav                        | 0dp           |
| labelOptions               | show lables under items nav items                                     | labele        |
| scaleImg                   | this will modify img scale in every item                              | 1f            |
 
### Limitation
#### you shouldn't put more than 5 elements in the navigation otherwise you should use to NavigationDrawer.

 
#### Example :
```xml
   <com.magenta.navigation.MagentaNav
        app:onClickItemElevation="14dp"
        android:id="@+id/magentaNav"
        app:scaleImg="1.5"
        app:itemWidth="60dp"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        app:marginBetweenItems="0dp"
        app:navElevation="7dp"
        app:menuRes="@menu/main_menu"
        app:text_size="21sp"
        app:navRadius="10dp"
        />
```
##### to handle clicks on items you have two options:

1.by implementing OnNavItemClicked listener

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

##### 2.by creating an anonymous object and implement OnNavItemClicked

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
