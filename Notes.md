## WORK LOG

### SEPTEMBER 30th, 2023
#### SUMMARY 
The packages created up 'til now are the following:
+ `Flowers`
+ `GUI`
+ `People`

Also, I began with the creation of the `Orders` package.

Note that the classes that have been better implemented are the ones in the `Flowers` package. The others still need a little bit of work.

#### REMARKABLE CHANGES
Even though it wasn't the idea, at the end I designed two more classes than expected for the `Flowers` package. The first one being `CatalogueEntry` and `Range`. `Range` is a small class meant to open the possibility of having values that exist in an interval. `CatalogueEntry` is a class to store the data of every entry in the Catalogue.

The necessity of designing both came up when I noticed that the price of the flowers varies according to the length of the stem. Given that, it made bo sense to have an entry per each possible stem length in the Catalogue, specially given that the length is measured in fractions (floats), not integers. Therefore, it was easier to store the information in the catalogue as intervals and create two more classes to handle the information accordingly.

**IMPORTANT NOTE:** Right now the catalogue is a .CSV file. Before designing the classes, the idea of what the .JSON would contain was not defined, ergo the format chosen for the document.

#### NOTES FOR FUTURE WORK
The `equal` method in the `Flower` class has to be reconsidered. Right now it takes two classes as equal if the type and species are the same. Yet, given that price might change depending on the length of the stem, it might be a good idea to include the stem length in the formula to decide whether two objects are equal. 

When doing the comparison, the length of the stem might work as a range. Like in the catalogue. This way, a hybrid tea rose of 5 in and a hybrid tea rose of 7 in would probably be the same, but a hybrid tea rose of 5 in and a hybrid tea rose of 18 in wouldn't.

The other option is: instead of using the stem length, use a category. Like *mini*, *standard*, *premium*, and *jumbo*. Based on the category determine whether two flowers are equal. Also, the Catalogue should be updated to match those catagories.

-------------

### OCTOBER 2nd, 2023
#### SUMMARY
Today's work consisted in completing some classes, creating two new ones and updating the previous classes based on the new insight that the new classes provided.

#### REMARKABLE CHANGES
Below are the changes made to certain classes from the different packages.
- **`Flowers` Package**:
  * `Bouquet` : change in the `toString` method.
  * `CatalogueEntry` : change in the `contain` method. Now, instead of just checking whether the two flowers are "equal", it also verifies the stem length of the flower is in the expected range.
- **`Orders` Package**:
  * `Order` : change how the flowers and amounts are stored. It is no longer an `ArrayList` of objects, but an `ArrayList` of `ArrayLists` of objects. The change was done because a single bouquet may contain various flowers; ergo, the need of more than one list.
  * `Order` : dates will no longer be handled with the `Date` class of `java.util`, but with the `LocalDate` class of `java.time`
- **`People` package**:
  * `Client` : change in the `toString` method.
  * `Employee` : change in the `toString` method.

#### NEW ADDITIONS
Below are the new classes implemented (listed according to the package they belong to).
- **`Orders` Package**:
  * `OrderMaker` : class to prepare the prepackage based on the order of the client.
- **`Packages` Package**:
  * `Prepackage` : class that contains the info of the prepackages (bouquets and prices).

#### NOTES FOR FUTURE WORK
Some issues that have come up with the work developed:
- Should the `client` contain the `order` or the `order` the `client`? Because, right now, they both include each other. Yet, that seems a little redundant.
- When the employee takes the order, it should create an `ArrayList` of `ArrayLists` of objects (flowers and amounts) to be compatible with the new formats implemented for the orders.