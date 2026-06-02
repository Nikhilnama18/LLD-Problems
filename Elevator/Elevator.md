## Design Elevator

### Requirements
* Multiple Elevator: The system manages multiple elevators.
* Request Handling: The system can handle requests to move to specific floors in a given direction (UP/DOWN).
* Direction Management: The elevator maintains and updates its current direction (UP, DOWN, IDLE).
* State Management: The elevator tracks its current floor, direction, and pending requests.
* Efficient Movement: The elevator processes requests in an efficient order (e.g., all UP requests, then all DOWN requests).
* Extensibility: Easy to add more elevators or advanced scheduling algorithms.

### Entities
* Elevator
  * currentFloor
  * maxFloors
  * status:Direction
  * requests[]
* Request
  * direction: Direction
  * floor
* ElevatorController
  * 
* Direction(enum)
  * UP
  * DOWN
  * IDLE

