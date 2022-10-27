# CSC120-A6: Use What Your Parent (Class) Gave You

## Outline
In this assignment (Part I of a two-week assignment), we'll explore how to use [**Inheritance**](https://en.wikipedia.org/wiki/Inheritance_(object-oriented_programming)) to write _parsimonious_ programs. 

We'll start with a simple class representing a generic `Building` (`Building.java`):

<img src="https://cdn-icons-png.flaticon.com/512/1324/1324872.png" alt="Building icon created by Freepik - Flaticon" width="200"/>

There is nothing special about this `Building`. It doesn't have any specific purpose, but it does have the minimal attributes you'd expect a building to have (pre-filled with some not-so-useful default values):

```
private String name = "<Name Unknown>";
private String address = "<Address Unknown>";
private int nFloors = 1;
```

In addition, it can do a few basic things. It can tell you its name:

```
public String getName();
```

as well as its location:
```
public String getAddress();
```

and of course, how tall it is:
```
public int getFloors();
```
Like any good `class`, the `Building` class also has an overridden `toString()` method that provides some more useful information than just its location in memory. You probably won't need to modify this file, but it might come in handy in more efficiently creating the following classes.

## Phase 1: the `House` class
A `House` is a specific type of `Building`:

<img src="https://cdn-icons-png.flaticon.com/512/738/738822.png" alt="House icon created by Freepik - Flaticon" width="200"/>

In addition to all the features it has by virtue of being a `Building`, it is also a place where students live, work, and sometimes eat (if the `House` has a dining room). In this phase, your task is to expand on the stub contained in `House.java`, which is reproduced in its entirety below:
```
/* This is a stub for the House class */
public class House {
  public House() {
    System.out.println("You have built a house: 🏠");
  }

  public static void main(String[] args) {
    new House();
  }
}
```
by doing the following:

---
1. Make the `House` class `extend` the `Building` class, and add the following attributes:
```
private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
private boolean hasDiningRoom;
```
Modify the `House` **constructor** to initialize `residents` to a `new ArrayList<String>()`, as well as to set `hasDiningRoom` to indicate whether or not the house has a dining room. You'll have to pass this value in as a parameter to the constructor, and don't forget to `import java.util.ArrayList`!

---
2. Write the following accessors to retrieve the indicated values:
```
public boolean hasDiningRoom();
public boolean nResidents();
```

---
3. Write methods to update the `ArrayList` of `residents` every time someone moves in or out:
```
public void moveIn(String name);
public String moveOut(String name); // return the name of the person who moved out
```
as well as a boolean method that tells us whether or not a given person is a resident of the `House` (for security reasons, we don't want to provide direct access to the entire list of residents):
```
public boolean isResident(String person);
```
_Hint: use the functions provided by the [`ArrayList`](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) class to make this much easier! Specifically, check out `add(...)`, `remove(...)`, and `contains(...)`._

## Phase 2: the `Library` class
A `Library` is an altogether different kind of building:

<img src="https://cdn-icons-png.flaticon.com/512/1596/1596485.png" alt="Library icon created by Freepik - Flaticon" width="200"/>

In this phase, your task is to expand on the stub contained in `Library.java`. A `Library` doesn't have any `residents` (nor do we have to worry about a dining room), but it does have a `collection` (of titles) which we'll store in another data structure called a `HashTable`:
```
private HashTable<String, boolean> collection;
```
`HashTable`s are a way to store `(key, value)` pairs in Java. We'll use store each book's title and author (concatenated together as one `String`, i.e. `"The Lorax by Dr. Seuss"`) as the `key`, and we'll use the corresponding boolean value to record whether or not the book is available (`true`) or currently checked out (`false`).

---
1. Make the `Library` class `extend` the `Building` class, add a `private HashTable<String, boolean> collection` attribute, and initialize this to an empty `HashTable<String, boolean>` inside the `Library` constructor.

---
2. Write methods to update the `HashTable` containing the `collection` every time we add/remove a title:
```
public void addTitle(String title);
public String removeTitle(String title); // return the title that we removed
```
as well as to check a book out or return it (rather than adding or removing a book from the collection, these methods will simply modify the `value` associated with the given `key` - the `title`):
```
public void checkOut(String title);
public void return(String title);
```
_Hint: use the functions provided by the [`HashTable`](https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html) class to make this much easier! Specifically, check out `put(...)`, `remove(...)`, and `replace(...)`._

---
3. For good measure, we'll also write a couple of methods to support browsing the collection:
```
public boolean containsTitle(String title); // returns true if the title appears as a key in the Libary's collection, false otherwise
public boolean isAvailable(String title); // returns true if the title is currently available, false otherwise
public void printCollection(); // prints out the entire collection in an easy-to-read way (including checkout status)
```
_Hint: again, let HashTable's methods do some of the heavy lifting for you!_

## Phase 3: The `Cafe` class
Finally, my personal favorite type of building within walking distance of any college campus, the `Cafe`:
<img src="https://cdn-icons-png.flaticon.com/512/1839/1839053.png" alt="Cafe icon created by Freepik - Flaticon" width="200"/>

