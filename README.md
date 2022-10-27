# CSC120-A6: Use What Your Parent (Class) Gave You

## Outline
In this assignment, we'll explore how to use [**Inheritance**](https://en.wikipedia.org/wiki/Inheritance_(object-oriented_programming)) to write _parsimonious_ programs. 

We'll start with a simple class representing a generic `Building` (`Building.java`):

<img src="https://cdn-icons-png.flaticon.com/512/1324/1324872.png" alt="drawing" width="200"/>

There is nothing special about this `Building` - it doesn't have any specific purpose, but it does have the minimal attributes you'd expect a building to have (pre-filled with some not-so-useful default values):

```
private String name = "<Name Unknown>";
private String address = "<Address Unknown>";
private int nFloors = 1;
```

In addition, it can do a few basic things. It can tell you its name:

```
public String getName()
```

as well as its location:
```
public String getAddress()
```

and of course, how tall it is:
```
public int getFloors()
```
