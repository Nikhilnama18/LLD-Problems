## Requirements
* Design a Tic-Tac-Toe game, where user who first places 3 token horizontally or vertically or diagonally wins.
* If no one does then it's a tie.
* Have Score for each user i.e X & O and also for Tie.
* Give option to reset score.

## Entities
* Player
* Symbol (X, O)
* Cell
* Board (3x3)
* ScoreBoard

## Attributes & methods
* Player
  * id
  * name
  * symbol
* Token (X, O)
  * id
  * pos
  * symbol
* Grid (3x3)
  * placed
  * List<Token>grid
  * isGameOver() - Checks if 9 tokens are placed 
  * gameOwn() - Checks if 3 token are placed correctly
* ScoreBoard
  * X User
  * O User
  * Tie
  * showLeaderBoard()
  * increaseScore()

## Relationships
* Grid-Token (One-to-Many)
