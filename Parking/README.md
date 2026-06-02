## Deign Parking lot

### Requirements
* A parking lot with multiple floors and each floor has certain set for spots
* A spot can be occupied only the vehicle allowed to park in it, i.e BIKE, CAR, TRUCK.
* Vehicles should be parked at the nearest parking spot available.
* A ticket should be generated when a vehicle is parked
* And fee should be collected when it's unparked. 
* We will have fee based on vehicle type calculated per hour

### Entities / Models
* Vehicle
* Spot
* Ticket
* Floor
* Fee

### Service
* ParkingLot

# Enums
* VehicleType
  * BIKE
  * CAR
  * TRUCK