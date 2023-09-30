## WORK LOG

### SEPTEMBER 30th, 2023
The packages created up 'til now are the following:
+ `Flowers`
+ `GUI`
+ `People`

Also, I began with the creation of the `Orders` package.

Note that the classes that have been better implemented are the ones in the `Flowers` package. The others still a little bit of work.

#### REMARKABLE CHANGES
Even though it wasn't the idea, at the end I designed two more classes than expected for the `Flowers` package. The first one being `CatalogueEntry` and `Range`. `Range` is a small class meant to open the possibility of having values that exist in an interval. `CatalogueEntry` is a class to store the data of every entry in the Catalogue.

The necessity of designing both came up when I noticed that the price of the flowers varies according to the length of the stem. Given that, it made bo sense to have an entry per each possible stem length in the Catalogue, specially given that the length is measured in fractions (floats), not integers. Therefore, it was easier to store the information in the catalogue as intervals and create two more classes to handle the information accordingly.

**IMPORTANT NOTE:** Right now the catalogue is a .CSV file. Before designing the classes, the idea of what the .JSON would contain was not defined, ergo the format chosen for the document.

#### NOTES FOR FUTURE WORK
The `equal` method in the `Flower` class has to be reconsidered. Right now it takes two classes as equal if the type and species are the same. Yet, given that price might change depending on the length of the stem, it might be a good idea to include the stem length in the formula to decide whether two objects are equal. 

When doing the comparison, the length of the stem might work as a range. Like in the catalogue. This way, a hybrid tea rose of 5 in and a hybrid tea rose of 7 in would probably be the same, but a hybrid tea rose of 5 in and a hybrid tea rose of 18 in wouldn't.

The other option is: instead of using the stem length, use a category. Like *mini*, *standard*, *premium*, and *jumbo*. Based on the category determine whether two flowers are equal. Also, the Catalogue should be updated to match those catagories.