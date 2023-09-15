# WESTERN GOVERNOR UNIVERSITY
## D287 – JAVA FRAMEWORKS

C. Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

File: mainscreen.HTML
Line #: changes

14: Changed title to My Drum Set Store

19:Changed text in h1 tags to Tempo Treasures

40-64: Added list of Parts (name, price, inventory)

101-125: Added list of products (name, price, inventory)


D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

File: about.HTML
Line #: changes

 1-38: Added a new html file under templates name about.HTML, I set up a basic page with a title and paragraphs using thymeleaf
 34: I added a button that leads back to the mainscreen labeled Back to Home

 File: AboutController.JAVA
1-13: I added a controller class called AboutController under controllers,
6: i added the annotation to mark it as  controller @controller
9: mapped the about.html by using @getmapping(/about)
20-13: made a method that returns the about page.






E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

File: BootStrapData.JAVA
Line #: changes

59: Added an If statement that checks the count of productRepository and partRepository to makes sure they are zero
61 - 105: added the 5 new objects of parts
107: Fetching all OutsourcedPart instances from the outsourcedPartRepository.
108 -116: Iterating through each part and checking if its name is matches the case then sets thePart# equal to Part
118 - 122: makes a new Product from the product class
124 -133: saving 5 outsourceParts and Products to their respective repositories.





F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•   The “Buy Now” button must be next to the buttons that update and delete products.

•   The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.

•   Display a message that indicates the success or failure of a purchase

File: BuyPartController.java
Line #: changes

1 -43: Added a Controller to that handles the buyNow request for a part and decrements the inventory

File: BuyProductController.java

1-41: Added a Controller to that handles the buyNow request for a product and decrements the inventory.

File: PartMessages.java

1-38: Added a class to handle the messages to the user after hitting the buyNow button on a part.

File: ProductMessages.JAVA

1-40: Added a class to handle the messages to the user after hitting the buyNow button on a product.

File: mainscreen.html

51-61: Added the HTML for the button buy now for parts and added an if that would print the message after button buy now is pressed.

99-110: Added the button for the products and added and if that would print the message after the button buy now is pressed.

G. Modify the parts to track maximum and minimum inventory by doing the following:
Add additional fields to the part entity for maximum and minimum inventory.

•   Modify the sample inventory to include the maximum and minimum fields.

•   Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.

•   Rename the file the persistent storage is saved to.

•   Modify the code to enforce that the inventory is between or at the minimum and maximum value.

File1: BootStrapData
Line#s: changes

67-68, 78-79, 89-90, 100-101, 112-113 : Setting the minimum inventory to 0 and maximum inventory to 10 for objects.

File2: application.properties

Line 6: update h2 file names

file3: InhousePartForm.HTML

21-22:Adding an input field for inventory and displaying errors if there are any issues with the provided inventory value

(after revision)
23-28: adds field to set maxInv and minInv that was missing when project was submitted.

File4: InventoryValidator.JAVA

1-23:Validator to ensure a part's inventory is within the specified minimum and maximum limits

File5: OutsourcePartForm.HTML

24-29: Input fields for setting and validating the minimum and maximum inventory values with error messages.

File6: Part.JAVA

24 : Custom validation for ensuring inventory is within the specified minimum and maximum limits using @ValidInventory

33, 35-38, 62-86 :Constructor and getters/setters for handling minimum and maximum inventory

file7: ValidInventory.JAVA

1-15: Defines @ValidInventory annotation for custom inventory range validation





H. Add validation for between or at the maximum and minimum fields. The validation must include the following:

Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.

•   Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.

•   Display error messages when adding and updating parts if the inventory is greater than the maximum.

File: InventoryValidator.JAVA
Line #s: changes

20-26: the logic checks if decrementing the current inventory by one would make it less than the allowed min. if true it customizes the validation error to show that the inventory would drop below allowed min and returns false to indicate validation failed.

28-36:checks current inventory exceeds the allowed max. if true the validation error message sent to indicate the inventory is over max and returns false for validation failed.



I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

file: PartTest.JAVA
Line #s: changes

34-35: added a validator instance to be used during testing

37-48, 50-60 : set up a test for both max and min inv that checks for both the outsource and insource confirming that if the inv is higher or lower than it expects it will trigger an error


J.  Remove the class files for any unused validators in order to clean your code.

File: DeletePartValidator.java
Line #s: changes

1-27: Deleted the class after ensuring it was not used anywhere else.
