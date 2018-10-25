
<p align="center"><img src="https://github.com/vipafattal/Magent-Navgation/blob/master/readme/magent-icon.png" width=20%></p>
<br>
# Magent-Navgation
### A stylish material navigation written in Kotlin
<img src="https://github.com/vipafattal/Magent-Navgation/blob/master/readme/magentaNav.gif" width=25%>

### How to use it
use it as you use any other view...

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
| textSize                   | the text size, default 22sp, note this tag takes float values         | 22sp          |
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
##### you can set the defualt nav item by calling the position

```kotlin
  magentaNav.callOnClickNavigation(0)
```

