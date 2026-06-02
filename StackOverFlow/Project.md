Design StackOverFlow
* Register users
* Ask questions with tags
* Post answers to questions
* Add comments on questions and answers
* Upvote/downvote questions and answers
* Search questions by keyword or tag

Entities 
* User
* Question
* Answer
* Tag
* Comment
* Vote


Relationship
* User
  * Question
  * Answer
* Question
  * Answer
  * Comment
  * Vote
  * Tags
* Answer
  * Comment
  * Vote