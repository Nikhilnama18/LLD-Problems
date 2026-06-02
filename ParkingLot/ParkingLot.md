## ParkingLot

### Requirements
* Build a parking lot system, which contains multiple floors
* A spot can be assigned only to a specific vehicle type i.e Bike, Car, Truck
* Vehicle should get nearest parking spot
* We should provide a vehicle with ticket and collect fee based on time & vehicle type

### Entities
* Vehicle
  * id, type
* ParkingFloor
  * floorId, slots[]
* ParkingSlot
  * id, type, available, currentVehicle
* Ticket
  * id, startTime
* Fee
  * pricePerVehicleType

### Service
* ParkingLot
  * createVehicle
  * park(Vehicle)
  * unpart(ticketId)
  * getParkingSlot(slotType)
  * getPrice()

### Enum
* VehicleType
  * BIKE
  * CAR
  * TRUCK