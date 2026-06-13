## Design Vending Machine

### Requirements
* Machine should have multiple products with different prices & quantities
* Machine should accept money as coin & notes
* Machine should dispense product & return change if necessary
* Machine should keep track of available products & their quantity
* Machine should handle multiple transactions concurrently
* Machine should provide a way to collect money & restock quantity
* Machine should handle scenarios like insufficient funds & out of stock

### Entities
* Product
  * id
  * name
  * price
* Inventory
  * List<Products>
  * Map<ProductName, Quantity>
  * isAvailable(ProductName)
  * addProduct(Product/ProductName, Price, Quantity)
  * getProduct(ProductName)
* Fund
  * coins
  * notes
  * getMoney
  * SetMoney
* Vending Machine
  * Inventory
  * Fund
  * restock(Product)
  * buy(product, money)
  * getProducts();
  * collectMoney(int amt);

### Service
* VendingMachineService

### Class Design
* VM will contain the list of products & provides methods to interact
* Product will have price & quantity info & provides method to get & restock
* VM will contain the funds & provides methods to insert money to get the product
* Funds will have coins & notes & provides method to add or collect cash.

### Missed points
* VM will have set of states
  * IDLE, PRODUCT_SELECTION, ADD_FUNDS, DISPENSE
* VM will have Inventory which will maintain stock & stuff