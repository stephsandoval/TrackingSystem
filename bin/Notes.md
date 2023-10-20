## WORK LOG

-------------

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
- **Flowers Package**:
  * `Bouquet` : change in the `toString` method.
  * `CatalogueEntry` : change in the `contain` method. Now, instead of just checking whether the two flowers are "equal", it also verifies the stem length of the flower is in the expected range.
- **Orders Package**:
  * `Order` : change how the flowers and amounts are stored. It is no longer an `ArrayList` of objects, but an `ArrayList` of `ArrayLists` of objects. The change was done because a single bouquet may contain various flowers; ergo, the need of more than one list.
  * `Order` : dates will no longer be handled with the `Date` class of `java.util`, but with the `LocalDate` class of `java.time`
- **People package**:
  * `Client` : change in the `toString` method.
  * `Employee` : change in the `toString` method.

#### NEW ADDITIONS
Below are the new classes implemented (listed according to the package they belong to).
- **Orders Package**:
  * `OrderMaker` : class to prepare the prepackage based on the order of the client.
- **Packages Package**:
  * `Prepackage` : class that contains the info of the prepackages (bouquets and prices).

#### NOTES FOR FUTURE WORK
Some issues that have come up with the work developed:
- Should the `client` contain the `order` or the `order` the `client`? Because, right now, they both include each other. Yet, that seems a little redundant.
- When the employee takes the order, it should create an `ArrayList` of `ArrayLists` of objects (flowers and amounts) to be compatible with the new formats implemented for the orders.

-------------

### OCTOBER 3rd, 2023
#### SUMMARY
This day's work consisted in developing two more classes from the `Packages` package. Below is explained what was developed.

#### REMARKABLE CHANGES
- Added a small header description to the `Prepackage` class at the beginning of the document to have a brief idea of what it does without having to read the whole document.

#### NEW ADDITIONS
Below are the new classes implemented
- **Packages Package**:
  * `Package` : class the contains all the information of whatever the order of the client was. Note that for every client there exists one and only one package. If the user asks for multiple items they are shipped in the same package.
  * `PackageMaker` : class to prepare the package of the client. Is in charge of asking the other class for the different elements a package must contain to put them in a single object (`Package`).

#### NOTES FOR FUTURE WORK
- The issues noted in October 2nd still need to be solved.
- Think about how the objects are going to be registered and where (this information is needed to develop the `recordProcessor`).

-------------

### OCTOBER 4th, 2023
#### SUMMARY
This day's work consisted in developing two more classes from the `Packages` package. Below is explained what was developed.

#### REMARKABLE CHANGES
- Since a package may go through multiple stages during its trip, the category of "event" of `Package` was changed to "events" and is an `ArrayList`. This way, it is possible to have multiple events for a single package.

#### NEW ADDITIONS
- **Packages Package**:
  * `Event` : class the contains the information of single event a package can go through.
  * `PackageManager` : class to update the available packages. This class is in charge of creating the new events and adding them to the existing objects to update their information. It works closely to the class `RecordProcessor` that will be later developed.

#### NOTES FOR FUTURE WORK
- The issues noted in October 2nd still need to be solved.
- Think about how the objects are going to be registered and where (this information is needed to develop the `Record Processor`).
- Make a small `main` program to run a small version of the code to show its functionality.
- The only class needed to finish the second progress of the project is `Record Processor`. Besides that, there is only the need of make everything work together in a single file for demonstration purposes.

-------------

### OCTOBER 5th, 2023
#### SUMMARY
Day of the second phase of the project. According to the first idea, up to this date the completed classes should be:
- `Package Manager`
- `Event`
- `Package Maker`
- `Record Processor`
- `Pre Package`
- `Package`
- `Order`
- `Order Maker`
- `Client`
- `Employee`
- `Catalogue`
- `Bouquet`
- `Flower`

but always taking into account that no console implementation was going to exist. If a method differs way to much between the GUI and the console version, then it is not fully designed. Yet, the class `Record Processor` was omitted from the final product for this phase (mostly because I am still not sure how or where to keep record of the objects).

Today, the main work was in the main driver program for the testing of this phase.

#### REMARKABLE CHANGES
- Cleaned the code a little bit to make it more readable and remove any other main method that still existed in this class. This way, the only `main` in the program belongs to the driver.

#### NEW ADDITIONS
Today's work included two additions to the project.
- **Packages Package**
  * `IDGenerator` : class to generate the ID's to the client and the package. The employee also has an ID attribute, but it is expected for the employee to know it's own ID. Therefore, no need of generating one for that object. The class follows the singleton pattern to make sure there are no duplicates.
- **General**
  * `Driver` : contains the `main` method to test the program up 'til today's progress.

#### NOTES FOR FUTURE WORK
- The issues noted in October 2nd still need to be solved.
- Think about how the objects are going to be registered and where (this information is needed to develop the `Record Processor`).
- Still need to work in the `Record Processor`
- Should `Catalogue` follow the singleton pattern just as `IDGenerator`? Should it even stay as a .CSV file or change to the .JSON?

-------------

### OCTOBER 10th, 2023
#### SUMMARY
Review of the second phase of the project. Today's work consisted in creating one more class and solving some previous issues.

#### REMARKABLE CHANGES
- Resolved the problem regarding object serialization. Now the package holds all the information of the client and the employee, instead of just the IDs.
- Since the client can exist without an order, but the order cannot exist without the client, the order will be the one holding the information of the client. Not viceversa and not both (as it was before).
- Changes in the `Driver` class to check if the `Package Manager` works with the new class implementations.

#### NEW ADDITIONS
Below are the new classes implemented
- **Records**
  * `RecordProcessor` : class to serialize the objects. For now, it works only with `Packages`. It can update an object (serialize the object) and read an object (deserialize the object).

#### NOTES FOR FUTURE WORK
- It would be a nice idea to make the `RecordProcessor` class more generic (work with objects and not packages). This way, one can use the same class to serialize other elements, like the `ID Generator`. This might be useful to ensure there are no repeated ID's even if the program is running for the n-th time.
- It might be a nice idea to leave the `Catalogue` as .CSV. This way, the .JSON would contain the list of values that can be presented in the GUI. Which would allow the possibility of having incomplete packages in case the .JSON and .CSV are not coordinated.
- Serialization problem : resolved.
- Order / Client problem : resolved.
- Record Processor class problem : resolved.

-------------

### OCTOBER 20th, 2023
#### SUMMARY
Today's work consisted in developing the reader for the json file and changing one of the gui classes to make it work with the reader. Also, some changes were made to the `Catalogue` class.

#### REMARKABLE CHANGES
- Changed the `Catalogue` class to make it work with the singleton design pattern. This way, it doesn't have to read and load the file multiple times.

#### NEW ADDITIONS
Below are the new additions to the code divided by folder.
- **Jar**
  * `API` : contains some jar files of some APIs developed to read the json files. This jar files are not my implementation (they come from an external source).
- **Json**
 * `Configuracion.json` : json file with the data that has to be included to the GUI. Note: *this was not developed this day, but it is included in this log entry to keep track of it.*
 * `JsonParser` : class to read the json file. Works with the singleton pattern to avoid loading the file multiple times.

#### NOTES FOR FUTURE WORK
- Still need to transform the `RecordProcessor` class to make it work with objects instead of packages.
- The catalogue will remain as a .CSV. If there is some incongruence with the data obtained from the .JSON then the order would be classified as incomplete.
- Work on the new GUI interface to continue with the project. The biggest part missing has to deal with the information that comes from the windows.

-------------