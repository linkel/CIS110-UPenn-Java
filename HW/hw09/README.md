## 2048 Clone

Okay, so I'm working on this 2048 clone ~~that's going to be done in the terminal~~ going to use Swing.

### Sketch To Do

In my sketch out, I just want a loop that collects user input and updates the board by generating numbers on it.

- [x] Simple while loop for collecting user input and running the game loop
- [x] Have a 2D array storing the numbers as strings
- [x] Implement a JFrame for capturing user input instead of command line, since the terminal can't seem to collect user input without also requiring an enter key press
- [x] Figure out how to draw grids and numbers on the JFrame
- [x] Tight feedback loop from entering a keyboard character and seeing board update (board array only edition)
- [x] Tight feedback loop from entering a keyboard character and seeing board update (real JFrame edition)
- [x] The above To Do ties in with the Repaint one below, and is actually kind of a hardish problem because I don't understand the library (turns out I just have to put repaint() at the end of the keypress method, what the heck!)
- [x] Read one character from user and update the board consequently (right now it seems to read more than one character)

### Real To Do

- [ ] Improve my Math.Random function for deciding where to spawn numbers (it's a nested lazy mess right now)
- [x] Implement the calculation for block contact
- [x] Bug: Middle blocks will disappear when block they contact isn't the same but there is one the same later in the row that it shouldn't be able to access. Probably my conditional is off.
- [x] Make WASD actually move blocks and combine them in the board array
- [x] Repaint what is happening to the board array on the screen (Very puzzled on how to do this)
- [ ] Cover the case of three of same blocks in a row (closer one to the direction gets combined)
- [ ] Cover the case of four blocks getting combined (they combine to pairs)
- [ ] Set up winning and losing detection and end screens
